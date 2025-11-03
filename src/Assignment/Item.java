package Assignment;

public class Item {
    private int id;
    private String name;
    private String type;
    private double price;

    public Item(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println("No\t\t: " + id);
        System.out.println("Nama\t: " + name);
        System.out.println("Tipe\t: " + type);
        System.out.println("Harga\t: " + (int)price);
        System.out.println("--------------------------------");
    }
}
