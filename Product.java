public class Product {

    // Private attributes store product information.
    private String productID;
    private String productName;
    private double price;
    private int stock;

    // Constructor initializes product information.
    public Product(String productID, String productName,
            double price, int stock) {

        this.productID = productID;
        this.productName = productName;
        setPrice(price);
        setStock(stock);
    }

    // Getters retrieve product information.
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters modify product information.
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    // Reduces available stock after a successful purchase.
    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock = stock - quantity;
        }
    }

    // Displays product information.
    public void displayProduct() {
        System.out.println("\n--- Product Information ---");
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.printf("Price: RM%.2f%n", price);
        System.out.println("Available Stock: " + stock);
    }
}

