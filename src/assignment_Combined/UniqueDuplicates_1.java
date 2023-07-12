package assignment_Combined;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student{
    private int studentID;
    private String studentNAME;

    private String event;

    private String emailID;

    public Student(Integer studentID,String studentNAME,String emailID,String event){
        this.studentID=studentID;
        this.studentNAME=studentNAME;
        this.emailID=emailID;
        this.event=event;
    }
    // this is the constructor function

    public int getStudentID() {
        return studentID;
    }

    public String getStudentNAME() {
        return studentNAME;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getEvent() {
        return event;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentNAME(String studentNAME) {
        this.studentNAME = studentNAME;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object obj) {
        Student otherStudent=(Student) obj;
        if(this.emailID.equals(otherStudent.emailID)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return emailID.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentNAME='" + studentNAME + '\'' +
                ", event='" + event + '\'' +
                ", emailID='" + emailID + '\'' +
                '}';
    }
}


public class UniqueDuplicates_1 {
// the following function can be used to find the unique students from the students list.
    public static Set<Student> findUniques(List<Student> s1){

        //s will store the unique elements into a hashSet.
        Set<Student> s=new HashSet<Student>();
        //first we will iterate the list to allow the hasset to add the unique elements if they are not present.
        for(Student z:s1){
            if(!s.contains(z)){
                s.add(z);
            }
            else{
                System.out.println("It was present.");
            }
        }
        return s;
    }

    // the following method can be used to find the duplicate elements of a list and store them in a hashset.
    public static Set<Student> findDuplicates(List<Student> s1){

        // students1 will be used to store the new emails.
        //duplicateStudent will be used to store the duplicate student entries into a hashSet.
        Set<String> students1=new HashSet<>();
        Set<Student> duplicateStudent=new HashSet<>();

        //first we will iterate the list s1 to allow the hashSets to check if the element is duplicate or not.
        for(Student li:s1){
            if(students1.contains(li.getEmailID())){
                //if the students1 will already contain the email id them it will add the duplicate email ID Student in the duplicateStudent hasSet.
                duplicateStudent.add(li);
            }
            else{
                //if the student have a unique email that it will add the student into the students1 list.
                students1.add(li.getEmailID());
            }
        }
        return duplicateStudent;
    }

    public static void main(String[] args){
        List<Student> students=new ArrayList<>();

        students.add(new Student(5004,"Wyatt","Wyatt@example.com","Dance"));
        students.add(new Student(5010, "Lucy", "Lucy@example.com","Dance"));
        students.add(new Student(5550, "Aaron", "Aaron@example.com","Dance"));
        students.add(new Student(5560, "Ruby", "Ruby@example.com","Dance"));
        students.add(new Student(5015, "Sophie", "Sophie@example.com","Music"));
        students.add(new Student(5013, "Clara", "Clara@example.com","Music"));
        students.add(new Student(5010, "Lucy", "Lucy@example.com","Music"));
        students.add(new Student(5011, "Ivan", "Ivan@example.com","Music"));
        students.add(new Student(5550, "Aaron", "Aaron@example.com","Music"));

        Set<Student> s1=findUniques(students);
        System.out.println(s1);

        Set<Student> s2=findDuplicates(students);
        System.out.println(s2);

    }

}
