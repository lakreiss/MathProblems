package eulerProblems;

public class Number06 {

	/*
	 * The sum of the squares of the first ten natural numbers is,
	 * 1^2 + 2^2 + ... + 10^2 = 385
	 * The square of the sum of the first ten natural numbers is,
	 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
	 * Hence the difference between the sum of the squares of the first ten natural numbers 
	 * and the square of the sum is 3025 − 385 = 2640.
	 * Find the difference between the sum of the squares of the first one hundred natural 
	 * numbers and the square of the sum.
	 */
	
	public static final int nums = 100;
	
	public static void main(String[] args) {
		int sumOfSquares = getSumOfSquares();
		int squareOfSums = getSquareOfSums();
		System.out.println(squareOfSums - sumOfSquares);
	}

	private static int getSquareOfSums() {
		return (int) Math.pow(((nums * (nums + 1)) / 2), 2);
	}

	private static int getSumOfSquares() {
		int total = 0;
		for (int i = 1; i <= nums; i++){
			total += Math.pow(i, 2);
		}
		return total;
	}

}
