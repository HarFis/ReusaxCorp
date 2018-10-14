package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Company {

	/*
	 * ----------- 
	 *  Attributes 
	 * ------------
	 */

	private ArrayList<Employee> employees;
	private static double directorBenefit; // static so that it is the same for every instance of director
	
	public static final String SORT_BY_NAME = "Name";
	public static final String SORT_BY_NET_SALARY = "Net Salary";

	/*
	 * -------------- 
	 *  Constructor 
	 * --------------
	 */

	public Company() {
		employees = new ArrayList<>();
		directorBenefit = 0.0;
	}

	/*
	 * ------------ 
	 *  Behaviours 
	 * ------------
	 */
	
	
	/*
	 * SEARCH FOR EMPLOYEE IN LIST
	 */
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
	
	
	/*
	 * REGISTER NEW EMPLOYEES
	 * 
	 */

	public boolean registerDefaultEmployee(String id, String name, double salary) {			//Register an Employee, returning value to tell if Employee was added
		if (this.retrieveEmployee(id) == null) {											//Checking if Employee already exists
			Employee newRegistered = new Employee(id, name, salary);
			employees.add(newRegistered);
			return true;																	
		}
		return false;
	}

	public boolean registerIntern(String id, String name, double salary, int gpa) {		//Register an Intern, returning value to tell if Intern was added 
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
	
	/*
	 *  UPDATE EMPLOYEES' INFO AND REMOVE EMPLOYEE
	 */

	public boolean removeEmployee(String id) {						//Removing employee, returning if successful or not
		Employee theOneToRemove = retrieveEmployee(id);
		if (theOneToRemove != null) {
			employees.remove(theOneToRemove);
			return true;
		}else {
			return false;
		}
	}

	public boolean updateName(String id, String newName) {					//Updating name to Employee, returning if successful or not
		Employee theOneToGetNewSalary = retrieveEmployee(id);
		if (theOneToGetNewSalary != null) {
			theOneToGetNewSalary.setName(newName);
			return true;
			
		}else {
			return false;
		}
	}

	public boolean updateDegree(String id, String newDegree) { 						//Updating degree, returning if successful or not
		Employee theOneToGetNewDegree = retrieveEmployee(id);
		if (theOneToGetNewDegree != null) {
			if (theOneToGetNewDegree instanceof Manager || theOneToGetNewDegree instanceof Director) {		//Can only update degree if Employee is Manager or Director
				Manager theOneTemp = (Manager) theOneToGetNewDegree;
				theOneTemp.setDegree(newDegree);
				return true;
			}
			return false;
		}else {
			return false;
		}
	}

	public boolean updateGrossSalary(String id, double newSalary) {
		Employee theOneToChangeSalary = retrieveEmployee(id);
		if (theOneToChangeSalary != null) {
			theOneToChangeSalary.setGrossSalary(newSalary);
			return true;
		} else {
			return false;
		}
	}

	public void updateDirectorBenefit(double newBenefit) { //change director's benefit which is a static variable
		directorBenefit = newBenefit;
		}
	
	public static double getDirectorBenefit() { //access director's benefit
		return directorBenefit;
	}
	
	/*
	 *  CALCULATE SUM OF EMPLOYEES' SALARIES & TOTAL NUMBER OF EMPLOYEES
	 */
	
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
	 *  Good:
	 *  - up- and downgrading possible
	 *  - reuse of all already existing data possible
	 * 
	 */
	
	public String checkPosition (String id) {
		Employee searchedEmployee = retrieveEmployee(id);
		if(searchedEmployee!=null)
		{
			return searchedEmployee.getClass().getSimpleName();
		}
		return "Does not exist";
		
	}
	
	
	public boolean changeToEmployee(String id) {

		Employee employeeToChange = this.retrieveEmployee(id);
		if (employeeToChange != null) {
			String name = employeeToChange.getName();
			double salary = employeeToChange.getBaseSalary();

			this.removeEmployee(id);
			this.registerDefaultEmployee(id, name, salary);
			return true;
		} else {
			return false;
		}
	}

	public boolean changeToManager(String id, String degree) {

		Employee employeeToChange = this.retrieveEmployee(id);
		if (employeeToChange != null) {
			String name = employeeToChange.getName();
			double grossSalary = employeeToChange.getBaseSalary();

			this.removeEmployee(id);
			this.registerManager(id, name, grossSalary, degree);
			return true;
		} else {
			return false;
		}
	}

	public boolean changeToDirector(String id, String degree, String department) {

		Employee employeeToChange = this.retrieveEmployee(id);
		if (employeeToChange != null) {
			String name = employeeToChange.getName();
			double grossSalary = employeeToChange.getBaseSalary();

			this.removeEmployee(id);
			this.registerDirector(id, name, grossSalary, degree, department);
			return true;
		} else {
			return false;
		}
	}

	public boolean changeToIntern(String id, int gpa) {

		Employee employeeToChange = this.retrieveEmployee(id);
		if (employeeToChange != null) {
			String name = employeeToChange.getName();
			double grossSalary = employeeToChange.getBaseSalary();

			this.removeEmployee(id);
			this.registerIntern(id, name, grossSalary, gpa);
			return true;
		} else {
			return false;
	}
	}
	


	/*
	 * -------
	 *  Sort
	 * -------
	 */
	
	public boolean sortBy(String sortOrder) {					//Sorting by name, if same name sort by gross salary

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
		return true;	
		} 
		else if (sortOrder.equals(SORT_BY_NET_SALARY)) {			//Sorting by net salary

			Collections.sort(employees, new Comparator<Employee>() {

				public int compare(Employee employee1, Employee employee2) {

					return Double.compare(employee1.getNetSalary(), employee2.getNetSalary());
				}
			});
		return true;
		}
		else { // return false if sorting method was not or wrongly specified
		return false;	
		}
	}
	


	/*
	 * ------------ 
	 *   toSTRING 
	 * ------------ 
	 */

	public String toString() {
		String print = employees.toString();
		return print;
	}

}