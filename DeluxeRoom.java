package hotelapp;


public class DeluxeRoom extends Room {
    private boolean wifiAvailable;
    private boolean balcony;
    private boolean breakfastIncluded;
    private double extraCharge;

    public DeluxeRoom(int roomNo, double basePrice, boolean wifi, boolean balcony, boolean breakfast, double extraCharge) {
        super(roomNo, "Deluxe", basePrice);
        this.wifiAvailable = wifi;
        this.balcony = balcony;
        this.breakfastIncluded = breakfast;
        this.extraCharge = extraCharge;
    }

    public boolean hasWifi() { return wifiAvailable; }
    public boolean hasBalcony() { return balcony; }
    public boolean isBreakfastIncluded() { return breakfastIncluded; }

    @Override
    public double computeBill() {
        double total = getBasePrice() + extraCharge;
        if (breakfastIncluded) total += 250;
        if (wifiAvailable) total += 100;
        if (balcony) total += 150;
        return total;
    }

    public void book(boolean breakfast, String couponCode) {
        if (!isBooked()) {
            setBooked(true);
            this.breakfastIncluded = breakfast;
            double discount = couponCode.equalsIgnoreCase("SAVE100") ? 100 : 0;
            System.out.println("Deluxe Room " + getRoomNo() + " booked. Discount applied: ₹" + discount);
        } else {
            System.out.println("Room already booked.");
        }
    }
}


