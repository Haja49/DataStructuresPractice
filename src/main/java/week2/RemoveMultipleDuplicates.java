package week2;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveMultipleDuplicates {

	/*
	 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
	 * 
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
	 *    What is the expected output? int
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
		int[] input = { 1, 1, 1, 2, 2, 3 };
		Assert.assertEquals(5, removeDuplicates(input));
	}

	@Test
	public void test2() {
		int[] input = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		Assert.assertEquals(7, removeDuplicates(input));
	}

	@Test
	public void test3() {
		int[] input = { 1, 2 };
		Assert.assertEquals(2, removeDuplicates(input));
	}

	/*
	 * 1. If length is less than 2, return length
	 * 2. Initialize 2 variables, count and left
	 * 3. While left < input length
	 * 		a) if input[left] is not equal to input[count-2]
	 * 		b) assign input[left] to input[count] and increment count and left
	 * 4. Increment left
	 * 5. Finally return count
	 */
	private int findCount(int[] input) {
		if (input.length <= 2)
			return input.length;
		int count = 2, left = 2;
		while (left < input.length) {
			if (input[left] != input[count - 2])
				input[count++] = input[left];
			left++;
		}
		return count;
	}

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
