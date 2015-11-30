package mathProblemGenerator;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		int upperBoundValue = 12;
		boolean newUpperBound = upperBound(console);
		if (newUpperBound){
			upperBoundValue = getUpperBoundValue(console);
		}
		
		int counter = 0;
		
		int correctAdditionProblems = 0, incorrectAdditionProblems = 0;
		int correctSubtractionProblems = 0, incorrectSubtractionProblems = 0;
		int correctMultiplicationProblems = 0, incorrectMultiplicationProblems = 0;
		int correctDivisionProblems = 0, incorrectDivisionProblems = 0;
		
		for (;;){
			Problem p1 = new AdditionProblem(upperBoundValue);
			correctAdditionProblems += p1.getCorrect();
			incorrectAdditionProblems += p1.getIncorrect();
			
			Problem p2 = new SubtractionProblem(upperBoundValue);			
			correctSubtractionProblems += p2.getCorrect();
			incorrectSubtractionProblems += p2.getIncorrect();
			
			Problem p3 = new MultiplicationProblem(upperBoundValue);
			correctMultiplicationProblems += p3.getCorrect();
			incorrectMultiplicationProblems += p3.getIncorrect();
			
			Problem p4 = new DivisionProblem(upperBoundValue);
			correctDivisionProblems += p4.getCorrect();
			incorrectDivisionProblems += p4.getIncorrect();
			
			counter += 4;
			
			if (counter % 20 == 0){
				displayStats(counter, correctAdditionProblems, incorrectAdditionProblems, 
						correctSubtractionProblems, incorrectSubtractionProblems, correctMultiplicationProblems, 
						incorrectMultiplicationProblems, correctDivisionProblems, incorrectDivisionProblems);
			}
		}
		//AdditionProblem a2 = new AdditionProblem("10.0 + 5.0");

	}

	private static void displayStats(int counter, int correctAdditionProblems, int incorrectAdditionProblems,
			int correctSubtractionProblems, int incorrectSubtractionProblems, int correctMultiplicationProblems,
			int incorrectMultiplicationProblems, int correctDivisionProblems, int incorrectDivisionProblems) {
		System.out.println();
		System.out.println("Total problems: " + counter);
		System.out.println("Addition Percentage = " + calculatePercentage(correctAdditionProblems, incorrectAdditionProblems));
		System.out.println("Subtraction Percentage = " + calculatePercentage(correctSubtractionProblems, incorrectSubtractionProblems));
		System.out.println("Multiplication Percentage = " + calculatePercentage(correctMultiplicationProblems, incorrectMultiplicationProblems));
		System.out.println("Division Percentage = " + calculatePercentage(correctDivisionProblems, incorrectDivisionProblems));
		System.out.println();
		
	}

	private static int getUpperBoundValue(Scanner console) {
		System.out.print("What is the upper bound value? ");
		return console.nextInt();
	}

	private static String calculatePercentage(int correctProblems, int incorrectProblems) {
		DecimalFormat f = new DecimalFormat( "##.#" );
		return f.format((correctProblems * 1.0) / (incorrectProblems + correctProblems) * 100) + "%";
	}
	
	public static boolean upperBound(Scanner console){
		System.out.print("Upper Bound different than 12? (y/n) ");
		if (console.next().toLowerCase().charAt(0) == 'y'){
			return true;
		} else {
			return false;
		}
	}

}
