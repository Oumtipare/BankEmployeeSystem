package bems.service;

import bems.model.BankEmployee;
import java.util.List;

public interface BankEmployeeService {
    void addEmployee(BankEmployee emp);
    BankEmployee getEmployeeById(int id);
    List<BankEmployee> getAllEmployees();
    void updateEmployee(int id, BankEmployee emp);
    void deleteEmployee(int id);
    List<BankEmployee> getEmployeesSortedBySalary();
}

