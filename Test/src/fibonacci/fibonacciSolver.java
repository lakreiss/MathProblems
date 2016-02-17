package fibonacci;

import java.util.Dictionary;
import java.util.Hashtable;

public class fibonacciSolver {
	public static Dictionary<Integer, Long> memo = new Hashtable<Integer, Long>();

	public static void main(String[] args) {
		long fibNum = f(50);
		System.out.println(fibNum);
	}

	private static long f(int n) {
		if (memo.get(n)!= null){
			return (long) memo.get(n);
		}
		if (n <= 2){
			return 1;
		} else {
			long f = f(n -1) + f(n-2);
			memo.put(n, f);
			return f;
		}
	}
}
