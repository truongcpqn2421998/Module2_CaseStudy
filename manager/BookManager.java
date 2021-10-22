package manager;

import model.book.Book;
import model.book.BookFactory;
import model.book.BookType;
import storage.BookReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements IGeneralManager<Book> {
    private BookReadWriteFile bookReadWriteFile=BookReadWriteFile.getInstance();
    public static List<Book> bookList=new ArrayList<>();
    public static BookManager bookManager;
    private BookManager(List<Book> bookList){
        this.bookList=bookList;
    }
    public static BookManager getInstance(List<Book> bookList){
        if(bookManager==null){
            bookManager=new BookManager(bookList);
        }
        return bookManager;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void save(Book book) throws IOException {
        bookList.add(book);
        bookReadWriteFile.writeFile(bookList);

    }

    @Override
    public void remove(Book book) throws IOException {
        bookList.remove(book);
        bookReadWriteFile.writeFile(bookList);
    }

    @Override
    public void update(int index, Book book) throws IOException {
        bookList.add(index,book);
        bookReadWriteFile.writeFile(bookList);

    }

    @Override
    public Book search(String code) {
        for (Book book : bookList) {
            if (book.getCode().equals(code)) {
                return book;
            }
        }
        return null;
    }

    public Book createBook(BookType bookType,String title, String category, String code, boolean status){
        return BookFactory.getBook(bookType,title,category,code);
    }
    public int findIndex(String code){
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getCode().equals(i)){
                return i;
            }
        }
        return -1;
    }
    public String displayABook(Book book){
        return book.toString();
    }
}
