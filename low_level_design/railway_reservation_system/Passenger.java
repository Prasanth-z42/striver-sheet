package low_level_design.railway_reservation_system;

public class Passenger {
    static int idProvider = 1;
    int ticketId;
    String name;
    int age;
    String berth;
    int seatNo;
    String ticketType;

    public Passenger(String name, int age, String berth) {
        this.ticketId = idProvider++;
        this.name = name;
        this.age = age;
        this.berth = berth;
    }

    public static int getIdProvider() {
        return idProvider;
    }

    public static void setIdProvider(int idProvider) {
        Passenger.idProvider = idProvider;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
