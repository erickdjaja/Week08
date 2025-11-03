package Assignment;

public abstract class Payment {
    protected Item item;
    protected boolean isPaidOff;

    public Payment(Item item) {
        this.item = item;
        this.isPaidOff = false;
    }

    public abstract void pay();
    public abstract double getRemainingAmount();

    public boolean isPaidOff() {
        return isPaidOff;
    }
}
