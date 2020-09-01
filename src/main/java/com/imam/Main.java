package com.imam;
import java.util.Scanner;

public class Main {
    public static Scanner input;
    public static Database database;
    public static callvaluesql callvalues;

    static 
    {
        try{
            database = new Database();
            callvalues = new callvaluesql();
            input = new Scanner(System.in); 
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) { 
        Main panggil = new Main();
        int choice;
        boolean jalan = true;

    try{
        Main.menu();
    do{
        choice = input.nextInt();
        if(choice == 1){
            System.out.println("\n");
            
            do{
                Main.menupembayaran();
                choice = input.nextInt();
                if (choice == 1){
                    panggil.awaltahun();
                    System.out.println("\n");
                    Main.menu();
                    jalan = false;
                }else if (choice == 2){
                    panggil.akhirtahun();
                    System.out.println("\n");
                    Main.menu();
                    jalan = false;
                }else if (choice == 3){
                    panggil.belumbayar();
                    System.out.println("\n");
                    Main.menu();
                    jalan = false;
                }else if (choice == 0){
                    System.out.println("\n");
                    Main.menu();
                    jalan = false;
                }else{
                    System.out.println("Wrong Input! \n");
                }
            }while(jalan);
           
        }else if (choice == 2){
            System.out.println("\n");
            
            do{
                Main.menuinvoiceid();
                choice = input.nextInt();     
                if (choice == 1){
                    // System.out.print("Masukkan Invoice ID: ");
                    do{
                        panggil.cekdiskon();
                        System.out.println("\n");
                        Main.menu();
                        jalan = false;                   
                    }while(jalan);

                }else if (choice == 0){
                    System.out.println("\n");
                    Main.menu();
                    jalan = false;
                }else{
                    System.out.println("Wrong Input! \n");
                }
            }while(jalan);   

        }else if (choice == 3){
            System.out.println("Thank you");
            System.exit(0);  

        }else{
            System.out.println("Wrong Input! \n");
            Main.menu();
        }
    } while(true); 
    
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}


    static void menu(){
        System.out.println("Menu Utama");
        System.out.println("===========================================");
        System.out.println("No 1. Cek Pembayaran");
        System.out.println("No 2. Cari Invoice ID");
        System.out.println("No 3. Exit");
        System.out.println("===========================================");
        System.out.print("Masukkan nomor pilihan anda: ");
    }

    static void menupembayaran(){
        System.out.println("Selamat datang di menu pembayaran");
        System.out.println("===========================================");
        System.out.println("No 1. Awal tahun");
        System.out.println("No 2. Akhir tahun");
        System.out.println("No 3. Belum bayar");
        System.out.println("No 0. Back");
        System.out.println("===========================================");
        System.out.print("Masukkan nomor pilihan anda: ");
    }

    static void menuinvoiceid(){
        System.out.println("Selamat datang di menu pencarian invoice id");
        System.out.println("===========================================");
        System.out.println("No 1. Cari Invoice");
        System.out.println("No 0. Back");
        System.out.println("===========================================");
        System.out.print("Masukkan nomor pilihan anda: ");
    }

    // running from another class
    public void awaltahun() throws Exception
  {
      database.awaltahun();
  }

    public void akhirtahun() throws Exception
  {
      database.akhirtahun();
  }

  public void belumbayar() throws Exception
  {
      database.belumbayar();
  }

  public void cekdiskon(){
      callvalues.cekdiskon();
  }
}

