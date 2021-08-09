package com.ds.week3;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSum {

	@Test
	public void test1() {
		int[] nums = { 34,23,1,24,75,33,54,8 };
		int k = 60;
		Assert.assertEquals(58, twoSumLessThanK(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = { 10,20,30 };
		int k = 15;
		Assert.assertEquals(-1, twoSumLessThanK(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = { 34,23,1,24,75,33,54,8 };
		int k = 60;
		Assert.assertEquals(58, twoSumLessThanK(nums, k));
	}

	private int maximumSum(int[] nums, int k) {
		Arrays.sort(nums);
		int left =0, right = nums.length-1, min =0;
		while (left < right) {
			int mid = (left+right)/2;
			if(nums[mid] + nums[mid+1] < k) {
				min = Math.max(min, nums[mid] + nums[mid+1]);
			}
			if(nums[left] + nums[right] < k)
				min = Math.max(min, nums[mid] + nums[mid+1]);
		}
		return 0;
	}
	
	public int twoSumLessThanK(int[] A, int K) {
		Arrays.sort(A);
		int sum = 0, mindiff = Integer.MAX_VALUE, l, r, mid, t;
		for (int i = 0; i < A.length; ++i) {
			l = 0;
			r = A.length - 1;
			t = K - A[i];
			while (l <= r) {
				mid = (l + r) / 2;
				if (A[mid] >= t)
					r = mid - 1;
				else {
					if (mid == A.length - 1 || A[mid + 1] >= t) {
						if (mid != i && K - A[mid] - A[i] < mindiff) {
							mindiff = K - A[mid] - A[i];
							sum = A[mid] + A[i];
						}
						break;
					} else
						l = mid + 1;
				}
			}
		}
		return mindiff == Integer.MAX_VALUE ? -1 : sum;
	}
}
