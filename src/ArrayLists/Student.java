package ArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private boolean courseRegistered;



    //defining three data values for the class.
    public Student(int studentId, String studentName, boolean courseRegistered) {
        this.studentId=studentId;
        this.studentName=studentName;
        this.courseRegistered=courseRegistered;
//it is the constructor class that will be used to create a new object known as Student.
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isCourseRegistered() {
        return courseRegistered;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseRegistered(boolean courseRegistered) {
        this.courseRegistered = courseRegistered;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    //these methods are just to set the details and return them.
}
class testing{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Sambhav", true));
        students.add(new Student(2, "Kunal", true));
        students.add(new Student(3, "Ayush", false));
        students.add(new Student(4, "Shaurya", true));
        students.add(new Student(5, "Shorya", false));

        //in the students class we will save the data of the Student objects where we are using student class as the wrapper class.
        Scanner sc=new Scanner(System.in);


        List<String> studentNames=new ArrayList<String>();

        //in the list studentNames we will save the names of students and later print it.

        for(Student student:students){

            studentNames.add(student.getStudentName());
            System.out.println("Student ID: "+student.getStudentId());
            System.out.println("Student Name: "+student.getStudentName());
            System.out.println("Course Registration Status: "+student.isCourseRegistered());
            System.out.println();
        }
        System.out.println();
        System.out.println("Student names : "+studentNames);
    }
}
