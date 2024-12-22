package AirlinePassenger;

public class Passenger {

    private String passengerID;
    private String name;
    private int age;
    private String seatNumber;
    private static int lastUsedId = 100;

    public Passenger(String name, int age, String seatNumber) {
        this.passengerID = Integer.toString(++lastUsedId);
        this.name = name;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getPassengerName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return  "passengerID= " + passengerID +
                "\nname= " + name +
                "\nage= " + age +
                "\nseatNumber= " + seatNumber ;
    }
}
