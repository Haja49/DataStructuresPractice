package com.ds.week7;

import org.junit.Test;

import junit.framework.Assert;

public class TrappingRainWater {

	@Test
	public void test1() {
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Assert.assertEquals(6, findTrappedRainWater(heights));
	}

	@Test
	public void test2() {
		int[] heights = { 4, 2, 0, 3, 2, 5 };
		Assert.assertEquals(9, findTrappedRainWater(heights));
	}

	private int findTrappedRainWater(int[] heights) {
		int sum = 0;
		for (int i = 0; i < heights.length; i++) {
			int minHeight = 0;
			for (int j = 0; j <= i; j++) {
				minHeight = Math.max(minHeight, heights[j]);
			}
			int maxHeight = 0;
			for (int j = i; j < heights.length; j++) {
				maxHeight = Math.max(maxHeight, heights[j]);
			}
			sum += Math.min(minHeight, maxHeight) - heights[i];
		}
		return sum;
	}
}
