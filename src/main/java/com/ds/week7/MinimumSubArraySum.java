package com.ds.week7;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumSubArraySum {

	/*
	 * Problem 1) Given an int array [1,4,20,3,10,5] and target sum 33. If target
	 * subarray sum is found, return true else false 
	 * Time : 20 Minutes - 
	 * Write another 2 test data (edge and neg) 
	 * - Pseudo Code for Optimised Solution -
	 * Code, Debug 
	 * - Time everything 
	 * - Do it yourself !!
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,4,20,3,10,5};
		int sum = 33;
		Assert.assertEquals(true, findMinSubArray(nums, sum));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,4,20,3,10,5};
		int sum = 2;
		Assert.assertEquals(false, findMinSubArray(nums, sum));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,4,3,10,5};
		int sum = 1;
		Assert.assertEquals(true, findMinSubArray(nums, sum));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,4,3,10,5};
		int sum = 0;
		Assert.assertEquals(false, findMinSubArray(nums, sum));
	}

	/*
	 * Pseudocode:
	 * 1. Initialize left, right, sum
	 * 2. Iterate through the array and get the sum
	 * 3. while sum is not equal to target, inc left
	 * 		if sum is equal to target, return true
	 * 4. Also increment right
	 * 5. Finally return false
	 */
	// Time - O(n^2)
	// Space - O(1)
	private boolean findMinSubArray(int[] nums, int sum) {
		if(sum==0) return false;
		if(nums.length<=0) return false;
		int subArraySum, left = 0;
		for (int right = 0; right < nums.length; right++) {
			subArraySum = 0;
			left = right;
			while (subArraySum != sum && left < nums.length) {
				subArraySum += nums[left++];
			}
			if (subArraySum == sum)
				return true;
		}
		return false;
	}
	
}
