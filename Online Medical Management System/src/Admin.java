public class Admin {
    private String UserName;

    private String Password;
    public Admin(String UserName,String Password)
    {
        this.UserName=UserName;
        this.Password=Password;
    }
    public Boolean AuthenticateAdmin(String UserName,String Password)
    {
        if(this.UserName.equals(UserName)&&this.Password.equals(Password))return true;
        return false;
    }
}
