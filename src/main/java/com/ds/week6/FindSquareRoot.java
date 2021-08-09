package com.ds.week6;

import org.junit.Test;

import junit.framework.Assert;

public class FindSquareRoot {

	@Test
	public void test1() {
		int k = 16;
		Assert.assertEquals(findSquareRootUsingBS(k), 4);
	}

	@Test
	public void test2() {
		int k = 2147483647;
		Assert.assertEquals(findSquareRootUsingBS(k), 46340);
	}

	@Test
	public void test3() {
		int k = 15;
		Assert.assertEquals(findSquareRootUsingBS(k), 3);
	}

	private int findSquareRootLinear(int k) {
		for (long i = 1; i <= (k / 2) + 1; i++) {
			if (i * i == k)
				return (int) i;
			else if (i * i > k)
				return (int) (i - 1);
		}
		return -1;
	}

	private int findSquareRootUsingBS(int k) {
		int start = 1;
		int end = k;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid == k / mid) {
				return mid;
			} else if (mid > k / mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
