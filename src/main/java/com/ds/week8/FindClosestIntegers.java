package com.ds.week8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindClosestIntegers {

	/*
	 * Question 2:
	Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. 
	The result should also be sorted in ascending order.
	An integer a is closer to x than an integer b if:
	|a - x| < |b - x|, or
	|a - x| == |b - x| and a < b
	 
	Example 1:
	Input: arr = [1,2,3,4,5], k = 4, x = 3
	Output: [1,2,3,4]
	Example 2:
	Input: arr = [1,2,3,4,5], k = 4, x = -1
	Output: [1,2,3,4]
	 Example 3:
	Input: arr = [8,17,24,25,28], k = 3, x = 23
	Output: [24,25,28]
	2 
	Output -> List<Integer>
	 */
	
	@Test
	public void test1() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 4, x = 3;
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, findClosest(nums, k, x));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 4, x = -1;
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, findClosest(nums, k, x));
	}

	@Test
	public void test3() {
		int[] nums = { 8, 17, 24, 25, 28 };
		int k = 3, x = 23;
		Assert.assertArrayEquals(new int[] { 24, 25, 28 }, findClosest(nums, k, x));
	}
	
	@Test
	public void test4() {
		int[] nums = { 1, 2, 3, 3, 4, 5 };
		int k = 2, x = 3;
		Assert.assertArrayEquals(new int[] { 3, 3 }, findClosest(nums, k, x));
	}

	private int[] findClosest(int[] nums, int k, int x) {
		int left = 0;
		int right = nums.length - k;
		while (left < right) {
			int mid = (left + right) / 2;
			if (x - nums[mid] > nums[mid + k] - x)
				left = mid + 1;
			else
				right = mid;
		}
		int[] output = new int[k];
		int j = 0;
		for (int i = left; i < left + k; i++) {
			output[j++] = nums[i];
		}
		return output;
	}
}
