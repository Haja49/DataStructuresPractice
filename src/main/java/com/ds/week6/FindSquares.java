package com.ds.week6;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSquares {

	@Test
	public void test1() {
		int[] nums = { 4, 6, 8 };
		Assert.assertArrayEquals(new int[] { 16, 36, 64 }, findSquaresWithConstantSpace(nums));
	}

	@Test
	public void test2() {
		int[] nums = { -2, 0, 4 };
		Assert.assertArrayEquals(new int[] { 0, 4, 16 }, findSquaresWithConstantSpace(nums));
	}

	@Test
	public void test3() {
		int[] nums = {};
		Assert.assertArrayEquals(new int[] {}, findSquaresWithConstantSpace(nums));
	}

	private int[] findSquares(int[] nums) {
		int left = 0, right = nums.length - 1;
		int[] output = new int[nums.length];
		for (int i = output.length - 1; i >= 0; i--) {
			if (Math.abs(nums[left]) > Math.abs(nums[right]))
				output[i] = nums[left] * nums[left++];
			else
				output[i] = nums[right] * nums[right--];
		}
		return output;
	}

	private int[] findSquaresWithConstantSpace(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (Math.abs(nums[i]) > Math.abs(nums[i + 1])) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		return nums;
	}

	private int[] findSquaresWithConstantSpaceOptimized(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				int temp = nums[left];
				nums[left++] = nums[right];
				nums[right] = temp;
			} else
				right--;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		return nums;
	}
}
