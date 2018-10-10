package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Company {

	/*
	 * ----------- Attributes ----------
	 */

	private ArrayList<Employee> employees;
	
	public static final String SORT_BY_NAME = "Name";
	public static final String SORT_BY_NET_SALARY = "Net Salary";

	/*
	 * -------------- Constructor -----------
	 */

	public Company() {
		employees = new ArrayList<>();
	}

	/*
	 * ------------ Behaviours ------------
	 */

	public boolean registerDefaultEmployee(String id, String name, double salary) {			//Register an Employee, returning value to tell if Employee was added
		if (this.retrieveEmployee(id) == null) {											//Checking if Employee already exists
			Employee newRegistered = new Employee(id, name, salary);
			employees.add(newRegistered);
			return true;																	
		}
		return false;
	}

	public boolean registerIntern(String id, String name, double salary, double gpa) {		//Register an Intern, returning value to tell if Intern was added 
		if (this.retrieveEmployee(id) == null) {											//Checking if Intern already exists
			Intern newRegistered = new Intern(id, name, salary, gpa);
			employees.add(newRegistered);

			return true;
		}
		return false;
	}

	public boolean registerManager(String id, String name, double salary, String degree) {		//Register a Manager, returning value to tell if manager was added
		if (this.retrieveEmployee(id) == null) {												//Checking if Manager already exsits
			Manager newRegistered = new Manager(id, name, salary, degree);
			employees.add(newRegistered);

			return true;
		}
		return false;
	}

	public boolean registerDirector(String id, String name, double salary, String degree, String department) {				//Register a Director, returning value to tell if manager was added
		if (this.retrieveEmployee(id) == null) {																			//Checking if Director already exsits
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
	
	//Changing the types of Employees
	/*
	 * Bad:
	 *  - Redundancy, same code in different methods
	 *  - getGrossSalary is overriden in all subclasses, to access original salary
	 *    we need to create new method getBaseSalary. (Redundancy)
	 * 
	 * 
	 */
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
	 * -------Sort----
	 */
	
	public void sortBy(String sortOrder) {

		if (sortOrder.equals(SORT_BY_NAME)) {

			Collections.sort(employees, new Comparator<Employee>() {

				public int compare(Employee employee1, Employee employee2) {

					int result = employee1.getName().compareTo(employee2.getName());

					if (result != 0) {
						return result;
					} else {
						return Double.compare(employee1.getBaseSalary(), employee2.getBaseSalary());
					}
				}
			});
		} else if (sortOrder.equals(SORT_BY_NET_SALARY)) {
			
			Collections.sort(employees, new Comparator<Employee>() {

				public int compare(Employee employee1, Employee employee2) {

						return Double.compare(employee1.getNetSalary(), employee2.getNetSalary());
					}
			});
		}
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