package assignment3;

public class Intern extends Employee {
	
	/* -----------
	 * Attributes
	   ---------- */
	private int gpa;
	
	public static final int LOWER_GPA_LIMIT = 5;
	public static final int UPPER_GPA_LIMIT = 8;
	public static final double HIGH_GPA_BONUS = 1000.0;
	public static final double LOW_GPA_SALARY = 0.0;

	public static final int MIN_GPA = 0;
	public static final int MAX_GPA = 10;

	
	/* --------------
	 *  Constructor
	    -----------  */

	public Intern(String id, String name, double grossSalary, int gpa) {
		super(id, name, grossSalary);
		this.gpa = gpa; 
	}


	/* ------------------
	 *  Getters & Setters
	   ------------------ */
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		if(gpa>MAX_GPA)
		{this.gpa = MAX_GPA;}
		if(gpa<MIN_GPA)
		{this.gpa = MIN_GPA;}
		
		this.gpa = gpa;
	}
	
	@Override
	public double getNetSalary() {
		return this.getGrossSalary();
	}
	
	@Override
	public double getGrossSalary() {						// Get Salary based on GPA

		if (this.gpa >= UPPER_GPA_LIMIT) { 					
			return super.getGrossSalary() + HIGH_GPA_BONUS;		// Gross salary with bonus
			
		} else if (this.gpa > LOWER_GPA_LIMIT) {			
			return super.getGrossSalary();					//Ordinary gross salary
			
		} else {
			return LOW_GPA_SALARY;							//Zero gross salary
		}
	}
}
