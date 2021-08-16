package com.ds.week7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class KSubArrays {

	@Test
	public void test1() {
		int[] nums = { 5, 10, 11, 9, 5 };
		int k = 5;
		Assert.assertEquals(10, kSub(nums, k));
	}

	private int findCountOfSubArrays(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			int left = i;
			while (left < nums.length) {
				sum += nums[left];
				if (sum % k == 0)
					count++;
				left++;
			}

		}
		return count;
	}

	public int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0, sum = 0;
		for (int a : nums) {
			sum = (sum + a) % k;
			if (sum < 0)
				sum += k;
			count += map.getOrDefault(sum, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public long kSub(int[] nums, int k) {

		// Cumulative Sum of each number in the list
		int sum = 0;

		// Return output
		long output = 0;

		// Find the frequency of remainder occurrence
		Map<Integer, Integer> freqMap = new HashMap<>();

		// Traverse
		for (int i = 1; i <= nums.length; ++i) {

			// Calculate remainder and add K to it if it is negative
			int rem = sum % k < 0 ? sum % k + k : sum % k;

			// If the remainder exist, update else add
			freqMap.put(rem, freqMap.getOrDefault(rem, 0) + 1);

			// add the previous number to cumulative sum
			sum += nums[i - 1];

			// Calculate remainder and add K to it if it is negative
			rem = sum % k < 0 ? sum % k + k : sum % k;

			// If found, add to the output
			if (freqMap.containsKey(rem)) {
				output += freqMap.get(rem);
			}
		}
		return output;

	}

}
