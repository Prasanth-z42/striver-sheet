package low_level_design.taxi_booking;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Booking booking = new Booking();
        while (true) {
            display();
            int choice;
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    bookTaxi(sc, booking);
                    break;
                case 2:
                    getDetails(booking);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void bookTaxi(Scanner sc, Booking booking) {
        System.out.println("Enter Pick up location");
        char pl = sc.next().charAt(0);
        System.out.println("Enter drop location");
        char dl = sc.next().charAt(0);
        System.out.println("Enter pick up time");
        int pt = sc.nextInt();
        booking.bookTicket(pt, pl, dl);
    }

    public static void getDetails(Booking booking) {
        booking.displayInformation();
    }


    public static void getDetails(Scanner sc, Booking booking) {

    }
    public static void display() {
        System.out.println("---------------------------------");
        System.out.println("1. Book Taxi");
        System.out.println("2. getDetails");
        System.out.println("3. Exit");
        System.out.println("---------------------------------");
    }

}
