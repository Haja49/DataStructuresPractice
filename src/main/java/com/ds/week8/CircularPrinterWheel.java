package com.ds.week8;

import org.junit.Test;

import junit.framework.Assert;

public class CircularPrinterWheel {

	@Test
	public void test1() {
		String s = "BZA";
		Assert.assertEquals(4, findDistance(s));
	}
	
	@Test
	public void test2() {
		String s = "AAA";
		Assert.assertEquals(0, findDistance(s));
	}
	
	@Test
	public void test3() {
		String s = "ZAZ";
		Assert.assertEquals(3, findDistance(s));
	}
	
	private int findDistance(String s) {
		int currChar = 'A';
		int totalTime = 0;
		for (int i = 0; i < s.length(); i++) {
			int dist1 = Math.abs(s.charAt(i) - currChar);
			int dist2 = Math.abs(dist1 - 26);
			totalTime += Math.min(dist1, dist2);
			currChar = s.charAt(i);
		}
		return totalTime;
	}
}
