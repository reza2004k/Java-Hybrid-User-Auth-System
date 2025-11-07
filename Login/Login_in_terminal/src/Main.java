import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(".Enter");
        System.out.println(".Enroll");
        System.out.println(".Exit");

        int n = input.nextInt();
        switch (n) {

            case 1:
                log_in();
            case 2:
                sign_in();
            case 3:
                System.exit(0);
        }
    }

    public static void log_in() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username:");
        String user = input.next();
        System.out.println("Password:");
        String pass = input.next();
        if (check_user(user) == null || check_user(user).compareTo(pass) != 0) {
            System.out.println("User or Password is not valid\n");
            log_in();
        }
        check_number();
    }

    public static void sign_in() {

        Scanner input = new Scanner(System.in);
        System.out.println("Username:");
        String user = input.next();

        if (check_user(user) != null) {
            System.out.println("Username already exists\n");
            sign_in();
        }
        check_pass(user);

    }

    public static String check_user(String user) {
        try {
            FileReader fr = new FileReader("member.txt");
            Scanner fs = new Scanner(fr);
            String c = fs.next();
            while (c.compareTo("null") != 0) {
                if (user.compareTo(c) == 0) {
                    String pu = fs.next();
                    return pu;
                }
                fs.next();
                c = fs.next();
            }
        } catch (Exception e) {
            
        }
        return null;
    }

    public static void check_pass(String user) {
        try {
            FileWriter fw = new FileWriter("member.txt", true);
            Scanner input = new Scanner(System.in);
            System.out.println("New Password:");
            String pass1 = input.next();
            char[] p = pass1.toCharArray();
            if (p.length < 8) {
                System.out.println("Your password is less than 8 character\n");
                check_pass(user);
            } else {
                System.out.println("Confirm Password:");
                String pass = input.next();
                if (pass.compareTo(pass1) != 0) {
                    System.out.println("Passwords do NOT match\n");
                    check_pass(user);
                }
                else {
                    fw.write(user + "\n");
                    fw.write(pass + "\n");
                    System.out.println("Congratulation your enroll successfully committed:)\n");
                    System.out.println("_______________WELCOME To our Website______________");
                    fw.close();
                    System.exit(0);
                }
            }
        } catch (Exception e) {

        }
    }
    public static void check_number(){
        Scanner input=new Scanner(System.in);
        System.out.println("------------------------------");
        int a=(int) (Math.random()*10000);
        System.out.println(a);
        System.out.println("------------------------------");

        System.out.println("Please fill this field with correct code");
        int b=input.nextInt();
        if(a==b){
            System.out.println("_______________WELCOME To our Website______________");
            System.exit(0);
        }else {
            System.out.println("invalid code");
            check_number();
        }
    }
}