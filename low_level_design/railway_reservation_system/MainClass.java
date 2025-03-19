package low_level_design.railway_reservation_system;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisplayTickets displayTickets = new DisplayTickets();

        while (true) {
            displayTickets.displayOptions();

            System.out.println("Enter Your Choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    cancelTicket(scanner);
                    break;
                case 3:
                    displayTickets.displayConfirmTickets();
                    break;
                case 4:
                    displayTickets.displayRACTickets();
                    break;
                case 5:
                    displayTickets.displayWLTickets();
                case 6:
                    System.out.println("thanks for coming...");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice... Try again");
            }
        }
    }
    public static void bookTicket(Scanner scanner) {
        System.out.println("------------- Welcome -------------");

        System.out.println("Enter name");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter age");
        int age = scanner.nextInt();

        System.out.println("Enter berth");
        String berth = scanner.next();


        Booking booking = new Booking();
        booking.bookTicket(name, age, berth);
    }

    public static void cancelTicket(Scanner scanner) {
        System.out.println("Enter Ticket id");
        int id = scanner.nextInt();

    }
}
