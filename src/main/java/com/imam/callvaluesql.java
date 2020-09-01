package com.imam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class callvaluesql{

    void cekdiskon(){
        try{
        Scanner input = new Scanner(System.in);
        String id = "";

        Class.forName("org.postgresql.Driver");
        String myUrl = "jdbc:postgresql://127.0.0.1:5432/mini_project";
        Connection conn = DriverManager.getConnection(myUrl, "postgres", "");

        System.out.print("Masukkan inputan: ");
        id = input.next();
        id = id.toUpperCase();

        PreparedStatement ps = conn.prepareStatement("select * from bayar_lunas where extract(month from date) in (01,02,03) and invoiceid =?");
        PreparedStatement ps1 = conn.prepareStatement("select * from bayar_lunas where extract(month from date) in (10,11,12) and invoiceid =?");
        PreparedStatement ps2 = conn.prepareStatement("select * from belum_bayar where invoiceid =?");
        ps.setString(1, id); // 1 adalah index table di database
        ps1.setString(1, id);
        ps2.setString(1, id);

        ResultSet rsAwaltahun = ps.executeQuery();
        ResultSet rsAkhirtahun = ps1.executeQuery();
        ResultSet rsBelumbayar = ps2.executeQuery();
        
        do{
        if (rsAwaltahun.next()){
            System.out.println("\nYeeeay dapat Diskon 10%");
        }else if (rsAkhirtahun.next()){
            System.out.println("\nYeeeay dapat Diskon 20%");
        }else if (rsBelumbayar.next()){
            System.out.println("\nAnda belum membayar invoice");
        }else{
            System.out.println("\nInvoice ID Tidak ditemukan");
        }
    }while(rsAwaltahun.next() && rsAkhirtahun.next() && rsBelumbayar.next());
   
        }catch (SQLException | ClassNotFoundException e) {
            System.err.println("Got an exception! ");
            throw new RuntimeException("Error during startup of service !!!");
        }
    }
}