public class Customer {

    // Private attributes protect customer information.
    private String customerID;
    private String customerName;
    private boolean member;

    // Constructor initializes customer information.
    public Customer(String customerID, String customerName,
            boolean member) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.member = member;
    }

    // Getters retrieve customer information.
    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean getMember() {
        return member;
    }

    // Setters allow customer information to be updated.
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    // Displays customer information.
    public void displayCustomer() {
        System.out.println("\n--- Customer Information ---");
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Membership: " + member);
    }
}

