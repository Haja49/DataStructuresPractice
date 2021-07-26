package week3;

import org.junit.Assert;
import org.junit.Test;

public class FindStartAndEnd {

	/* 
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position
	 * of a given target value. If target is not found in the array, return [-1, -1]. 
	 * You must write an algorithm with O(log n) runtime complexity. 
	 * Example 1: Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] 
	 * Example 2: Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] 
	 * Example 3: Input: nums = [], target = 0 Output: [-1,-1]
	 */
	
	@Test
	public void test1() {
		int[] nums = { 5,7,7,8,8,10 };
		int target = 8;
		Assert.assertArrayEquals(new int[] {3,4}, findStartAndEnd(nums, target));
	}
	
	@Test
	public void test2() {
		int[] nums = { 5,7,7,8,8,10 };
		int target = 6;
		Assert.assertArrayEquals(new int[] {-1,-1}, findStartAndEnd(nums, target));
	}
	
	@Test
	public void test3() {
		int[] nums = { };
		int target = 0;
		Assert.assertArrayEquals(new int[] {-1, -1}, findStartAndEnd(nums, target));
	}
	
	@Test
	public void test4() {
		int[] nums = { 5,7,7,8,10 };
		int target = 8;
		Assert.assertArrayEquals(new int[] {3,3}, findStartAndEnd(nums, target));
	}

	/*
	 * 1. Initialize low as 0, high as length -1
	 * 2. To find first index, Iterate until low crosses high
	 * 3. Calculate mid
	 * 4. If value of mid >= target, high = mid-1
	 * 5. Else low = mid+1
	 * 6. If value of mid is equal to target, return mid
	 * 7. Reset values of low and high, and find the last index in a similar approach
	 * 8. Add the index to output array and return the output
	 */
	// O(logn)
	// O(1)
	private int[] findStartAndEnd(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int index = -1;
		int[] output = new int[2];
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] >= target)
				high = mid - 1;
			else
				low = mid + 1;
			if (nums[mid] == target) index = mid;
		}
		output[0] = index;
		index = -1;
		low = 0;
		high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] <= target)
				low = mid + 1;
			else
				high = mid - 1;
			if (nums[mid] == target) index = mid;
		}
		output[1] = index;
		return output;
	}
	

}
