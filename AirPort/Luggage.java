package AirPort;

public class Luggage {
    private int luggage_ID;
    private String belongs_to;
    private int weigth_kilo;
    private double capacity_lt;
    private static int lastUsedId = 500;

    public Luggage(String belongs_to , int weigth_kilo , double capacity_lt) {
        this.luggage_ID = lastUsedId++;
        this.belongs_to = belongs_to;
        this.capacity_lt = capacity_lt;
        this.weigth_kilo = weigth_kilo;
    }

    public int getLuggage_ID() {
        return luggage_ID;
    }

    public String getBelongsTo() {
        return belongs_to;
    }

    public double getCapacity() {
        return capacity_lt;
    }

    public int getWeigth() {
        return weigth_kilo;
    }

    @Override
    public String toString() {
        return "Luggage ID=" + luggage_ID +
                "\nBelongs to=" + belongs_to +
                "\nWeigth=" + weigth_kilo +
                "\nCapacity(lt)=" + capacity_lt ;
    }
}
