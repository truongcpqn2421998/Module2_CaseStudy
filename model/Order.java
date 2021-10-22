package model;

import model.account.Student;
import model.book.Book;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Order implements Serializable {
    private Student student;
    private LocalDate borrowDate;
    private String code;
    private List<Book> bookList;


    public Order(Student student, LocalDate borrowDate, String code, List<Book> bookList) {
        this.student = student;
        this.borrowDate = borrowDate;
        this.code = code;
        this.bookList = bookList;
    }

    public Student getStudent() {
        return student;
    }

    public void setUser(Student student) {
        this.student = student;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public LocalDate getDeadLine(){
        return borrowDate.plusMonths(2);
    }

    @Override
    public String toString() {
        return "Order{" +
                "Student=" + student +
                ", borrowDate=" + borrowDate +
                ", code='" + code + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
