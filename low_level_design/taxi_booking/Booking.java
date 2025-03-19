package low_level_design.taxi_booking;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    public List<Taxi> taxiList = new ArrayList<>();
    int totalTaxi = 4;
    static int idGenerator = 1;

    public List<Taxi> confirmList = new ArrayList<>();

    public void bookTicket(int pt, char pl, char dl) {
        if (taxiList.size() < totalTaxi) {
            taxiList.add(new Taxi());
        }

        Taxi taxiReady = null;
        int min = Integer.MAX_VALUE;

        for (Taxi taxi : taxiList) {
            if (taxi.getDropTime() <= pt && Math.abs(pl - taxi.getCurrentLocation()) <= min) {
                if (Math.abs(pl - taxi.getCurrentLocation()) == min) {
                    if (taxi.getEarnings() < taxiReady.getEarnings()) {
                        taxiReady = taxi;
                    }
                } else {
                    taxiReady = taxi;
                    min = Math.abs(pl - taxi.getCurrentLocation());
                }
            }
        }

        if (taxiReady != null) {
            taxiReady.setCustomerId(idGenerator++);
            taxiReady.setPickLocation(pl);
            taxiReady.setDropLocation(dl);
            taxiReady.setPickTime(pt);
            taxiReady.setDropTime(pt + Math.abs(dl - pl));
            taxiReady.setCurrentLocation(dl);
            taxiReady.setEarnings(taxiReady.getEarnings() + (200 * Math.abs(dl - pl)));
            taxiReady.setTaxiId(taxiList.indexOf(taxiReady) + 1);
            confirmList.add(taxiReady);
            System.out.println("Taxi no : " + taxiReady.getTaxiId() + " is booked");
        } else {
            System.out.println("Taxis not available");
        }


    }

    public void displayInformation() {
        for (Taxi t : confirmList) {
            print(t);
        }
    }

    public static void print(Taxi t) {
        System.out.println("--------------------------------");
        System.out.println("Taxi Id : " + t.getTaxiId());
        System.out.println("Customer Id : " + t.getCustomerId());
        System.out.println("Pickup Location : " + t.getPickLocation());
        System.out.println("Drop Location : " + t.getDropLocation());
        System.out.println("Pickup Time : " + t.getPickTime());
        System.out.println("Drop Time : " + t.getDropTime());
        System.out.println("Current Location : " + t.getCurrentLocation());
        System.out.println("Total Earnings : " + t.getEarnings());
    }
}
