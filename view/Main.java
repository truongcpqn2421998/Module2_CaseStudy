package view;


import manager.BookManager;
import manager.LibrarianManager;
import manager.OrderManager;
import manager.StudentManager;
import model.Order;
import model.account.Librarian;
import model.account.Student;
import model.book.Book;
import storage.BookReadWriteFile;
import storage.LibrarianReadWriteFile;
import storage.OrderReadWriteFile;
import storage.StudentReadWriteFile;
import view.loginMenu.MenuLogin;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibrarianReadWriteFile librarianReadWriteFile=LibrarianReadWriteFile.getInstance();
        List<Librarian> librarianList= null;
        try {
            librarianList = librarianReadWriteFile.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        StudentReadWriteFile studentReadWriteFile=StudentReadWriteFile.getInstance();
        List<Student> studentList= null;
        try {
            studentList = studentReadWriteFile.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        BookReadWriteFile bookReadWriteFile=BookReadWriteFile.getInstance();
        List<Book> bookList= null;
        try {
            bookList = bookReadWriteFile.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        OrderReadWriteFile orderReadWriteFile=OrderReadWriteFile.getInstance();
        List<Order> orderList= null;
        try {
            orderList = orderReadWriteFile.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        LibrarianManager librarianManager=LibrarianManager.getInstance(librarianList);
        StudentManager studentManager=StudentManager.getInstance(studentList);
        BookManager bookManager=BookManager.getInstance(bookList);
        OrderManager  orderManager=OrderManager.getInstance(orderList,studentList,bookList);
        MenuLogin.Login();

    }
}
