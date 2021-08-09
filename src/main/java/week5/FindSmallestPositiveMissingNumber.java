package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestPositiveMissingNumber {

	/*
	 * 1) Did I understand the problem? Yes -> If yes, go to next step !!
	 * 
	 * What is the input(s)? What is the expected output? Do I have constraints to
	 * solve the problem? Do I have all informations to go to next step!! How big is
	 * your test data set will be?
	 * 
	 * 2) Test data set
	 * 
	 * Minimum of 3 data set !! Positive, Edge, Negative Validate with the
	 * interviewer if the data set is fine by his/her assumptions
	 * 
	 * 3) Do I know how to solve it?
	 * 
	 * Yes - great, is there an alternate?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 * 
	 * 5) Do I know alternate solutions as well? No
	 * 
	 * No - That is still fine, proceed to solve by what you know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * Then, explain either both or the best (depends on the time)
	 * 
	 * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * Approach 2: Write down the options and benefits and code the best
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
		int[] input = { 1, 2, 0 };
		Assert.assertEquals(firstMissingPositive(input), 3);
	}

	@Test
	public void test2() {
		int[] input = { 3, 4, -1, 1 };
		Assert.assertEquals(firstMissingPositive(input), 2);
	}

	@Test
	public void test3() {
		int[] input = { 7, 8, 9, 11, 12 };
		Assert.assertEquals(firstMissingPositive(input), 1);
	}

	public int firstMissingPositiveUsingList(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		for (int i = 1; i <= nums.length; i++) {
			if(!list.contains(i))
				return i;
		}
		return nums.length+1;
	}
	
	public int firstMissingPositiveUsingArray(int[] nums) {
		boolean[] presence = new boolean[nums.length];
		for (int num : nums) {
			if (num > 0 && num <= nums.length)
				presence[num - 1] = true;
		}
		for (int i = 0; i < presence.length; i++) {
			if (!presence[i])
				return i + 1;
		}
		return nums.length + 1;
	}
	
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return nums.length + 1;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
