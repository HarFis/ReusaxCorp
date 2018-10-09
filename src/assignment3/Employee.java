package assignment3;

public class Employee {
	
	/* -----------
	 * Attributes
	   ---------- */
	
	private String id;
	private String name;
	private double grossSalary;
	
	public static final double DEFAULT_TAX = 0.1;
	
	/* --------------
	 *  Constructor
	    -----------  */
	
	public Employee (String id, String name, double grossSalary)
	{
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;		
	}
	
	/* ------------------
	 *  Getters & Setters
	   ------------------ */
	
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
	
	/* ------------
	 *  Behaviours
	   ------------ */
	
	public double getNetSalary() {
		
		double netSalary = grossSalary - (grossSalary*DEFAULT_TAX);
		return netSalary;
	}
	
}
