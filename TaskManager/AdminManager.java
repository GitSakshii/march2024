import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private List<Admin> admins=new ArrayList<>();

    public void RegisterAdmin(Scanner scanner){
        System.out.println("Enter Email: ");
        String Email=scanner.nextLine();
        System.out.println("Set Password: ");
        String Password=scanner.nextLine();
        Admin admin=new Admin(Email,Password);
        admins.add(admin);
        System.out.println("Admin Added Sucessfully!!");

    }
    public Boolean LoginasAdmin(Scanner scanner)
    {
        System.out.println("Enter Email:");
        String Email=scanner.nextLine();
        System.out.println("Set Password: ");
        String Password=scanner.nextLine();
        for(Admin admin:admins)
        {
            if(admin.getEmail().equals(Email)&&admin.getPassword().equals(Password))
                return  true;
        }
        return false;
    }
}
