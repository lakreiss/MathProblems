package eulerProblems;

public class Number09 {
	
	/*
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
	 * a2 + b2 = c2
	 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 */
	
	public static final int DESIRED_NUMBER_SUM = 36;

	public static void main(String[] args) {
		boolean found = false;
		int i = 1;
		int stifelNum = 3;
		int oxanamNum = 8;
		
		while (!found){
			int[] stifelSolution = getStifelSolution(i, stifelNum);
			if (checkTriplet(stifelSolution)){
				System.out.println(tripletProduct(stifelSolution));
				found = true;
			}
			stifelNum += 2;
			int[] oxanamSolution = getOxanamSolution(i, oxanamNum);
			if (checkTriplet(oxanamSolution)){
				System.out.println(tripletProduct(oxanamSolution));
				found = true;
			}
			oxanamNum += 4;
		}

	}

	private static int tripletProduct(int[] i) {
		int multiplier = DESIRED_NUMBER_SUM / (i[0] + i[1] + i[2]);
		i[0] *= multiplier;
		i[1] *= multiplier;
		i[2] *= multiplier;
		return i[0] * i[1] * i[2];
	}

	private static boolean checkTriplet(int[] i) {
		if (DESIRED_NUMBER_SUM % (i[0] + i[1] + i[2]) == 0){
			return true;
		}
		return false;
	}

	/**
	 * uses the oxanam method to find pythagorean triplets
	 * 
	 * @param i
	 * @param oxanamNum
	 * @return
	 */
	private static int[] getOxanamSolution(int i, int oxanamNum) {
		int c = (int) Math.sqrt(Math.pow(oxanamNum, 2) + Math.pow(i * oxanamNum + oxanamNum - 1, 2));
		return new int[]{oxanamNum, i * oxanamNum + oxanamNum - 1, c};
	}

	/**
	 * uses the Stifel method to find pythagorean triplets
	 * 
	 * @param i
	 * @param stifelNum
	 * @return
	 */
	private static int[] getStifelSolution(int i, int stifelNum) {
		int c = (int) Math.sqrt(Math.pow(stifelNum, 2) + Math.pow(i * stifelNum + i, 2));
		return new int[]{stifelNum, i * stifelNum + i, c};
	}

}
