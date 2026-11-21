// Interface defining the required shopping cart methods.
interface ShoppingCartActions {

    double calculateFinalTotal();

    void displayCart();
}

// Base class implements the interface.
public class SmartShoppingCart implements ShoppingCartActions {

    // Private attributes protect the shopping cart information.
    private String cartID;
    private String customerName;
    private String itemName;
    private int quantity;
    private double itemPrice;
    private double discountRate;
    private boolean member;

    // Default constructor initializes the cart with default values.
    public SmartShoppingCart() {
        cartID = "C001";
        customerName = "Unknown";
        itemName = "None";
        quantity = 0;
        itemPrice = 0.0;
        discountRate = 0.0;
        member = false;
    }

    // Parameterized constructor initializes the cart with user information.
    public SmartShoppingCart(String cartID, String customerName,
            String itemName, int quantity, double itemPrice,
            double discountRate, boolean member) {

        this.cartID = cartID;
        this.customerName = customerName;
        this.itemName = itemName;
        setQuantity(quantity);
        setItemPrice(itemPrice);
        setDiscountRate(discountRate);
        this.member = member;
    }

    // GETTERS: Retrieve private attribute values.
    public String getCartID() {
        return cartID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public boolean getMember() {
        return member;
    }

    // SETTERS: Modify private attributes safely.
    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public void setItemPrice(double itemPrice) {
        if (itemPrice >= 0) {
            this.itemPrice = itemPrice;
        }
    }

    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 100) {
            this.discountRate = discountRate;
        }
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    // Calculates the total price before discounts.
    public double calculateSubtotal() {
        return quantity * itemPrice;
    }

    // Calculates the final total after membership discount.
    // This method can be overridden by derived classes.
    public double calculateFinalTotal() {
        double total = calculateSubtotal();

        if (member) {
            total = total - (total * discountRate / 100);
        }

        return total;
    }

    // Displays the shopping cart information.
    public void displayCart() {
        System.out.println("\n--- Shopping Cart Details ---");
        System.out.println("Cart ID: " + cartID);
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Item Price: RM%.2f%n", itemPrice);
        System.out.println("Member: " + member);
        System.out.printf("Subtotal: RM%.2f%n", calculateSubtotal());
        System.out.printf("Final Total: RM%.2f%n", calculateFinalTotal());
    }
}

