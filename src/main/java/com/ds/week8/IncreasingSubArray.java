package com.ds.week8;

import org.junit.Test;

import junit.framework.Assert;

public class IncreasingSubArray {

	/*
	 * Question 1: 
	Count the number of strictly increasing subarray of a specified size k in an array of size N .
	Example 1:
	int[] nums = [ 5,3,5,7,8] and k=3 , 
	The answer is 2 as [3,5,7] and [5,7,8] are the sub arrays.
	Example 2:
	int[] nums = [ 5,3,5,7,8] and k=2 , 
	The answer is 3 as [3,5] and [5,7] and [7,8] are the sub arrays.
	 */
	
	@Test
	public void test1() {
		int[] nums = { 5, 3, 5, 7, 8 };
		int k = 3;
		Assert.assertEquals(2, countSubArray(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = { 5, 5, 7, 8 };
		int k = 2;
		Assert.assertEquals(2, countSubArray(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = { 5, 6, 8, 9, 7, 9 };
		int k = 3;
		Assert.assertEquals(2, countSubArray(nums, k));
	}

	private int countSubArrayUsingMath(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				count++;
		}
		return count - k + 2;
	}
	
	private int countSubArray(int[] arr, int k) {
		int j = 1;
		int output = 0;
		int count = 0;
		while (j < arr.length) {
			if (arr[j] > arr[j - 1]) {
				count++;
			} else {
				if (count + 1 >= k) {
					output += count - k + 2;
					count = 0;
				}
			}
			j++;
		}
		if (count + 1 >= k)
			output += count - k + 2;
		return output;
	}

}
