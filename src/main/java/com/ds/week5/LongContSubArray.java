package com.ds.week5;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class LongContSubArray {

	@Test
	public void test1() {
		int[] input = { 2, 5, 2 };
		int k = 9;
		Assert.assertEquals(3, longestSubArrayUsingDeQ(input, k));

	}

	@Test
	public void test2() {
		int[] input = { 10, 1, 2, 4, 7, 2 };
		int k = 5;
		Assert.assertEquals(4, longestSubArrayUsingDeQ(input, k));

	}

	@Test
	public void test3() {
		int[] input = { 4, 2, 2, 2, 4, 4, 2, 2 };
		int k = 0;
		Assert.assertEquals(3, longestSubArrayUsingDeQ(input, k));

	}

	/*
	 * Two Pointer Algorithm - Equi Directional Find the min and max for slow and
	 * fast pointer values if the abs difference is the less than or equal to limit
	 * -> find the longest and move right else reset the min and max with the right
	 * value -> left
	 * 
	 */

	private int longestSubArray(int[] nums, int limit) {

		int left = 0, right = 0;
		int longest = Integer.MIN_VALUE, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		while (left < nums.length && right < nums.length) {

			// find the min and max for the absolute difference
			min = Math.min(min, Math.min(nums[left], nums[right]));
			max = Math.max(max, Math.max(nums[left], nums[right]));

			// Check with the limit
			if (Math.abs(max - min) <= limit) {
				longest = Math.max(longest, right - left + 1);
				right++;
			} else {
				right = ++left;
				min = nums[left];
				max = nums[left];
			}

		}
		return longest;

	}

	private int longestSubArrayUsingDeQ(int[] nums, int limit) {
		int longest = Integer.MIN_VALUE, left = 0, right = 0;
		ArrayDeque<Integer> minQue = new ArrayDeque<Integer>();
		ArrayDeque<Integer> maxQue = new ArrayDeque<Integer>();
		for (left = 0; left < nums.length; left++) {
			while (!maxQue.isEmpty() && nums[maxQue.peekLast()] <= nums[left]) {
				maxQue.pollLast();
			}
			maxQue.offer(left);
			while (!minQue.isEmpty() && nums[minQue.peekLast()] >= nums[left]) {
				minQue.pollLast();
			}
			minQue.offer(left);

			while (nums[maxQue.peek()] - nums[minQue.peek()] > limit) {

				if (maxQue.peekFirst() < minQue.peekFirst())
					right = maxQue.removeFirst();
				else
					right = minQue.removeFirst();
			}
			longest = Math.max(longest, left - right);
		}
		return longest;

	}

}
