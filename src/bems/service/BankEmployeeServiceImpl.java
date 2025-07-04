package bems.service;

import bems.model.BankEmployee;
import bems.repositery.*;
import bems.exception.EmployeeNotFoundException;
import bems.exception.*;
import bems.utility.EmployeeSalaryComparator;

import java.util.*;

public class BankEmployeeServiceImpl implements BankEmployeeService {

    @Override
    public void addEmployee(BankEmployee emp) {
        if (EmployeeRepository.get(emp.getId()) != null) {
            throw new DuplicateEmployeeException(emp.getId());
        }
        EmployeeRepository.add(emp);
    }

    @Override
    public BankEmployee getEmployeeById(int id) {
        BankEmployee emp = EmployeeRepository.get(id);
        if (emp == null) {
            throw new EmployeeNotFoundException(id);
        }
        return emp;
    }

    @Override
    public List<BankEmployee> getAllEmployees() {
        return EmployeeRepository.getAll();
    }

    @Override
    public void updateEmployee(int id, BankEmployee emp) {
        if (EmployeeRepository.get(id) == null) {
            throw new EmployeeNotFoundException(id);
        }
        EmployeeRepository.update(id, emp);
    }

    @Override
    public void deleteEmployee(int id) {
        if (EmployeeRepository.get(id) == null) {
            throw new EmployeeNotFoundException(id);
        }
        EmployeeRepository.delete(id);
    }

    @Override
    public List<BankEmployee> getEmployeesSortedBySalary() {
        List<BankEmployee> list = EmployeeRepository.getAll();
        list.sort(new EmployeeSalaryComparator());
        return list;
    }
}