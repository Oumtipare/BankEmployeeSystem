package bems.client;

import bems.model.BankEmployee;
import bems.service.BankEmployeeService;
import bems.service.BankEmployeeServiceImpl;
import bems.utility.BankEmployeeCreate;
import bems.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankEmployeeService service = new BankEmployeeServiceImpl();

        while (true) {
            System.out.println("hello from utkarsh190203");

            System.out.println("\n=== Bank Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Get Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter role (manager/cashier): ");
                        String role = scanner.nextLine();
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();

                        BankEmployee emp = BankEmployeeCreate.createEmployee(role, id, name, salary);
                        service.addEmployee(emp);
                        System.out.println("✅ Employee added successfully.");
                        break;

                    case 2:
                        List<BankEmployee> all = service.getAllEmployees();
                        if (all.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            for (BankEmployee e : all) {
                                System.out.println(e);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();
                        BankEmployee found = service.getEmployeeById(searchId);
                        System.out.println(found);
                        break;

                    case 4:
                        System.out.print("Enter ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        service.getEmployeeById(updateId); // Will throw exception if not found

                        System.out.print("Enter new role (manager/cashier): ");
                        String newRole = scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSalary = scanner.nextDouble();
                        scanner.nextLine();

                        BankEmployee updatedEmp = BankEmployeeCreate.createEmployee(newRole, updateId, newName, newSalary);
                        service.updateEmployee(updateId, updatedEmp);
                        System.out.println("✅ Employee updated successfully.");
                        break;

                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        service.deleteEmployee(deleteId);
                        System.out.println("✅ Employee deleted.");
                        break;

                    case 6:
                        List<BankEmployee> sorted = service.getEmployeesSortedBySalary();
                        for (BankEmployee e : sorted) {
                            System.out.println(e);
                        }
                        break;

                    case 0:
                        System.out.println("👋 Exiting... Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("❌ Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException | EmployeeNotFoundException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Unexpected error: " + e.getMessage());
            }
        }
    }
}
