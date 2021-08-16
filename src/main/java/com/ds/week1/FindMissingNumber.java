package com.ds.week1;

import org.junit.Test;

import junit.framework.Assert;

public class FindMissingNumber {
	
	/*
	 * 4) Given an array nums containing n distinct numbers in the range [0, n], 
	 * return the only number in the range that is missing from the array.
	 * 		Input: nums = [3,0,1]
	 * 		Output: 2
	 */
	
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
		int[] input = { 0, 1, 2, 3, 5 };
		Assert.assertEquals(findMissingNumber(input), 4);
	}

	@Test
	public void test2() {
		int[] input = { 1, 2, 3, 4, 5 };
		Assert.assertEquals(findMissingNumber(input), 0);
	}

	@Test
	public void test3() {
		int[] input = { 2147483647, 2147483645, 2147483644 };
		Assert.assertEquals(findMissingNumber(input), 2147483646);
	}
	
	@Test
	public void test4() {
		int[] input = { 0 };
		Assert.assertEquals(findMissingNumber(input), -1);
	}

	/*
	 * 1. Iterate over the elements of the array.
	 * 2. Sort the Array.
	 * 3. If the iterator value is not equal to the value in the specific index
	 * 		a) return the index
	 * 4. Return -1 at the end
	 */

	// O(n^2)
	private int findMissingNumber(int[] input) {
		int length = input.length;
		int temp = 0;
		// Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (input[i] != i)
				return i;
		}
		return -1;
	}

	/*
	 * 1. Get the sum of n elements using Math (n * (n+1)/2).
	 * 2. Iterate over the elements of the array and add sum all the values.
	 * 3. If the difference of sum is not equal to the length of array:
	 * 		a) return the difference.
	 *		b) Return -1 at the end.
	 */

	// O(n)
	private int findMissingNumberUsingMath(int[] input) {
		int length = input.length;
		int totalSum = length * (length + 1) / 2;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		return totalSum - sum;
	}
	
	/*
	 * 1. Find the minimum and maximum number in the array
	 * 2. From the minimum and maximum number, iterate through the array elements
	 * 3. Check all the values within min and max are present
	 * 		a) Return the missing value
	 * 		b) If no value is missing, return -1
	 */
	
	// O(n^2)
	private int findMissingNumberInArray(int[] input) {
		int min = input[0];
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] < min)
				min = input[i];
			else
				max = input[i];
		}
		for (int i = min; i < max; i++) {
			boolean exist = false;
			for (int j = 0; j < input.length; j++) {
				if (input[j] == i)
					exist = true;
			}
			if (!exist)
				return i;
		}

		return -1;
	}
	
	//Bitwise
	//Adding 1
	// Hashset and add 1
	// Add all nos and find diff
}
