package fibonacci;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class fibonacciSolver {
	public static Dictionary<Integer, Long> memo = new Hashtable<Integer, Long>();

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		for (;;){
			System.out.print("What fibonacci number do you want to find? ");
			int n = console.nextInt();
			long fibNum = f(n);
			System.out.println("The " + n + "th fibonacci number is " + fibNum);
		}
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
