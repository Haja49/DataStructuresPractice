package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class DuplicateNumber {

	@Test
	public void test1() {
		int[] nums = { 1, 3, 4, 2, 2 };
		Assert.assertEquals(2, findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int curr = Math.abs(nums[i]);
			if (nums[curr] < 0) {
				return curr;
			}
			nums[curr] *= -1;
		}
		return -1;
	}

	public int findDuplicate1(int[] nums) {
		while (nums[0] != nums[nums[0]]) {
			int temp = nums[nums[0]];
			nums[nums[0]] = nums[0];
			nums[0] = temp;
		}
		return nums[0];
	}
}
