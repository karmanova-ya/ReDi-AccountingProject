import model.BankAccount;
import model.PaymentCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IncomeStorage;
import repository.PaymentStorage;
import services.TransactionService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionServiceTest {

    PaymentStorage ps;
    IncomeStorage is;
    TransactionService ts;
    String bankName;
    BankAccount deutscheBank;

    @BeforeEach
    void init() {
        ps = new PaymentStorage();
        is = new IncomeStorage();
        ts = new TransactionService(ps, is);
//        bankName = "Deutsche Bank";
        deutscheBank = new BankAccount(bankName);
    }

//    @Test
//    public void end2End() {
//        assertTrue(deutscheBank.getBankName().equals("Deutsche Bank"));
//    }

    @Test
    public void testDepositWithdraw() {
        double depositAmount = 100;
        ts.deposit(deutscheBank, depositAmount);
        assertEquals(100, deutscheBank.getBalance());

        double withdrawAmount = 30;
        ts.withdraw(deutscheBank, withdrawAmount);
        assertEquals(70, deutscheBank.getBalance());
    }

    @Test
    public void testAddPayCategoryPositiv() {
        String input = "e";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(ts.addPayCategory().equals(PaymentCategory.ENTERTAINMENT));
    }

//    @Test
//    public void testAddPayCategoryNegativ() {
//        String input = "y";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertFalse(ts.addPayCategory().equals(PaymentCategory.ENTERTAINMENT));
//    }

    @Test
    public void testAddInCategory() {

    }

    @Test
    public void testAddPaymentDate() {

    }

    @Test
    public void testAddPayment() {

    }

    @Test
    public void testAddIncome() {

    }

//        BankAccount bankAccount;
//        if (f.exists() && !f.isDirectory()) {
//            bankAccount = readBankAcc();
//        } else {
//            bankAccount = createBankAcc();
//        }
//
//        System.out.println("Do you want add some money? (y/n)");
//        String answer = input.next();
//        double deposit = 0;
//        if (answer.equals("y")) {
//            try {
//                System.out.println("Input here -->");
//                deposit = input.nextDouble();
//                transactionService.deposit(bankAccount, deposit);
//            } catch (InputMismatchException e) {
//                System.out.println("This does not really make sense, sorry. Please add an amount instead of text.");
//                System.out.println("Input here -->");
//                deposit = input.nextDouble();
//                transactionService.deposit(bankAccount, deposit);
//            }
//        }
//
//        System.out.println("Do you want to add payment(p) or income(i)?");
//        String typeOfPayment = input.next();
//        if (typeOfPayment.equals("p")) {
//            transactionService.addPayment();
//        } else if (typeOfPayment.equals("i")) {
//            transactionService.addIncome();
//        } else {
//            System.out.println("Please clarify your answer\n");
//        }
//
//        System.out.println("Do you want to see transaction statistic? (y/n)");
//        String userSelection = input.next();
//        if (userSelection.equals("y")) {
//            staticticService.selectStatistics();
//        } else {
//            System.out.println("Please clarify your answer\n");
//            staticticService.selectStatistics();
//        }
//    }
}

