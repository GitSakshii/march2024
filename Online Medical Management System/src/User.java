public class User {
    private String UserId;
    private String Name;
    private String Email;
    private String Password;
    public User(String UserId,String Name,String Email,String Password)
    {
        this.UserId=UserId;
        this.Name=Name;
        this.Email=Email;
        this.Password=Password;
    }
   public String getId(){
        return this.UserId;
   }
   public String getName(){
        return Name;
   }
   public boolean authenticateUser(String password){
        if(this.Password.equals(password))return true;
        return false;
   }
   public String getEmail(){
        return Email;
   }

}
