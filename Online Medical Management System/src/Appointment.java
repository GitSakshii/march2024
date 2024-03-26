import java.time.LocalDate;


public class Appointment {
    private String appointmentId;
    private String DoctorId;
    private String PatientId;
    private LocalDate date;
    private String Status;
    public Appointment(String appointmentId,String DoctorId, String PatientId, LocalDate date)
    {
        this.appointmentId=appointmentId;
        this.DoctorId=DoctorId;
        this.PatientId=PatientId;
        this.date=date;
        this.Status="Wating";
    }

    public String getAppointmentId(){
        return appointmentId;
    }
    public String getDoctorId(){
        return DoctorId;
    }
    public String getPatientId(){
        return PatientId;
    }
    public String getStatus(){
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    @Override
    public String toString(){
        return "Appointment Id:"+appointmentId+" Doctor Id :"+DoctorId+" Patient Id:"+PatientId+"Date:"+date;
    }
}
