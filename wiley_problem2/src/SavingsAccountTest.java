
public class SavingsAccountTest {

   public static void main(String[] args) {
   SavingsAccount saver1 = new SavingsAccount(2000.00); //sets saver1 with balance of 2000
   SavingsAccount saver2 = new SavingsAccount(3000.00); //sets saver 2 with balance of 3000
   SavingsAccount.annualInterestRate = 4; //4% annual interest rate
  
   System.out.println("Account 1: ");
   System.out.println("Month \tBalance");
   
   for(int i = 1; i < 12; i++){
       saver1.calculateMonthlyInterest();
       System.out.printf("%d \t%.2f \n", i, saver1.getBalance());
   }
   System.out.printf("\n");
   
   System.out.println("Account 2: ");
   System.out.println("Month \tBalance");
   
   for(int i = 1; i < 12; i++){
       saver2.calculateMonthlyInterest();      
       System.out.printf("%d \t%.2f \n", i, saver2.getBalance());
   }
   System.out.printf("\n");
  
   System.out.println("Annual rate changed to 5%: ");
   SavingsAccount.modifyInterestRate(5);
  
   System.out.println("Account 1: ");

   saver1.calculateMonthlyInterest();
   System.out.printf("The new balance of account 1 is:%.2f \n", saver1.getBalance());
  
   System.out.println("Account 2: ");

   saver1.calculateMonthlyInterest();
   System.out.printf("The new balance of account 2 is:%.2f \n", saver1.getBalance());
  

   }
}