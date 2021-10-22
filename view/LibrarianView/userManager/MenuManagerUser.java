package view.LibrarianView.userManager;

import view.LibrarianView.userManager.MenuLibrarianManager;
import view.LibrarianView.userManager.MenuStudentManager;

import java.util.Scanner;

public class MenuManagerUser {
    public static void Menu(){
        Scanner num=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|______MENU USER_____|");
            System.out.println("1.Librarian Manager");
            System.out.println("2.Student Manager");
            System.out.println("0.Back");
            choice=num.nextInt();
            switch (choice){
                case 1:
                    MenuLibrarianManager.menu();
                    break;
                case 2:
                    MenuStudentManager.menu();
                    break;
            }
        }while (choice!=0);
    }
}
