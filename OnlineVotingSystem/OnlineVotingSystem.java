import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineVotingSystem {

    private Admin admin;

    private final String ElectionsFile = "E:/VotingSystem/elections.txt";

    private final String AdminFile="E:/VotingSystem/admin.txt";
    private final String Voters="E:/VotingSystem/RegisteredUsers.csv";


    public OnlineVotingSystem(){

        admin=readAdminFromFile();
    }
    private void saveAdminToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AdminFile))) {
            writer.write(admin.getUserName());
            writer.newLine();
            writer.write(admin.getRole());
            writer.newLine();
            writer.write(admin.getPassword());
        } catch (IOException e) {
            System.out.println("Error writing admin file: " + e.getMessage());
        }
    }
    private void writeElectionsToFile(List<Election> elections) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ElectionsFile))) {
            for (Election election : elections) {
                objectOutputStream.writeObject(election);
            }
        } catch (IOException e) {
            System.out.println("Error writing Elections file: " + e.getMessage());
        }
    }
    private Admin readAdminFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(AdminFile))) {
            String username = reader.readLine();
            String role=reader.readLine();
            String password = reader.readLine();
            return new Admin(username,role, password);
        } catch (IOException e) {
            System.out.println("Error reading admin file: " + e.getMessage());
            return null;
        }
    }
    public List<Election> readElectionsFromFile() {
        List<Election> elections= new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(ElectionsFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
              while (true) {
                try {
                    Election election = (Election) objectInputStream.readObject();
                    elections.add(election);
                } catch (EOFException e) {
                break;
            }
        } }catch (IOException|ClassNotFoundException  e) {
            System.out.println("Error reading Elections file: " + e.getMessage());
        }
        return elections;
    }

    public boolean adminLogin(){
        Scanner scanner=new Scanner(System.in);
        int attempt = 0;
        while (attempt < 3) {
            System.out.print("Enter Admin Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Admin Password: ");
            String password = scanner.nextLine();
            if (admin.authenticate(username, password)) {
                System.out.println("Admin login successful!");
                return true;
            } else {
                System.out.println("Invalid credentials. Please try again.");
                attempt++;
            }
        }
        System.out.println("Maximum login attempts reached. Exiting...");
        return false;
    }
    public void changeAdminPassword(String newPassword) {
        admin.changePassword(newPassword);
        saveAdminToFile();
    }
    public void showElectionDetails(){
        for(Election electionItem:readElectionsFromFile()){
            System.out.println(electionItem);
            }
    }
    public void showElectionCandidates(String electionid){

        int found=0;
        for(Election electionItem:readElectionsFromFile()){
            if(electionItem.getElectionId().equals(electionid)){
                electionItem.displayElectionCandidates();
                found=1;
                break;
            }
        }
        if(found==0) System.out.println("Election not found!!");
    }
    public void manageElection()throws IOException{
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Add Elections");
            System.out.println("2. Show Candidates");
            System.out.println("3. Edit Candidate Info");
            System.out.println("4. Delete Candidate");
            System.out.println("5. Declare Results");
            System.out.println("6. Go back to Main Menu");
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();
            List<Election> elections = readElectionsFromFile();
            switch (choice){
                case 1:
                    System.out.println("Add Elections");
                    System.out.println("Elections taking place for Position:");
                    String Position=scanner.nextLine();
                    System.out.println("Enter election Id");
                    String electionId=scanner.nextLine();
                    Election newElection=new Election(Position,electionId);
                    char add;
                    do {
                        System.out.println(" Add Candidate(y/n)");
                        add = scanner.next().charAt(0);
                        if(add=='n')break;
                        scanner.nextLine();
                        System.out.println("Enter Candidate ID");
                        String id=scanner.nextLine();
                        System.out.println("Enter Candidate Name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter Position :");
                        String position = scanner.nextLine();
                        System.out.println("Enter Election Symbol");
                        char electionSymbol = scanner.next().charAt(0);
                        Candidate candidate = new Candidate(id,name, position, electionSymbol);
                        newElection.addCandidate(candidate);
                        System.out.println("Candidate Added Successfully!!");
                    }while(add!='n');
                    List<Election>Elections=new ArrayList<>();
                    Elections.add(newElection);
                    writeElectionsToFile(Elections);
                    break;

                case 2:
                    System.out.println("Enter Election ID");
                    String elctionid=scanner.nextLine();
                    showElectionCandidates(elctionid);
                    break;
                case 3:
                    System.out.println("Edit Candidate info");
                    showElectionDetails();
                    System.out.println("Enter Election Id where you want to edit candidate info");
                    String id=scanner.nextLine();
                    int foundid=0;
                    Election e=null;
                    for(Election electionItem:readElectionsFromFile()){
                        if(electionItem.getElectionId().equals(id)){
                            electionItem.displayElectionCandidates();
                            e=electionItem;
                            foundid=1;
                            break;
                        }
                    }
                    if(foundid==0) System.out.println("Election not found!!");
                    System.out.println("Enter candidate id");
                    String CandidateId=scanner.nextLine();
                    Candidate editCandidate=null;
                    for(Candidate candidate:e.getElectionCandidates()){
                        if(CandidateId.equals(candidate.getId())){
                            editCandidate=candidate;
                            System.out.println(candidate);
                        }
                    }if(editCandidate==null) System.out.println("Invalid Candidate Id");
                    else {
                    System.out.println("Enter Field To be changed");
                    System.out.println("1. Name \n2. Symbol");
                    System.out.println("Enter Choice");
                    int Field = scanner.nextInt();
                    scanner.nextLine();
                    switch (Field) {
                        case 1:
                            System.out.println("Enter New Name:");
                            String newName = scanner.nextLine();
                            editCandidate.setName(newName);
                            System.out.println("Name Edited Successfully!!");
                            break;
                        case 2:
                            System.out.println("Enter new Election Symbol");
                            char newSymbol = scanner.next().charAt(0);
                            editCandidate.setElectionSymbol(newSymbol);
                            System.out.println("Election Symbol changed Successfully");
                            break;
                        default:
                            System.out.println("Enter Valid Choice!!");

                    }
                    // Update the list of elections with edited candidate information
                    for (Election election : elections) {
                        if (election.getElectionId().equals(e.getElectionId())) {
                            election = e; // Replace the old election object with the edited one
                            break;
                        }
                    }
                    // Write the updated list of elections back to the file
                    writeElectionsToFile(elections);

                }
                    break;
                case 4:
                    System.out.println("Delete Candidate");
                    System.out.println("Enter Election Id where you want to edit candidate info");
                    String Electionid=scanner.nextLine();

                    Election electioncandiatedlt=null;
                    for(Election electionItem:readElectionsFromFile()){
                        if(electionItem.getElectionId().equals(Electionid)){
                            electionItem.displayElectionCandidates();
                            electioncandiatedlt=electionItem;
                            foundid=1;
                            break;
                        }
                    }
                    if(electioncandiatedlt==null) System.out.println("Election not found!!");
                    System.out.println("Enter candidate id to be deleted");
                    String Candidateidtodelete=scanner.nextLine();
                    Candidate deleteCandidate=null;
                    for(Candidate candidate:electioncandiatedlt.getElectionCandidates()){
                        if(Candidateidtodelete.equals(candidate.getId())){
                            deleteCandidate=candidate;
                            System.out.println(candidate);
                        }
                    }
                    electioncandiatedlt.removeCandidate(deleteCandidate);
                    System.out.println("Candidate Removed Successfully!!");
                  break;
                case 5:
                    System.out.println("Enter Election ID:");
                    String ElectionId=scanner.nextLine();
                    declareElectionResult(ElectionId);

            }
        }while(choice!=6);
    }
    public void manageProfile(){
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Profile Management:");
            System.out.println("1. View Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Go back to main menu");
            System.out.println(" Enter your choice: ");
            choice =scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("\n   Admin Profile:");
                    System.out.println("User: "+admin.getUserName());
                    System.out.println("Role: "+admin.getRole());
                    break;
                case 2:
                    int change=1;
                    String newPassword="";
                    while(change!=0) {
                        System.out.println("Enter new Password:");
                        newPassword = scanner.nextLine();
                        System.out.println("Confirm new Password:");
                        String confirmPassword = scanner.nextLine();
                        if (newPassword.equals(confirmPassword))change=0;
                        else {
                            System.out.println("New Password and confirm Password field doesn't match !!\nPlease Re-enter!!");
                        }
                    }
                    changeAdminPassword(newPassword);
                    System.out.println("Password changed successfully!");
                    break;
            }
        }while (choice!=3);
    }
    public void declareElectionResult(String electionId) {
        List<Election> elections = readElectionsFromFile();
        for (Election election : elections) {
            if (election.getElectionId().equals(electionId)) {
                List<Candidate> candidates = election.getElectionCandidates();
                if (candidates.isEmpty()) {
                    System.out.println("No candidates registered for this election.");
                    return;
                }

                // Find the candidate with the most votes
                Candidate winner = candidates.get(0);
                for (Candidate candidate : candidates) {
                    if (candidate.getVotes() > winner.getVotes()) {
                        winner = candidate;
                    }
                }

                // Declare the winner
                System.out.println("Election winner: " + winner.getName() + " (Position: " + winner.getPosition() +
                        ", Symbol: " + winner.getElectionSymbol() + ") with " + winner.getVotes() + " votes.");

                // Remove the election from the list
                elections.remove(election);
                // Write the updated list back to the file
                writeElectionsToFile(elections);
                return;
            }
        }
        System.out.println("Election with ID " + electionId + " not found.");
    }
    

}
