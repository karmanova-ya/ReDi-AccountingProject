package model;

import utils.DateUtils;

public class Income extends Transaction{
        private IncomeCategory inCategory;

        @Override
        public String toString() {
            return "Income {" +
                    ", amount=" + getAmount() +
                    ", category=" + inCategory +
                    ", month=" + DateUtils.month(getMonth()) +
                    ", year=" + getYear() +
                    '}';
        }

    public IncomeCategory getInCategory() {
        return inCategory;
    }

    public void setInCategory(IncomeCategory inCategory) {
        this.inCategory = inCategory;
    }
}
