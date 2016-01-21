package eulerProblems;

import java.util.ArrayList;

public class Number7 {
	
	//find the 10,001 prime number
	public static final int NTH_PRIME_NUMBER = 10001;

	public static void main(String[] args) {
		int counter = 1;			//2 is a prime number
		int num = 3;
		boolean done = false;
		while (!done){
			if (isPrime(num)){
				counter++;
			}
			if (counter == NTH_PRIME_NUMBER){
				done = true;
				System.out.println(num);
			}
			num+=2;
		}

	}

	private static boolean isPrime(int num) {
		for (int i = 3; i < num / 2; i+=2){
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	

}
