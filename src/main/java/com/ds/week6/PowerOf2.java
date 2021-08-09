package com.ds.week6;

import org.junit.Test;

import junit.framework.Assert;

public class PowerOf2 {

	/*
	 * Given an integer n, return true if it is a power of two. Otherwise, return
	 * false.
	 * 
	 * An integer n is a power of two, if there exists an integer x such that n ==
	 * 2x.
	 * 
	 * https://leetcode.com/problems/power-of-two/
	 */

	@Test
	public void test1() {
		Assert.assertEquals(true, findPowerUsingRecursion(1));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, findPowerUsingRecursion(-8));
	}

	@Test
	public void test3() {
		Assert.assertEquals(false, findPowerUsingRecursion(5));
	}

	private boolean findPower(int n) {
		if (n <= 0)
			return false;
		while (n % 2 == 0)
			n /= 2;
		return n == 1;
	}

	private boolean findPowerUsingRecursion(int n) {
		if (n <= 0)
			return false;
		return n == 1 || (n % 2 == 0 && findPowerUsingRecursion(n / 2));
	}

	private boolean findPowerUsingBit(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}
}
