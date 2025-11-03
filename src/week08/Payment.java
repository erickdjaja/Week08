package week08;

public abstract class Payment {
    protected double amount;
    protected boolean isPaidOff;
    
    public Payment(double amount) {
        this.amount = amount;
        this.isPaidOff = false;
    }
    
    public abstract void pay();
    public abstract double getRemainingAmount();
}
