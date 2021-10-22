package view.LibrarianView.userManager;

import manager.LibrarianManager;
import model.account.Librarian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuLibrarianManager {
    private static List<Librarian> librarianList=LibrarianManager.librarianList;
    private static LibrarianManager librarianManager=LibrarianManager.getInstance(librarianList);

    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("_____Librarian User Manager_____");
            System.out.println("1.Create new Librarian account");
            System.out.println("2.Remove a Librarian account");
            System.out.println("3.Repair a Librarian account ");
            System.out.println("4.Show all Librarian");
            System.out.println("5.View Librarian by id");
            System.out.println("0.Back");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addLibrarian();
                    break;
                case 2:
                    removeLibrarian();
                    break;
                case 3:
                    repairLibrarian();
                    break;
                case 4:
                    viewAll();
                    break;
                case 5:
                    viewALibrarian();
                    break;
                default:
                    System.out.println("Choice again:");
            }
        }while (choice!=0);
    }
    public static Librarian createLibrarianAccount(){
        Scanner num=new Scanner(System.in);
        Scanner str=new Scanner(System.in);
        System.out.println("Enter librarian's name:");
        String name=str.nextLine();
        System.out.println("Enter librarian's id:");
        String id=str.nextLine();
        System.out.println("Enter librarian age");
        int age=num.nextInt();
        System.out.println("Enter librarian's name of account:");
        String accountName=str.nextLine();
        System.out.println("Enter librarian's password of account");
        String accountPass=str.nextLine();
        Librarian librarian= new Librarian(name,id,age,accountName,accountPass);
        return librarian;
    }
    public static void addLibrarian(){
        Librarian librarian=createLibrarianAccount();
        try {
            librarianManager.save(librarian);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Librarian checkLibrarianById(){
        Scanner str=new Scanner(System.in);
        Librarian librarian=null;
        do{
            System.out.println("Enter Librarian's id of account:");
            String id=str.nextLine();
            librarian=librarianManager.search(id);
            if(librarian==null){
                System.out.println("Librarian not exist");
            }
        }while (librarian==null);
        return librarian;
    }
    public static void removeLibrarian(){
        Librarian librarian=checkLibrarianById();
        try {
            librarianManager.remove(librarian);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void repairLibrarian(){
        Scanner str=new Scanner(System.in);
        int index=-1;
        do {
            System.out.println("Enter Librarian's id you want to repair: ");
            String id = str.nextLine();
            index=librarianManager.findIndex(id);
            if(index==-1){
                System.out.println("id is not exist");
            }
        }while(index==-1);
        Librarian librarian=createLibrarianAccount();
        try {
            librarianManager.update(index,librarian);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewAll(){
        for (Librarian librarian: librarianList
             ) {
            System.out.println(librarian.toString());
        }
    }
    public static void viewALibrarian(){
        Librarian librarian=checkLibrarianById();
        System.out.println(librarian.toString());
    }

}
