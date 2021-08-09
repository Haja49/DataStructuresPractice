package week4;

import org.junit.Test;

import junit.framework.Assert;

public class MaximumSumOfPartitionArray {

	@Test
	public void test1() {
		int[] nums = {1,15,7,9,2,5,10};
		int k = 3;
		Assert.assertEquals(84, maximumSum(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,4,1,5,7,3,6,1,9,9,3};
		int k = 4;
		Assert.assertEquals(83, maximumSum(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {1};
		int k = 1;
		Assert.assertEquals(1, maximumSum(nums, k));
	}
	
	private int maximumSum(int[] nums, int k) {
		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			int maxval = nums[i - 1];
			int maxsum = 0;			
			for (int j = 1; j <= k; j++) {
				if (i < j)
					continue;
				maxval = Math.max(maxval, nums[i - j]);
				maxsum = Math.max(maxsum, maxval * j + dp[i - j]);
			}
			dp[i] = maxsum;
		}
		// System.out.println(Arrays.toString(dp));
		return dp[nums.length];
	}
}
