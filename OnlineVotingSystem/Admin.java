public class Admin {
    private String username;
    private String role;
    private String password;

    public Admin(String username,String role,String password){
        this.username=username;
        this.role=role;
        this.password=password;

    }
    public boolean authenticate(String enteredUsername,String enteredPassword){
        return this.username.equals(enteredUsername)&&this.password.equals(enteredPassword);
    }
    public void changePassword(String  newPassword){
        this.password=newPassword;
    }
    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
}
