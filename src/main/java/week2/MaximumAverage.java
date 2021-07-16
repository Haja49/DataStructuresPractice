package week2;

import org.junit.Assert;
import org.junit.Test;

public class MaximumAverage {

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
	 *    What is the expected output? int[]
	 *    Do I have constraints to solve the problem?
	 *    Do I have all informations to go to next step!!
	 *    How big is your test data set will be?
	 *    
	 * 2) Test data set
	 *  	
	 *  	Minimum of 3 data set !! Positive, Edge, Negative 
	 *      Validate with the interviewer if the data set is fine by his/her assumptions
	 * 
	 * 3) Do I know how to solve it?
	 * 		
	 * 		Yes - great, is there an alternate?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 *  
	 * 5) Do I know alternate solutions as well? No
	 * 
	 * 		No - That is still fine, proceed to solve by what you know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * 		Then, explain either both or the best (depends on the time)
	 * 
	 * 		Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * 		Approach 2: Write down the options and benefits and code the best 
	 * 
	 * 7) Start always with Psuedo code 
	 * 
	 * 8) Implement them in the code (editor)
	 * 
	 * 9) Test against the different data set 
	 * 
	 * 10) If it fails, debug them to solve it !!
	 * 
	 */

	@Test
	public void test1() {
		int[] input = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		Assert.assertEquals(maxAverage(input, k), 12.7500, 4);
	}

	@Test
	public void test2() {
		int[] input = { 5 };
		int k = 1;
		Assert.assertEquals(maxAverage(input, k), 5.0000, 4);
	}

	private double maxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		double maxSum = sum;
		for (int i = 1; i <= nums.length - k; i++) {
			sum += nums[i + k - 1] - nums[i - 1];
			maxSum = Math.max(sum, maxSum);
		}
		System.out.println(maxSum / k);
		return maxSum / k;
	}

}
