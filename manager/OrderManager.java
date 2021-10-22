package manager;

import model.Order;
import model.account.Student;
import model.book.Book;
import storage.BookReadWriteFile;
import storage.OrderReadWriteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements IGeneralManager<Order> {
    private OrderReadWriteFile orderReadWriteFile=OrderReadWriteFile.getInstance();
    private BookReadWriteFile bookReadWriteFile=BookReadWriteFile.getInstance();
    public static List<Order> orderList=new ArrayList<>();
    public static List<Student> studentList=StudentManager.studentList;
    public static List<Book> bookList=BookManager.bookList;
    public static OrderManager orderManager;
    private OrderManager(List<Order> orderList,List<Student> studentList,List<Book> bookList) {
    }

    public static OrderManager getInstance(List<Order> orderList,List<Student>studentList,List<Book>bookList) {
        if (orderManager == null) {
            orderManager = new OrderManager(orderList,studentList,bookList);
        }
        return orderManager;
    }


    @Override
    public void save(Order order) throws IOException {
        orderList.add(order);
        orderReadWriteFile.writeFile(orderList);
    }

    @Override
    public void remove(Order order) throws IOException {
        orderList.remove(order);
        orderReadWriteFile.writeFile(orderList);

    }

    @Override
    public void update(int index, Order order) throws IOException {
        orderList.remove(index);
        orderList.add(index, order);
        orderReadWriteFile.writeFile(orderList);

    }

    @Override
    public Order search(String code) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode().equals(code)) {
                return orderList.get(i);
            }
        }
        return null;
    }


    public Book getABook(String code) throws IOException {
        for (Book book: bookList
             ) {
            if(book.getCode().equals(code)&& book.isStatus()==true){
                book.setStatus(false);
                bookReadWriteFile.writeFile(bookList);
                return book;
            }
        }
        return null;
    }

    public Student checkIdStudent(String id){
        for (Student student: studentList
             ) {
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public void giveBookBack(Book book) throws IOException {
        Order order=findOrderToGiveBack(book);
        book.setStatus(true);
        order.getBookList().remove(book);
        bookReadWriteFile.writeFile(bookList);
        orderReadWriteFile.writeFile(orderList);
        if(order.getBookList().size()==0){
            remove(order);
        }

    }
    public Order findOrderToGiveBack(Book book){
        for (Order order: orderList
             ) {
            if(checkBookInOrder(order.getBookList(),book)){
                return order;
            }
        }
        return null;
    }
    public boolean checkBookInOrder(List<Book>list,Book book){
        for (Book bookTest:list
             ) {
            if(bookTest.getCode().equals(book.getCode())){
                return true;
            }
        }
        return false;
    }
    public Book checkCodeBook(String code){
        for (Book book: bookList
             ) {
            if(book.getCode().equals(code)){
                return book;
            }
        }
        return null;
    }

    public List<Order> checkOverDate(){
        List<Order> overDate=new ArrayList<>();
        for (Order order:orderList
             ) {
            if((order.getDeadLine().isBefore(LocalDate.now()))==true){
                overDate.add(order);
            }
        }
        return overDate;
    }
}
