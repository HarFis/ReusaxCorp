package assignment3;

public class TestMain {
	
	public static void main(String[] args) {
		
		
		Company reusaxCorp = new Company();
		
		reusaxCorp.registerDefaultEmployee("1", "Bertil", 10000);
		reusaxCorp.registerManager("2", "David", 10000, "bsc.");
		reusaxCorp.registerDirector("3", "Ceast", 50000, "phd", "Technincal");
		reusaxCorp.registerIntern("4", "Adam", 10000, 8);
		
		System.out.println(reusaxCorp);
		//reusaxCorp.updateDirectorBenefit(5000);
		
		reusaxCorp.sortBy("Name");
		System.out.println();
		//reusaxCorp.changeToIntern("3", 9.0);
		System.out.println(reusaxCorp);
		System.out.println();
		reusaxCorp.sortBy("Net Salary");
		System.out.println(reusaxCorp);

		
	}
		
}
