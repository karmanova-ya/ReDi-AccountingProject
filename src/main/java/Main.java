import model.BankAccount;
import repository.IncomeStorage;
import repository.PaymentStorage;
import services.StaticticService;
import services.TransactionService;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//add expenses and earnings through the console
//retrieve all previously inserted expenses and earnings
//receive summaries and balances
//#Bonus: ↗️
//If this is too simple, here some ideas how you can make the project more complex, potentially using more tools too:
//
//save and load data to and from file, to use it later on
//have a simple user management system that allows different users to register and log in the system, and store their data in different files
//use a real db!

public class Main {

    //create file with Bank Account data
    public static BankAccount createBankAcc() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Let create your bank account!");
        System.out.print("Input bank name - ");
        String bn = in.nextLine();
        BankAccount bankAccount = new BankAccount(bn);
        FileOutputStream fout = new FileOutputStream("bankAccount.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(bankAccount);
        return bankAccount;
    }

    //read file with Bank Account data
    public static BankAccount readBankAcc() throws IOException, ClassNotFoundException {
        ObjectInputStream objectinputstream = null;
        FileInputStream streamIn = new FileInputStream("bankAccount.ser");
        objectinputstream = new ObjectInputStream(streamIn);
        BankAccount bankAccount = (BankAccount) objectinputstream.readObject();
        return bankAccount;
    }

    //create Menu method with selection
    public static void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("");

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);

        PaymentStorage paymentStorage = new PaymentStorage();
        IncomeStorage incomeStorage = new IncomeStorage();

        TransactionService transactionService = new TransactionService(paymentStorage, incomeStorage);
        StaticticService staticticService = new StaticticService(paymentStorage, incomeStorage);

        //-----------------------------------------------
        // checking to see if the account was created or not
        File f = new File("bankAccount.ser");
        BankAccount bankAccount;
        if (f.exists() && !f.isDirectory()) {
            bankAccount = readBankAcc();
        } else {
            bankAccount = createBankAcc();
        }

        System.out.println("Do you want add some money? (y/n)");
        String answer = input.next();
        double deposit = 0;
        if (answer.equals("y")) {
            try {
                System.out.println("Input here -->");
                deposit = input.nextDouble();
                transactionService.deposit(bankAccount, deposit);
            } catch (InputMismatchException e) {
                System.out.println("This does not really make sense, sorry. Please add an amount instead of text.");
                System.out.println("Input here -->");
                deposit = input.nextDouble();
                transactionService.deposit(bankAccount, deposit);
            }
        }

        System.out.println("Do you want to add payment(p) or income(i)?");
        String typeOfPayment = input.next();
        if (typeOfPayment.equals("p")) {
            transactionService.addPayment();
        } else if (typeOfPayment.equals("i")) {
            transactionService.addIncome();
        } else {
            System.out.println("Please clarify your answer\n");
        }

        System.out.println("Do you want to see transaction statistic? (y/n)");
        String userSelection = input.next();
        if (userSelection.equals("y")) {
            staticticService.selectStatistics();
        } else {
            System.out.println("Please clarify your answer\n");
            staticticService.selectStatistics();
        }
    }
}
