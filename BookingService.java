package hotelapp;

import java.util.*;

public class BookingService {
    private List<Room> rooms;

    public BookingService() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showAvailability() {
        System.out.println("\n=== Available Rooms ===");
        for (Room r : rooms) {
            if (r.checkAvailability()) r.displayInfo();
        }
    }

    public Room findRoom(int roomNo) {
        for (Room r : rooms) {
            if (r.getRoomNo() == roomNo) return r;
        }
        return null;
    }

    public void cancelBooking(int roomNo) {
        Room r = findRoom(roomNo);
        if (r != null) r.cancel();
        else System.out.println("Room not found.");
    }

    public void generateInvoice(int roomNo) {
        Room r = findRoom(roomNo);
        if (r != null && r.isBooked()) {
            double bill = r.computeBill();
            double tax = bill * 0.10; // 10% tax
            System.out.println("Invoice for Room " + roomNo + ":");
            System.out.println("Base + Extras: " + bill);
            System.out.println("Tax (10%): " + tax);
            System.out.println("Total: " + (bill + tax));
        } else {
            System.out.println("Room not booked or doesn't exist.");
        }
    }

    public void dailyReport() {
        int bookedCount = 0;
        double revenue = 0;
        for (Room r : rooms) {
            if (r.isBooked()) {
                bookedCount++;
                revenue += r.computeBill();
            }
        }
        System.out.println("\n=== Daily Report ===");
        System.out.println("Rooms Booked: " + bookedCount);
        System.out.println("Revenue (before tax): " + revenue);
    }
}


