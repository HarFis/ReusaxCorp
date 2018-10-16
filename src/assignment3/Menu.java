package assignment3;

public class Menu {
	/* <<--------------------------------->>
    *  <<---- ATTRIBUTES & CONSTANTS ----->>
    *  <<--------------------------------->>
	*/
	
	private static final int REGISTER_EMPLOYEE = 1;
	private static final int PRO_DEMOTE_EMPLOYEE = 2;
	private static final int CHANGE_NAME = 3;
	private static final int CHANGE_SALARY = 4;
	private static final int CHANGE_DEGREE = 5;
	private static final int REMOVE_EMPLOYEE = 6;
	private static final int PRINT_GROSS_SALARY = 7;
	private static final int PRINT_NET_SALARY = 8;
	private static final int NUMBER_OF_EMPLOYEES = 9;
	private static final int SORT_EMPLOYEES = 10;
	private static final int CHANGE_DIRECTOR_BENEFIT = 11;
	private static final int QUIT = 12;

	
	private static final int SUB_REG_EMPLOYEE = 1;
	private static final int SUB_REG_INTERN = 2;
	private static final int SUB_REG_MANAGER = 3;
	private static final int SUB_REG_DIRECTOR= 4;
	private static final int SUB_REG_MAIN_MENU= 5;

	
	private myIOClass userInput;
	private Company reusaxCorp;

public Menu ()
{
userInput = new myIOClass();
reusaxCorp = new Company();
	
}

//<<---------------------------->>
// <<------ M A I N M E N U ----->>
// <<---------------------------->>

public void run() {
    
    System.out.println(" === Welcome to ReusaxCorp's HR Department === ");
	
    int option;
    do {
        printMenuOptions();
        option = userInput.readInt("Type the option: ");
        
        switch (option) {
		
        case REGISTER_EMPLOYEE:
			SubRegisterEmployeeOptions();			
			break;

		case PRO_DEMOTE_EMPLOYEE:
			String id = userInput.readLine("Enter ID of the employee that you want to promote: ");
			Employee employeeToChange = reusaxCorp.retrieveEmployee(id);
			System.out.println(employeeToChange.getClass().getSimpleName()); //for testing

			printSubPromoteEmployee();
			
			int x = userInput.readInt("Type your option: ");
			
			String degree;
			
			switch(x) {
			
				case 1://Intern
					
										
						int gpa = userInput.readInt("Enter GPA: ");
						reusaxCorp.changeToIntern(id, gpa);
					
					
					break;
					
				case 2://Employee
					
					printMessageRegistration(reusaxCorp.changeToEmployee(id),id);
					break;
				
				case 3: //Manager
					 
			
						degree = userInput.readLine("Enter degree: ");
						reusaxCorp.changeToManager(id, degree);
					
					break;
					
				case 4: // Director
					
					String department;
						
						degree = userInput.readLine("Enter Degree:");
						department = userInput.readLine("Enter Department:");
						
						printMessageID(reusaxCorp.changeToDirector(id, degree, department),id);
						break;
					
					
			} 
				
			break;

		case CHANGE_NAME:
			id = userInput.readLine("Enter ID of the employee that you want to update: ");
			String newName = userInput.readLine("Enter new name: ");
			printMessageID(reusaxCorp.updateName(id, newName),id);
			break;
					
		case CHANGE_SALARY:
			id = userInput.readLine("Enter ID of the employee that you want to update: ");
			double newSalary = userInput.readDoubleLowerLimit("Enter new salary: ", 0);
			printMessageID(reusaxCorp.updateGrossSalary(id, newSalary),id);
			break;
			
		case CHANGE_DEGREE:
			id = userInput.readLine("Enter ID of the employee that you want to update: ");
			String newDegree = userInput.readLine("Enter new degree: ");
			printMessageID(reusaxCorp.updateDegree(id, newDegree),id);
			break;

		case REMOVE_EMPLOYEE:
			id = userInput.readLine("Enter ID of the employee that you want to remove: ");
			printMessageID(reusaxCorp.removeEmployee(id),id);
			break;

		case PRINT_GROSS_SALARY:
			System.out.println("Total sum of gross salaries: "+reusaxCorp.calculateTotalGrossSalaries()+" SEK");
			break;

		case PRINT_NET_SALARY:
			System.out.println("Total sum of net salaries: "+reusaxCorp.calculateTotalNetSalaries()+" SEK");
			break;
			
		case NUMBER_OF_EMPLOYEES:
			System.out.println("Total number of employees: "+reusaxCorp.numOfEmployees());
			break;
		
		case SORT_EMPLOYEES:
			System.out.println(reusaxCorp.toString());
			String choice = userInput.readLine("How do you want to sort your employees - after "+ Company.SORT_BY_NAME+ " or: "+Company.SORT_BY_NET_SALARY+"?");
			reusaxCorp.sortBy(choice);
			System.out.println(reusaxCorp.toString());
			break;
			
		case CHANGE_DIRECTOR_BENEFIT:
			double newBenefit = userInput.readInt("Enter new director benefit: ");
			reusaxCorp.updateDirectorBenefit(newBenefit);
			break;
			
		case QUIT:
			System.out.println("Thank you for using the HR App. See you soon!");
			System.out.println();
			break;

		default:
			System.out.println("Option "+option+" is not valid.");
			System.out.println();
			break;
		}
	} while (option != QUIT);
}


private void printMenuOptions() {

    System.out.println(" Choose an option below: ");
    System.out.println(" ");
    System.out.println(" 1. Register an employee ");
    System.out.println(" 2. Promote & demote an employee ");
    System.out.println(" 3. Change name of an employee ");
	System.out.println(" 4. Change salary of an employee ");
    System.out.println(" 5. Change degree of an employee ");
    System.out.println(" 6. Remove an employee ");
	System.out.println(" 7. Print total gross salaries ");
    System.out.println(" 8. Print total net salaries ");
    System.out.println(" 9. Print number of employees ");
    System.out.println("10. Sort employees ");
    System.out.println("11. Change director benefit ");
    System.out.println("12. Quit this program ");
    System.out.println();
}

private void printSubRegisterEmployee ()
{
	System.out.println(" Choose an option below: ");
    System.out.println(" ");
    System.out.println(" 1. Register an ordinary employee ");
    System.out.println(" 2. Register an intern ");
    System.out.println(" 3. Register a manager ");
	System.out.println(" 4. Register a director ");
    System.out.println(" 5. Back to main menu ");
}
private void printSubPromoteEmployee ()
{
	System.out.println(" Choose an option below: ");
    System.out.println(" ");
    System.out.println(" 1. Promote to Intern ");
    System.out.println(" 2. Promote to Employee ");
    System.out.println(" 3. Promote to Manager ");
	System.out.println(" 4. Promote to Director");
}
private void SubRegisterEmployeeOptions() {
	int option = 0;
	do {
	printSubRegisterEmployee();
	option = userInput.readInt("Type the option: ");
	switch (option) {
		case SUB_REG_EMPLOYEE:
			{String id = userInput.readLine("Enter employee's ID: ");
			String name = userInput.readLine("Enter employee's name: ");
			double salary = userInput.readDoubleLowerLimit("Enter employee's salary: ", 0);
			printMessageRegistration(reusaxCorp.registerDefaultEmployee(id, name, salary),id);
			break;}
			
		case SUB_REG_INTERN:
			{String id = userInput.readLine("Enter intern's ID: ");
			String name = userInput.readLine("Enter intern's name: ");
			double salary = userInput.readDoubleLowerLimit("Enter intern's salary: ", 0);
			int gpa = userInput.readIntMinMax("Enter intern's GPA: ", Intern.MIN_GPA, Intern.MAX_GPA);

			printMessageRegistration(reusaxCorp.registerIntern(id, name, salary, gpa),id);
			break;}
			
		case SUB_REG_MANAGER:
			{String id = userInput.readLine("Enter manager's ID: ");
			String name = userInput.readLine("Enter manager's name: ");
			double salary = userInput.readDoubleLowerLimit("Enter manager's salary: ", 0);
			String degree = userInput.readLine("Enter manager's highest degree: ");

			printMessageRegistration(reusaxCorp.registerManager(id, name, salary, degree),id);
			break;}		
			
		case SUB_REG_DIRECTOR:
			{String id = userInput.readLine("Enter director's ID: ");
			String name = userInput.readLine("Enter director's name: ");
			double salary = userInput.readDoubleLowerLimit("Enter director's salary: ", 0);
			String degree = userInput.readLine("Enter director's highest degree: ");
			String department = userInput.readLine("Enter director's department: ");

			printMessageRegistration(reusaxCorp.registerDirector(id, name, salary, degree, department),id);
			break;}	
			
		case SUB_REG_MAIN_MENU:
			break;

		default:
			System.out.println("Option "+option+" is not valid.");
			System.out.println();
			break;
	}
	}while(option != SUB_REG_MAIN_MENU);
	
}
private void printMessageID (boolean success, String id)
{
if(success)
	System.out.println("Operation sucessful.");
else
{
	System.out.println("Error! An employee of ID "+id+" is not registered in the system.");
}
}

private void printMessageRegistration (boolean success, String id)
{
if(success)
	System.out.println("A new employee of ID "+id+" was successfully created.");
else
{
	System.out.println("Error! An employee of ID "+id+" is already registered in the system.");	
}

}

}
