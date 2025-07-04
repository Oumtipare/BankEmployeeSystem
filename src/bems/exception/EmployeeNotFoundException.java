package bems.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int id) {
        super("❌ Employee with ID " + id + " not found.");
    }
}
