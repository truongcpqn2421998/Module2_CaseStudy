package storage;

import model.account.Librarian;
import model.book.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookReadWriteFile {
    private static BookReadWriteFile bookReadWriteFile;
    private BookReadWriteFile(){
    }
    public static BookReadWriteFile getInstance(){
        if(bookReadWriteFile==null){
            bookReadWriteFile=new BookReadWriteFile();
        }
        return bookReadWriteFile;
    }
    public List<Book> readFile() throws IOException, ClassNotFoundException {
        File file = new File("bookList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Book> list = (List<Book>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Book> books) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("bookList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(books);
        objectOutputStream.close();
        fileOutputStream.close();
    }

}
