package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class ShortestUnsortedContinuousArray {

	@Test
	public void test1() {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		Assert.assertEquals(5, findSubArray(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 2, 6, 4, 3, 10, 9, 15 };
		Assert.assertEquals(5, findSubArray(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 1, 2, 3, 4 };
		Assert.assertEquals(0, findSubArray(nums));
	}

	@Test
	public void test4() {
		int[] nums = { 2, 1 };
		Assert.assertEquals(2, findSubArray(nums));
	}

	@Test
	public void test5() {
		int[] nums = { 1, 3, 2, 2, 2 };
		Assert.assertEquals(4, findSubArray(nums));
	}

	private int findSubArray2(int[] nums) {
		int firstIndex = 0, lastIndex = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					firstIndex = Math.max(firstIndex, j);
					lastIndex = Math.min(lastIndex, i);
				}
			}
		}
		return (firstIndex - lastIndex) < 0 ? 0 : (firstIndex - lastIndex + 1);
	}

	private int findSubArray(int[] nums) {
		int firstIndex = 0, lastIndex = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] > nums[left + 1]) {
				min = Math.min(min, nums[left + 1]);
			}
			left++;
		}
		left = 0;
		while (left < right) {
			if (nums[right] < nums[right - 1]) {
				max = Math.max(max, nums[right - 1]);
			}
			right--;
		}
		for (firstIndex = 0; firstIndex < nums.length; firstIndex++) {
			if (min < nums[firstIndex])
				break;
		}
		for (lastIndex = nums.length - 1; lastIndex >= 0; lastIndex--) {
			if (max > nums[lastIndex])
				break;
		}
		return (lastIndex - firstIndex) < 0 ? 0 : (lastIndex - firstIndex + 1);
	}
}
