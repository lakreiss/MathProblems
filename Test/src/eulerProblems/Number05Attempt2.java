package eulerProblems;

import java.util.ArrayList;

public class Number05Attempt2 {

	/*
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
	 * without any remainder.
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */
	
	//solvable with values:
	/*
	 * MAX_DIVISOR = 20;
	 * TOTAL_PRIMES_POSSIBLE = 9
	 * PRIMES_POSSIBLE_PER_NUMBER = 3
	 */
	
	public static final int MAX_DIVISOR = 30;
	public static final int TOTAL_PRIMES_POSSIBLE = 14; //(int) (MAX_DIVISOR / Math.log(MAX_DIVISOR) + 3);
	public static final int PRIMES_POSSIBLE_PER_NUMBER = 5;

	public static void main(String[] args) {
		int[][] allFactors = new int[TOTAL_PRIMES_POSSIBLE][2];
		for (int i = 2; i <= MAX_DIVISOR; i++){
			ArrayList<Integer> factors = primeFactorize(i);
			int[][] newFactors = convertToIntArray(factors);
			compare(newFactors, allFactors);
		}
		System.out.println(process(allFactors));
	}
	
	private static void compare(int[][] newFactors, int[][] allFactors) {
		for (int i = 0; i < newFactors.length; i++){
			boolean exists = false;
			int fNum = 0;
			while (!exists){
				if (allFactors[fNum][0] == 0){
					allFactors[fNum][0] = newFactors[i][0];
					allFactors[fNum][1] = newFactors[i][1];
					exists = true;
				} else if (allFactors[fNum][0] == newFactors[i][0]){
					if (allFactors[fNum][1] < newFactors[i][1]){
						allFactors[fNum][1] = newFactors[i][1];
					}
					exists = true;
				} else {
					fNum++;
				}
			}
		}
	}

	private static long process(int[][] allFactors) {
		long total = 1;
		for (int i = 0; i < allFactors.length; i++){
			total *= Math.pow(allFactors[i][0], allFactors[i][1]);
		}
		return total;		
	}

	private static int[][] convertToIntArray(ArrayList<Integer> factors) {
		int[][] allFactors = new int[PRIMES_POSSIBLE_PER_NUMBER][2];
		for (int i : factors){
			boolean exists = false;
			int fNum = 0;
			while (!exists){
				if (allFactors[fNum][0] == 0){
					allFactors[fNum][0] = i;
					allFactors[fNum][1]++;
					exists = true;
				} else if (allFactors[fNum][0] == i){
					allFactors[fNum][1]++;
					exists = true;
				} else {
					fNum++;
				}
			}
		}
		return allFactors;
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
			if (i == 2){
				done = true;
			}
			i /= 2;
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
