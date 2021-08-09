package com.ds.week3;

import org.junit.Test;

import junit.framework.Assert;

public class FindTarget {

	/*
	 * Given a sorted array of distinct integers and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order. 
	 * You must write an algorithm with O(log n) runtime complexity. 
	 * Example 1: Input: nums = [1,3,5,6], target = 5 Output: 2 
	 * Example 2: Input: nums = [1,3,5,6], target = 2 Output: 1 
	 * Example 3: Input: nums = [1,3,5,6], target = 7 Output: 4 
	 * Example 4: Input: nums = [1,3,5,6], target = 0 Output: 0
	 *
	 */
	
	@Test
	public void test1() {
		int[] nums = {1,3,5,6};
		int target = 5;
		Assert.assertEquals(2, findTarget(nums, target));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,3,5,6};
		int target = 2;
		Assert.assertEquals(1, findTarget(nums, target));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,3,5,6};
		int target = 7;
		Assert.assertEquals(4, findTarget(nums, target));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,3,5,6};
		int target = 0;
		Assert.assertEquals(0, findTarget(nums, target));
	}

	/*
	 * 1. Initialize low as 0, high as length -1
	 * 2. Iterate until low crosses high
	 * 3. Calculate mid
	 * 4. If value of mid is equal to target, return mid
	 * 5. Else if value of mid >= target, high = mid-1
	 * 6. Else low = mid+1
	 * 7. Finally return low
	 */
	// O(logn)
	// O(1)
	private int findTarget(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
