package eulerProblems;

import java.util.ArrayList;

public class Number03 {
	
	/*
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * What is the largest prime factor of the number 600851475143 ?
	 */

	public static void main(String[] args) {
		System.out.println(primeFactorize(600851475143L));

	}
	
	private static int primeFactorize(long i) {
		int largestPrime = 2;
		
		boolean done = false;
		while (i % 2 == 0){
			i /= 2;
			if (i == 2){
				done = true;
			}
		}
		
		int j = 3;
		while (!done){
			if (i % j == 0){
				largestPrime = j;
				if (i == j){
					done = true;
				}
				i /= j;
			}
			if (i % j != 0){
				j += 2;
			}
		}
		
		return largestPrime;
	}

}
