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

	public boolean registerDefaultEmployee(String id, String name, double salary) {
		if (this.retrieveEmployee(id) == null) {
			Employee newRegistered = new Employee(id, name, salary);
			employees.add(newRegistered);
			return true;
		}
		return false;
	}

	public boolean registerIntern(String id, String name, double salary, double gpa) {
		if (this.retrieveEmployee(id) == null) {
			Intern newRegistered = new Intern(id, name, salary, gpa);
			employees.add(newRegistered);

			return true;
		}
		return false;
	}

	public boolean registerManager(String id, String name, double salary, String degree) {
		if (this.retrieveEmployee(id) == null) {
			Manager newRegistered = new Manager(id, name, salary, degree);
			employees.add(newRegistered);

			return true;
		}
		return false;
	}

	public boolean registerDirector(String id, String name, double salary, String degree, String department) {
		if (this.retrieveEmployee(id) == null) {
			Director newRegistered = new Director(id, name, salary, degree, department);
			employees.add(newRegistered);

			return true;
		}
		return false;
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
	
	//PROMOTE
	
	public void changeToEmployee(String id) {
		
		Employee employeeToChange = this.retrieveEmployee(id);
		String name = employeeToChange.getName();
		double salary = employeeToChange.getBaseSalary();
		
		this.removeEmployee(id);
		
		this.registerDefaultEmployee(id, name, salary);
	}
	
	
	public void changeToManager(String id, String degree) {
		
		Employee employeeToChange = this.retrieveEmployee(id);
		
		String name = employeeToChange.getName();
		double grossSalary = employeeToChange.getBaseSalary();
		
		this.removeEmployee(id);
		this.registerManager(id, name, grossSalary, degree);
		
	}
	
	public void changeToDirector(String id, String degree, String department) {
		
		Employee employeeToChange = this.retrieveEmployee(id);

		String name = employeeToChange.getName();
		double grossSalary = employeeToChange.getBaseSalary();

		this.removeEmployee(id);
		this.registerDirector(id, name, grossSalary, degree, department);
	}
	
	public void changeToIntern(String id, double gpa) {
		
		Employee employeeToChange = this.retrieveEmployee(id);
		
		String name = employeeToChange.getName();
		double grossSalary = employeeToChange.getBaseSalary();

		this.removeEmployee(id);
		this.registerIntern(id, name, grossSalary, gpa);
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