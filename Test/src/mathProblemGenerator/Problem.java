package mathProblemGenerator;
import java.util.Scanner;

public class Problem {
	int correct = 0;
	int incorrect = 0;
	
	public Problem(){
		
	}
	
	public void checkUser(String s, int answer) {
		boolean isCorrect = false;
		System.out.print(s + " = ");
		Scanner console = new Scanner(System.in);
		do {
			double userAnswer = console.nextInt();
			if (userAnswer == answer){
				correct++;
				System.out.println("Great work!");
				isCorrect = true;
			} else {
				incorrect++;
				System.out.println("Try again!");
				System.out.print(s + " = ");
			}
		} while (!isCorrect);
	}
	
	public int getCorrect(){
		return correct;
	}
	
	public int getIncorrect(){
		return incorrect;
	}
}
