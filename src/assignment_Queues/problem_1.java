package assignment_Queues;
//Implement a program to split a given queue of patients based on their age and return a list of queues with the split queues.

//The first element of the list should contain a queue with all the patients having age greater than or equal to 60.
//The second element of the list should contain a queue with all the remaining patients.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Patient{
    String name;
    int age;
    String gender;

    public Patient(String name, String gender,int age){
        this.name=name;
        this.gender=gender;
        this.age=age;

    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
public class problem_1 {
    public static List<Deque<Patient>> splitQueue(Deque<Patient> patientsQueue) {

        List<Deque<Patient>> sq=new ArrayList<>();
        Deque<Patient> d1=new ArrayDeque<Patient>();
        Deque<Patient> d2=new ArrayDeque<Patient>();
        for(Patient p:patientsQueue){
            if(p.getAge()>=60){
                d1.add(p);
            }
            else{
                d2.add(p);
            }
        }
        sq.add(d1);
        sq.add(d2);
        return sq;
    }

    public static void main(String[] args){

        Patient patient1=new Patient("Jack","Male",18);
        Patient patient2=new Patient("Tom","Male",64);
        Patient patient3=new Patient("Simona","Female",24);

        Deque<Patient> patientDeque= new ArrayDeque<Patient>();
        patientDeque.add(patient1);
        patientDeque.add(patient2);
        patientDeque.add(patient3);


        List<Deque<Patient>> queuesList = splitQueue(patientDeque);

        int counter=0;
        for (Deque<Patient> queue : queuesList) {
            if(counter==0)
                System.out.println("Patients in the senior queue\n============================");
            else
                System.out.println("Patients in the normal queue\n============================");

            for (Patient patient : queue) {
                System.out.println("Name : "+patient.getName());
                System.out.println("Age : "+patient.getAge());
                System.out.println();
            }
            counter++;
        }
    }
}
