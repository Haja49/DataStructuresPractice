package com.group1.solutions;

import org.junit.Assert;
import org.junit.Test;

public class DIStringMatch {

	@Test
	public void test1() {
		String s = "IDID";
		Assert.assertArrayEquals(new int[] { 0, 4, 1, 3, 2 }, findMatch(s));
	}

	@Test
	public void test2() {
		String s = "III";
		Assert.assertArrayEquals(new int[] { 0, 1, 2, 3 }, findMatch(s));
	}

	@Test
	public void test3() {
		String s = "DDI";
		Assert.assertArrayEquals(new int[] { 3, 2, 0, 1 }, findMatch(s));
	}

	private int[] findMatch(String s) {
		int[] output = new int[s.length() + 1];
		int low = 0, high = s.length();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				output[i] = low++;
			} else if (s.charAt(i) == 'D')
				output[i] = high--;
		}
		output[s.length()] = low;
		return output;
	}
}
