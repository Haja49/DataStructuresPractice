package com.ds.week8;

import org.junit.Test;

import junit.framework.Assert;

public class FrogLeap {

	@Test
	public void test1() {
		int[] nums = { 6, 13, 10, 8, 11, 7, 3, 5, 4, 2 };
		Assert.assertEquals(6, findLeaps(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 6, 10, 15, 18 };
		Assert.assertEquals(0, findLeaps(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 6, 13, 10, 6 };
		Assert.assertEquals(2, findLeaps(nums));
	}

	@Test
	public void test4() {
		int[] nums = { 6, 13, 10, 6, 15, 13, 12, 11 };
		Assert.assertEquals(3, findLeaps(nums));
	}

	@Test
	public void test5() {
		int[] nums = { 6, 4, 5, 4, 3, 2, 1 };
		Assert.assertEquals(5, findLeaps(nums));
	}
	
	@Test
	public void test6() {
		int[] nums = { 7, 6, 4, 5, 4, 3, 2, 1 };
		Assert.assertEquals(6, findLeaps(nums));
	}

	/*
	 * 1.
	 */
	private int findLeaps(int[] nums) {
		int max = Integer.MIN_VALUE;
		int tempCount = 0;
		for (int i = 0; i < nums.length-1; i++) {
			int count = 0;
			if (nums[i] < nums[i + 1])
				count = 0;
			else
				count = tempCount;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[j - 1])
					count = 0;
				else
					count = tempCount;
				tempCount = 0;
				int temp = nums[j];
				if (nums[j] < nums[i]) {
					count++;
					tempCount++;
					for (int k = j + 1; k < nums.length; k++) {
						if (nums[k] < temp) {
							count++;
							temp = nums[k];
						}
					}
				}
				max = Math.max(count, max);
			}
		}
		return max;
	}
}
