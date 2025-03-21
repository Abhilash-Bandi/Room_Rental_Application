import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User
{
    private String name;
    private String email;
    private String phoneNumber;
    private String password;



    //color codes
    static final String def = "\u001b[0;1m";
    static final String RESET = "\u001B[0m";
    static final String blink = "\u001b[5m";
    static final String red =  "\u001b[31;1m";
    static final String green = "\u001b[32;1m";
    static final String yellow = "\u001b[33;1m";
    static final String blue = "\u001b[34;1m";
    static final String purple = "\u001b[35;1m";
    static final String skblue = "\u001b[36;1m";
    static final String bgred =  "\u001b[101;1m";
    static final String bggreen = "\u001b[102;1m";
    static final String bgyellow = "\u001b[103;1m";
    static final String bgblue = "\u001b[104;1m";
    static final String bgpurpe = "\u001b[105;1m";
    static final String bgskblue = "\u001b[106;1m";


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public User(){

    }
    public User(String name,String email,String phoneNumber,String password){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }


    public  User createUser(){
        String name;
        String email;
        String phoneNumber;
        String password;
        Scanner scanner = new Scanner(System.in);
        int attempts=0;

        while (true)
        {
            System.out.print(yellow+"Enter name : "+RESET);
            String inputName = scanner.nextLine();

            if (Pattern.matches("^[a-zA-Z ]{3,}+$", inputName))
            {
                name = inputName;
                break;
            }
            else if(attempts>=2){
                return new User();
            }
            else
            {
                System.out.println(red+"Invalid name! Please enter alphabets only.");
                System.out.println("You Have "+(3- ++attempts)+" Attempts Left Enter valid Input."+RESET);

            }
        }
        attempts=0;
        while (true)
        {
            System.out.print(yellow+"Enter email : "+RESET);
            String inputEmail = scanner.nextLine();

            if (Pattern.matches("^[a-z]{6,12}+@[a-z]+\\.[a-z]+$", inputEmail))

            {
                email = inputEmail;
                break;
            }else if(attempts>=2){
                return new User();
            }
            else
            {
                System.out.println(red+"Invalid email! Ensure it contains '@' and ends with '.com'.");
                System.out.println("You Have "+(3- ++attempts)+" Attempts Left Enter valid Input."+RESET);

            }
        }

        attempts=0;
        while (true)
        {

            System.out.print(yellow+"Enter phone number : "+RESET);
            String inputPhone = scanner.nextLine();
            if (Pattern.matches("^[6-9]\\d{9}$", inputPhone))
            {
                phoneNumber = inputPhone;
                break;
            }
            else if(attempts>=2){
                return new User();
            }
            else
            {
                System.out.println(red+"Invalid phone number! Ensure it starts with 6-9 and is 10 digits long."+RESET);
                System.out.println(red+"You Have "+(3- ++attempts)+" Attempts Left Enter valid Input."+RESET);

            }
        }

        attempts=0;
        while (true)
        {

            System.out.print(yellow+"Enter password : "+RESET);
            String inputPassword = scanner.nextLine();

            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$";


            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(inputPassword);
            if( matcher.matches()){
                password = inputPassword;

                break;
            }else if(attempts>=2){
                return new User();
            }
            else
            {
                System.out.println(red+"Invalid Password!"+RESET);
                System.out.println(blink+"Password Constraints:\n1.Password Should Contain atleast One UpperCase\n2.Password Should Contain atleast One LowerCase\n3.Password Should Contain atleast One Special Character\n4.Password Should Contain atleast One Numeric Value."+RESET);
                System.out.println(red+"You Have "+(3- ++attempts)+" Attempts Left Enter valid Input."+RESET);

            }
        }
        User obj=new User(name,email,phoneNumber,password);

        return obj;

    }

    public void displayUserDetails()
    {


        System.out.println(yellow +"Name: " + name + RESET);
        System.out.println(skblue +"Phone Number: " + phoneNumber +RESET);

    }


}