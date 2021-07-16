package com.dsweek1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindElementsCount {

	/*
	 * 7) Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. 
	 * If there are duplicates in arr, count them separately.
	 */

	/*
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
		int[] input = { 1, 2, 3 };
		Assert.assertEquals(findElementsCount1(input), 2);
	}

	@Test
	public void test2() {
		int[] input = { 1, 1, 3, 3, 5, 5, 7, 7 };
		Assert.assertEquals(findElementsCount1(input), 0);
	}

	@Test
	public void test3() {
		int[] input = { 1, 3, 2, 3, 5, 0 };
		Assert.assertEquals(findElementsCount1(input), 3);
	}

	@Test
	public void test4() {
		int[] input = { 1, 1, 2, 2 };
		Assert.assertEquals(findElementsCount1(input), 2);
	}

	@Test
	public void test5() {
		int[] input = { 1, 1, 2 };
		Assert.assertEquals(findElementsCount1(input), 2);
	}
	
	@Test
	public void test6() {
		int[] input = { -1, 1, 2, 0 };
		Assert.assertEquals(findElementsCount1(input), 3);
	}

	/*
	 * 1. Get the length of the Array and iterate through its length
	 * 2. Initialize a counter and compare elements of array
	 * 3. If the current element matches with any other element value + 1
	 * 		a) Increment the counter and break the loop
	 * 4. Finally return the counter value
	 */

	// Time Complexity - O(n^2)
	// Space Complexity - O(n)
	private int findElementsCount(int[] input) {
		int length = input.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i] + 1 == input[j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	/*
	 * 1. Initialize a Hash set and add all array elements
	 * 2. Initialize the counter
	 * 3. Iterate through the array elements
	 * 		a) If set contains the current element value + 1, increment counter
	 * 4. Finally return counter value
	 */
	
	// Time Complexity - O(n) ==> 2 Pass
	// Space Complexity - O(n)
	private int findElementsCount1(int[] input) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			set.add(input[i]);
		}
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (set.contains(input[i] + 1)) {
				count++;
			}
		}
		return count;
	}
}
