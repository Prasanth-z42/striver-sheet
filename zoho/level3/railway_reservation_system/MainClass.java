package com.zoho.level3.railway_reservation_system;
import java.util.Scanner;



public class MainClass {
    static void bookTicket(Passenger p) {
        TicketBooker booker = new TicketBooker();
        if (TicketBooker.waitingList < 1) {
            System.out.println("Tickets are not available");
            return;
        }
        if ((TicketBooker.lowerBerth > 0 && p.berthPreference.equals("L")) ||
                (TicketBooker.middleBerth > 0 && p.berthPreference.equals("M")) ||
                (TicketBooker.upperBerth > 0 && p.berthPreference.equals("U"))) {
            System.out.println("preferred berth is available");
            if (p.berthPreference.equals("L")) {
                System.out.println("Lower berth given");
                booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");
                TicketBooker.lowerBerthPositions.remove(0);
                TicketBooker.lowerBerth--;
            }
            if (p.berthPreference.equals("M")) {
                System.out.println("middle berth given");
                booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");
                TicketBooker.middleBerthPositions.remove(0);
                TicketBooker.middleBerth--;
            }
            if (p.berthPreference.equals("U")) {
                System.out.println("upper berth given");
                booker.bookTicket(p,(TicketBooker.upperBerthPositions.get(0)),"U");
                TicketBooker.upperBerthPositions.remove(0);
                TicketBooker.upperBerth--;
            }
        } else if (TicketBooker.rac > 0) {
            System.out.println("RAc given");
            booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC");
        } else {
            System.out.println("Waiting List given");
            booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
        }
    }

    static void print() {
        System.out.println("-----------------------------------------");
        System.out.println("1. Book Ticket");
        System.out.println("2. Available Tickets");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. Booked Tickets");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            print();
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name, age and berth preference");
                    String name = sc.next();
                    int age = sc.nextInt();
                    String berth = sc.next();
                    Passenger p = new Passenger(name, age, berth);
                    bookTicket(p);
                    break;
                case 2:
                    TicketBooker booker = new TicketBooker();
                    booker.availableTickets();
                    break;
                case 3:
                    System.out.println("Enter passenger id");
                    int id = sc.nextInt();
                    cancelTicket(id);
                    break;
                case 4:
                    TicketBooker booker2 = new TicketBooker();
                    booker2.bookedTickets();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Choose correct option");
            }
        }
    }
    public static void cancelTicket(int id) {
        TicketBooker booker = new TicketBooker();
        if (!TicketBooker.passengers.containsKey(id)) {
            System.out.println("Passenger id is not available in the booked list");
        } else {
            booker.cancelTicket(id);
        }
    }
}
