package view.LibrarianView.bookManager;

import manager.BookManager;
import model.book.Book;
import model.book.BookFactory;
import model.book.BookType;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuBookManager {
    private static List<Book> bookList=BookManager.bookList;
    private static BookManager bookManager=BookManager.getInstance(bookList);
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|_____BOOK MANAGER_____|");
            System.out.println("1.Add a new Book");
            System.out.println("2.Remove a Book");
            System.out.println("3.Repair a Book");
            System.out.println("4.Display a Book");
            System.out.println("5.Display all book in library");
            System.out.println("0.Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    repairBook();
                    break;
                case 4:
                    displayABook();
                    break;
                case 5:
                    viewAllBookInLibrary();
                    break;
            }
        }while (choice!=0);
    }
    public static void addBook(){
        Book book = createBook();
        if(book!=null){
            try {
                bookManager.save(book);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Book createBook() {
        Scanner scanner=new Scanner(System.in);
        Book book=null;
        System.out.println("Enter Type Book you want to create:");
        String type=scanner.nextLine();
        if(type.equals("technical")){
            book=createTechnicalBook();
        }else if(type.equals("economic")){
            book=createEconomicBook();
        }else {
            throw new IllegalArgumentException("Library don't want to take this");
        }
        return book;
    }

    public static Book createEconomicBook(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter title of Economic Book:");
        String title=str.nextLine();
        System.out.println("Enter category of Economic Book:");
        String category=str.nextLine();
        System.out.println("Enter code of Economic Book:");
        String code=str.nextLine();
        Book book= BookFactory.getBook(BookType.ECONOMICBOOK,title,category,code);
        return book;
    }
    public static Book createTechnicalBook(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter title of Technical Book:");
        String title=str.nextLine();
        System.out.println("Enter category of Technical Book:");
        String category=str.nextLine();
        System.out.println("Enter code of Technical Book:");
        String code=str.nextLine();
        Book book= BookFactory.getBook(BookType.TECHNICALBOOK,title,category,code);
        return book;
    }
    public static void removeBook(){
        Scanner str=new Scanner(System.in);
        String code=str.nextLine();
        System.out.println("Enter book's code you want to remove:");
        Book book=bookManager.search(code);
        if(book!=null){
            try {
                bookManager.remove(book);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new IllegalArgumentException("Not exist");
        }
    }
    public static void repairBook(){
        Scanner str=new Scanner(System.in);
        int index=-1;
        System.out.println("Enter Book's code you want to repair:");
        String code=str.nextLine();
        index=bookManager.findIndex(code);
        if(index!=-1){
            Book book=createBook();
            try {
                bookManager.update(index,book);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new IllegalArgumentException("Not Exist");
        }
    }
    public static void displayABook(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter book's code you want to view");
        String code=str.nextLine();
        Book book=bookManager.search(code);
        if(book!=null){
            System.out.println(bookManager.displayABook(book));
        }else {
            System.out.println("Not Exist");
        }
    }
    public static void viewAllBookInLibrary(){
        for (Book book:bookList
             ) {
            System.out.println(book.toString());
        }
    }


}
