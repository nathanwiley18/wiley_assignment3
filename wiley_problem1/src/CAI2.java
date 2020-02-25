import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2 {
   public static void main(String[] args){
   quiz(); //program logic
   }
  
   public static void quiz(){
    SecureRandom secureRandom = new SecureRandom();
	int num1 = secureRandom.nextInt(10); //two random...
	int num2 = secureRandom.nextInt(10); //...integers

	int realAnswer = num1 * num2; //the actual answer to compare the input answer
	int inputAnswer; //user input answer
	
	while(true){
	askQuestion(num1,num2); //ask the question
	inputAnswer = readResponse(); //read the response
	
	if (isAsnwerCorrect(realAnswer,inputAnswer)){ //if the answers are correct...
	displayCorrectResponse(); //...display the correct response (and "Very good!")
	break;
	} 
	else {
	displayInorrectResponse(); //if not, display incorrect response (and "No. Please try again.")
	}
	
	}
   }

   public static void askQuestion(int num1, int num2){ //prompt the user input
   System.out.println("How much is " + num1 + " times " + num2 + "?");
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