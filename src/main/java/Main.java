import model.BankAccount;
import model.IncomeCategory;
import model.PaymentCategory;
import model.Payment;
import repository.IncomeStorage;
import repository.PaymentStorage;
import services.StaticticService;
import services.TransactionService;
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
        //create Menu method with selection

    public static void main(String[] args) {

        PaymentStorage paymentStorage = new PaymentStorage();
        IncomeStorage incomeStorage = new IncomeStorage();

        TransactionService transactionService = new TransactionService(paymentStorage, incomeStorage);
        StaticticService staticticService = new StaticticService(paymentStorage, incomeStorage);

        //-----------------------------------------------

        Scanner input = new Scanner(System.in);


        System.out.println("Let create your bank account!");
        System.out.print("Input bank name - ");

        String bankName = input.nextLine();
        BankAccount deutscheBank = new BankAccount(bankName);

        System.out.println("Do you want add some money?");
        double deposit = input.nextDouble();

        transactionService.deposit(deutscheBank, deposit);

        System.out.println("Do you want to add payment(p) or income(i)?");
        String typeOfPayment = input.next();
        if (typeOfPayment.equals("p")){
            transactionService.addPayment();
        }else if(typeOfPayment.equals("i")){
            transactionService.addIncome();
        }else{
            System.out.println("Please clarify your answer\n");
        }
    }
}
