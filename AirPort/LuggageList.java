package AirPort;

public class LuggageList {
    public static final int MAX_COUNT = 2;
    public static final int MAX_KILOS = 50;
    private static Luggage[] myLuggages = new Luggage[MAX_COUNT];
    private static int total_kilo = 0;
    private static int total_LuggageCount = 0;


    private LuggageList() {

    }
    public static boolean addLuggage(Luggage luggage){
        if(total_LuggageCount < MAX_COUNT && total_kilo + luggage.getWeigth() <= MAX_KILOS){
            System.out.println("Luggage has been added sucessfully");
            myLuggages[total_LuggageCount++] = luggage;
            total_kilo += luggage.getWeigth();
            return true;
        }
        System.out.println("Your luggage's weight is not acceptable");
        return false;
    }
    public static boolean removeLuggage(String ID){
        int luggageID = Integer.parseInt(ID);
        for (int i = 0; i < total_LuggageCount; i++) {
            if(myLuggages[i].getLuggage_ID() == luggageID){
                System.out.println("The Luggage belonging to " + myLuggages[i].getBelongsTo() + " is deleted.");
                total_kilo -= myLuggages[i].getWeigth();
                myLuggages[i] = myLuggages[--total_LuggageCount];
                return true;
            }
        }
        return false;
    }
    public static Luggage getLuggage(String owner){
        for (int i = 0 ; i < total_LuggageCount ; i++){
            if(myLuggages[i].getBelongsTo().equals(owner)){
                return myLuggages[i];
            }
        }
        return null;
    }
    public static Luggage[] getAll(){
        return myLuggages;
    }
    public static Luggage gethighestCapacityLuggage(){
        double highestCapacity = myLuggages[0].getCapacity();
        Luggage highestCapacityLuggage = myLuggages[0];
        for (int i = 1 ; i < total_LuggageCount ; i++){
            if(myLuggages[i].getCapacity() > highestCapacity){
                highestCapacity = myLuggages[i].getCapacity();
                highestCapacityLuggage = myLuggages[i];
            }
        }
        return highestCapacityLuggage;
    }
    public static int getTotalCount(){
        return total_LuggageCount;
    }
    public static void display(){
        display(0,total_LuggageCount);
    }
    private static void display(int start, int end ){
        if(start < end) {
            System.out.println(myLuggages[start].toString());
            display(start + 1, end);
        }
    }
}
