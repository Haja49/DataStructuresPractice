package binarysearch;

import org.junit.Test;

import junit.framework.Assert;

public class SingleElementInSortedArray {

	@Test
	public void test1() {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		Assert.assertEquals(2, singleNonDuplicate(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
		Assert.assertEquals(10, singleNonDuplicate(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 3 };
		Assert.assertEquals(3, singleNonDuplicate(nums));
	}

	
	private int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1])
				low = mid + 2;
			else
				high = mid;
		}
		return nums[low];
	}
}
