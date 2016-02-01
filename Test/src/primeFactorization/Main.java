package primeFactorization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(Long.MAX_VALUE);
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
				Scanner input = new Scanner(new File("primeFactorizationTest.txt"));
				process(input);
			}
		} else {
			System.out.print(userIntro());
			//cant say continue
			boolean onward = true;
			while (onward){
				try {
					boolean typeIsInt = checkInt();
					if (typeIsInt){
						ArrayList<Integer> primes = generateIntFactorizationFromUser(console);
						System.out.println("\n" + primes.toString());
					} else {
						ArrayList<Long> primes = generateLongFactorizationFromUser(console);
						System.out.println("\n" + primes.toString());
					}
				} catch (NullPointerException n) {
					onward = false;
				}
			}
		}
	}

	private static ArrayList<Long> generateLongFactorizationFromUser(Scanner console) {
		System.out.print("Enter a long value: ");
		if (console.hasNextLong()){
			return primeFactorize(console.nextLong());
		} else {
			System.out.println("You did not enter a long.");
			generateLongFactorizationFromUser(console);
			return primeFactorize(0L);
		}
	}

	private static ArrayList<Integer> generateIntFactorizationFromUser(Scanner console) {
		System.out.print("Enter an int value: ");
		if (console.hasNextInt()){
			return primeFactorize(console.nextInt());
		} else {
			System.out.println("You did not enter an int.");
			return primeFactorize(0);
		}
	}

	private static boolean checkInt() {
		Scanner input = new Scanner(System.in);
		System.out.print("Are you factorizing an int or a long? (i for int, anything else for long) ");
		String s = input.nextLine();
		if (s.toLowerCase().equals("i")){
			return true;
		} 
		return false;
	}

	private static String userIntro() {
		return "\n";
	}
	
	private static void process(Scanner input) throws FileNotFoundException {
		System.out.println();
		while (input.hasNextLine()){
			try {
				if (input.hasNextInt()){
					ArrayList<Integer> primes = primeFactorize(input.nextInt());
					System.out.println(primes.toString());
				} else if (input.hasNextLong()){
					ArrayList<Long> primes = primeFactorize(input.nextLong());
					System.out.println(primes.toString());
				} else {
					System.out.println("Incorrect format");
				}
			} catch (NullPointerException n) {
				System.out.println("Incorrect format (Null Pointer Exception");
			}
			if (input.hasNextLine()){
				input.nextLine();
			}
		}
	}

	private static ArrayList<Long> primeFactorize(long i) {
		ArrayList<Long> primes = new ArrayList<Long>();
		
		boolean done = false;
		while (i % 2 == 0){
			primes.add(2L);
			i /= 2;
			if (i == 2){
				done = true;
			}
		}
		
		long j = 3;
		while (!done){
			if (i % j == 0){
				primes.add(j);
				if (i == j){
					done = true;
				}
				i /= j;
			}
			if (i % j != 0){
				j += 2;
			}
		}
		
		return primes;
	}
	
	private static ArrayList<Integer> primeFactorize(int i) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		if (i == 1){
			primes.add(1);
			return primes;
		}
		
		boolean done = false;
		while (i % 2 == 0){
			primes.add(2);
			i /= 2;
			if (i == 2){
				done = true;
			}
		}
		
		int j = 3;
		while (!done){
			if (i % j == 0){
				primes.add(j);
				if (i == j){
					done = true;
				}
				i /= j;
			}
			if (i % j != 0){
				j += 2;
			}
		}
		
		return primes;
	}

}
