import java.util.ArrayList;
import java.util.List;

public class Patient extends User{
    private String Results ;
    private String Prescription;
    private String expertAdvice;
    private List<Appointment>Appointments;


    public Patient(String id,String Name,String Email,String Password,String Prescription,String Results)
    {
        super(id,Name,Email,Password);
        this.Results=Results;
        this.Prescription=Prescription;
        this.expertAdvice="Awaited!!";
        Appointments=new ArrayList<>();


    }
    public void SetResults(String result)
    {
        this.Results=result;
    }
    public void setExpertAdvice(String advice)
    {
        this.expertAdvice=advice;
    }
    public void addAppointment(Appointment appointment){
        Appointments.add(appointment);
    }
    @Override
    public String toString(){
        return "Id:"+getId()+"Name:"+getName();
    }
    public String viewMedicalInformation(){
        return "Id:"+getId()+"Name:"+getName()+" Results:"+Results+" Prescription :"+Prescription+"\n"+"Expert Advice:"+expertAdvice;
    }

}
