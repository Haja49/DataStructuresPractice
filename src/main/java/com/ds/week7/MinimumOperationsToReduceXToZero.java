package com.ds.week7;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumOperationsToReduceXToZero {

	@Test
	public void test1() {
		int[] nums = { 1, 1, 4, 2, 3 };
		int k = 5;
		Assert.assertEquals(2, minOperations(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = { 3, 2, 20, 1, 1, 3 };
		int k = 10;
		Assert.assertEquals(5, minOperations(nums, k));
	}

	public int minOperations(int[] nums, int x) {
		int count = 0;
		int right = nums.length - 1;
		for (int i = 0; i < nums.length;) {
			int max = 0, min = 0;
			if (nums[i] < nums[right]) {
				max = nums[right--];
				min = nums[i];
			} else {
				max = nums[i++];
				min = nums[right];
			}
			if (x >= max) {
				x -= max;
				count++;
			} else if (x >= min) {
				x -= min;
				count++;
			} else
				break;
			if (x == 0)
				return count;
		}
		return -1;
	}

	public int minOperations1(int[] nums, int x) {
		int length = 0, left = 0, target = -x;
		for (int i = 0; i < nums.length; i++) {
			target += nums[i];
		}
		if (target == 0)
			return nums.length;
		if (target < 0)
			return -1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum > target) {
				sum -= nums[left++];
			}
			if (sum == target) {
				length = Math.max(length, i - left + 1);
			}
		}
		return length > 0 ? nums.length - length : -1;
	}
}
