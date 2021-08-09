package com.ds.week4;

import org.junit.Test;

import junit.framework.Assert;

public class CharacterReprogramming {

	@Test
	public void test1() {
		String s = "URDR";
		Assert.assertEquals(2, getCharCount1(s));
	}

	@Test
	public void test2() {
		String s = "LLL";
		Assert.assertEquals(0, getCharCount1(s));
	}

	@Test
	public void test3() {
		String s = "";
		Assert.assertEquals(0, getCharCount1(s));
	}

	private int getCharCount(String s) {
		if(s.length()==0)
			return 0;
		int[] charArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			charArray[s.charAt(i) - 'A']++;
		}
		return 2 * (Math.min(charArray['U' - 'A'], charArray['D' - 'A'])
				+ Math.min(charArray['R' - 'A'], charArray['L' - 'A']));
	}
	
	private int getCharCount1(String s) {
		int u = 0, d = 0, r = 0, l = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U')
				u++;
			else if (s.charAt(i) == 'D')
				d++;
			else if (s.charAt(i) == 'L')
				l++;
			else if (s.charAt(i) == 'R')
				r++;
		}
		return s.length() - (Math.abs(u - d) + Math.abs(r - l));

	}
}
