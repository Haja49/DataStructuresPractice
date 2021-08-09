package com.ds.week5;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindAverage {

	@Test
	public void test1() {
		int[] arr = {2,5, 8, 4, 7};
		Assert.assertEquals(5.33, findAverage(arr));
	}

	private double findAverage(int[] arr) {
		Arrays.sort(arr);
		double maxSum = 0;
		for (int i = 1; i < arr.length-1; i++) {
			maxSum += arr[i];
		}
		System.out.println(maxSum/(arr.length-2));
		return maxSum/(arr.length-2);
	}
}
