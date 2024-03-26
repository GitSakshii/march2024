import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor extends User{
    private String Specialization;
    private List<Appointment>Appointments;
    private Map<String,Patient> Patients;
    public Doctor(String id,String Name,String email,String Password,String Speciallization)
    {
        super(id,Name, email,Password);
        this.Specialization=Speciallization;
        this.Appointments=new ArrayList<>();
        this.Patients=new HashMap<>();
    }
    public void addAppointment(Appointment appointment){
        Appointments.add(appointment);
    }
    public void viewAppointmentList(){
        System.out.println("Appointment List");
       for(Appointment appointment:Appointments){
           System.out.println(appointment);
       }
    }
    public void addPatient(Patient patient)
    {
        Patients.put(patient.getId(),patient);
    }
    public void viewPatientList()
    {
        for(Map.Entry<String ,Patient> patientEntry:Patients.entrySet())
        {
            System.out.println(patientEntry.getValue());
        }
    }
    public void viewPatientInfo(String patientId){
        System.out.println(Patients.get(patientId));
    }
    public void addAdvice(String patientId,String Advice){
        Patient patient=Patients.get(patientId);
        patient.setExpertAdvice(Advice);
    }
    @Override
    public String toString(){
        return "Id:"+getId()+"Name:"+getName()+"Specialization:"+Specialization;
    }


}
