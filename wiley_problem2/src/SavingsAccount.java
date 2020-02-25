
public class SavingsAccount {
	static double annualInterestRate; //static variable to store annual interest rates
	private double savingsBalance; //private instance variable indicating balance
	
	public SavingsAccount(double savingsBalance) {
		super();
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() { 
		savingsBalance += savingsBalance * (annualInterestRate/ 12);
	}
	
	//static method setting annualInterestRate to new value
	public static void modifyInterestRate(double finalAnnualInterestRate) { 
		annualInterestRate = finalAnnualInterestRate;
	}
	
	//get the saving account balance
	public double getBalance() {
		return savingsBalance;
	}
}
