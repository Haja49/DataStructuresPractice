package com.ds.week8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class KSubArrays2 {
	/*
	 * Question 3:
	Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise. An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
	 
	Example 1:
	Input: nums = [23,2,4,6,7], k = 6
	Output: true
	Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
	Example 2:
	Input: nums = [23,2,6,4,7], k = 6
	Output: true
	Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
	42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
	Example 3:
	Input: nums = [23,2,6,4,7], k = 13
	Output: false
	 */

	@Test
	public void test1() {
		int[] nums = {23, 2, 4, 6, 7};
		int k = 6;
		Assert.assertEquals(true, findCountOfSubArrays(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {23, 2, 6, 4, 7};
		int k = 8;
		Assert.assertEquals(true, findCountOfSubArrays(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {2, 23, 6, 4, 7};
		int k = 23;
		Assert.assertEquals(false, findCountOfSubArrays(nums, k));
	}

	private boolean findCountOfSubArrays(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			int left = i;
			while (left < nums.length - 1) {
				sum += nums[left] + nums[left + 1];
				if (sum % k == 0)
					return true;
				left++;
			}
		}
		return false;
	}

	public boolean kSub(int[] nums, int k) {

		// Cumulative Sum of each number in the list
		int sum = 0;

		// Find the frequency of remainder occurrence
		Map<Integer, Integer> freqMap = new HashMap<>();

		// Traverse
		for (int i = 1; i < nums.length; ++i) {

			// Calculate remainder and add K to it if it is negative
			int rem = sum % k < 0 ? sum % k + k : sum % k;

			// If the remainder exist, update else add
			freqMap.put(rem, freqMap.getOrDefault(rem, 0) + 1);

			// add the previous number to cumulative sum
			sum += nums[i - 1] + nums[i];

			// Calculate remainder and add K to it if it is negative
			rem = sum % k < 0 ? sum % k + k : sum % k;

			// If found, add to the output
			if (freqMap.containsKey(rem)) {
				return true;
			}
		}
		return false;

	}
	
}
