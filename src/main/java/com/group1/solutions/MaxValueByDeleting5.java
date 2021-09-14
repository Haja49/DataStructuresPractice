package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class MaxValueByDeleting5 {

	@Test
	public void test1() {
		int n = -5657;
		Assert.assertEquals(-567, delete5(n));
	}

	private int delete5(int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
		}
		String s = Integer.toString(n);
		int max = 0, min = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '5') {
				String temp = s.substring(0, i) + s.substring(i + 1);
				int tempInt = Integer.parseInt(temp);
				if (isNegative)
					min = Math.min(tempInt, max);
				else
					max = Math.max(tempInt, max);
			}
		}
		return isNegative ? min : max;

	}
}
