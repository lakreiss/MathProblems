package mathProblemGenerator;
import java.util.Random;

public class AdditionProblem extends Problem{
	private int answer = 0;
	
//	public AdditionProblem(String s) throws FileNotFoundException{
//		File f = new File(s);
//		@SuppressWarnings("resource")
//		Scanner problem = new Scanner(f);
//		answer += problem.nextDouble();
//		while (problem.hasNext()){
//			problem.next();
//			answer += problem.nextDouble();
//		}
//		checkUser(s);
//	}
	
	public AdditionProblem(int x) {
		Random r = new Random();
		int number1 = r.nextInt(x) + 1;
		int number2 = r.nextInt(x) + 1;
		this.answer = number1 + number2;
		String s = (number1 + " + " + number2); 
		super.checkUser(s, answer);
	}

	public int getAnswer(){
		return answer;
	}
}
