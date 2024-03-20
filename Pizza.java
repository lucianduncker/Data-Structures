public class Pizza {
    private String[] toppings;
    private double price;

    public Pizza(String[] toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String[] getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }
}
