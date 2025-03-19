package com.zoho.level3.railway_reservation_system;

public class Passenger {
    static int id = 1;
     String name;
     int age;
     String berthPreference;
     String alloted;
     int passengerId;
     int seatNumber;

    public Passenger (String name, int age, String berthPreference) {
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        this.alloted = "";
        this.passengerId = id++;
        this.seatNumber = 0;
    }

}
