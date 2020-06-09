package model;

import utils.DateUtils;

public class Income {
        private double amount;
        private IncomeCategory inCategory;
        private Integer month;
        private int year;

        @Override
        public String toString() {
            return "Income {" +
                    ", amount=" + amount +
                    ", category=" + inCategory +
                    ", month=" + DateUtils.month(month) +
                    ", year=" + year +
                    '}';
        }

//        public Income(int id, double amount, IncomeCategory incomeCategory, int month, int year) {
//            this.amount = amount;
//            this.incomeCategory = inCategory;
//            this.month = month;
//            this.year = year;
//        }
    }
