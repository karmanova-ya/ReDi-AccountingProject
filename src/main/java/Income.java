import model.PaymentCategory;
import utils.DateUtils;

public class Income {
        private int id;
        private double amount;
        private PaymentCategory paymentCategory;
        private Integer month;
        private int year;

        @Override
        public String toString() {
            return "Income {" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", category=" + paymentCategory +
                    ", month=" + DateUtils.month(month) +
                    ", year=" + year +
                    '}';
        }

        public Income(int id, double amount, PaymentCategory paymentCategory, int month, int year) {
            this.id = id;
            this.amount = amount;
            this.paymentCategory = paymentCategory;
            this.month = month;
            this.year = year;
        }
    }
