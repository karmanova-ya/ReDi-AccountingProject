import model.BankAccount;
import model.IncomeCategory;
import model.PaymentCategory;
import model.Payment;
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let create your bank account!");
        System.out.print("Input bank name - ");

        String bankName = input.nextLine();
//        String secondBName = input.nextLine();
        BankAccount deutscheBank = new BankAccount(bankName);
//        BankAccount n26 = new BankAccount(secondBName);

        System.out.println("Do you want add some money?");
        double deposit = input.nextDouble();

        TransactionService db = new TransactionService();
        db.deposit(deutscheBank, deposit);

        System.out.println("Do you want to add payment(p) or income(i)?");
        String typeOfPayment = input.next();
        if (typeOfPayment.equals("p")){
            db.addPayment();
        }else if(typeOfPayment.equals("i")){
            db.addIncome();
        }else{
            System.out.println("Please clarify your answer\n");
        }






//        bank.addPayment(new Expense(1, 500, Category.SALARY, 4, 2019));
//        bank.addPayment(new Expense(2, -10.5, Category.CAFE, 4, 2019));
//        bank.addPayment(new Expense(3, -4.5, Category.TRANSPORT, 4, 2019));
//        bank.addPayment(new Expense(4, 33, Category.DIVIDEND, 5, 2019));
//        bank.addPayment(new Expense(5, 500, Category.SALARY, 5, 2019));
//        bank.addPayment(new Expense(6, -5, Category.CAFE, 5, 2019));
//        bank.addPayment(new Expense(7, 20, Category.DIVIDEND, 4, 2020));
//        bank.addPayment(new Expense(8, 3, Category.DIVIDEND, 4, 2020));
//
//        System.out.println(bank.biggestPayment());
//        System.out.println(bank.totalIncome());
//        bank.alphGrouping();
//        bank.selectStatistics();
//        bank.biggestIncome();
//        bank.totalSpending();
//        bank.totalSpendingByMonth();
    }
}
