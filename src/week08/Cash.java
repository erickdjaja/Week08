package week08;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    @Override
    public void pay() {
        System.out.println("Payment made with cash for " + item.getName());
        isPaidOff = true;
    }

    @Override
    public double getRemainingAmount() {
        return isPaidOff ? 0 : item.getPrice();
    }
}
