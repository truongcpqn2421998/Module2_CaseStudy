package view.StudentView.RepairAccount;

import manager.StudentManager;
import model.account.Student;
import storage.StudentReadWriteFile;
import view.StudentView.managerBook.BorrowAndGiveBack;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EditStudentAccount {
    private static StudentReadWriteFile studentReadWriteFile=StudentReadWriteFile.getInstance();
    private static List<Student>studentList=StudentManager.studentList;
    private static StudentManager studentManager=StudentManager.getInstance(studentList);
    public static void EditAccount(Student student){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|______EDIT STUDENT ACCOUNT_____|");
            System.out.println("1.Edit name:");
            System.out.println("2.Edit id:");
            System.out.println("3.Edit age:");
            System.out.println("4.Change password:");
            System.out.println("0.Back");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    editName(student);
                    break;
                case 2:
                    editId(student);
                    break;
                case 3:
                    editAge(student);
                    break;
                case 4:
                    changePass(student);
                    break;
            }
        }while(choice!=0);
    }
    public static void editName(Student student){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name you want:");
        String name=scanner.nextLine();
        student.setName(name);
        try {
            studentReadWriteFile.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void editId(Student student){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id you want:");
        String id=scanner.nextLine();
        student.setId(id);
        try {
            studentReadWriteFile.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void editAge(Student student){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter age:");
        int age=scanner.nextInt();
        student.setAge(age);
        try {
            studentReadWriteFile.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void changePass(Student student){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter password you want change");
        String pass=scanner.nextLine();
        student.setPassword(pass);
        try {
            studentReadWriteFile.writeFile(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
