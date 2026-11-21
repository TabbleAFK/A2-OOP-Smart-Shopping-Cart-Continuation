import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Demonstrates the default constructor from the base class.
        SmartShoppingCart defaultCart = new SmartShoppingCart();

        System.out.println("Default Cart ID: " + defaultCart.getCartID());

        System.out.println("\n=== SMART SHOPPING CART SYSTEM ===");

        // 1. Get customer information.
        System.out.print("Enter customer ID: ");
        String customerID = input.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();

        System.out.print("Is the customer a member? (true/false): ");
        boolean member = Boolean.parseBoolean(input.nextLine());

        // Create a Customer object.
        Customer customer = new Customer(
                customerID, customerName, member);

        // 2. Get product information.
        System.out.print("\nEnter product ID: ");
        String productID = input.nextLine();

        System.out.print("Enter product name: ");
        String productName = input.nextLine();

        System.out.print("Enter product price: RM");
        double price = Double.parseDouble(input.nextLine());

        System.out.print("Enter available stock: ");
        int stock = Integer.parseInt(input.nextLine());

        // Create a Product object.
        Product product = new Product(
                productID, productName, price, stock);

        // 3. Get shopping cart information.
        System.out.print("\nEnter cart ID: ");
        String cartID = input.nextLine();

        System.out.print("Enter purchase quantity: ");
        int quantity = Integer.parseInt(input.nextLine());

        // Selection structure checks whether enough stock is available.
        if (quantity > 0 && quantity <= product.getStock()) {
            System.out.println("Product quantity is available.");
        } else {
            System.out.println("Invalid quantity or insufficient stock.");
            input.close();
            return;
        }

        // 4. Create a base-class reference for polymorphism.
        SmartShoppingCart cart;

        System.out.println("\nChoose Shopping Type:");
        System.out.println("1. Online Shopping");
        System.out.println("2. In-Store Shopping");
        System.out.print("Enter your choice: ");

        int shoppingType = Integer.parseInt(input.nextLine());

        // The selected derived class is assigned to the base-class reference.
        if (shoppingType == 1) {

            // Create an OnlineShoppingCart object.
            cart = new OnlineShoppingCart(
                    cartID,
                    customer.getCustomerName(),
                    product.getProductName(),
                    quantity,
                    product.getPrice(),
                    10.0,
                    customer.getMember(),
                    10.0
            );

            System.out.println("Online shopping cart created.");

        } else if (shoppingType == 2) {

            // Create an InStoreShoppingCart object.
            cart = new InStoreShoppingCart(
                    cartID,
                    customer.getCustomerName(),
                    product.getProductName(),
                    quantity,
                    product.getPrice(),
                    10.0,
                    customer.getMember(),
                    5.0
            );

            System.out.println("In-store shopping cart created.");

        } else {

            System.out.println("Invalid shopping type.");
            input.close();
            return;
        }

        // 5. Demonstrates an if-else statement for membership.
        if (cart.getMember()) {
            System.out.println("Member discount is available.");
        } else {
            System.out.println("Customer is not a member.");
        }

        // 6. Displays the customer and product information.
        customer.displayCustomer();
        product.displayProduct();

        // 7. Menu controlled by a while loop.
        int choice = 0;
        boolean paymentCompleted = false;

        while (choice != 4) {

            System.out.println("\n=== SHOPPING CART MENU ===");
            System.out.println("1. Display Shopping Cart");
            System.out.println("2. Update Quantity");
            System.out.println("3. Make Payment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(input.nextLine());

            // Switch statement handles the user's menu selection.
            switch (choice) {

                case 1:

                    // Calls the overridden displayCart() method.
                    cart.displayCart();
                    break;

                case 2:

                    System.out.print("Enter new quantity: ");
                    int newQuantity =
                            Integer.parseInt(input.nextLine());

                    // Checks that the requested quantity is valid.
                    if (newQuantity > 0
                            && newQuantity <= product.getStock()) {

                        cart.setQuantity(newQuantity);
                        paymentCompleted = false;

                        System.out.println("Quantity updated.");

                    } else {
                        System.out.println(
                                "Invalid quantity or insufficient stock.");
                    }
                    break;

                
case 3:
    if (paymentCompleted) {
        System.out.println("Payment has already been completed.");
        break;
    }

    System.out.println("\n--- Payment Method ---");
    System.out.println("1. Card");
    System.out.println("2. QR");
    System.out.print("Choose your payment method: ");

    int paymentChoice = Integer.parseInt(input.nextLine());

    String paymentMethod = "";

    switch (paymentChoice) {
        case 1:
            paymentMethod = "Card";
            break;

        case 2:
            paymentMethod = "QR";
            break;

        default:
            System.out.println("Invalid payment choice. Payment cancelled.");
            break;
    }

    // Only proceed if the customer selected a valid payment method.
    if (!paymentMethod.isEmpty()) {

        Payment payment = new Payment(
            "PAY001",
            paymentMethod,
            cart.calculateFinalTotal()
        );

        payment.processPayment();

        if (payment.isPaid()) {
            product.reduceStock(cart.getQuantity());
            paymentCompleted = true;
            payment.displayPayment();
        }
    }

    break;


                case 4:

                    System.out.println(
                            "Thank you for using Smart Shopping Cart!");
                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again.");
            }
        }

        // Close the Scanner after the program finishes.
        input.close();
    }
}

