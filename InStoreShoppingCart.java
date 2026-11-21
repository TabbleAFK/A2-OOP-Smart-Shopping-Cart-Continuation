public class InStoreShoppingCart extends SmartShoppingCart {

    // Additional attribute for in-store discount.
    private double storeDiscountRate;

    // Constructor initializes inherited and additional attributes.
    public InStoreShoppingCart(String cartID, String customerName,
            String itemName, int quantity, double itemPrice,
            double discountRate, boolean member,
            double storeDiscountRate) {

        super(cartID, customerName, itemName, quantity,
                itemPrice, discountRate, member);

        setStoreDiscountRate(storeDiscountRate);
    }

    // Getter for store discount rate.
    public double getStoreDiscountRate() {
        return storeDiscountRate;
    }

    // Setter ensures the discount stays between 0 and 100.
    public void setStoreDiscountRate(double storeDiscountRate) {
        if (storeDiscountRate >= 0 && storeDiscountRate <= 100) {
            this.storeDiscountRate = storeDiscountRate;
        }
    }

    // Overrides the base class method.
    // In-store purchases receive an additional store discount.
    @Override
    public double calculateFinalTotal() {
        double total = super.calculateFinalTotal();

        total = total - (total * storeDiscountRate / 100);

        return total;
    }

    // Displays the additional in-store discount.
    @Override
    public void displayCart() {
        super.displayCart();
        System.out.println("Store Discount Rate: "
                + storeDiscountRate + "%");
        System.out.printf("In-Store Total: RM%.2f%n",
                calculateFinalTotal());
    }
}

