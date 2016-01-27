package eulerProblems;

import java.util.ArrayList;
import java.util.Collections;

public class Number05Attempt1 {
	
	/*
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
	 * without any remainder.
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */

	public static void main(String[] args) {
		ArrayList<Integer> allFactors = new ArrayList<Integer>();
		for (int i = 2; i <= 20; i++){
			ArrayList<Integer> factors = primeFactorize(i);
			update(allFactors, factors);
			Collections.sort(allFactors);
		}
		System.out.println(allFactors);
	}
	
	private static void update(ArrayList<Integer> allFactors, ArrayList<Integer> factors) {
		int nextVal = 0;
		for (int i : factors){
			if (allFactors.size() > nextVal){
				if (allFactors.get(nextVal) == i){
				} else {
					allFactors.add(i);
				}
			} else {
				allFactors.add(i);
			}
			nextVal++;
		}
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
