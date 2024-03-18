import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Classroom classroom=new Classroom();
        AdminManager adminManager=new AdminManager();
        Scanner scanner=new Scanner(System.in);
        int choice;
      do {
          System.out.println("  Register ");
          System.out.println("1. As Admin");
          System.out.println("2. As Student");
          System.out.println("  Log in ");
          System.out.println("3. As Admin");
          System.out.println("4. As Student");
          choice=scanner.nextInt();
          scanner.nextLine();
          switch (choice){
              case 1:

                  adminManager.RegisterAdmin(scanner);
                  break;
              case 2:
                  classroom.registerAsStudent(scanner);

                  break;
              case 3:
                  if(adminManager.LoginasAdmin(scanner))
                  {
                      classroom.AdminMenu(scanner);
                  }
                  else {
                      System.out.println("Email / Password doesn't match!!");
                  }
                  break;
              case 4:
                  classroom.loginAsStudent(scanner);
                  break;
              case 5:
                  break;
              default:
                  System.out.println("Please Enter a valid choice");

          }

      }while(choice!=5);

    }
}
