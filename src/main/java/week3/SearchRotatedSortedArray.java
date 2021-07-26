package week3;

import org.junit.Test;

import junit.framework.Assert;

public class SearchRotatedSortedArray {
	
	/*
	 * There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
	 *
	 *Input = int[], int
	 *Output = int
	 */

	@Test
	public void test1() {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		Assert.assertEquals(4, searchRotatedSortedArray(nums, target));
	}

	@Test
	public void test2() {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;
		Assert.assertEquals(-1, searchRotatedSortedArray(nums, target));
	}

	@Test
	public void test3() {
		int[] nums = { 1 };
		int target = 0;
		Assert.assertEquals(-1, searchRotatedSortedArray(nums, target));
	}

	/*
	 * 1. Initialize low as 0, high as length of array -1
	 * 2. While low is less than high
	 * 3. Find mid
	 * 4. If the value in mid is equal to target, return mid
	 * 5. If value at low <= value at mid
	 * 		a) If target is not within that range, set low = mid+1
	 * 		b) else set high = mid-1
	 * 6. If value at low > value at mid
	 * 		a) If target is not within that range, set high = mid-1
	 * 		b) else set low = mid+1
	 */
	// O(logn)
	// O(1)
	private int searchRotatedSortedArray(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target < nums[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			}

		}

		return nums[low] == target ? low : -1;
	}

}
