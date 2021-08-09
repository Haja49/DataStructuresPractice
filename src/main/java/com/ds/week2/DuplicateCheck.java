package com.ds.week2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class DuplicateCheck {

	/*
	 * 1) Given an integer array nums, return true if any value appears at least twice in the array, 
	 * and return false if every element is distinct.
	 */

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
	 *    What is the expected output? boolean
	 *    Do I have constraints to solve the problem? 1 <= nums.length <= 105
	 *    											  -109 <= nums[i] <= 109
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
		int[] input1 = { 1, 2, 3, 1 };
		Assert.assertEquals(duplicateCheck(input1), true);
	}

	@Test
	public void test2() {
		int[] input1 = { 1, 2, 3, 4 };
		Assert.assertEquals(duplicateCheck(input1), false);
	}

	@Test
	public void test3() {
		int[] input1 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		Assert.assertEquals(duplicateCheck(input1), true);
	}

	/*
	 * Brute Force
	 * 1. Iterate over the elements of the array.
	 * 2. Compare the Elements of the array with the next element
	 * 		a) If the element matches, then return the indices of both elements
	 *		b) Else, return {-1, -1}.
	 */
	// Time Complexity ==> O(n^2)
	// Space Complexity ==> O(n)
	
	/*
	 * Using Hash Set
	 * 1. If the length of the array is 0, return false
	 * 2. Initialize a Hash set
	 * 3. Iterate through the length of the array
	 * 		a) Add the array elements to array
	 * 		b) If set contains the array element, return true
	 * 		c) Else return false
	 */
	
	// Time Complexity ==> O(n)
	// Space Complexity ==> O(n)
	public boolean duplicateCheck(int[] nums) {
		if (nums.length == 0)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

}
