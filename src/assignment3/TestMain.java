package assignment3;

public class TestMain {
	
	public static void main(String[] args) {
		
		
		Company reusaxCorp = new Company();
		
		reusaxCorp.registerDefaultEmployee("1", "Alex", 30000);
		reusaxCorp.registerManager("2", "Bertil", 40000, "bsc.");
		reusaxCorp.registerDirector("3", "Cesar", 50000, "phd", "Technincal");
		reusaxCorp.registerIntern("4", "David", 10000, 9);
		
		System.out.println(reusaxCorp.toString());
		//reusaxCorp.updateDirectorBenefit(5000);
		
		reusaxCorp.changeToIntern("3", 9.0);
		System.out.println(reusaxCorp.toString());


		
	}
		
}
