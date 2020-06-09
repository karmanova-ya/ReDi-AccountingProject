package repository;

import model.Income;

import java.util.HashSet;

public class IncomeStorage {
    HashSet<Income> incomes = new HashSet();

    public void addIncome(Income income){
        incomes.add(income);
    }

    public HashSet<Income> getIncomes() {
        return incomes;
    }
}
