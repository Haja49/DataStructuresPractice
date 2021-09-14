package com.ds.week7;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumSpeed {

	@Test
	public void test1() {
		int[] dist = { 1, 3, 2 };
		double hour = 6;
		Assert.assertEquals(1, findMinSpeed(dist, hour));
	}

	@Test
	public void test2() {
		int[] dist = { 1, 3, 2 };
		double hour = 2.7;
		Assert.assertEquals(3, findMinSpeed(dist, hour));
	}

	@Test
	public void test3() {
		int[] dist = { 1, 3, 2 };
		double hour = 1.9;
		Assert.assertEquals(-1, findMinSpeed(dist, hour));
	}

	@Test
	public void test4() {
		int[] dist = { 1, 1, 100000 };
		double hour = 2.01;
		Assert.assertEquals(10000000, findMinSpeed(dist, hour));
	}

	/*
	 * 
	 */

	private int findMinSpeed(int[] dist, double hour) {
		if (hour < dist.length - 1) {
			return -1;
		}
		int minSpeed = 1, maxSpeed = 10000000;
		while (minSpeed < maxSpeed) {
			int mid = (minSpeed + maxSpeed) / 2;
			double hr = 0;
			for (int i = 0; i < dist.length; i++) {
				hr += Math.ceil((double) dist[i] / (double) mid);
			}
			if (hr <= hour) {
				maxSpeed = mid - 1;
			} else
				minSpeed = mid + 1;
		}

		return minSpeed;
	}
	
}
