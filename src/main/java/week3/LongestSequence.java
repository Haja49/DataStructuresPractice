package week3;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class LongestSequence {
	
	/*
	 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
		You must write an algorithm that runs in O(n) time.
	 *
	 * Input : int[]
	 * Output: int
	 */

	@Test
	public void test1() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		Assert.assertEquals(4, longestSequence(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		Assert.assertEquals(9, longestSequence(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 0, 1, 2, 4, 6, 5 };
		Assert.assertEquals(3, longestSequence(nums));
	}

	@Test
	public void test4() {
		int[] nums = {4, 5, 5, 6, 7, 5 };
		Assert.assertEquals(4, longestSequence(nums));
	}

	/*
	 * 1. Add the array elements to set to make it unique
	 * 2. Iterate through the set
	 * 3. While set contains num+1, increment the number and counter
	 * 4. Find the max of every iteration and return it
	 */
	private int longestSequence(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int max = 0;
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int counter = 1;
				while (set.contains(num + 1)) {
					num += 1;
					counter += 1;
				}
				max = Math.max(max, counter);
			}
		}
		return max;
	}
}
