package view.LibrarianView.orderManager;

import manager.BookManager;
import manager.OrderManager;
import manager.StudentManager;
import model.Order;
import model.account.Student;
import model.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOrderManager {
    private static List<Order> orderList=OrderManager.orderList;
    private static List<Student> studentList= StudentManager.studentList;
    private static List<Book> bookList= BookManager.bookList;
    private static OrderManager orderManager=OrderManager.getInstance(orderList,studentList,bookList);
        public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|_____MENU ORDER_____|");
            System.out.println("1.Check a order");
            System.out.println("2.Check People overdue people");
            System.out.println("3.View all Order in library:");
            System.out.println("0.Back");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    checkOrder();
                    break;
                case 2:
                    viewAllOrder();
                    break;
                case 3:
                    checkOrderOverDate();
                    break;
                default:
                    System.out.println("Choice again");
            }
        }while (choice!=0);
    }
    public static void checkOrder(){
        Scanner scanner=new Scanner(System.in);
        String code=scanner.nextLine();
        Order order=orderManager.search(code);
        if(order!=null){
            System.out.println(order.toString());
        }else {
            System.err.println("Order not exist");
        }
    }
    public static void viewAllOrder(){
        for (Order order: orderList
        ) {
            System.out.println(order);
        }
    }
    public static void checkOrderOverDate(){
            List<Order> orderOverDate= orderManager.checkOverDate();
        for (Order order: orderOverDate
             ) {
            System.out.println(order);
        }
    }

}
