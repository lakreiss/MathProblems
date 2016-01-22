package eulerProblems;

public class Number04 {
	
	/*
	 * A palindromic number reads the same both ways. The largest palindrome made from 
	 * the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	
	public static final int UPPER_BOUND = 1000000;

	public static void main(String[] args) {
		boolean found = false;
		int[] digits = new int[]{9, 9, 9};
		while (!found){
			decrementPalindrome(digits);
			found = checkForFactors(createPalindrome(digits));
		}
		System.out.println(createPalindrome(digits));
	}
	
	private static void decrementPalindrome(int[] digits) {
		digits[2]--;
		if (digits[2] == -1){
			digits[1]--;
			digits[2] = 9;
		} 
		if (digits[1] == -1){
			digits[0]--;
			digits[1] = 9;
		} 
	}

	private static boolean checkForFactors(int num) {
		for (int i = 999; i > 900; i--){
			if (num % i == 0){
				for (int j = 999; j > 900; j--){
					if (num / i % j == 0){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static int createPalindrome(int[] digits){
		int totalNum = (int) (digits[0] * Math.pow(10, 5) + digits[0]);
		totalNum += digits[1] * Math.pow(10, 4) + digits[1] * Math.pow(10, 1);
		totalNum += digits[2] * Math.pow(10, 3) + digits[2] * Math.pow(10, 2);
		return totalNum;
	}

}
