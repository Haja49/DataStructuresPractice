package binarysearch;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class LongestIncreasingSubsequence {
	
	@Test
	public void test1() {
		int[] nums = {10,9,2,5,3,7,101,18};
		Assert.assertEquals(4, lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		for (int num : nums) {
			int j = binarySearch(sub, num);
			if (j >= sub.size()) {
				sub.add(num);
			} else {
				sub.set(j, num);
			}
		}
		return sub.size();
	}

	private int binarySearch(ArrayList<Integer> sub, int num) {
		int left = 0;
		int right = sub.size() - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			mid = (left + right) / 2;
			if (sub.get(mid) == num) {
				return mid;
			} else if (sub.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
