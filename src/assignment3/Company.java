package assignment3;

import java.util.ArrayList;

public class Company {

	/*
	 * ----------- Attributes ----------
	 */

	private ArrayList<Employee> employees;

	/*
	 * -------------- Constructor -----------
	 */

	public Company() {
		employees = new ArrayList<>();
	}

	/*
	 * ------------ Behaviours ------------
	 */

	public void registerDefaultEmployee(String id, String name, double salary) {
		Employee newRegistered = new Employee(id, name, salary);
		employees.add(newRegistered);

	}

	public void registerIntern(String id, String name, double salary, double gpa) {
		Intern newRegistered = new Intern(id, name, salary, gpa);
		employees.add(newRegistered);
	}

	public void registerManager(String id, String name, double salary, String degree) {
		Manager newRegistered = new Manager(id, name, salary, degree);
		employees.add(newRegistered);
	}

	public void registerDirector(String id, String name, double salary, String degree, String department) {
		Director newRegistered = new Director(id, name, salary, degree, department);
		employees.add(newRegistered);
	}

	public void removeEmployee(String id) {
		Employee theOneToRemove = retrieveEmployee(id);
		employees.remove(theOneToRemove);
	}

	public Employee retrieveEmployee(String id) {
		Employee searchedEmployee = null;
		for (Employee employee : employees) {
			if (employee.getId().equals(id)) {
				searchedEmployee = employee;
				return searchedEmployee;
			}
		}
		return searchedEmployee;
	}

	public void updateName(String id, String newName) {
		Employee theOneToRename = retrieveEmployee(id);
		theOneToRename.setName(newName);
	}

	public void updateGrossSalary(String id, double newSalary) {
		Employee theOneToRename = retrieveEmployee(id);
		theOneToRename.setGrossSalary(newSalary);
	}

	public void updateDirectorBenefit(double newBenefit) {
		for (Employee employee : employees) {

			if (employee instanceof Director) {
				Director director = (Director) employee;
				director.setDirectorBenefit(newBenefit);
			}
		}
	}

	public double calculateTotalGrossSalaries() {
		double total = 0.0;
		for (Employee employee : employees) {
			total += employee.getGrossSalary();
		}

		return total;
	}

	public double calculateTotalNetSalaries() {
		double total = 0.0;
		for (Employee employee : employees) {
			total += employee.getNetSalary();
		}

		return total;
	}

	public int numOfEmployees() {
		int totalNumber = 0;
		totalNumber = employees.size();

		return totalNumber;
	}

	/*
	 * ------------ toSTRING ------------ 
	 * Test
	 */

	public String toString() {
		String print = employees.toString();
		return print;
	}

}