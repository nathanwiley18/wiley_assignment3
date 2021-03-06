import java.security.SecureRandom;
import java.util.Scanner;
public class CAI5 {
	
   public static void main(String[] args){
   quiz(); //program logic
   }
  
   public static void quiz(){
		Scanner scan2 = new Scanner(System.in); //used for getting diff level
		Scanner scan3 = new Scanner(System.in);
		SecureRandom secureRandom = new SecureRandom();
		int numCorrect = 0; 
    
	for(int i = 1; i <= 10; i++) {
		int diff = readDifficulty(scan2); //read difficulty from user
		int type = readProblemType(scan3);
		
		int num1 = generateQuestionArgument(secureRandom, diff); //two random...
		int num2 = generateQuestionArgument(secureRandom, diff); //...integers based on diff
		int realAnswer = generateProblemType(type, num1, num2); //the actual answer to compare the input answer (from generateProblemType)
		int inputAnswer; //user input answer
		
		while(true){
			askQuestion(type, num1, num2); //ask the question (now depending on the type the user inputs)
			inputAnswer = readResponse(); //read the response
			
			if (isAsnwerCorrect(realAnswer,inputAnswer)){ //if the answers are correct...
			displayCorrectResponse(); //...display a correct response
			numCorrect++;
			break;
			} 
			else {
			displayInorrectResponse(); //if not, display incorrect response
			}
		}
		percentCompleted(numCorrect);
	}
   }
   
   private static int generateProblemType(int type, int num1, int num2){
	   int finalAnswer = 0;
	   
	   if (type == 1)
		   finalAnswer = num1 + num2;
	   else if (type == 2)
		   finalAnswer = num1 * num2;
	   else if (type == 3)
		   finalAnswer = num1 - num2;
	   else
		   finalAnswer = num1 / num2;
	   
	   return finalAnswer;
   }
   
   private static int generateQuestionArgument(SecureRandom secureRandom, int diff) { //determines how many digits given difficulty
	   int diffLevel = 0;
	   
	   if(diff == 1)
		   diffLevel = secureRandom.nextInt(10);
	   else if(diff == 2)
		   diffLevel = secureRandom.nextInt(100);
	   else if(diff == 3)
		   diffLevel = secureRandom.nextInt(1000);
	   else
		   diffLevel = secureRandom.nextInt(10000);
	   
	   return diffLevel;
   }
   
   private static int readProblemType(Scanner scan3) {
	   System.out.println("Please enter the type of problem you would like to practice (1 for addition, 2 for multiplication, "
	   		+ "3 for subtraction, or 4 for division: ");
	   return scan3.nextInt();
   }
   
   private static int readDifficulty(Scanner scan2) { //user input difficulty
	   System.out.println("Please enter the difficulty level from 1 to 4: ");
	   return scan2.nextInt();
   }
   
   private static void percentCompleted(int numCorrect) {
       double percent = ((double) numCorrect / 10.0) * 100.0;
       System.out.println("You Scored: " + percent + "%");
       if (numCorrect == 10) {
       if (percent < 75)
           System.out.println("Please ask your teacher for extra help.");
       else if (percent > 75)
           System.out.println("Congratulations, you are ready to go to next level!");
       }
   }

   public static void askQuestion(int type, int num1, int num2){ //prompt the user input
		   
	   if (type == 1)
		   System.out.println("How much is " + num1 + " plus " + num2 + "?");
	   else if (type == 2)
		   System.out.println("How much is " + num1 + " times " + num2 + "?");
	   else if (type == 3)
		   System.out.println("How much is " + num1 + " minus " + num2 + "?");
	   else
		   System.out.println("How much is " + num1 + " divided by " + num2 + "?");
	   
   }
  
   public static int readResponse(){
   Scanner scan = new Scanner(System.in);
   int answer = scan.nextInt();
   return answer;
   }
  
   public static boolean isAsnwerCorrect(int expectedAnswer, int inputAnswer){ //is the answer correct?
	   //takes the expected answer and input answer and determines if they are equal
	   return expectedAnswer == inputAnswer; //outputs true or false (used in if statement above)
   }
  
   public static void displayCorrectResponse(){
		String correctResponses[]= {"Very good!", "Excellent!", "Nice job!", 
		   "Great work!"};
	   SecureRandom secureRandom = new SecureRandom();
	   int randNum;
	   randNum = secureRandom.nextInt(3);
	   System.out.println(correctResponses[randNum]);
   }
  
   public static void displayInorrectResponse(){
   String wrongResponses[]= {"No. Please try again.", "Incorrect, try again.", 
		   "Sorry, wrong answer.", "Wrong. Keep trying!"};
   SecureRandom secureRandom = new SecureRandom();
   int randNum;
   randNum = secureRandom.nextInt(3);
   System.out.println(wrongResponses[randNum]);
   }
}