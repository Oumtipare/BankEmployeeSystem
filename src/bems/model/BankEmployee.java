package bems.model;

public abstract class BankEmployee {
	private int id;
	private String name;
	private double salary;

	public BankEmployee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return "ID: " + id + ", Name" + name + ", Salary of the employee" + salary;
	}
}
