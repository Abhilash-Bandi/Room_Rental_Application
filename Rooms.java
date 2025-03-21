import java.util.*;

abstract class Property{


    protected boolean isRental;
    protected String title;
    protected String location;
    protected String locality;
    protected String roomType;
    protected String roomSize;



    protected User user;


    protected String address;
    protected double roomPrice;
    protected double depositAmount=0;
    abstract void displayProperties(int a);
}



public class Rooms extends Property {
    static Scanner sc=new Scanner(System.in);


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



    static private HashMap<String,List<String>> map=new HashMap<String,List<String>>();


    static private List<String> hyderabadLocalities=Arrays.asList("KUKATPALLY","KPHB","SUNCITY","MEHDIPATNAM","AMEERPET","PUNJAGUTTA","SECUNDARABAD");

    static private List<String> mumbaiLocalities=Arrays.asList("BANDRA","DAHISAR","MULUND","SHIVAJI NAGAR","DHARAVI");

    static private List<String> bangaloreLocalities=Arrays.asList("CV RAMAN NAGAR","KRISHNARAJAPURAM","GIRINAGAR","ELECTRONIC CITY","KUMARASWAMY LAYOUT");
    private List<Rooms> listOfRooms=new ArrayList<>();
    static{
        map.put("HYDERABAD",hyderabadLocalities);
        map.put("MUMBAI",mumbaiLocalities);
        map.put("BANGALORE",bangaloreLocalities);
    }


    public Rooms(boolean isRental,String title,String location,String locality,String roomType, String roomSize,String address, double roomPrice, double depositAmount,User user) {

        super.isRental=isRental;
        super.title=title;
        super.location=location;
        super.locality=locality;
        super.roomType = roomType;
        super.roomSize = roomSize;
        super.address=address;
        super.roomPrice = roomPrice;
        super.depositAmount = depositAmount;
        super.user=user;


    }


    public Rooms(){

    }

    public HashMap<String, List<String>> getMap() {
        return map;
    }
    public boolean isRental() {
        return isRental;
    }

    public void setRental(boolean rental) {
        isRental = rental;
    }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Rooms> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(List<Rooms> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }



    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }



    void displayProperties(int snoValue){

        System.out.println(blink+"*************************************************"+RESET);
        System.out.println(blink+"*   "+green+"S.No - "+snoValue+RESET);
        if(isRental){
            System.out.println(blink+"#   "+green+"Rental Room   "+RESET);
        }else{
            System.out.println(blink+"#   "+green+"Selling Room");
        }
        if(title!=null) {
            System.out.println(blink+"*   "+green+"Title of the Room : " +RESET+ super.title);
        }

         System.out.println(blink+"*   "+green+"Location : "+RESET+location+blink+"\n*   "+green+"Locality : "+RESET+locality+blink+"\n*   "+green+"Room Type : " +RESET+roomType+blink+"\n*   "+green+"Room Size (or) NO of shares : "+RESET+roomSize+blink+"\n*   "+green+"Address of the Room or Flat : "+RESET+address+blink+"\n*   "+green+"Price of the Room/Flat : "+RESET+roomPrice+blink+"\n*   "+green+"Deposit For the Room/Flat : "+RESET+depositAmount+blink+"\n*   "+green+"Contact Details :\n"+RESET);
        user.displayUserDetails();
        System.out.println(blink+"****************************************************"+RESET);
    }

}



