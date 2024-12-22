package AirlinePassenger;

public class PassengerList {
    public static final int MAX_PASSENGERS = 3;
    private static Passenger[] passengers = new Passenger[MAX_PASSENGERS];
    private static int totalPassengerCount = 0;

    public  static boolean addPassenger(Passenger passenger) {
        if(totalPassengerCount < MAX_PASSENGERS) {
            System.out.println("The passenger is added.");
            passengers[totalPassengerCount] = passenger;
            totalPassengerCount++;
            return true;

        }
        System.out.println("The list is already full.");
        return false;
    }

    public  static boolean removePassenger(String passengerID) {
        for(int i = 0; i < totalPassengerCount; i++) {
            if(passengers[i].getPassengerID().equals(passengerID)) {
                System.out.printf("%s is removed.\n", passengers[i].getPassengerID());
                for(int j = i; j < totalPassengerCount-1 ; j++) {
                    passengers[j] = passengers[j+1];
                }
                totalPassengerCount--;
                return true;
            }
        }
        System.out.println("A passenger with that ID does not exist.");
        return false;
    }

    public static int getTotalPassengerCount() {
        return totalPassengerCount;
    }

    public  static void sortPassengers() {
        sortPassengers(passengers, totalPassengerCount-1);
    }
    private static void sortPassengers(Passenger[] passengers, int end) {
        if(end <= 0) return;

        for(int i = 0; i < end; i++) {
            if(passengers[i].getPassengerName().compareTo(passengers[i+1].getPassengerName()) > 0) {
                Passenger temp = passengers[i];
                passengers[i] = passengers[i+1];
                passengers[i+1] = temp;
            }
        }
        sortPassengers(passengers, end-1);
    }

    public  static Passenger getPassenger(String passengerName){
        return binarySearchPassenger(passengerName , 0 , totalPassengerCount);

    }
    private static Passenger binarySearchPassenger(String passengerName , int lowest, int highest) {
        if(lowest > highest) return null;
        int mid = (lowest + highest)/2;
        if(passengerName.compareTo(passengers[mid].getPassengerName()) == 0)
            return passengers[mid];
        else if (passengerName.compareTo(passengers[mid].getPassengerName()) > 0){
            return binarySearchPassenger(passengerName , mid +1 , highest);
        }
        else{
            return binarySearchPassenger(passengerName , lowest , mid -1);
        }
    }

    public  static Passenger[] getAllPassengers() {
        return passengers;
    }

    public  static void displayPassengers() {
        System.out.println("Passengers List:\n" + getPassengers(0) );
    }
    private static String getPassengers(int index) {
        if(index >= totalPassengerCount) return "";

        return passengers[index].toString() + "\n"
                + "--------------------------\n"
                + getPassengers(index+1);
    }
}
