import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main{

    //colour codes
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




    static Scanner sc = new Scanner(System.in);
    static Rooms obj = new Rooms();
    static List<Rooms> mainRooms=new ArrayList<>();
    static List<User> users=new ArrayList<>();


    // Main Menu logic method
    public static void mainMenu(User currentUser) {
        int attempts=0;
        while(true) {

            System.out.println(green+"Choose your Options\n1.To Post Your Property\n2.Search Rooms\n3.Delete your Room\n4.Display My Posted Properties\n5.Services\n6.Logout"+RESET);
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                addRoom(currentUser);
            }else if(n==2){
                getRooms();
            }else if(n==3){
                deleteRoom(currentUser);
            }else if(n==4){
                displayMyRooms(currentUser);
            }
            else if(n==5){
                Services serve=new Services();
                serve.servicesMenu();
            }
            else if(n==6){
                System.out.println(yellow+"Are you Sure You Want to Logout(Y/N)"+RESET);
                String t=sc.next();
                if(t.equalsIgnoreCase("y")){
                    break;
                }

            }else if(attempts>=2){
                break;
            }else{
                System.out.println(red+"Enter valid Options you have "+(3- ++attempts)+" Attempts Left."+RESET);

            }


        }
    }


    //logic to display user posted rooms
    public static void displayMyRooms(User user){
        int inc=0;
        for(Rooms x:mainRooms){
            if(x.getUser().equals(user)){
                x.displayProperties(++inc);
            }
        }
        if(inc==0){
            System.out.println(red+"Currently You Haven't Posted Any Rooms!"+RESET);
        }
    }


    //logic for deleting a room
    public static void deleteRoom(User user){

            while(true) {
                System.out.println(green+"Enter SNo To Delete"+RESET);
                int id=sc.nextInt();
                boolean flag=true;
                int inc=0;
                int index=0;
                for (Rooms room : mainRooms) {

                    if(room.getUser().equals(user)) {
                        if(id==++inc){
                            mainRooms.remove(index);
                            flag=false;
                            break;
                        }
                    }
                    index++;
                }

                if (flag) {
                    System.out.println(red+"Given ID Does Not Exist\nProvide valid ID To Delete."+RESET);
                }else{
                    System.out.println(purple+"Room Deleted Successfully."+RESET);
                }
                System.out.println(yellow+"Do You Want Exit(Y/N) : "+RESET);
                String s = sc.next();
                if (s.equalsIgnoreCase("y")) {
                    return;
                }
            }

    }



    //Logic for forget password
    public static void forgetPassword(){
        String email;
        String password;
        System.out.println("Enter Email : ");
        email=sc.next();
        System.out.println("Enter Password : ");
        password=sc.next();


    }


    //Search For a Room Logic
    public static void getRooms() {
        System.out.println(blue+"Search Flats or PG here"+RESET);
        int exit = 0;

        //Serch for rent or buy
        boolean isRental;
        while(true){
            System.out.println(yellow+"Do you want rent a room or buy\n1.To Rent a Room/PG\n2.To Buy Rooms"+RESET);
            int t=sc.nextInt();
            if(t==1){
                isRental=true;
                break;
            }else if(t==2){
                isRental=false;
                break;
            }else{
                System.out.println(red+"Enter Valid Options."+RESET);
            }
        }
        sc.nextLine();
        // search location Input

        String location="";

        while (true) {
            if (exit == 1) {
                return;
            }
            int inc=0;
            System.out.println(green+"Available Locations."+RESET);
            for(String x:obj.getMap().keySet()){

                System.out.println(++inc+"."+x);
            }
            System.out.print(yellow+"Enter Location value: "+RESET);
            int userChoice = sc.nextInt();
            boolean flag=false;
            inc=0;
            for (String x : obj.getMap().keySet()) {

                if(userChoice==++inc){
                    location=x;
                    flag=true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                System.out.println(red+"Invalid Choice! Please provide valid options."+RESET);
                System.out.println(yellow+"Do you want to continue?\nEnter your choice \n1.Exit\n2.continue"+RESET);
                exit = sc.nextInt();
                sc.nextLine();
            }
        }


        //locality Input

        String locality="";
        while (true) {
            if(exit==1){
                return;
            }
            System.out.println(green+"Available Localities"+RESET);

            boolean localityFlag = false;
            int inc=0;
            for (String x : obj.getMap().get(location)) {
                System.out.println(++inc+"."+x);
            }
            System.out.print(yellow+"Enter Your Choice :"+RESET);
            int userChoice=sc.nextInt();
            inc=0;
            for (String x : obj.getMap().get(location)) {
                if(userChoice==++inc){
                    locality=x;
                    localityFlag=true;
                    break;
                }

            }
            if (localityFlag) {
                break;
            } else {
                System.out.println(red+"Invalid Choice! Please Provide valid Options."+RESET);
                System.out.println(yellow+"Do you want to continue?");
                System.out.println("Enter your choice\n1.Exit\n2.Continue"+RESET);
                exit = sc.nextInt();


            }
        }



        // search logic for Room type.

        String roomType;

        while (true) {
            if(isRental) {
                System.out.println(yellow+"Select Room Type \n1.PG/Hostel\n2.Flat : "+RESET);
                int temp = sc.nextInt();
                if (temp == 1) {
                    roomType = "PG";
                    break;

                } else if (temp == 2) {
                    roomType = "FLAT";
                    break;
                } else {
                    System.out.println(red+"Enter valid options"+RESET);
                }
            }else{
                roomType="FLAT";
                break;
            }

        }

        // Search Logic for Room Size.
        String roomSize;
        while (true) {
            if(isRental) {
                if (roomType.equalsIgnoreCase("FLAT")) {
                    System.out.println(yellow+"Select Room Size \n1.1BHK\n2.2BHK\n3.Any "+RESET);
                } else {
                    System.out.println(yellow+"Select Number of Room Share \n1.For Two Share\n2.For Three share\n3.Any"+RESET);
                }
                int temp = sc.nextInt();
                if (temp == 1) {
                    if (roomType.equalsIgnoreCase("flat")) {
                        roomSize = "1BHK";
                    } else {
                        roomSize = "Two Share";
                    }
                    break;
                } else if (temp == 2) {
                    if (roomType.equalsIgnoreCase("flat")) {
                        roomSize = "2BHK";
                    } else {
                        roomSize = "Three Share";
                    }
                    break;
                } else if (temp == 3) {
                    roomSize = "Any";
                    break;
                } else {
                    System.out.print(red+"Enter valid options"+RESET);
                }
            }else{
                System.out.println(yellow+"Select Room Size \n1.1BHK\n2.2BHK\n3.Any "+RESET);
                int temp = sc.nextInt();
                if (temp == 1) {

                    roomSize = "1BHK";

                    break;
                } else if (temp == 2) {

                    roomSize = "2BHK";
                    break;
                } else if (temp == 3) {
                    roomSize = "Any";
                    break;
                } else {
                    System.out.print(red+"Enter valid options"+RESET);
                }
            }

        }



        //Search Logic for price
        double roomPriceStart=0;
        double roomPriceEnd=0;
        while (true) {
            System.out.println(yellow+"Do you want to filter rooms by price Range (Y/N) : "+RESET);
            String temp=sc.next();
            if(temp.equalsIgnoreCase("y")){
                System.out.println(yellow+"Enter Room Price Range"+RESET);
                try {
                    System.out.print(yellow+"Enter minimum value : "+RESET);
                    roomPriceStart = sc.nextDouble();

                    System.out.print(yellow+"Enter  maximum value : "+RESET);

                    roomPriceEnd=sc.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println(red+"Enter valid price"+RESET);
                }
            }else if(temp.equalsIgnoreCase("N")){
                break;
            }else{
                System.out.println(red+"Enter valid Input"+RESET);
            }

        }

        //Search Logic for deposit money
        boolean depositAmount = true;
        boolean noFilterOnDeposit=true;
        while (true) {
            if(isRental) {
                System.out.println(yellow+"Do You Want to Filter Search Results With Deposit Amount(Y/N) : "+RESET);
                String t = sc.next();
                if (t.equalsIgnoreCase("Y")) {
                    noFilterOnDeposit = false;
                    System.out.println(yellow+"Do YOU WANT ROOMS WITHOUT DEPOSIT AMOUNT(Y/N) : "+RESET);
                    String temp = sc.next();
                    if (temp.equalsIgnoreCase("y")) {
                        depositAmount = false;
                        break;
                    } else if (temp.equalsIgnoreCase("n")) {
                        break;
                    } else {
                        System.out.println(red+"Enter valid Input"+RESET);
                    }
                } else {

                    break;
                }
            }else{
                break;
            }
        }

        //Display Rooms according to given values
        List<Rooms> list=mainRooms;
        List<Rooms> resultList=new ArrayList<>();
        for(Rooms room:list){
            if(isRental && room.isRental) {
                if (room.location.equalsIgnoreCase(location)) {
                    if (room.locality.equalsIgnoreCase(locality)) {
                        if (room.roomType.equalsIgnoreCase(roomType)) {
                            if (roomSize.equalsIgnoreCase("Any") || room.roomSize.equalsIgnoreCase(roomSize)) {
                                if ((room.roomPrice >= roomPriceStart && room.roomPrice <= roomPriceEnd) || roomPriceStart == 0) {
                                    if (noFilterOnDeposit) {
                                        resultList.add(room);
                                    } else {
                                        if (!depositAmount) {
                                            if (room.depositAmount == 0) {
                                                resultList.add(room);
                                            }
                                        } else {
                                            if (room.depositAmount != 0) {
                                                resultList.add(room);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else if(!isRental && !room.isRental){
                if (room.location.equalsIgnoreCase(location)) {
                    if (room.locality.equalsIgnoreCase(locality)) {
                        if (room.roomType.equalsIgnoreCase(roomType)) {
                            if (roomSize.equalsIgnoreCase("Any") || room.roomSize.equalsIgnoreCase(roomSize)) {
                                if ((room.roomPrice >= roomPriceStart && room.roomPrice <= roomPriceEnd) || roomPriceStart == 0) {
                                    if (noFilterOnDeposit) {
                                        resultList.add(room);
                                    } else {
                                        if (!depositAmount) {
                                            if (room.depositAmount == 0) {
                                                resultList.add(room);
                                            }
                                        } else {
                                            if (room.depositAmount != 0) {
                                                resultList.add(room);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // displaying result list
        if(resultList.size()==0){
            System.out.println(red+"No Rooms Available!\nplease change your Filter values.."+RESET);
        }else {
            int inc=0;
            for (Rooms room : resultList) {
                room.displayProperties(++inc);
            }
        }





    }


    // Adding Room logic

    public static void addRoom(User currentUser){



        //Boolean value for the room purpose rental or selling purpose
        boolean isRental;
        int exit=0;
        while(true){
            System.out.println(yellow+"Do You Want to Add Room/Flat for Rental purpose or Selling purpose\n1.Rental purpose\n2.Selling purpose"+RESET);
            int t=sc.nextInt();
            if(t==1){
                isRental=true;
                break;
            }else if(t==2){
                isRental=false;
                break;
            }else{
                System.out.println(red+"Enter valid Input"+RESET);
            }
        }
        sc.nextLine();
        //Input logic of title
        String title=null;
        while (true) {
            System.out.println(yellow+"Do You Want to add title for Your Property/Flat (Y/N) : "+RESET);
            String t = sc.nextLine();
            if (t.equalsIgnoreCase("Y")) {
                System.out.print(yellow+"Enter Property/Flat Name : "+RESET);
                title = sc.nextLine().toUpperCase();
                break;
            } else if (t.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println(red+"Enter valid Input."+RESET);
            }
        }



        // Input for location

        String location="";

        while (true) {
            if (exit == 1) {
                return;
            }
            int inc=0;
            System.out.println(green+"Available Locations."+RESET);
            for(String x:obj.getMap().keySet()){

                System.out.println(++inc+"."+x);
            }
            System.out.print(yellow+"Enter Location value: "+RESET);
            int userChoice = sc.nextInt();
            boolean flag=false;
            inc=0;
            for (String x : obj.getMap().keySet()) {

                if(userChoice==++inc){
                    location=x;
                    flag=true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                System.out.println(red+"Invalid Choice! Please provide valid options."+RESET);
                System.out.println(yellow+"Do you want to continue?\nEnter your choice \n1.Exit\n2.continue"+RESET);
                exit = sc.nextInt();
                sc.nextLine();
            }
        }


        // Input for localities


        String locality="";
        while (true) {
            if(exit==1){
                return;
            }
            System.out.println(green+"Available Localities"+RESET);

            boolean localityFlag = false;
            int inc=0;
            for (String x : obj.getMap().get(location)) {
                System.out.println(++inc+"."+x);
            }
            System.out.print(yellow+"Enter Your Choice :"+RESET);
            int userChoice=sc.nextInt();
            inc=0;
            for (String x : obj.getMap().get(location)) {
                if(userChoice==++inc){
                    locality=x;
                    localityFlag=true;
                    break;
                }

            }
            if (localityFlag) {
                break;
            } else {
                System.out.println(red+"Invalid Choice! Please Provide valid Options."+RESET);
                System.out.println(yellow+"Do you want to continue?");
                System.out.println("Enter your choice\n1.Exit\n2.Continue"+RESET);
                exit = sc.nextInt();


            }
        }


        //Input for roomType
        String roomType;
        while (true) {
            if(isRental) {
                System.out.println(yellow+"Select Room Type \n1.PG/Hostel\n2.Flat : "+RESET);
                int temp = sc.nextInt();
                if (temp == 1) {
                    roomType = "PG";
                    break;

                } else if (temp == 2) {
                    roomType = "FLAT";
                    break;
                } else {
                    System.out.println(red+"Enter valid options"+RESET);
                }
            }else{
                roomType="FLAT";
                break;
            }

        }

        //Input for Room Size.
        String roomSize;
        while (true) {
            if(isRental) {
                if (roomType.equalsIgnoreCase("FLAT")) {
                    System.out.println(yellow+"Select Room Size \n1.1BHK\n2.2BHK "+RESET);
                } else {
                    System.out.println(yellow+"Select Number of Room Share \n1.For Two Share\n2.For Three share"+RESET);
                }
                int temp = sc.nextInt();
                if (temp == 1) {
                    if (roomType.equalsIgnoreCase("flat")) {
                        roomSize = "1BHK";
                    } else {
                        roomSize = "Two Share";
                    }
                    break;
                } else if (temp == 2) {
                    if (roomType.equalsIgnoreCase("flat")) {
                        roomSize = "2BHK";
                    } else {
                        roomSize = "Three Share";
                    }
                    break;
                } else {
                    System.out.print(red+"Enter valid options"+RESET);
                }
            }else{
                System.out.println(yellow+"Select Room Size \n1.1BHK\n2.2BHK "+RESET);
                int temp = sc.nextInt();
                if(temp==1){
                    roomSize="1BHk";
                    break;
                }else if(temp==2){
                    roomSize="2BHK";
                    break;
                }else{
                    System.out.print(red+"Enter valid options"+RESET);
                }
            }

        }
        sc.nextLine();
        //Input for Address
        String address;
        while(true){
            System.out.println(yellow+"Enter Address of the Room/Flat : "+RESET);
            try{
                address=sc.nextLine();
                break;
            }catch (Exception e){
                System.out.println(red+"Enter valid Input"+RESET);
            }
        }

        //Input for roomPrice
        double roomPrice;
        while (true) {
            System.out.println(yellow+"Enter Room Price : "+RESET);
            try {
                roomPrice = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println(red+"Enter valid price"+RESET);
            }
        }

        //Input for depositAmount
        double depositAmount = 0;
        while (true) {
            if(isRental) {
                System.out.println(yellow+"Do YOU WANT DEPOSIT AMOUNT FOR ROOM(Y/N) : "+RESET);
                String temp = sc.next();
                if (temp.equalsIgnoreCase("y")) {
                    try {
                        System.out.println(green+"Enter deposit Money:"+RESET);
                        depositAmount = sc.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println(red+"Enter valid price"+RESET);
                    }
                } else if (temp.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println(red+"Enter valid Input"+RESET);
                }
            }else{
                break;
            }
        }

        // adding payment for posting
        double commision=(5*roomPrice)/100;
        while(true){
            System.out.println(green+"To Post your property you have to pay 5 percent commission."+RESET);
            System.out.println("Amount = "+commision);
            System.out.println(yellow+"Do You Want to continue(Y/N)"+RESET);
            String t=sc.next();
            if(t.equalsIgnoreCase("y")){
                Payment pay=new Payment();
                if(!pay.paymentMenu()){
                    return;
                }

                break;
            }else if(t.equalsIgnoreCase("n")){
                return;
            }else{
                System.out.println(red+"Enter valid choice."+RESET);
            }

        }


        // adding given data into the rooms array.
        List<Rooms> list = obj.getListOfRooms();
        Rooms room= new Rooms(isRental,title,location, locality, roomType, roomSize,address, roomPrice, depositAmount,currentUser);
        list.add(room);
        obj.setListOfRooms(list);
        mainRooms.add(room);
        System.out.println(green+"Room added successfully!"+RESET);


        System.out.println(yellow+"Do you want to see your rooms(Y/N)"+RESET);
        String x = sc.next();
        if (x.equalsIgnoreCase("y")) {
            displayMyRooms(currentUser);

        }


    }
    public static void main(String[] args){

       User obj=new User();




        int attempts=0;
        while(true){

            System.out.println(blue+"Welcome to the Room Rental Application\n1.Login\n2.Sign Up\n3.exit"+RESET);
            int n= sc.nextInt();




            if(n==1){

                System.out.print(yellow+"Enter Email : "+RESET);
                String email=sc.next();
                sc.nextLine();
                System.out.print(yellow+"Enter Password : "+RESET);
                String password=sc.next();
                sc.nextLine();
                User currentUser=new User();
                boolean found=false;
                for(User user:users){
                    if(user.getEmail().equals(email)) {

                        if (user.getPassword().equals(password)) {
                            currentUser = user;
                            found = true;
                            break;
                        }
                    }
                }

                if(found){
                    System.out.println(green+"Login Successfully"+RESET);
                    mainMenu(currentUser);
                }else{
                    System.out.println(red+"Invalid Credentials Try Again."+RESET);
                }
            }else if(n==2){
                User object=obj.createUser();
                if (object.getName() != null) {
                    users.add(object);
                    System.out.println(green+"You Have Registered Successfully.\nLogin with your credentials."+RESET);
                }
                else{
                    break;
                }

            }else if(n==3){
                break;
            }

        }


    }
}
