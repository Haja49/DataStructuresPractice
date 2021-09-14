package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class ProductSign {

	@Test
	public void test1() {
		int[] nums = { -1, -2, -3, -4, 3, 2, 1 };
		Assert.assertEquals(1, findSign(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 5, 0, 2, -3 };
		Assert.assertEquals(0, findSign(nums));
	}

	@Test
	public void test3() {
		int[] nums = { -1, 1, -1, 1, -1 };
		Assert.assertEquals(-1, findSign(nums));
	}

	private int findSign(int[] nums) {
		int output = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				return 0;
			else if (nums[i] < 0)
				output = -output;
		}
		return output;
	}
}
