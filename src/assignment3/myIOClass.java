package assignment3;

import java.util.Scanner;

public class myIOClass {
	Scanner scanner;
	
	public myIOClass() {
		scanner = new Scanner(System.in);
	}
	
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
	
	public String readLine (String printThis)
	{
		String UserInputString="";
		System.out.print(printThis);
		UserInputString = scanner.nextLine();
		return UserInputString;
	}
	
	public String readNext (String printThis)
	{
		String UserInputNextString="";
		System.out.print(printThis);
		UserInputNextString = scanner.next();
		scanner.nextLine();
		return UserInputNextString;
	}
	
	public int readInt (String printThis)
	{
		int UserInputInt=0;
		System.out.print(printThis);
		UserInputInt = scanner.nextInt();
		scanner.nextLine();
		return UserInputInt;
	}
	
	public double readDouble (String printThis)
	{
		double UserInputDouble=0;
		System.out.print(printThis);
		UserInputDouble = scanner.nextDouble();
		scanner.nextLine();
		return UserInputDouble;
	}
	
	public int readIntLowerLimit (String printThis, int lowestValue)
	{
		int UserInputInt=0;
		System.out.print(printThis);
		do {
		UserInputInt = scanner.nextInt();
		scanner.nextLine();
		if(UserInputInt<lowestValue)
			{System.out.println("The value entered is not valid. Value must be at least "+lowestValue+".");}
		}while(UserInputInt<lowestValue);
		return UserInputInt;
	}
	
	public int readIntUpperLimit (String printThis, int highestValue)
	{
		int UserInputInt=0;
		System.out.print(printThis);
		do {
		UserInputInt = scanner.nextInt();
		scanner.nextLine();
		if(UserInputInt>highestValue)
			{System.out.println("The value entered is not valid. Value must be maximal "+highestValue+".");}
		}while(UserInputInt>highestValue);
		return UserInputInt;
	}
	
	public double readDoubleLowerLimit (String printThis, double lowestValue)
	{
		double UserInputDouble=0;
		System.out.print(printThis);
		do {
		UserInputDouble = scanner.nextDouble();
		scanner.nextLine();
		if(UserInputDouble<lowestValue)
			{System.out.println("The value entered is not valid. Value must be at least "+lowestValue+".");}
		}while(UserInputDouble<lowestValue);
		return UserInputDouble;
	}
	
	
	
	public double readDoubleMinMax (String printThis, double min, double max)
	{
		double UserInputDouble=0;
		System.out.print(printThis);
		do {
		UserInputDouble = scanner.nextDouble();
		scanner.nextLine();
		if(!(UserInputDouble > min && max > UserInputDouble))
		{System.out.println("The value entered is not valid. Value must be between "+min+" and "+max+"." );}
		}while(!(UserInputDouble > min && max > UserInputDouble));
		return UserInputDouble;
	}
	
	public int readIntMinMax (String printThis, int min, int max)
	{
		int UserInputInt=0;
		System.out.print(printThis);
		do {
		UserInputInt = scanner.nextInt();
		scanner.nextLine();
		if(!(UserInputInt > min && max > UserInputInt))
		{System.out.println("The value entered is not valid. Value must be between "+min+" and "+max+"." );}
		}while(!(UserInputInt > min && max > UserInputInt));
		return UserInputInt;
	}
	

}
