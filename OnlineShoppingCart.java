public class OnlineShoppingCart extends SmartShoppingCart {

    // Additional attribute for online delivery.
    private double deliveryFee;

    // Constructor initializes inherited and additional attributes.
    public OnlineShoppingCart(String cartID, String customerName,
            String itemName, int quantity, double itemPrice,
            double discountRate, boolean member, double deliveryFee) {

        super(cartID, customerName, itemName, quantity,
                itemPrice, discountRate, member);

        setDeliveryFee(deliveryFee);
    }

    // Getter for delivery fee.
    public double getDeliveryFee() {
        return deliveryFee;
    }

    // Setter validates the delivery fee.
    public void setDeliveryFee(double deliveryFee) {
        if (deliveryFee >= 0) {
            this.deliveryFee = deliveryFee;
        }
    }

    // Overrides the base class method.
    // Online shopping includes an additional delivery fee.
    @Override
    public double calculateFinalTotal() {
        return super.calculateFinalTotal() + deliveryFee;
    }

    // Displays the delivery fee and final online shopping total.
    @Override
    public void displayCart() {
        super.displayCart();
        System.out.printf("Delivery Fee: RM%.2f%n", deliveryFee);
        System.out.printf("Online Total: RM%.2f%n", calculateFinalTotal());
    }
}

