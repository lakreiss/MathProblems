package euclideanAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.print("File or entered manually? (type f for file) ");
		if (console.nextLine().toLowerCase().equals("f")){
			System.out.print("Your own file or the file programmed in? (type o for your own) ");
			if (console.nextLine().toLowerCase().equals("o")){
				System.out.print("What is the name of your file? ");
				File f = new File(console.nextLine());
				while (!f.exists() || f.isDirectory()) {
					System.out.println("Please try again");
					System.out.print("What is the name of your file? ");
					f = new File(console.nextLine());
				} 
			    process(new Scanner(f));
			} else {
				Scanner input = new Scanner(new File("euclideanAlgorithmProblems.txt"));
				process(input);
			}
		} else {
			System.out.println(userIntro());
			Equation e = generateEquationFromUser(console);
			while (!e.equals(null)){
				System.out.println("\n" + getFullAnswer(e));
				e = generateEquationFromUser(console);
			}
		}
	}

	private static String userIntro() {
		return "Please type two integers into the console. If you do not type an integer, the "
				+ "program will terminate";
	}

	private static void process(Scanner input) throws FileNotFoundException {
		System.out.println();
		while (input.hasNextLine()){
			Equation e = generateEquationFromFile(input);
			if (!e.equals(null)){ //for some reason this doesnt work
				System.out.println(getFullAnswer(e));
			} else {
				System.out.println("Incorrect format");
			}
		}
	}

	private static Equation generateEquationFromFile(Scanner input) {
		int num1, num2;
		if (input.hasNextInt()){
			num1 = input.nextInt();
		} else{
			return null;
		}
		if (input.hasNextInt()){
			num2 = input.nextInt();
		} else {
			return null;
		}
		return new Equation(num1, num2);
	}

	private static String getFullAnswer(Equation e) {
		String fullAnswer = "";
		fullAnswer += "For the equation: " + e.getEquation() + "\n";
		fullAnswer += "The first coefficient is " + e.getFirstCoefficient() + "\n";
		fullAnswer += "The second coefficient is " + e.getSecondCoefficient() + "\n";
		fullAnswer += "The greatest common divisor is " + e.getGcd() + "\n";
		fullAnswer += e.getAnswer() + "\n";
		return fullAnswer;
	}

	private static Equation generateEquationFromUser(Scanner console) {
		System.out.print("Integer 1: ");
		int num1 = 0, num2 = 0;
		if (console.hasNextInt()){
			num1 = console.nextInt();
		} else {
			return null;
		}
		System.out.print("Integer 2: ");
		if (console.hasNextInt()){
			num2 = console.nextInt();
		} else {
			return null;
		}
		return new Equation(num1, num2);
	}

}
