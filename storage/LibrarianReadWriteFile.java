package storage;

import model.account.Librarian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianReadWriteFile {
    private static LibrarianReadWriteFile librarianReadWriteFile;
    private LibrarianReadWriteFile(){
    }
    public static LibrarianReadWriteFile getInstance(){
        if(librarianReadWriteFile==null){
            librarianReadWriteFile=new LibrarianReadWriteFile();
        }
        return librarianReadWriteFile;
    }
    public List<Librarian> readFile() throws IOException, ClassNotFoundException {
        File file = new File("librarianList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Librarian> list = (List<Librarian>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Librarian> librarianList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("librarianList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(librarianList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
