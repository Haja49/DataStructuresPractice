package com.group1.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class KDifferentPairs {

	@Test
	public void test1() {
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 2;
		Assert.assertEquals(2, findPairs(nums, k));
	}

	@Test
	public void test2() {
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 1;
		Assert.assertEquals(2, findPairs(nums, k));
	}

	@Test
	public void test3() {
		int[] nums = { 1, 1, 1, 2, 2 };
		int k = 0;
		Assert.assertEquals(2, findPairs(nums, k));
	}

	@Test
	public void test4() {
		int[] nums = { 1, 3, 1, 5, 4 };
		int k = 0;
		Assert.assertEquals(1, findPairs(nums, k));
	}

	private int findPairs1(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Entry<Integer, Integer> eachEntry : map.entrySet()) {
			if (k == 0) {
				if (eachEntry.getValue() > 1) {
					count++;
				}
			} else if (map.containsKey(eachEntry.getKey() + k))
				count++;
		}

		return count;
	}

	private int findPairs(int[] nums, int k) {
		int count = 0;
		int left = 0, right = 1;
		Arrays.sort(nums);
		while (right < nums.length) {
			if (nums[right] - nums[left] == k) {
				count++;
				left++;
				while (left < nums.length && nums[left] == nums[left - 1])
					left++;
				right = Math.max(right + 1, left + 1);
			} else if (nums[right] - nums[left] < k) {
				right++;
			} else {
				left++;
				right = left == right ? left + 1 : right;
			}
		}
		return count;
	}

}
