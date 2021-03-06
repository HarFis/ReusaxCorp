package assignment3;


public class Employee {

	/* -----------
	   Attributes
	   ---------- */

	private String id;
	private String name;
	private double grossSalary;

	public static final double DEFAULT_TAX = 0.1;

	/* --------------
    	Constructor
       --------------  */

	public Employee(String id, String name, double grossSalary) {
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;
	}

	/*
	 * ------------------- 
	 *  Getters & Setters 
	 * -------------------
	 */

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	public double getBaseSalary() {
		return grossSalary;
	}

	/*
	 * ------------ 
	 *  Behaviours 
	 * -------------
	 */

	public double getNetSalary() { // Getting net salary

		double netSalary = this.getGrossSalary() * (1 - DEFAULT_TAX);
		return netSalary;
	}


	/*
	 * ---------------------------- 
	 * ToString & Equals (Override) 
	 * ----------------------------
	 */
	
	@Override
	public String toString() {

		String print = this.getName() + "'s gross salary is of " + this.getGrossSalary() + " SEK per month. (Net Salary: " + this.getNetSalary()+" SEK/month)\n";
		return print;
	}

	@Override
	public boolean equals(Object anotherObject) { // Equals if same ID

		if (anotherObject instanceof Employee) {

			Employee anotherEmployee = (Employee) anotherObject;

			return this.id.equals(anotherEmployee.getId());

		} else {
			return false;
		}
	}

}
