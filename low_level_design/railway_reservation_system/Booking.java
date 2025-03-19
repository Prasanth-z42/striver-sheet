package low_level_design.railway_reservation_system;

import java.util.*;

public class Booking {
    static int upperBerthTicket = 1;
    static int middleBerthTicket = 1;
    static int lowerBerthTicket = 1;
    static int racTicket = 1;
    static int waitingListTicket = 1;

    static int upper = 1;
    static int middle = 2;
    static int lower = 3;

    static List<Passenger> confirmList = new ArrayList<>();

    static List<Passenger> upperList = new ArrayList<>();
    static List<Passenger> middleList = new ArrayList<>();
    static List<Passenger> lowerList = new ArrayList<>();

    static Queue<Passenger> racList = new LinkedList<>();
    static Queue<Passenger> waitingList = new LinkedList<>();
    static Map<Integer, Passenger> map = new HashMap<>();
    public Booking() {

    }

    public void bookTicket(String name, int age, String berth) {

        Passenger p = new Passenger(name, age, berth);

        if (upperBerthTicket > 0 && p.getBerth().equals("U")) {
            upperBerthTicket--;
            p.seatNo = upper;
            upper += 3;
            upperList.add(p);
            confirmList.add(p);
            map.put(p.ticketId, p);
            System.out.println("Confirmed Ticket /n upper berth given");
        } else if (middleBerthTicket > 0 && p.getBerth().equals("M")) {
            middleBerthTicket--;
            p.seatNo = middle;
            middle += 3;
            middleList.add(p);
            confirmList.add(p);
            map.put(p.ticketId, p);
            System.out.println("Confirmed Ticket /n middle berth given");
        } else if (lowerBerthTicket > 0 && p.getBerth().equals("L")) {
            lowerBerthTicket--;
            p.seatNo = lower;
            lower += 3;
            lowerList.add(p);
            confirmList.add(p);
            map.put(p.ticketId, p);
            System.out.println("Confirmed Ticket /n lower berth given");
        } else {
            System.out.println("Preferred berth is not available");
            if (lowerBerthTicket > 0) {
                lowerBerthTicket--;
                p.seatNo = lower;
                lower += 3;
                lowerList.add(p);
                confirmList.add(p);
                map.put(p.ticketId, p);
                System.out.println("Confirmed Ticket /n lower berth given");
            } else if (middleBerthTicket > 0) {
                middleBerthTicket--;
                p.seatNo = middle;
                middle += 3;
                middleList.add(p);
                confirmList.add(p);
                map.put(p.ticketId, p);
                System.out.println("Confirmed Ticket /n middle berth given");
            } else if (upperBerthTicket > 0) {
                upperBerthTicket--;
                p.seatNo = upper;
                upper += 3;
                upperList.add(p);
                confirmList.add(p);
                map.put(p.ticketId, p);
                System.out.println("Confirmed Ticket /n upper berth given");
            } else if (racTicket > 0) {
                racTicket--;
                p.setBerth("RAC");
                racList.add(p);
                System.out.println("RAC given");
            } else if (waitingListTicket > 0){
                waitingListTicket--;
                p.setBerth("WL");
                waitingList.add(p);
                System.out.println("Waiting List given");
            } else {
                System.out.println("Tickets unavailable");
                Passenger.idProvider--;
            }
        }
    }

    public static List<Passenger> getConfirmList() {
        return confirmList;
    }

    public static List<Passenger> getUpperList() {
        return upperList;
    }

    public static List<Passenger> getMiddleList() {
        return middleList;
    }

    public static List<Passenger> getLowerList() {
        return lowerList;
    }

    public static Queue<Passenger> getRacList() {
        return racList;
    }

    public static Queue<Passenger> getWaitingList() {
        return waitingList;
    }
}
