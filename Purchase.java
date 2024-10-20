import java.util.Scanner;

public class Purchase {

    // Fields to store the invoice number, sale amount, and calculated sales tax
    private int invoiceNumber;
    private double saleAmount;
    private double salesTax;

    // Setter for the invoice number with validation
    // Ensures that the invoice number is a positive integer
    public void setInvoiceNumber(int invoiceNumber) {
        if (invoiceNumber <= 0) {
            System.out.println("Error: Invoice number must be a positive integer.");
        } else {
            this.invoiceNumber = invoiceNumber;
        }
    }

    // Setter for the sale amount with validation
    // Ensures that the sale amount is greater than zero
    public void setSaleAmount(double saleAmount) {
        if (saleAmount <= 0) {
            System.out.println("Error: Sale amount must be greater than zero.");
        } else {
            this.saleAmount = saleAmount;
            calculateSalesTax(); // Automatically calculate the sales tax
        }
    }

    // Private method to calculate sales tax (5% of sale amount)
    private void calculateSalesTax() {
        this.salesTax = this.saleAmount * 0.05;
    }

    // Method to display purchase details: invoice number, sale amount, and sales tax
    public void display() {
        if (invoiceNumber > 0 && saleAmount > 0) {
            System.out.println("Invoice Number: " + invoiceNumber);
            System.out.println("Sale Amount: $" + saleAmount);
            System.out.println("Sales Tax: $" + salesTax);
        }
    }

    // Main method to run the program and test the Purchase class
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        Scanner sc = new Scanner(System.in);

        // Getting user input for invoice number
        System.out.print("Enter Invoice Number: ");
        int invoiceNum = sc.nextInt();
        purchase.setInvoiceNumber(invoiceNum);

        // Getting user input for sale amount
        System.out.print("Enter Sale Amount: ");
        double saleAmt = sc.nextDouble();
        purchase.setSaleAmount(saleAmt);

        // Displaying the purchase details
        purchase.display();
        sc.close(); // Closing the scanner to avoid resource leak
    }
}
