package com.imam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection con;
    Statement st;
    
    public Database() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mini_project", "postgres", "");
        st = con.createStatement();
    }

    public void awaltahun() throws Exception{
        String query = "select * from bayar_lunas where extract(month from date) in (01,02,03)";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String invoiceid = rs.getString("invoiceid");
            System.out.format("Terima kasih karena Anda telah melakukan pembayaran invoice %s. Anda berhak mendapatkan diskon awal sebesar 10%%!\n", invoiceid);
        }
    }

    public void akhirtahun() throws Exception{
        String query = "select * from bayar_lunas where extract(month from date) in (10,11,12)";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String invoiceid = rs.getString("invoiceid");
            System.out.printf("Terima kasih karena Anda telah melakukan pembayaran invoice %s. Anda berhak mendapatkan diskon awal sebesar 20%%!\n", invoiceid);
        }
    }

    public void cekawaltahun() throws Exception{
        String query = "select * from bayar_lunas where extract(month from date) in (01,02,03)";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String invoiceid = rs.getString("invoiceid");
            System.out.format("Terima kasih karena Anda telah melakukan pembayaran invoice %s. Anda berhak mendapatkan diskon awal sebesar 10%%!\n", invoiceid);
        }
    }

    public void belumbayar() throws Exception{
        String query = "select invoiceid from belum_bayar";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String invoiceid = rs.getString("invoiceid");
                System.out.format("Yuk segera bayar tagihan invoice %s, dan dapatkan diskon sebesar 15%%!\n", invoiceid);
        }
    }    
}



    // contoh method insert db
    // public void insertData(String name, int age) throws SQLException 
    // {
    //     if(name!=null && age!=0)
    //     {
    //         String query = "insert into user values(\""+name+"\","+age+")";
    //         int a = stObj.executeUpdate(query);

    //         if(a == 1)
    //         {
    //             System.out.println("Update Successful");
    //         }
    //         else
    //         {
    //             System.out.println("Update Failed");
    //         }
    //     }
    // }

//     public void takeDetails() throws Exception
//   {
//      System.out.println("Enter name");
//      String name = sc.next();
//      System.out.println("Enter age");
//      int age = sc.nextInt();
//      d.insertData(name, age);
//   }




    // contoh delete
    // void deleteData(String name) throws Exception 
    // {
    //     String query = "delete from user where name = \""+name+"\"";
    //     int a = stObj.executeUpdate(query);

    //     if(a == 1)
    //     {
    //             System.out.println("delete Successful");
    //     }
    //     else
    //     {
    //             System.out.println("deletion Failed");
    //     }
    // }

//     private void deleteData() throws Exception {
//         System.out.println("Enter name of the user whose record is to be deleted");
//         String name = sc.next();
//         d.deleteData(name);
//     }
// }