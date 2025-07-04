package bems.utility;

import bems.model.*;

public class BankEmployeeCreate {

    public static BankEmployee createEmployee(String role, int id, String name, double salary) {
        if (role.equalsIgnoreCase("manager")) {
            return new BankManager(id, name, salary);
        } 
        else if (role.equalsIgnoreCase("cashier")) {
            return new BankCashier(id, name, salary);
        } 
        else {
            throw new IllegalArgumentException("Invalid employee role");
        }
    }
}
