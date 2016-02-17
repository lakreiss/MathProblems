package theMesh;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("What are the numbers that can be combined? ");
		String numsInStringForm = console.nextLine();
		ArrayList<Integer> nums = getNums(numsInStringForm);
		System.out.print("What is the goal? ");
		int goal = console.nextInt(); 
		ArrayList<Step> allSteps = new ArrayList<Step>();
		allSteps = findBestChoices(nums, goal, allSteps);
		System.out.println(allSteps);
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

	private static ArrayList<Step> findBestChoices(ArrayList<Integer> nums, int goal, ArrayList<Step> allSteps) {
		ArrayList<Integer> tempNums = nums;
		return null;
		
	}

}
