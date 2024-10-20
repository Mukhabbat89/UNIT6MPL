import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Salesperson {
    private int idNumber;
    private double salesValue;

    // Constructor to initialize Salesperson object with id and sales value
    public Salesperson(int idNumber, double salesValue) {
        this.idNumber = idNumber;
        this.salesValue = salesValue;
    }

    // Getter for ID number
    public int getIdNumber() {
        return idNumber;
    }

    // Getter for sales value
    public double getSalesValue() {
        return salesValue;
    }

    // Method to display Salesperson details
    public void display() {
        System.out.println("ID: " + idNumber + ", Sales Value: $" + salesValue);
    }
}

public class SalespersonSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Salesperson[] salespersons = new Salesperson[7]; // Array to store 7 Salespersons

        // Input salesperson data with validation
        for (int i = 0; i < salespersons.length; i++) {
            int id = 0;
            double value = 0.0;

            // Validate ID input
            while (true) {
                try {
                    System.out.print("Enter ID for Salesperson " + (i + 1) + ": ");
                    id = scanner.nextInt();
                    break;  // Break loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid integer for ID.");
                    scanner.next();  // Clear the invalid input
                }
            }

            // Validate Sales Value input
            while (true) {
                try {
                    System.out.print("Enter sales value for Salesperson " + (i + 1) + ": ");
                    value = scanner.nextDouble();
                    break;  // Break loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number for sales value.");
                    scanner.next();  // Clear the invalid input
                }
            }

            salespersons[i] = new Salesperson(id, value);  // Create a new Salesperson object
        }

        // User choice for sorting by ID or Sales Value
        System.out.println("Sort by: 1. ID  2. Sales Value");
        int choice = scanner.nextInt();

        // Sorting based on user choice
        if (choice == 1) {
            // Sort by ID
            Arrays.sort(salespersons, Comparator.comparingInt(Salesperson::getIdNumber));
        } else if (choice == 2) {
            // Sort by Sales Value
            Arrays.sort(salespersons, Comparator.comparingDouble(Salesperson::getSalesValue));
        } else {
            System.out.println("Invalid choice.");
            scanner.close();  // Close the scanner resource

            return;  // Exit if choice is invalid
        }

        // Display sorted Salespersons
        System.out.println("Sorted Salespersons:");
        for (Salesperson sp : salespersons) {
            sp.display();
        }

        scanner.close();  // Close the scanner resource
    }
}
