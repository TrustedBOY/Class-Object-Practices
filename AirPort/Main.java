package AirPort;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Luggage luggage = null;
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < LuggageList.MAX_COUNT; i++) {
            System.out.println("Luggage Number #" + (i+1));
            System.out.print("Enter the name of the owner: ");
            String owner = scan.nextLine();
            System.out.print("Enter the weigth in kg: ");
            int weigth = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter the Capacity: ");
            String capacity = scan.nextLine();
            String[] dimensions = capacity.split(":");
            double capacity_lt = Double.parseDouble(dimensions[0])*Double.parseDouble(dimensions[1])*Double.parseDouble(dimensions[2]) / 1000;
            luggage = new Luggage(owner, weigth, capacity_lt);
            if(!LuggageList.addLuggage(luggage))
                i -- ;
        }
        if (LuggageList.MAX_COUNT == LuggageList.getTotalCount()){
            System.out.println("The maximum number of Luggages reached.");
        }
        System.out.println("-----------");

        LuggageList.display();
        System.out.println("-----------");

        System.out.println("Which luggage ID to remove?");
        String luggageID = scan.nextLine();
        LuggageList.removeLuggage(luggageID);
        System.out.println("-----------");

        System.out.println("Whose luggage to search?");
        String searchLuggage = scan.nextLine();
        System.out.println(LuggageList.getLuggage(searchLuggage).toString());
        System.out.println("-----------");

        System.out.println(LuggageList.gethighestCapacityLuggage().toString());
    }
//    private static void getInfo(LuggageList luggageList) {
//        getInfo(0,LuggageList.MAX_COUNT,luggageList);
//    }
//    private static LuggageList getInfo(int counter , int endPoint , LuggageList luggageList){
//        if (counter == LuggageList.MAX_COUNT){return luggageList;}
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Luggage Number " + counter+1);
//        System.out.print("Enter the name of the owner: ");
//        String owner = scan.nextLine();
//        System.out.print("Enter the weigth in kg: ");
//        int weigth = scan.nextInt();
//        scan.nextLine();
//        System.out.print("Enter the Capacity: ");
//        String capacity = scan.nextLine();
//        String[] dimensions = capacity.split(":");
//        double capacity_lt = Double.parseDouble(dimensions[0])*Double.parseDouble(dimensions[1])*Double.parseDouble(dimensions[2]) / 1000;
//        luggageList.
//
//    }
}
