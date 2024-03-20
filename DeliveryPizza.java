public class DeliveryPizza extends Pizza {
    private String deliveryAddress;
    private double deliveryFee;

    public DeliveryPizza(String[] toppings, double price, String deliveryAddress, double deliveryFee) {
        super(toppings, price);
        this.deliveryAddress = deliveryAddress;
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }
}
