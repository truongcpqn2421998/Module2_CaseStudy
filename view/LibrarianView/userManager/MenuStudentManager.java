package view.LibrarianView.userManager;

import manager.StudentManager;
import model.account.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuStudentManager {
    private  static List<Student> studentList=StudentManager.studentList;
    private  static StudentManager studentManager=StudentManager.getInstance(studentList);
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("_____Student Manager_____");
            System.out.println("1.Create new Student account");
            System.out.println("2.Remove a Student account");
            System.out.println("3.Repair a Student account ");
            System.out.println("4.View all Student");
            System.out.println("5.Check a Student by id:");
            System.out.println("0.Back");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addLibrarian();
                    break;
                case 2:
                    removeLibrarian();
                    break;
                case 3:
                    repairStudent();
                    break;
                case 4:
                    viewAll();
                    break;
                case 5:
                    checkAStudent();
                    break;
                default:
                    System.out.println("Choice again");
            }
        }while (choice!=0);
    }
    public static Student createStudentAccount(){
        Scanner num=new Scanner(System.in);
        Scanner str=new Scanner(System.in);
        System.out.println("Enter Student's name:");
        String name=str.nextLine();
        System.out.println("Enter Student's id:");
        String id=str.nextLine();
        System.out.println("Enter Student's age");
        int age=num.nextInt();
        System.out.println("Enter student's name of account:");
        String accountName=str.nextLine();
        System.out.println("Enter student's password of account");
        String accountPass=str.nextLine();
        Student student= new Student(name,id,age,accountName,accountPass);
        return student;
    }
    public static void addLibrarian(){
        Student student= createStudentAccount();
        try {
            studentManager.save(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Student checkStudentById(){
        Scanner str=new Scanner(System.in);
        Student student=null;
        do{
            System.out.println("Enter Librarian's id of account :");
            String id=str.nextLine();
            student=studentManager.search(id);
            if(student==null){
                System.out.println("Librarian not exist");
            }
        }while (student==null);
        return student;
    }
    public static void removeLibrarian(){
        Student student= checkStudentById();
        try {
            studentManager.remove(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void repairStudent(){
        Scanner str=new Scanner(System.in);
        int index=-1;
        do {
            System.out.println("Enter student's id you want to repair: ");
            String id = str.nextLine();
            index=studentManager.findIndex(id);
            if(index==-1){
                System.out.println("id is not exist");
            }
        }while(index==-1);
        Student student= createStudentAccount();
        try {
            studentManager.update(index,student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewAll(){
        for (Student student: studentList
             ) {
            System.out.println(student.toString());
        }
    }

    public static void checkAStudent(){
        Student student=checkStudentById();
        System.out.println(student.toString());
    }
}
