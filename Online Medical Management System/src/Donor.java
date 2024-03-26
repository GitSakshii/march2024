public class Donor {
    private String donorId;
    private String Name;
    private int age;
    private String bloodGroup;
    public Donor(String donorId,String Name,int Age,String bloodGroup){
        this.donorId=donorId;
        this.Name=Name;
        this.age =Age;
        this.bloodGroup=bloodGroup;
    }
    public String getDonorId(){
        return donorId;
    }
    public void setDonorName(String Name){
        this.Name=Name;
    }
    public void setDonorAge(int age) {
       this.age=age;
    }
    public void setBloodGroup(String  BloodGroup){
        this.bloodGroup=bloodGroup;
    }

    @Override
    public String toString(){
        return "Id: "+donorId+" Name:"+Name+" Age: "+ age +" Blood Group:"+bloodGroup+"/n";
    }
}
