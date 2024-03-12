import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationForm {
    OnlineVotingSystem system=new OnlineVotingSystem();
    private String EmployeesFile="E:/VotingSystem/Employees.csv";
    private String RegisteredUsersFile="E:/VotingSystem/RegisteredUsers.csv";
    private String VotersVote="E:/VotingSystem/VotersVote.txt";
    public void RegisterUser(Scanner sc)throws IOException{
        System.out.println("Enter Employee Id");
        String empId=sc.nextLine();
        String[]EmployeeInfo=readEmployeeFile(empId);
        if(EmployeeInfo==null){
            System.out.println("Enter a Valid Employee ID");

        }
        else {
            if (Integer.parseInt(EmployeeInfo[2] )< 18) {
                System.out.println("Not Eligible for voting!!");
            } else {
                String Name = EmployeeInfo[1];
                String Age = EmployeeInfo[2];
                System.out.println("Set Password");
                String Password = sc.nextLine();
                System.out.println("Confirm Password");
                String ConfirmPassword = sc.nextLine();
                if (!Password.equals(ConfirmPassword)) {
                    System.out.println("Passwords Doesn't Match!! \n Please Re-enter Password");
                }

                AddRegisteredUser(empId, Name, Age, Password);
                System.out.println("User Registered!!");
            }
        }

    }

    public Boolean isRegisteredUser(String empId,String Password)throws IOException{
        try(BufferedReader br=new BufferedReader(new FileReader(RegisteredUsersFile))){
            String RegisteredUser;
            while ((RegisteredUser = br.readLine()) != null) {
                String[] words = RegisteredUser.split(",");
                if (words[0].equals(empId)&&words[3].equals(Password)) return true;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return false;
    }
    public String[] readEmployeeFile(String empId)throws IOException{

        try(BufferedReader br=new BufferedReader(new FileReader(EmployeesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                if (words[0].equals(empId)) return words;
            }
        }catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");

        }
      return null;
    }

    public void AddRegisteredUser(String EmployeeId,String Name,String Age,String Password)throws IOException{
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(RegisteredUsersFile))){
            writer.write(EmployeeId+","+Name+","+Age+","+Password);
            writer.newLine();
            System.out.println("User Registered");
        }catch (FileNotFoundException e){
            System.out.println("File not found :"+"E:/VotingSystem/RegisteredUsers");
        }
    }
    public List<Voter> readRegisteredUsers() {
        List<Voter> registeredUsers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RegisteredUsersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                // Assuming the format is: EmployeeId,Name,Age,Password
                if (userInfo.length == 4) {
                    String employeeId = userInfo[0];
                    String name = userInfo[1];
                    int age = Integer.parseInt(userInfo[2]);
                    String password = userInfo[3];
                    registeredUsers.add(new Voter(employeeId, name, age, password));
                } else {
                    System.out.println("Invalid format in registered users file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading Registered Users file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed error information
        }
        return registeredUsers;
    }

    public void ShowVoterdetails(){
        List<Voter>VoterList=readRegisteredUsers();
        for(Voter voter:VoterList){
            System.out.println(voter);
        }
    }
    public void removeRegisteredUser(String employeeId) {
        List<Voter> registeredUsers = readRegisteredUsers();
        boolean found = false;

        for (Voter voter : registeredUsers) {
            if (voter.getEmployeeId().equals(employeeId)) {
                registeredUsers.remove(voter);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User with Employee ID " + employeeId + " not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RegisteredUsersFile))) {
            for (Voter voter : registeredUsers) {
                bw.write(voter.toCsvString());
                bw.newLine();
            }
            System.out.println("User with Employee ID " + employeeId + " removed successfully.");
        } catch (IOException e) {
            System.out.println("Error writing updated registered users to file: " + e.getMessage());
        }
    }
    public void castVote(String employeeId, String electionId, char candidateSymbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(VotersVote));
             BufferedWriter bw = new BufferedWriter(new FileWriter(VotersVote, true))) {

            boolean alreadyVoted = false;
            String line;

            // Check if the file is empty or doesn't exist
            if ((line = br.readLine()) == null) {
                bw.write(employeeId + "," + electionId);
                bw.newLine();
            } else {
                do {
                    String[] voteInfo = line.split(",");
                    if (voteInfo[0].equals(employeeId) && voteInfo[1].equals(electionId)) {
                        alreadyVoted = true;
                        break;
                    }
                } while ((line = br.readLine()) != null);
            }

            if (alreadyVoted) {
                System.out.println("You have already cast your vote in this election.");
            } else {
                // Update the vote count for the corresponding candidate
                for (Election election : system.readElectionsFromFile()) {
                    if (election.getElectionId().equals(electionId)) {
                        for (Candidate candidate : election.getElectionCandidates()) {
                            if (candidate.getElectionSymbol() == candidateSymbol) {
                                candidate.setVotes(candidate.getVotes() + 1);
                                System.out.println("Vote cast successfully for candidate: " + candidate.getName());
                                break;
                            }
                        }
                        break;
                    }
                }
                bw.write(employeeId + "," + electionId);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error casting vote: " + e.getMessage());
        }
    }

    public void changePassword(String employeeId, String newPassword) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RegisteredUsersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (userInfo[0].equals(employeeId)) {
                    // Found the user, update the password
                    userInfo[3] = newPassword;
                    line = String.join(",", userInfo);
                }
                updatedLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error changing password: " + e.getMessage());
            return;
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RegisteredUsersFile))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
            System.out.println("Password changed successfully.");
        } catch (IOException e) {
            System.out.println("Error writing updated password to file: " + e.getMessage());
        }
    }



}
