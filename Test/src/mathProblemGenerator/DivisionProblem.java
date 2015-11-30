package mathProblemGenerator;
import java.util.Random;

public class DivisionProblem extends Problem {
	int answer;
	
	public DivisionProblem(int x) {
		Random r = new Random();
		int number1 = r.nextInt(x) + 1;
		int number2 = r.nextInt(x) + 1;
		this.answer = number1 / number2;
		String s = (number1 + " / " + number2); 
		super.checkUser(s, answer);
	}
	
	public int getAnswer(){
		return this.answer;
	}

}
