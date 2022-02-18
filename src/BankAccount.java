import java.util.Scanner;

public class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount){
        if (amount >= 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount){
        if ((balance - amount) < 0){
            System.out.println("Not enough many!");
        }
        if (amount >= 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu(){

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);

        do {
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            System.out.println("*************************************");
            System.out.println("Enter an option");
            System.out.println("*************************************");
            option = scanner.next().charAt(0);
            scanner.nextLine();

            switch (option){
                case 'A' :
                    System.out.println("*******************************");
                    System.out.println("Balance = " + balance);
                    System.out.println("*******************************");
                    break;
                case 'B' :
                    System.out.println("*******************************");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("*******************************");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("*******************************");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("*******************************");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;
                case 'D' :
                    System.out.println("*******************************");
                    getPreviousTransaction();
                    System.out.println("*******************************");
                    break;
                case 'E':
                    System.out.println("*******************************");
                default:
                    System.out.println("Invalid option!! Please enter again");
                    break;
            }
        } while (option != 'E');

        System.out.println("Thank you for using our services!");
    }
}
