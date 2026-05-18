package hotelapp;


import java.util.Scanner;

public class HotelAppMain {
    public static void main(String[] args) {
        BookingService service = new BookingService();

        service.addRoom(new Room(101, "Standard", 1500));
        service.addRoom(new DeluxeRoom(102, 2500, true, true, false, 300));
        service.addRoom(new SuiteRoom(201, 5000, true, true, 1000));
        service.addRoom(new DeluxeRoom(103, 2800, false, true, true, 400));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hotel Booking Menu ===");
            System.out.println("1. Check Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Generate Invoice");
            System.out.println("5. Daily Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.showAvailability();
                    break;
                case 2:
                    System.out.print("Enter Room No to Book: ");
                    int bookNo = sc.nextInt();
                    Room roomToBook = service.findRoom(bookNo);
                    if (roomToBook != null) {
                        if (roomToBook instanceof DeluxeRoom) {
                            ((DeluxeRoom) roomToBook).book(true, "SAVE100");
                        } else {
                            roomToBook.book();
                        }
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Room No to Cancel: ");
                    int cancelNo = sc.nextInt();
                    service.cancelBooking(cancelNo);
                    break;
                case 4:
                    System.out.print("Enter Room No for Invoice: ");
                    int invoiceNo = sc.nextInt();
                    service.generateInvoice(invoiceNo);
                    break;
                case 5:
                    service.dailyReport();
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}


