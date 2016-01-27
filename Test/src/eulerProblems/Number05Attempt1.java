package eulerProblems;

import java.util.ArrayList;

public class Number05Attempt1 {
	
	/*
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
	 * without any remainder.
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */

	public static final int MAX_DIVISOR = 20;
	
	public static void main(String[] args) {
		ArrayList<Integer> allPrimes = new ArrayList<Integer>();
		for (int i = 2; i <= MAX_DIVISOR; i++){
			if (isPrime(i)){
				allPrimes.add(i);
			}
		}
		long total = 1;
		for (int p : allPrimes){
			int i = 1;
			while (Math.pow(p, i) <= MAX_DIVISOR){
				i++;
			}
			total *= Math.pow(p, i - 1);
		}
		System.out.println(total);
	}

	private static boolean isPrime(int num) {
	        if (num == 2 ) return true;
	        if (num % 2 == 0) return false;
	        for (int i = 3; i * i <= num; i += 2)
	            if (num % i == 0) return false;
	        return true;
	}

}
