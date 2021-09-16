package slidingwindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class BinarySubArrayWithSum {

	@Test
	public void test1() {
		int[] nums = { 1, 0, 1, 0, 1 };
		int goal = 2;
		Assert.assertEquals(4, numSubarraysWithSum(nums, goal));
	}

	@Test
	public void test2() {
		int[] nums = { 0, 0, 0, 0, 1 };
		int goal = 1;
		Assert.assertEquals(5, numSubarraysWithSum(nums, goal));
	}

	@Test
	public void test3() {
		int[] nums = { 0, 0, 0, 0, 0 };
		int goal = 0;
		Assert.assertEquals(15, numSubarraysWithSum(nums, goal));
	}

	@Test
	public void test4() {
		int[] nums = { 1, 1, 0, 0, 1 };
		int goal = 1;
		Assert.assertEquals(7, numSubarraysWithSum(nums, goal));
	}

	public int numSubarraysWithSum(int[] nums, int goal) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			int j = i;
			while (sum <= goal && j < nums.length) {
				sum += nums[j];
				if (sum == goal) {
					count++;
				}
				j++;
			}
		}
		return count;
	}

	public int numSubarraysWithSum1(int[] nums, int goal) {
		if (nums.length == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			count += map.getOrDefault(sum - goal, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
