
import java.util.Scanner;

public class Payment{

    //Color codes
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



    static Scanner scanner = new Scanner(System.in);
    public boolean paymentMenu() {

        System.out.println(green+"Welcome to the Payment System!"+RESET);
        int attempts=0;

        while(true) {

            System.out.println(green+"Choose a payment method:");
            System.out.println("1. Credit/Debit Card");
            System.out.println("2. UPI"+RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();


            if(choice==1) {
                if(processCardPayment()) {
                    return true;
                }
                else {
                    attempts++;
                    System.out.println(red+"You Have "+(3-attempts)+" Attempts Left."+RESET);
                }

            }
            else if(choice==2) {
                if(processUPIPayment())
                    return true;
                else{
                    attempts++;
                    System.out.println(red+"You Have "+(3-attempts)+" Attempts Left."+RESET);
                }
            }else if(attempts>=2){
                return false;
            }
            else {
                if(attempts<2) {
                    attempts++;
                    System.out.println(red+"You Have " + (3 - attempts) + " Attempts Left.");
                    System.out.println("Invalid choice. Please try again."+RESET);
                }else{
                    return false;
                }
            }
        }


    }

    public boolean processCardPayment() {
        System.out.println(yellow+"Enter your card number:");
        String cardNumber = scanner.nextLine();

        System.out.println("Enter expiration date (MM/YY):");
        String expiryDate = scanner.nextLine();

        System.out.println("Enter CVV:"+RESET);
        String cvv = scanner.nextLine();

        if (cardNumber.length() == 16 && cvv.length() == 3) {
            System.out.println(green+"Payment processed successfully with your card."+RESET);
            return true;
        } else {
            System.out.println(red+"Invalid card details. Payment failed."+RESET);
            return false;
        }
    }

    public boolean processUPIPayment() {
        System.out.println(yellow+"Enter your UPI ID:"+RESET);
        String upiId = scanner.nextLine();

        if (upiId.contains("@")) {
            System.out.println(green+"UPI payment successful."+RESET);
            return true;
        } else {
            System.out.println(red+"Invalid UPI ID. Payment failed."+RESET);
            return false;
        }
    }


}
