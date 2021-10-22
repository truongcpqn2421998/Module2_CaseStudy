package storage;

import model.Order;
import model.account.Librarian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderReadWriteFile {
    private OrderReadWriteFile(){

    }
    private static OrderReadWriteFile orderReadWriteFile;
    public static OrderReadWriteFile getInstance(){
        if(orderReadWriteFile==null){
            orderReadWriteFile=new OrderReadWriteFile();
        }
        return orderReadWriteFile;
    }
    public List<Order> readFile() throws IOException, ClassNotFoundException {
        File file = new File("orderList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Order> list = (List<Order>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Order> orderList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("orderList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(orderList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
