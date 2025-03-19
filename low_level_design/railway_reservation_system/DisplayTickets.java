package low_level_design.railway_reservation_system;

import java.util.Queue;

public class DisplayTickets {

    public DisplayTickets() {

    }
    public void displayConfirmTickets() {
        for (Passenger p : Booking.confirmList) {
            displayPassengerDetails(p);
        }
    }
    public void displayRACTickets() {
        Queue<Passenger> racList = Booking.getRacList();

        while (!racList.isEmpty()) {
            displayPassengerDetails(racList.poll());
        }
    }

    public void displayWLTickets() {
        Queue<Passenger> waitingList = Booking.getWaitingList();

        while (!waitingList.isEmpty()) {
            displayPassengerDetails(waitingList.poll());
        }
    }

    public void displayPassengerDetails(Passenger p) {
        System.out.println("-----------------------------------");
        System.out.println("Ticket id       : " + p.getTicketId());
        System.out.println("Passenger Name  : " + p.name);
        System.out.println("Passenger Age   : " + p.getAge());
        System.out.println("Passenger Berth : " + p.getBerth());
        System.out.println("Seat Number     : " + p.getSeatNo());
        System.out.println("-----------------------------------");
    }

    public void displayOptions() {
        System.out.println("---------------------------------------");
        System.out.println("1. Book Ticket                 : ");
        System.out.println("2. Cancel Ticket               : ");
        System.out.println("3. Display Confirm Tickets     : ");
        System.out.println("4. Display RAC Tickets         : ");
        System.out.println("5. Display WaitingList Tickets : ");
        System.out.println("6. Exit");
        System.out.println("---------------------------------------");
    }
}
