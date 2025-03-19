package low_level_design.taxi_booking;

public class Taxi {
    private int taxiId;
    private int customerId;
    private int pickTime;
    private int dropTime;
    private char currentLocation;

    private char pickLocation;
    private char dropLocation;
    private double earnings;

    public Taxi() {
        this.currentLocation = 'A';
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPickTime() {
        return pickTime;
    }

    public void setPickTime(int pickTime) {
        this.pickTime = pickTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public char getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(char pickLocation) {
        this.pickLocation = pickLocation;
    }

    public char getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(char dropLocation) {
        this.dropLocation = dropLocation;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
}
