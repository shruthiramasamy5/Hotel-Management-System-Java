package hotelapp;


public class SuiteRoom extends Room {
    private boolean privateJacuzzi;
    private boolean livingArea;
    private double luxuryCharge;

    public SuiteRoom(int roomNo, double basePrice, boolean jacuzzi, boolean livingArea, double luxuryCharge) {
        super(roomNo, "Suite", basePrice);
        this.privateJacuzzi = jacuzzi;
        this.livingArea = livingArea;
        this.luxuryCharge = luxuryCharge;
    }

    public boolean hasJacuzzi() { return privateJacuzzi; }
    public boolean hasLivingArea() { return livingArea; }

    @Override
    public double computeBill() {
        double total = getBasePrice() + luxuryCharge;
        if (privateJacuzzi) total += 800;
        if (livingArea) total += 500;
        return total;
    }
}

