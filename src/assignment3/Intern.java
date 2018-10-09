package assignment3;

public class Intern extends Employee {
	
	/* -----------
	 * Attributes
	   ---------- */
	private double gpa;
	
	public static final double LOWER_GPA_LIMIT = 5.0;
	public static final double UPPER_GPA_LIMIT = 8.0;
	public static final double HIGH_GPA_BONUS = 1000.0;
	public static final double LOW_GPA_SALARY = 0.0;

	
	/* --------------
	 *  Constructor
	    -----------  */

	public Intern(String id, String name, double grossSalary, double gpa) {
		super(id, name, grossSalary);
		this.gpa = gpa; //check if values are valid in Constructor? 
	}


	/* ------------------
	 *  Getters & Setters
	   ------------------ */
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public double getGrossSalary() {
		
		if(this.gpa >= UPPER_GPA_LIMIT)
			return super.getGrossSalary() + HIGH_GPA_BONUS;
		
		if(this.gpa > LOWER_GPA_LIMIT)
			return super.getGrossSalary();

		return LOW_GPA_SALARY;
	}
	
}
