package ArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Student_1 {
    private int studentId;
    private String studentName;
    private boolean courseRegistered;



    //defining three data values for the class.
    public Student_1(int studentId, String studentName, boolean courseRegistered) {
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
class testing1{
    public static void main(String[] args) {
        List<Student_1> students1 = new ArrayList<Student_1>();
        students1.add(new Student_1(1, "Sambhav", true));
        students1.add(new Student_1(2, "Kunal", true));
        students1.add(new Student_1(3, "Ayush", false));
        students1.add(new Student_1(4, "Shaurya", true));
        students1.add(new Student_1(5, "Shorya", false));

        //in the students class we will save the data of the Student objects where we are using student class as the wrapper class.

        ListIterator<Student_1> studentNames = students1.listIterator();

        while (studentNames.hasNext()) {
            System.out.println("Student ID : " + studentNames.next().getStudentId());
        }
        System.out.println();
        System.out.println("Names in reverse order");
        while (studentNames.hasPrevious()) {
            System.out.println("Student ID : "+studentNames.previous().getStudentId());

        }
        while (studentNames.hasNext()) {

            System.out.println("Student Name : "+studentNames.next().getStudentName());

        }
        //in the list studentNames we will save the names of students and later print it.

    }
}
