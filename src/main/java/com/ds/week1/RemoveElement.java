package com.ds.week1;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveElement {
	
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
		int[] input = { 2, 3, 3, 4, 5 };
		int target = 3;
		Assert.assertEquals(removeElement(input, target), new int[] {2, 4, 5});
	}

	@Test
	public void test2() {
		int[] input = { 5, 5, 5, 5 };
		int target = 5;
		Assert.assertEquals(removeElement(input, target), new int[] {});
	}

	@Test
	public void test3() {
		int[] input = { 2, 3, 3, 4, 5 };
		int target = 6;
		Assert.assertEquals(removeElement(input, target), new int[] {2, 3, 3, 4, 5 });
	}

	/*
	 * Brute Force
	 * 
	 * 1. Iterate thorugh the array 
	 * 2. Verify if target matches the value within array 
	 * 		a) get the count of matches. 
	 * 		b) create a new array with target - count
	 * 3. If target matches the value, add remaining values to a new Array 
	 * 4. Return the new array
	 */
	
	// Two Pass --> O (2n)
	private int[] removeElement(int[] input, int target) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == target) {
				count++;
			}
		}
		if (count == 0)
			return input;
		int[] output = new int[input.length - count];
		count = 0;
		for (int i = 0; i < input.length; i++) {
			if (target != input[i])
				output[count++] = input[i];
		}
		return output;
	}

}
