package Sets;

import java.util.*;

public class Student {
    private int studentID;
    private String studentName;
    private int courseID;

    public Student(int studentID,String studentName,int courseID){
        this.studentID=studentID;
        this.studentName=studentName;
        this.courseID=courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", courseID=" + courseID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Student o1=(Student) o;
        if (this.studentID == o1.studentID) return true;
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return studentID;
    }
}
class tester{

    public static Set<Student> findDuplicateEntries(List<Student> list1){

        Set<Integer> studentsID=new HashSet<Integer>();

        Set<Student> duplicatesstudentsIDset = new HashSet<Student>();
        for (Student st:list1){
            if(studentsID.contains(st.getStudentID())) {
                duplicatesstudentsIDset.add(st);
            }
            else{
                studentsID.add(st.getStudentID());
            }
        }
        return duplicatesstudentsIDset;
    }
    public static void main(String[] args){

        List<Student> studentsList=new ArrayList<Student>();

        studentsList.add(new Student(1001, "Dean", 111));
        studentsList.add(new Student(1002, "Harley", 112));
        studentsList.add(new Student(1003, "Franklin", 113));
        studentsList.add(new Student(1005, "Arden", 113));
        studentsList.add(new Student(1100, "Juliet", 112));
        studentsList.add(new Student(1003, "Franklin", 111));
        studentsList.add(new Student(1001, "Dean", 114));

        studentsList.toArray();
        ListIterator<Student> studentListIterator= studentsList.listIterator();
        while(studentListIterator.hasNext()){
            System.out.println(studentListIterator.next());
        }
        System.out.println();

        Set<Student> studentsSet = findDuplicateEntries(studentsList);
        System.out.println("Students who have applied for re-evaluation in more than one subject");
        for(Student student: studentsSet)
            System.out.println(student);

    }
}
