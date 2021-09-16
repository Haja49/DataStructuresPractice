package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class MaxSumCircularSubArray {

	@Test
	public void test1() {
		int[] nums = { 1, -2, 3, -2 };
		Assert.assertEquals(3, maxSubarraySumCircular(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 5, -3, 5 };
		Assert.assertEquals(10, maxSubarraySumCircular(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 3, -1, 2, -1 };
		Assert.assertEquals(4, maxSubarraySumCircular(nums));
	}

	@Test
	public void test4() {
		int[] nums = { -2, -3, -1 };
		Assert.assertEquals(-1, maxSubarraySumCircular(nums));
	}

	@Test
	public void test5() {
		int[] nums = { 3, -2, 2, -3 };
		Assert.assertEquals(3, maxSubarraySumCircular(nums));
	}

	public int maxSubarraySumCircular(int[] nums) {
		int totalSum = 0, curMax = 0, maxSum = nums[0], curMin = 0, minSum = nums[0];
		for (int num : nums) {
			curMax = Math.max(curMax + num, num);
			maxSum = Math.max(maxSum, curMax);
			curMin = Math.min(curMin + num, num);
			minSum = Math.min(minSum, curMin);
			totalSum += num;
		}
		return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
	}
}
