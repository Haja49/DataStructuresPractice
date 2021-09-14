package com.group1.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MinimizeMaxPairSum {

	@Test
	public void test1() {
		int[] nums = { 3, 5, 2, 3 };
		Assert.assertEquals(7, findMax(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 3, 5, 4, 2, 4, 6 };
		Assert.assertEquals(8, findMax(nums));
	}

	private int findMax(int[] nums) {
		List<int[]> list = new ArrayList<int[]>();
		int left = 0, right = nums.length - 1;
		Arrays.sort(nums);
		while (left <= right) {
			list.add(new int[] { nums[left++], nums[right--] });
		}
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			max = Math.max(max, (list.get(i)[0] + list.get(i)[1]));
		}
		return max;
	}

	private int findMax1(int[] nums) {
		int left = 0, right = nums.length - 1;
		Arrays.sort(nums);
		int max = 0;
		while (left <= right) {
			max = Math.max(max, nums[left++] + nums[right--]);
		}
		return max;
	}
}
