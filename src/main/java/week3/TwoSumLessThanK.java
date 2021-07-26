package week3;

import org.junit.Test;

import junit.framework.Assert;

public class TwoSumLessThanK {

	@Test
	public void test1() {
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		Assert.assertEquals(58, twoSumLessThanK(nums, k));
	}

	private int twoSumLessThanK(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			int low = 0, high = nums.length - 1;
			while (low < high) {
				int mid = (low + high) / 2;
				if(nums[i]+nums[mid]<k)
					return nums[i]+nums[mid];
				else {
					
				}
			}
		}
		return 0;
	}
}
