import java.io.IOException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        RegistrationForm registrationForm=new RegistrationForm();
        OnlineVotingSystem system=new OnlineVotingSystem();
        int choice;
        try {
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Admin Login");
            System.out.println("2. Register User ");
            System.out.println("3. User Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (system.adminLogin()) {
                            int adminChoice;
                            do {
                                System.out.println("\nAdmin Menu:");
                                System.out.println("1. Manage Election Candidate");
                                System.out.println("2. Manage Voters ");
                                System.out.println("3. Manage Profile");
                                System.out.println("4. Logout");
                                System.out.println("Enter your Choice: ");
                                adminChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (adminChoice) {
                                    case 1:
                                        system.manageElection();
                                        break;
                                    case 2:
                                        int adminchoice;
                                        do{
                                            System.out.println("Manage Voters:");
                                            System.out.println("1.View Voters");
                                            System.out.println("2.Remove Voters");
                                            System.out.println("3.Go Back");
                                            System.out.println("Enter Choice");
                                            adminchoice=scanner.nextInt();
                                            scanner.nextLine();
                                            switch (adminchoice){
                                                case 1:
                                                    registrationForm.ShowVoterdetails();
                                                    break;
                                                case 2:
                                                    registrationForm.ShowVoterdetails();
                                                    System.out.println("Enter Id of voter to be removed");
                                                    String removeVoter=scanner.nextLine();
                                                    registrationForm.removeRegisteredUser(removeVoter);
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("Enter Valid Choice!!");
                                            }

                                        }while(adminchoice!=3);

                                        break;
                                    case 3:
                                        system.manageProfile();
                                        break;
                                    default:
                                        System.out.println("Invalid choice .Please try again..");
                                }


                            } while (adminChoice != 4);
                        } else {
                            System.out.println("Exiting...");
                            System.exit(0);
                        }
                        break;
                    case 2:
                        registrationForm.RegisterUser(scanner);
                        break;
                    case 3:
                        int attempts=3;

                        System.out.println("Log in ");
                        String employeeId="",Password="";
                        while(attempts!=0) {
                            System.out.println("Enter Employee ID:");
                            employeeId = scanner.nextLine();
                            System.out.println("Enter Password:");
                            Password = scanner.nextLine();
                            if (!registrationForm.isRegisteredUser(employeeId, Password)) {
                                System.out.println("Invalid Username or Password .Try Again");

                                attempts--;
                                System.out.println(attempts +" attempts left!!");
                            }
                            else break;
                        }
                        if(attempts==0){ System.out.println("User has been  Blocked for 5 seconds...");
                            try {
                                Thread.sleep(5000); // Block for 5 seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }}
                        if(registrationForm.isRegisteredUser(employeeId,Password)) {
                            System.out.println("Login Successful!!");

                            int userChoice;
                            do {
                                System.out.println("1.View Profile");
                                System.out.println("2.Show Active Elections ");
                                System.out.println("3.Cast Vote");
                                System.out.println("4.Change Password");
                                System.out.println("5.Logout");
                                System.out.println(" Enter your Choice");
                                 userChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (userChoice){
                                    case 1:
                                        for(Voter voter:registrationForm.readRegisteredUsers()){
                                            if(employeeId.equals(voter.getEmployeeId())){
                                                System.out.println(voter);
                                                break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Elections:");
                                        system.showElectionDetails();
                                        break;
                                    case 3:
                                        System.out.println("Elections:");
                                        system.showElectionDetails();
                                        System.out.println("Enter Election Id");
                                        String idElection =scanner.nextLine();
                                        system.showElectionCandidates(idElection);
                                        System.out.println("Enter Candidates Symbol");
                                        char symbol=scanner.next().charAt(0);
                                        registrationForm.castVote(employeeId,idElection,symbol);
                                        break;
                                    case 4:
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
                                        registrationForm.changePassword(employeeId,newPassword);
                                        System.out.println("Password changed successfully!");
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid Choice.Enter Valid choice!!");
                                }

                            }while(userChoice!=5);

                         }



                        break;
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice. Please try again..");

                }
            } while (choice != 5) ;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
