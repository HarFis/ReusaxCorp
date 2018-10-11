package assignment3;

public class Director extends Manager {

	/*
	 * ----------- Attributes ----------
	 */

	private String department;

	public static final double LOWER_TAXATION_LIMIT = 30000.0;
	public static final double UPPER_TAXATION_LIMIT = 50000.0;
	public static final double TAXATION_FACTOR_1 = 0.2;
	public static final double TAXATION_FACTOR_2 = 0.4;

	/*
	 * -------------- Constructor -----------
	 */

	public Director(String id, String name, double grossSalary, String degree, String department) {
		super(id, name, grossSalary, degree);
		this.department = department;
	}

	/*
	 * ------------------ Getters & Setters ------------------
	 */
	
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public double getGrossSalary() {
		return super.getGrossSalary() + Company.getDirectorBenefit();
	}

	@Override
	public double getNetSalary() {							//Different net salary for different gross salary

		if (this.getGrossSalary() > UPPER_TAXATION_LIMIT) {
			return (LOWER_TAXATION_LIMIT * (1 - TAXATION_FACTOR_1))
					+ ((this.getGrossSalary() - LOWER_TAXATION_LIMIT) * (1 - TAXATION_FACTOR_2));			
			
		} else if (this.getGrossSalary() >= LOWER_TAXATION_LIMIT) {
			return this.getGrossSalary() * (1 - TAXATION_FACTOR_1);
			
		} else {
			return super.getNetSalary();
		}
	}
}
