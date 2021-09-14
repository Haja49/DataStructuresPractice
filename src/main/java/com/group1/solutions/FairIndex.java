package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class FairIndex {

	@Test
	public void test1() {
		int[] nums1 = { 4, -1, 0, 3 };
		int[] nums2 = { -2, 5, 0, 3 };
		Assert.assertEquals(2, fairIndex(nums1, nums2));
	}

	@Test
	public void test2() {
		int[] nums1 = { 2, -2, -3, 3 };
		int[] nums2 = { 0, 0, 4, -4 };
		Assert.assertEquals(1, fairIndex(nums1, nums2));
	}

	@Test
	public void test3() {
		int[] nums1 = { 4, -1, 0, 3 };
		int[] nums2 = { -2, 6, 0, 4 };
		Assert.assertEquals(0, fairIndex(nums1, nums2));
	}

	@Test
	public void test4() {
		int[] nums1 = { 1, 4, 2, -2, 5 };
		int[] nums2 = { 7, -2, -2, 2, 5 };
		Assert.assertEquals(2, fairIndex(nums1, nums2));
	}

	private int findIndexCount(int[] nums1, int[] nums2) {
		int count = 0;
		for (int i = 1; i < nums1.length; i++) {
			int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
			for (int j = 0; j < i; j++) {
				sum1 += nums1[j];
			}
			for (int j = i; j < nums2.length; j++) {
				sum2 += nums1[j];
			}
			for (int j = 0; j < i; j++) {
				sum3 += nums2[j];
			}
			for (int j = i; j < nums2.length; j++) {
				sum4 += nums2[j];
			}
			if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4)
				count++;
		}
		return count;
	}

	public int fairIndex(int[] a, int[] b) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < a.length; i++) {
			sumA += a[i];
			sumB += b[i];
		}
		int count = 0;
		int tempA = a[0];
		int tempB = b[0];
		for (int i = 1; i < a.length; i++) {
			if (i != 1 && tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
				count++;
			}
			tempA += a[i];
			tempB += b[i];
		}
		return count;
	}
}
