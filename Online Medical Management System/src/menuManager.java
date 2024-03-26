import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class menuManager {
    private Admin admin;
    private AdminManager adminManager;
    private Scanner scanner=new Scanner(System.in);
    public menuManager()
    {
        admin=new Admin("Sakshi","Sakshi");
        adminManager=new AdminManager();

    }
    public void mainMenu()
    {
        int choice;
        do
        {
            System.out.println("MAIN MENU:");
            System.out.println("1.Admin Login");
            System.out.println("2.Doctor Login:");
            System.out.println("3.Patient Login");
            System.out.println("4.Exit");
            System.out.println("Enter Your Choice:");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Username:");
                    String Username=scanner.nextLine();
                    System.out.println("Enter Password:");
                    String Password=scanner.nextLine();
                    if(admin.AuthenticateAdmin(Username,Password))
                    {
                         AdminMenu();
                    }else {
                        System.out.println("Invalid Username / Password");
                    }
                    break;
                case 2:
                    System.out.println("Doctor Login");
                    System.out.println("Enter Doctor Id");
                    String doctorId=scanner.nextLine();
                    System.out.println("Enter Password");
                    String doctorPassword=scanner.nextLine();
                    Doctor doctor=adminManager.authenticateDoctor(doctorId,doctorPassword);
                    if(doctor.equals(null)){
                        System.out.println("Invalid Id /Password!!");
                    }
                    else {
                        doctorsMenu(doctor);
                    }
                    break;

                case 3:
                    System.out.println("Patient Login");
                    System.out.println("Enter Patient Id");
                    String patientId=scanner.nextLine();
                    System.out.println("Enter Password");
                    String patientPassword=scanner.nextLine();
                    Patient patient=adminManager.authenticatePatient(patientId,patientPassword);
                    if(patient==null){
                        System.out.println("Invalid Id /Password!!");
                    }
                    else {
                        patientMenu(patient);
                    }
                    break;





            }

        }while(choice!=4);
    }
    public void AdminMenu()
    {
        int choice ;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1.Add Doctors:");
            System.out.println("2.Delete Doctors");
            System.out.println("3.Add Patients");
            System.out.println("4.Remove Patients");
            System.out.println("5.Approve Appointment");
            System.out.println("6.Decline Appointment");
            System.out.println("7.Add Donor");
            System.out.println("8.Delete Donor Information");
            System.out.println("9.Update Donor Information");
            System.out.println("10.Back to main menu");
            System.out.println("Enter Your Choice");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Doctor's Id:");
                    String id=scanner.nextLine();
                    System.out.println("Enter Doctor's Name:");
                    String UserName=scanner.nextLine();
                    System.out.println("Enter Email");
                    String Email=scanner.nextLine();
                    System.out.println("Set Password");
                    String Password=scanner.nextLine();
                    System.out.println("Specialization:");
                    String Specialization=scanner.nextLine();
                    Doctor doctor=new Doctor(id,UserName,Email,Password,Specialization);
                    adminManager.addDoctor(doctor);
                    System.out.println("Doctor Added Successfully!!");
                    break;
                case 2:
                    adminManager.viewDoctors();
                    System.out.println("Enter the ID of the doctor to be removed");
                    String doctorId=scanner.nextLine();
                    adminManager.removeDoctor(doctorId);
                    break;
                case 3:
                    System.out.println("Enter Patient's ID:");
                    String PatientId=scanner.nextLine();
                    System.out.println("Enter Patient's Name:");
                    String patientsName=scanner.nextLine();
                    System.out.println("Enter Email");
                    String patientEmail=scanner.nextLine();
                    System.out.println("Set Password");
                    String patientPassword=scanner.nextLine();
                    System.out.println("Enter the previous Prescription");
                    String Prescription=scanner.nextLine();
                    System.out.println("Enter Results");
                    String Results=scanner.nextLine();
                    Patient patient=new Patient(PatientId,patientsName,patientEmail,patientPassword,Prescription,Results);
                    adminManager.addPatient(patient);
                    System.out.println("Patient Added!!");
                    break;
                case 4:
                    System.out.println("Remove Patient");
                    adminManager.ViewPatients();
                    System.out.println("Enter Patient Id to remove");
                    String patientId=scanner.nextLine();
                    adminManager.removePatient(patientId);
                    System.out.println("Patient Removed Successfully!!");
                    break;
                case 5:
                    System.out.println("Appointements");
                    adminManager.viewAppointments();
                    System.out.println("Appointment Id to Approve");
                    String appointementId=scanner.nextLine();
                    if( !adminManager.approveAppointment(appointementId)) {
                        System.out.println("Enter valid appoointment Id!!");}
                    System.out.println("Appointment Approved!!");
                    break;
                case 6:
                    System.out.println("Appointments");
                    adminManager.viewAppointments();
                    System.out.println("Enter Appointment Id to Decline");
                    String appointmentToDelete=scanner.nextLine();
                    if( !adminManager.declineAppointment(appointmentToDelete)) {
                        System.out.println("Enter valid appoointment Id!!");}
                    break;
                case 7:
                    System.out.println("Enter donor Id ");
                    String donorId=scanner.nextLine();
                    System.out.println("Enter donor Name");
                    String donorName=scanner.nextLine();
                    System.out.println("Enter donor Age");
                    int donorage=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter donor Blood Group");
                    String bloodGroup=scanner.nextLine();
                    Donor donor=new Donor(donorId,donorName,donorage,bloodGroup);
                    adminManager.addDonor(donor);
                    System.out.println("Donor Added Successfully!!");
                    break;
                case 8:
                    System.out.println("Donors List");
                    adminManager.viewDonors();
                    System.out.println("Enter Donor Id to be deleted");
                    String DonorId=scanner.nextLine();
                    adminManager.removeDonor(DonorId);
                    System.out.println("Donor Successfully removed from the list");
                    break;
                case 9:
                    System.out.println("Donors List");
                    adminManager.viewDonors();
                    System.out.println("Enter Donor Id to be Updated");
                    String updateDonor=scanner.nextLine();
                    System.out.println("1.Update Name ");
                    System.out.println("2.Update age ");
                    System.out.println("3.Update BloodGroup");
                    int updatechoice=scanner.nextInt();
                    scanner.nextLine();

                    switch(updatechoice){
                        case 1:
                            System.out.println("Enter Updated name:");
                            String Name=scanner.nextLine();
                            adminManager.updateDonorName(updateDonor,Name);
                            System.out.println("Name Updated Successfully!!");
                            break;
                        case 2:
                            System.out.println("Enter Updated age");
                            int age=scanner.nextInt();
                            scanner.nextLine();
                            adminManager.updateDonorAge(updateDonor,age);
                            System.out.println("Age Updated Successfully!!");
                            break;
                        case 3:
                            System.out.println("Enter Updated Blood Group:");
                            String updatedBloodGroup=scanner.nextLine();
                            adminManager.updateDonorBloodGroup(updatedBloodGroup,updatedBloodGroup);
                            System.out.println("BloodGroup Updated Successfully");
                            break;

                    }
                case 10:
                    break;



            }

        }while(choice!=10);

    }
    public void doctorsMenu(Doctor doctor) {
        int doctorchoice;

        do{
            System.out.println("Doctor's Menu");
            System.out.println("1.View Appointment list");
            System.out.println("2.View Patient record");
            System.out.println("3.Provide Advice");

            doctorchoice=scanner.nextInt();
            scanner.nextLine();
            switch (doctorchoice){
                case 1:
                    doctor.viewAppointmentList();
                    break;
                case 2:
                    doctor.viewPatientList();
                    System.out.println("Enter Patient id to view Medical Information");
                    String patientId=scanner.nextLine();
                    doctor.viewPatientInfo(patientId);
                    break;
                case 3:
                    doctor.viewPatientList();
                    System.out.println("Enter Patient Id to Add Advice");
                    String advicePatient=scanner.nextLine();
                    doctor.viewPatientInfo(advicePatient);
                    System.out.println("Add Advice:");
                    String advice =scanner.nextLine();
                    doctor.addAdvice(advicePatient,advice);
                    break;
                case 4:
                    break;

            }

          doctorchoice=scanner.nextInt();
        }while(doctorchoice!=4);


    }
    public void patientMenu(Patient patient)
    {
        int patientchoice;
        do {
            System.out.println("Patient's Menu");
            System.out.println("1.Schedule Appointment");
            System.out.println("2.View Medical information");
            System.out.println("3.Go back");
            patientchoice=scanner.nextInt();
            scanner.nextLine();
            switch (patientchoice)
            {
                case 1:
                    adminManager.viewDoctors();
                    System.out.println("Enter Appointment Id");
                    String AppointmentID=scanner.nextLine();
                    System.out.println("Enter Doctors ID to schedule appointment");
                    String doctorId=scanner.nextLine();
                    System.out.println("Enter Date for the appointment(dd/mm/yyyy)");
                    String dateStr=scanner.next();
                    scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date= LocalDate.parse(dateStr,formatter);
                    Appointment appointment=new Appointment(AppointmentID,doctorId,patient.getId(),date);
                    adminManager.requestAppointment(appointment);
                    System.out.println("Appointment requested");
                    break;
                case 2:
                    System.out.println("Medical Information");
                    patient.viewMedicalInformation();
                    break;
                case 3:
                    break;

            }
        }while(patientchoice!=3);
    }

}
