package com.dsweek1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class TwoSum {

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)?
	 *    What is the expected output?
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
		int[] input = { 2, 4, 6, 8, 12, 5 };
		int target = 10;
		Assert.assertArrayEquals(twoSum(input, target), new int[] { 0, 3 });
	}

	@Test
	public void test2() {
		int[] input = { 2, 4, 6, 8, 12, 5 };
		int target = 15;
		Assert.assertArrayEquals(twoSum(input, target), new int[] { -1, -1 });
	}

	@Test
	public void test3() {
		int[] input = { 7, 4, 5, 7 };
		int target = 10;
		Assert.assertArrayEquals(twoSum(input, target), new int[] { -1, -1 });
	}

	/*
	 * 1. Iterate over the elements of the array.
	 * 2. Compare the Elements of the array with the next element
	 * 		a) If the element matches, then return the indices of both elements
	 *		b) Else, return {-1, -1}.
	 */
	
	// O(n^2)
	private int[] twoSum(int[] input, int sum) {
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == sum) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array.
	 * 3. For every element in the array:
	 * 		a) Check if it’s difference (target - element) exists in the Map or not. 
	 * 		   If the difference exists then return the indices of the current element and the difference.
	 *		b) Else, put the element in the Map.
	 */
	
	// O(n)
	private int[] twoSumUsingMap(int[] input, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			int difference = sum - input[i];
			if (map.containsKey(difference)) {
				return new int[] { map.get(difference), i };
			}
			map.put(input[i], i);

		}
		return new int[] { -1, -1 };
	}
}
