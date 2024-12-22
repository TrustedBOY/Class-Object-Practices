package AirlinePassenger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        info();

        System.out.println(PassengerList.getTotalPassengerCount());
        PassengerList.displayPassengers();
        PassengerList.sortPassengers();
        System.out.println("\n");
        PassengerList.displayPassengers();

        System.out.println("remove passenger:");
        PassengerList.removePassenger(scan.nextLine());

        System.out.println("get passenger: ");
        System.out.println(PassengerList.getPassenger(scan.nextLine()));

    }
    public static void info(){
        info(0);
    }
    private static void info (int count){
        if(count<PassengerList.MAX_PASSENGERS) {

            Scanner scanL = new Scanner(System.in);
            Scanner scanD = new Scanner(System.in);
            System.out.println("\nPassenger N. " + (count + 1));

            System.out.print("Passenger's Name: ");
            String name = scanL.nextLine();

            System.out.print("Passenger's Age: ");
            int age = scanD.nextInt();

            System.out.print("Passengers Seat Number: ");
            String seat = scanL.nextLine();
            Passenger passenger = new Passenger(name, age, seat);
            PassengerList.addPassenger(passenger);

            info(count + 1);

        }
        else System.out.println("PassengerList is Full\n");

    }


}
