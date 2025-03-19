package com.zoho.level3.railway_reservation_system;
import java.util.*;

public class TicketBooker {
    static int lowerBerth = 1;
    static int middleBerth = 1;
    static int upperBerth = 1;
    static int rac = 1;
    static int waitingList = 1;

    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingLists = new LinkedList<>();
    static List<Integer> confirmList = new ArrayList<>();

    static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));
    static Map<Integer, Passenger> passengers = new HashMap<>();

    public void bookTicket(Passenger p, int seatInfo, String berth) {
        p.seatNumber = seatInfo;
        p.alloted = berth;
        confirmList.add(p.passengerId);
        passengers.put(p.passengerId,p);
        System.out.println("Booked Successfully");
    }
    public void addToRAC(Passenger p, int seatInfo, String berth) {
        p.seatNumber = seatInfo;
        p.alloted = berth;
        passengers.put(p.passengerId,p);
        racList.add(p.passengerId);
        rac--;
        System.out.println("Booked successfully");
    }
    public void addToWaitingList(Passenger p, int seatInfo, String berth) {
        p.seatNumber = seatInfo;
        p.alloted = berth;
        passengers.put(p.passengerId,p);
        waitingLists.add(p.passengerId);
        waitingList--;
        System.out.println("Booked Successfully");
    }

    public void bookedTickets() {
        if(confirmList.size() == 0)
        {
            System.out.println("Passenger details has not available");
            return;
        }
        for(Passenger p : passengers.values())
        {
            System.out.println("Passenger Id "+p.passengerId);
            System.out.println("Passenger Name "+p.name);
            System.out.println("Passenger age "+p.age);
            System.out.println("Passenger berth "+p.seatNumber+p.alloted);
            System.out.println("-------------------------------------------");
        }
    }

    public void cancelTicket(int id) {
        Passenger p = passengers.get(id);
        confirmList.remove(Integer.valueOf(id));
        passengers.remove(Integer.valueOf(id));
        int pos = p.seatNumber;
        System.out.println("Cancelled successfully");

        if(p.alloted.equals("WL")) {
            waitingList++;
            return;
        }

        if (p.alloted.equals("L")) {
            lowerBerth++;
            lowerBerthPositions.add(pos);
        }
        else if (p.alloted.equals("M")) {
            middleBerth++;
            middleBerthPositions.add(pos);
        }
        else if (p.alloted.equals("U")) {
            upperBerth++;
            upperBerthPositions.add(pos);
        }
        if (racList.size() > 0) {
            Passenger racPassenger = passengers.get(racList.poll());
            int racPos = racPassenger.seatNumber;
            racList.remove(racPassenger.passengerId);
            racPositions.add(racPos);
            rac++;

            if (waitingLists.size() > 0) {
                Passenger wlPassenger = passengers.get(waitingLists.poll());
                int wlPos = wlPassenger.seatNumber;
                waitingLists.remove(wlPassenger.passengerId);
                waitingListPositions.add(wlPos);

                wlPassenger.seatNumber = racPositions.get(0);
                racList.add(wlPassenger.passengerId);
                wlPassenger.alloted = "RAC";
                racPositions.remove(0);

                waitingList++;
                rac--;
            }
            MainClass.bookTicket(racPassenger);
        }
    }
    public void availableTickets() {
        System.out.println("--------------------------------------");
        System.out.println("Lower Berth Tickets  : "+lowerBerth);
        System.out.println("Middle Berth Tickets : "+middleBerth);
        System.out.println("Upper Berth Tickets  : "+upperBerth);
        System.out.println("Rac Tickets          : "+rac);
        System.out.println("WaitingList Tickets  : "+waitingList);
        System.out.println("--------------------------------------");
    }

}
