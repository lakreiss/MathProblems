package theMesh;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
	
	public static Dictionary<ArrayList<Integer>, Boolean> memo = new Hashtable<ArrayList<Integer>, Boolean>();

	public static void main(String[] args) {
		//still very much in the process of being completed
		
		for (;;){
			Scanner console = new Scanner(System.in);
			System.out.print("What are the numbers that can be combined? ");
			String numsInStringForm = console.nextLine();
			ArrayList<Integer> nums = getNums(numsInStringForm);
			System.out.print("What is the goal? ");
			int goal = console.nextInt(); 
			ArrayList<Step> allSteps = new ArrayList<Step>();
			boolean found = false;
			if (!found){
				found = findBestChoice(nums, goal, goal, allSteps);
			}
			System.out.println(found);
			System.out.println(allSteps);
		}
	}

	private static ArrayList<Integer> getNums(String numsInStringForm) {
		Scanner line = new Scanner(numsInStringForm);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (line.hasNext()){
			if (line.hasNextInt()){
				nums.add(line.nextInt());
			}
		}
		return nums;
	}

	private static boolean findBestChoice(ArrayList<Integer> nums, int goal, int originalGoal, ArrayList<Step> allSteps) {
		if (memo.get(nums)!= null){
			return memo.get(nums);
		}
		if (nums.size() == 1){
			if (nums.get(0) == originalGoal){
				return true;
			}
			return false;
		} else {
			int firstNum = nums.get(0);
			nums.remove(0);
			if (Math.abs(goal + firstNum) < Math.abs(goal - firstNum)){
				allSteps.add(0, new Step(goal, -firstNum));
				goal += firstNum;
			} else {
				allSteps.add(0, new Step(goal, firstNum));
				goal -= firstNum;
			}
			return findBestChoice(nums, goal, originalGoal, allSteps);
		}
		
	}

}
