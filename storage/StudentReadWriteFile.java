package storage;

import model.account.Librarian;
import model.account.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentReadWriteFile {
    private StudentReadWriteFile(){}
    private static StudentReadWriteFile studentReadWriteFile;
    public static StudentReadWriteFile getInstance(){
        if(studentReadWriteFile==null){
            studentReadWriteFile=new StudentReadWriteFile();
        }
        return studentReadWriteFile;
    }
    public List<Student> readFile() throws IOException, ClassNotFoundException {
        File file = new File("studentList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Student> list = (List<Student>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Student> studentList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("studentList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
