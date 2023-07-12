package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Participant {
    private String participantName;
    private String participantTalent;
    private double participantScore;

    public Participant(String participantName,String participantTalent,double participantScore){
        this.participantName=participantName;
        this.participantTalent=participantTalent;
        this.participantScore=participantScore;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantTalent() {
        return participantTalent;
    }

    public void setParticipantScore(double participantScore) {
        this.participantScore = participantScore;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public void setParticipantTalent(String participantTalent) {
        this.participantTalent = participantTalent;
    }

    public double getParticipantScore() {
        return participantScore;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantName='" + participantName + '\'' +
                ", participantTalent='" + participantTalent + '\'' +
                ", participantScore=" + participantScore +
                '}';
    }
}
class testParticipant{
    public static List<Participant> generateListOfFinalists(Participant[] finalists) {

        List<Participant> participants_List= new ArrayList<>();
        participants_List.addAll(Arrays.asList(finalists));
        System.out.println(participants_List);
        return participants_List;
    }
    public static List<Participant> getFinalistsByTalent(List<Participant> finalists, String talent) {

        List<Participant> finalistsByTalent = new ArrayList<Participant>();
        for (Participant participant : finalists) {
            if (participant.getParticipantTalent().equals(talent)) {
                finalistsByTalent.add(participant);
            }
        }
        ListIterator<Participant> partIT=finalistsByTalent.listIterator();
        while(partIT.hasNext()){
            System.out.println();
            System.out.println(partIT.next());
            System.out.println();
        }
        System.out.println();
        return finalists;

    }

    public static void main(String[] args){

        Participant p1=new Participant("Sambhav","Swimming",92.4);
        Participant p2=new Participant("Shorya","Dancing",95.1);
        Participant p3=new Participant("Shaurya","Boxing",94.8);
        Participant p4=new Participant("Kunal","Running",90.0);
        Participant p5=new Participant("Ayush","Singing",93.6);

        Participant[] finalistsList={p1,p2,p3,p4,p5};

        List<Participant> participantList=generateListOfFinalists(finalistsList);

        System.out.println();
        System.out.println("Finalists");
        for (Participant finalist : finalistsList)
            System.out.println(finalist);

        String talent = "Singing";

        System.out.println();
        System.out.println("Finalists in " + talent + " category");

        List<Participant> finalistsCategoryList = getFinalistsByTalent(participantList, talent);
        for (Participant finalist : finalistsCategoryList)
            System.out.println(finalist);



    }
}
