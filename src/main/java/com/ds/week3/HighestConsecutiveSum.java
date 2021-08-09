package com.ds.week3;

import org.junit.Test;

import junit.framework.Assert;

public class HighestConsecutiveSum {

	@Test
	public void test1() {
		int[] input = { 1, -5, 2, -3, 7, 1 };
		Assert.assertEquals(highestSum(input), 8);
	}
	
	@Test
	public void test2() {
		int[] input = { 1, -5, 2, -3, 7 };
		Assert.assertEquals(highestSum(input), 7);
	}
	
	@Test
	public void test3() {
		int[] input = { -1, -2, -3 };
		Assert.assertEquals(highestSum(input), -1);
	}

	private int highestSum(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				max = Math.max(max, sum);
			}
		}
		return max;
	}

}
