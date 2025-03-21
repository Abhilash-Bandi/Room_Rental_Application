import java.util.Scanner;

class Services
{


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




	static Scanner scanner = new Scanner(System.in);
    static Payment pay=new Payment();
	public void servicesMenu()
	{
        
        int choice;

        System.out.println(blink+"Welcome to the Room Service!"+RESET);

        while (true) {
            System.out.println(yellow+"Please select a service:");
            System.out.println("1. Room Cleaning");
            System.out.println("2. Painting");
            System.out.println("3. Electrician");
            System.out.print("Enter your choice: "+RESET);

           choice = scanner.nextInt();

            if (choice >= 1 && choice <= 3) {
                break; 
            } else {
                System.out.println(red+"Invalid choice. Please try again.\n"+RESET);
            }
        }
        boolean flag=false;

        switch (choice) {
            case 1:
                flag=roomCleaning();
                break;
            case 2:
                flag=painting();
                break;
            case 3:
                flag=electrician();
                break;
        }

        if(flag)
            System.out.println(green+"Thank you for using our services!"+RESET);
        else
            System.out.println(red+"Something Went Wrong... Please Try Again."+RESET);
        
    }

    public static boolean roomCleaning() {
	int choice1;
	while(true)
	{
        	System.out.println(green+"1.Full house cleaning");
       		 System.out.println("2.Kitchen cleaning");
		System.out.println("3.Sofa cleaning"+RESET);
	 	System.out.print(yellow+"Enter your choice: "+RESET);

            	choice1 = scanner.nextInt();

            	if (choice1 >= 1 && choice1 <= 3)
		{
                	break; 
            	}
		else
		{
                System.out.println(red+"Invalid choice. Please try again.\n"+RESET);
            	}
        }
        boolean flag=false;
        switch (choice1) {
            case 1:
                System.out.println(purple+"You selected full house cleaning costs Rs.4259");
		        System.out.println("includes wiping and mopping of complete floor area ");
		        System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);
                String s=scanner.next();
                if(s.equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
            case 2:
                System.out.println(purple+"You selected kitchen cleaning costs Rs.1,439");
		        System.out.println("includes all items of esential kitchen cleaning  ");
		        System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);
                if(scanner.next().equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
            case 3:
                System.out.println(purple+"You selected Sofa cleaning costs Rs.539");
		        System.out.println("includes shamppoing and freshen the sofa's plush seats ");
		        System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);
                if(scanner.next().equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
                
        }
        return flag;
    }

    public static boolean painting() {
       int choice2;
       boolean flag=false;
	while(true)
	{
        	System.out.println(green+"1.full house painting");
       		 System.out.println("2.one wall painting"+RESET);
		
	 	System.out.print(yellow+"Enter your choice: "+RESET);

            	choice2 = scanner.nextInt();

            	if (choice2 >= 1 && choice2 <= 3)
		{
                	break; 
            	}
		else
		{
                System.out.println(red+"Invalid choice. Please try again.\n"+RESET);
            	}
        }

        switch (choice2) {
            case 1:
                System.out.println(green+"You selected full house painting costs based on estimation");
                System.out.println(purple+"includes exterior and interior painting with one year warranty! ");
                System.out.println(blue+"proceed for booking (Y/N) : "+RESET);
                String s= scanner.next();
                if(s.equalsIgnoreCase("y")) {
                    flag = true;
                }else {
                    flag=false;
                }
                        break;
            case 2:
                System.out.println(green+"You selected one wall painting starting at Rs.2599  ");
                System.out.println(purple+"includes one wall with service warranty of 1 year quick drying and complete coverage");
                System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);

                if(scanner.next().equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
            
                
       		 }
    return flag;
    }

    

    public static boolean electrician() {
   int choice3;
   boolean flag=false;
	while(true)
	{
        	System.out.println(green+"1.Book an electrician");
       		 System.out.println("2.Switch board/socket repair"+RESET);
		
	 	System.out.print(yellow+"Enter your choice: "+RESET);

            	choice3 = scanner.nextInt();

            	if (choice3 >= 1 && choice3 <= 3)
		{
                	break; 
            	}
		else
		{
                System.out.println(red+"Invalid choice. Please try again.\n"+RESET);
            	}
        }

        switch (choice3) {
            case 1:
                System.out.println(green+"You selected for an electrician visit costs Rs.229 ");
                System.out.println(purple+"includes on site issue inspection actual service based on scope of work and cost  ");
                System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);
                if(scanner.next().equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
            case 2:
                System.out.println(green+"You selected Switch board/socket repair costs Rs.149");
                System.out.println(purple+"material cost will be additional if any ");
                System.out.println(blue+"proceed for booking(Y/N) ?"+RESET);
                if(scanner.next().equalsIgnoreCase("y")) {
                    flag = pay.paymentMenu();
                }
                break;
            
                
        }
    return flag;
    }

    
}	 
 	
