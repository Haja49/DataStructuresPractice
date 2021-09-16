package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class MaxValueByDeleting5 {

	@Test
	public void test1() {
		int n = -15657;
		Assert.assertEquals(-1567, delete5(n));
	}

	@Test
	public void test2() {
		int n = -12535;
		Assert.assertEquals(-1235, delete5(n));
	}

	private int delete5(int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
			n *= -1;
		}
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				String temp = s.substring(0, i) + s.substring(i + 1);
				int tempInt = Integer.parseInt(temp);
				if (isNegative)
					min = Math.min(tempInt, min);
				else
					max = Math.max(tempInt, max);
			}
		}
		return isNegative ? min * -1 : max;

	}

	private int delete(int n) {
		String s = Integer.toString(n);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				String temp = s.substring(0, i) + s.substring(i + 1);
				int tempInt = Integer.parseInt(temp);
				max = Math.max(tempInt, max);
			}
		}
		return max;
	}
}
