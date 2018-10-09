package assignment3;

public class TestMain {
	
	public static void main(String[] args) {
		
		
		Company reusaxCorp = new Company();
		
		reusaxCorp.registerDefaultEmployee("1", "Alex", 30000);
		reusaxCorp.registerManager("2", "Bertil", 40000, "bsc.");
		reusaxCorp.registerDirector("3", "Cesar", 50000, "phd", "Technincal");
		reusaxCorp.registerIntern("4", "David", 10000, 9);
		
		System.out.println(reusaxCorp.retrieveEmployee("1"));
		System.out.println(reusaxCorp.retrieveEmployee("2"));
		System.out.println(reusaxCorp.retrieveEmployee("3"));
		System.out.println(reusaxCorp.retrieveEmployee("4"));
		
		reusaxCorp.updateDirectorBenefit(5000);
		
		//System.out.println(reusaxCorp.calculateTotalGrossSalaries());
		
		System.out.println(reusaxCorp.retrieveEmployee("3"));
		reusaxCorp.updateDirectorBenefit(5000);
		System.out.println(reusaxCorp.retrieveEmployee("3"));
	}
		
}
