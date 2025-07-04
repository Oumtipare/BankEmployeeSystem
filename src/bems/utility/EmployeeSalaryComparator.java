package bems.utility;

import bems.model.BankEmployee;
import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<BankEmployee> {
    @Override
    public int compare(BankEmployee e1, BankEmployee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
