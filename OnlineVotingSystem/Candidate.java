import java.io.Serializable;

public class Candidate implements Serializable {
    private String id;
    private String name;
    private String position;
    private char electionSymbol;
    private int votes;
    public Candidate(String id,String name,String position,char electionSymbol){
        this.id=id;
        this.name=name;
        this.position =position;
        this.votes=0;
        this.electionSymbol=electionSymbol;
    }
    public String getId(){return id;
    }
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public char getElectionSymbol(){
        return electionSymbol;
    }
    public int getVotes(){
        return votes;
    }
    public void setName(String name){
       this.name=name;
    }
    public void setPosition(String Position){
        this.position=Position;
    }
    public void setVotes(int votes){
       this.votes=votes;
    }
    public void setElectionSymbol(char symbol){
        electionSymbol=symbol;
    }
    @Override
    public String toString(){
        return "ID:"+id+"Name:"+ name+",Position:"+position+"Election Symbol:"+electionSymbol;
    }
   }
