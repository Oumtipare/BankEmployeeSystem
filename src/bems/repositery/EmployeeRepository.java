package bems.repositery;
import bems.model.*;
import java.util.*;


public class EmployeeRepository {
	private static Map<Integer, BankEmployee> employeeMap = new HashMap<>();
	
	public static void add(BankEmployee emp) {
	        employeeMap.put(emp.getId(), emp);
	}
    public static BankEmployee get(int id) {
        return employeeMap.get(id);
    }

    public static List<BankEmployee> getAll() {
        return new ArrayList<>(employeeMap.values());
    }

    public static void update(int id, BankEmployee emp) {
        employeeMap.put(id, emp);
    }

    public static void delete(int id) {
        employeeMap.remove(id);
    }
	
}



