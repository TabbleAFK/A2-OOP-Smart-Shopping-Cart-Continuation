public class Payment {

    // Private attributes for payment information.
    private String paymentID;
    private String paymentMethod;
    private double amount;
    private boolean paid;

    // Constructor to initialize payment details.
    public Payment(String paymentID, String paymentMethod, double amount) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        setAmount(amount);
        this.paid = false;
    }

    // Getters and setters.
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = 0;
        }
    }

    public boolean isPaid() {
        return paid;
    }

    // Processes payment only if the method and amount are valid.
    public void processPayment() {

        if (amount > 0 &&
            (paymentMethod.equalsIgnoreCase("Card") ||
             paymentMethod.equalsIgnoreCase("QR"))) {

            paid = true;
            System.out.println("Payment successful!");

        } else {
            paid = false;
            System.out.println("Payment failed. Invalid payment details.");
        }
    }

    // Displays payment information.
    public void displayPayment() {
        System.out.println("\n--- Payment Details ---");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.printf("Amount Paid: RM%.2f%n", amount);
        System.out.println("Payment Status: " + (paid ? "Paid" : "Not Paid"));
    }
}
