package com.ds.week3;

import org.junit.Test;

import junit.framework.Assert;

public class PresenceOfNumber {

	@Test
	public void test1() {
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;
		Assert.assertEquals(true, isNumberPresent(nums, target));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 3, 5, 6 };
		int target = 4;
		Assert.assertEquals(false, isNumberPresent(nums, target));
	}

	private boolean isNumberPresent(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return true;
		}
		return false;
	}

	private boolean isNumberPresentUsing2Pointer(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (nums[low++] == target)
				return true;
			if (nums[high--] == target)
				return true;
		}
		return false;
	}

	private boolean isNumberPresentUSingBS(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
}
