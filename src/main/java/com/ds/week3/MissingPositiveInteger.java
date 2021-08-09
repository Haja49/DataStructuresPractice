package com.ds.week3;

import org.junit.Assert;
import org.junit.Test;

public class MissingPositiveInteger {

	@Test
	public void test1() {
		int[] nums = { 2, 3, 4, 7, 11 };
		int k = 5;
		Assert.assertEquals(9, findKthPositive(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 2, 3, 4 };
		int k = 2;
		Assert.assertEquals(6, findKthPositive(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = { 2, 3, 4, 7, 11 };
		int k = 1;
		Assert.assertEquals(1, findKthPositive(nums, k));
	}

	public int findKthPositive(int[] nums, int k) {
		int low = 0, high = nums.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] - (mid + 1) >= k)
				high = mid;
			else
				low = mid + 1;
		}
		return low + k;
	}
}
