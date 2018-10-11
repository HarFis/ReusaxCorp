package assignment3;

public class Manager extends Employee{
	
	/* -----------
	 * Attributes
	   ---------- */
	
	private String degree;
	
	public static final String LOW_EDU_LEVEL = "BSc.";
	public static final double LOW_EDU_BONUS_FACTOR = 0.1;

	public static final String MEDIUM_EDU_LEVEL = "MSc.";
	public static final double MEDIUM_EDU_BONUS_FACTOR = 0.2;

	public static final String HIGH_EDU_LEVEL = "PhD";
	public static final double HIGH_EDU_BONUS_FACTOR = 0.35;

	
	/* --------------
	 *  Constructor
	    -----------  */

	public Manager(String id, String name, double grossSalary, String degree) {
		super(id, name, grossSalary);
		
		this.degree = degree;
	}

	/* ------------------
	 *  Getters & Setters
	   ------------------ */
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public double getBonus() { // getting bonus depending on which degree

		double bonus = 0;

		if (this.isDegreeBsc()) {
			bonus = super.getGrossSalary() * LOW_EDU_BONUS_FACTOR;

		} else if (this.isDegreeMsc()) {
			bonus = super.getGrossSalary() * MEDIUM_EDU_BONUS_FACTOR;

		} else if (this.isDegreePhd()) {
			bonus = super.getGrossSalary() * HIGH_EDU_BONUS_FACTOR;
		}

		return bonus;
	}
	
	@Override
	public double getGrossSalary() {

		return super.getGrossSalary()+ this.getBonus();
	}
	public boolean isDegreeBsc() { // Check to see if degree is equal to a BSc
		return this.degree.toLowerCase().equals(LOW_EDU_LEVEL.toLowerCase());
	}

	public boolean isDegreeMsc() { // Check to see if degree is equal to a MSc
		return this.degree.toLowerCase().equals(MEDIUM_EDU_LEVEL.toLowerCase());
	}

	public boolean isDegreePhd() { // Check to see if degree is equal to a PhD
		return this.degree.toLowerCase().equals(HIGH_EDU_LEVEL.toLowerCase());
	}
}
