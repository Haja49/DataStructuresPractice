package week3;

import org.junit.Test;

import junit.framework.Assert;

public class FindCountOfOne {

	@Test
	public void test1() {
		int[] nums = { 0, 0, 0, 1, 1, 1 };
		Assert.assertEquals(3, findCountUsingBS(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 0, 0, 0, 0 };
		Assert.assertEquals(0, findCountUsingBS(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 1, 1, 1, 1 };
		Assert.assertEquals(4, findCountUsingBS(nums));
	}

	@Test
	public void test4() {
		int[] nums = { 0, 0, 0, 1, 1 };
		Assert.assertEquals(2, findCountUsingBS(nums));
	}

	@Test
	public void test5() {
		int[] nums = { 0, 1, 1, 1 };
		Assert.assertEquals(3, findCountUsingBS(nums));
	}

	private int findCount(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				return nums.length - i;
		}
		return 0;
	}

	private int findCountUsingTwoPointer(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (high < nums.length) {
			if (nums[low] == 1)
				return nums.length - low;
			if (nums[high] == 0)
				return nums.length - high - 1;
			low++;
			high--;
		}
		return 0;
	}

	private int findCountUsingBS(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] < 1)
				high = mid - 1;
			else if (nums[mid] > 1)
				low = mid + 1;
			else {
				if (mid == nums.length - 1 || nums[mid + 1] != 1)
					return mid + 1;
				else
					low = mid + 1;
			}
		}
		return 0;
	}
}
