package eulerProblems;

public class Number10 {
	
	/*
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 */
	
	public static final int MAX = 2000000;	//1 greater because of indexing

	public static void main(String[] args) {
		boolean[] primes = new boolean[MAX];
		for (int i = 0; i < MAX; i++){
			primes[i] = true;
		}
		for (int i = 2; i < MAX; i++){
			if (primes[i] == true){
				for (int j = 2 * i; j < MAX; j += i){
					primes[j] = false;
				}
			}
		}
		long sum = 0;
		for (int i = 2; i < MAX; i++){
			if (primes[i]){
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
