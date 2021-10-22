package manager;

import model.account.Student;
import storage.StudentReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IGeneralManager<Student> {
    private StudentReadWriteFile studentReadWriteFile=StudentReadWriteFile.getInstance();
    public static  List<Student> studentList=new ArrayList<>();

    public static StudentManager studentManager;
    private StudentManager(List<Student> studentList){
        this.studentList=studentList;
    }
    public static StudentManager getInstance(List<Student> studentList){
        if(studentManager==null){
            studentManager=new StudentManager(studentList);
        }
        return studentManager;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void save(Student student) throws IOException {
        studentList.add(student);
        studentReadWriteFile.writeFile(studentList);
    }

    @Override
    public void remove(Student student) throws IOException {
        studentList.remove(student);
        studentReadWriteFile.writeFile(studentList);

    }

    @Override
    public void update(int index, Student student) throws IOException {
        studentList.remove(index);
        studentList.add(index,student);
        studentReadWriteFile.writeFile(studentList);

    }

    @Override
    public Student search(String id) {
        for (Student student: studentList
             ) {
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }
    public int findIndex(String id){
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public Student findStudentByAccount(String account){
        for (Student student:studentList
             ) {
            if(student.getNameAccount().equals(account)){
                return student;
            }
        }
        return null;
    }

}
