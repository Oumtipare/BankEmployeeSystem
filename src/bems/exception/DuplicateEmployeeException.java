package bems.exception;

public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException(int id) {
        super("Employee with ID " + id + " already exists.");
    }
}
