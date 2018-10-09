package assignment3;

public class Manager extends Employee{
	
	/* -----------
	 * Attributes
	   ---------- */
	
	private String degree;
	
	// TODO: There must be a better way to do this
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
	
	@Override // I smell reduandancy !!!
	// SOLUTION 1: 
	public double getGrossSalary() {
		
		if(this.degree.equals(LOW_EDU_LEVEL))
			return super.getGrossSalary()+(super.getGrossSalary()*LOW_EDU_BONUS_FACTOR);
		
		if(this.degree.equals(MEDIUM_EDU_LEVEL))
			return super.getGrossSalary()+(super.getGrossSalary()*MEDIUM_EDU_BONUS_FACTOR);

		return super.getGrossSalary()+(super.getGrossSalary()*HIGH_EDU_BONUS_FACTOR);
	}
	
	//SOLUTION 2:
	public double getGrossSalary2() {

		return super.getGrossSalary()+(super.getGrossSalary()*getBonusFactor(this.degree));
	}
	
	private double getBonusFactor (String eduLevel)
	{
		if(eduLevel.equals(LOW_EDU_LEVEL))
			return LOW_EDU_BONUS_FACTOR;
		if(eduLevel.equals(MEDIUM_EDU_LEVEL))
			return MEDIUM_EDU_BONUS_FACTOR;
		
		return HIGH_EDU_BONUS_FACTOR;
	}
	
}
