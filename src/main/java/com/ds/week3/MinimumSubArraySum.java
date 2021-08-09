package com.ds.week3;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumSubArraySum {
	
	/*
	 * Given an array of positive integers nums and a positive integer target, 
	 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
	 * of which the sum is greater than or equal to target. 
	 * If there is no such subarray, return 0 instead
	 * 
	 * input = int[], int
	 * Output = int
	 */

	@Test
	public void test1() {
		int[] input = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		Assert.assertEquals(minimumSubArrayLengthUsingSW(input, target), 2);
	}

	@Test
	public void test2() {
		int[] input = { 1, 4, 4 };
		int target = 4;
		Assert.assertEquals(minimumSubArrayLengthUsingSW(input, target), 1);
	}

	@Test
	public void test3() {
		int[] input = { 1, 1, 1, 1, 1, 1, 1, 1 };
		int target = 11;
		Assert.assertEquals(minimumSubArrayLengthUsingSW(input, target), 0);
	}

	@Test
	public void test4() {
		int[] input = { 1, 2, 3, 4, 5 };
		int target = 11;
		Assert.assertEquals(minimumSubArrayLengthUsingSW(input, target), 3);
	}

	/*
	 * 1. Iterate through the array
	 * 2. Initialize a variable sum
	 * 3. Add the elements of the array through another iteration
	 * 4. If the sum is greater or equal to target, find the min and store it in a variable and break iteration
	 * 5. Finally return min. If min is less than the target, return 0
	 */
	/*
	 * Time Complexity - O(n^2)
	 * Space Complexity - O(1)
	 */
	private int minimumSubArrayLength(int[] input, int target) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				if (sum >= target) {
					min = Math.min(min, j - i + 1);
					break;
				}
			}
		}
		return min != Integer.MAX_VALUE ? min : 0;
	}

	/*
	 * 1. Initialize min with max int value, left, right and sum
	 * 2. Iterate through the array and get the sum
	 * 3. While sum is greater or equal to target,
	 * 		a) Find min
	 * 		b) Remove the first input and increment left
	 * 4. Also increment right
	 * 5. Finally return min. If min is less than the target, return 0
	 */
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private int minimumSubArrayLengthUsingSW(int[] input, int target) {
		int min = Integer.MAX_VALUE, left = 0, sum = 0;
		for (int right = 0; right < input.length; right++) {
			sum += input[right];
			while (sum >= target) {
				min = Math.min(min, right - left + 1);
				sum -= input[left++];
			}
		}

		return min != Integer.MAX_VALUE ? min : 0;
	}

}
