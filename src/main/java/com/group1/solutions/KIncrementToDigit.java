package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class KIncrementToDigit {

	@Test
	public void test1() {
		int n = 512;
		int k = 10;
		Assert.assertEquals(972, findMax(n, k));
	}

	private int findMax(int n, int k) {
		String num = String.valueOf(n);
		String s = "";
		for (int i = 0; i < num.length(); i++) {
			int charAt = Integer.parseInt(num.charAt(i) + "");
			System.out.println(charAt);
			if (charAt < k) {
				int diff = 9 - charAt;
				int dif = charAt + diff;
				s += dif;
				k -= diff;
			}
		}
		return Integer.valueOf(s);
	}
}
