package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class SmallestSubArraySum {

	/*
	 * 	Given an integer array nums of length n and an integer k, return the kth smallest subarray sum.

	A subarray is defined as a non-empty contiguous sequence of elements in an array.
 	A subarray sum is the sum of all elements in the subarray.
	 */

	@Test
	public void test1() {
		int[] input = { 2, 1, 3 };
		int k = 4;
		Assert.assertEquals(3, smallestSubArraySum(input, k));
	}

	@Test
	public void test2() {
		int[] input = { 3, 3, 5, 5 };
		int k = 7;
		Assert.assertEquals(10, smallestSubArraySum(input, k));
	}

	/*
	 * 1. Initialize min with max int value, left, right and sum
	 * 2. Iterate through the array and get the sum
	 * 3. Add all sum values to a list
	 * 4. Sort the list and return the value based on target
	 */
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 */
	private int smallestSubArraySum(int[] input, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				list.add(sum);
			}
		}
		Collections.sort(list);
		return list.get(k - 1);
	}
}
