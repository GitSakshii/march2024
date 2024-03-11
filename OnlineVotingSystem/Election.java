import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Election implements Serializable {
    private String position;
    private String electionId;
    private List<Candidate> electionCandidates;

    Election (String position,String electionId){
        this.position=position;
        this.electionId=electionId;
        electionCandidates=new ArrayList<>();

    }
     public String getElectionId(){
        return electionId;
    }
    public List<Candidate>getElectionCandidates(){
        return electionCandidates;
    }

    public void addCandidate(Candidate candidate){
        electionCandidates.add(candidate);
    }
    public void removeCandidate(Candidate candidate){
        electionCandidates.remove(candidate);
    }
    public void displayElectionCandidates() {

        System.out.println("Election Candidates:");
        for (Candidate candidate : electionCandidates) {
            System.out.println(candidate);
        }
    }
    @Override
    public String toString(){return "Election Id: "+electionId+" Position: "+position;}


}
