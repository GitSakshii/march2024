
public class Voter{
    private String Name;
    private String EmployeeId;
    private int age;

    private String Password;
    Voter(String EmployeeId,String Name,int age,String Password){
        this.Name=Name;
        this.EmployeeId=EmployeeId;
        this.age=age;
        this.Password=Password;
    }

    public String getEmployeeId(){return this.EmployeeId;}
    @Override
    public String toString(){return "Employee Id:"+EmployeeId+" Name:"+Name+" Age: "+age;}

}
