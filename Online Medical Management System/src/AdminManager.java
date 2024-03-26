
import java.util.HashMap;
import java.util.Map;

public class AdminManager {

    private Map<String ,Appointment>appointments;
    private Map<String ,Patient>Patients;
    private Map<String ,Doctor>Doctors;
    private Map<String ,Donor> Donors;
    public AdminManager()
    {
        this.Patients=new HashMap<>();
        this.Doctors=new HashMap<>();
        this.Donors=new HashMap<>();
        this.appointments=new HashMap<>();
    }

    public void addPatient(Patient patient)
    {
        Patients.put(patient.getId(),patient);
    }
    public void removePatient(String Id){
        Patients.remove(Id);
    }
    public void ViewPatients(){
     for(Map.Entry<String,Patient> p:Patients.entrySet()){
         System.out.println(p.getValue());
     }
    }
    public Patient authenticatePatient(String id,String password)
    {
        if(!Patients.containsKey(id))return null;
        Patient patient=Patients.get(id);
        if(!patient.authenticateUser(password))return null;
        return patient;
    }
    public void addDoctor(Doctor doctor)
    {
        Doctors.put(doctor.getId(),doctor);
    }
    public void removeDoctor(String Id){
        Doctors.remove(Id);
    }
    public Doctor authenticateDoctor(String id,String password)
    {
        if(!Doctors.containsKey(id))return null;
        Doctor doctor=Doctors.get(id);
        if(!doctor.authenticateUser(password))return null;
        return doctor;
    }
    public void viewDoctors(){
        for(Map.Entry<String,Doctor> d:Doctors.entrySet()){
            System.out.println(d.getValue());
        }
    }
    public void addDonor(Donor donor){
        Donors.put(donor.getDonorId(),donor);
    }
    public void removeDonor(String Donorid)
    {
        Donors.remove(Donorid);
    }
    public void viewDonors()
    {
        for(Map.Entry<String ,Donor> donorEntry :Donors.entrySet()){
            System.out.println(donorEntry.getValue());
        }
    }
    public void updateDonorName(String donorId,String Name){
        Donor doner =Donors.get(donorId);
        doner.setDonorName(Name);
    }
    public void updateDonorAge(String donorId,int age)
    {
        Donors.get(donorId).setDonorAge(age);
    }
    public void updateDonorBloodGroup(String donorId,String bloodGroup){
        Donors.get(donorId).setBloodGroup(bloodGroup);
    }
    public void requestAppointment(Appointment appointment)
    {
        appointments.put(appointment.getAppointmentId(),appointment);
    }
    public Boolean approveAppointment(String appointmentid) {

        Appointment appointment=appointments.get(appointmentid);
        if(appointment.equals(null))return false;
       appointment.setStatus("Approved");
       Patient patient= Patients.get(appointment.getPatientId());
       patient.addAppointment(appointment);
       Doctor doctor=Doctors.get(appointment.getDoctorId());
       doctor.addAppointment(appointment);
       doctor.addPatient(patient);
       return true;

    }
    public Boolean declineAppointment(String AppointmentId)
    {
        if(appointments.get(AppointmentId).equals(null))return false;
        appointments.remove(AppointmentId);
        return true;
    }
    public void viewAppointments()
    {
        for(Map.Entry<String ,Appointment> appointmentEntry :appointments.entrySet()){
            System.out.println(appointmentEntry.getValue());
        }
    }
}
