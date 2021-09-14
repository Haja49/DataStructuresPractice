package com.ds.week8;

import org.junit.Test;

import junit.framework.Assert;

public class FindFirstUniqueCharacter {

	@Test
	public void test1() {
		String s = "statistics";
		Assert.assertEquals(3, findFirstUniqueSimple(s));
	}

	@Test
	public void test2() {
		String s = "bababa";
		Assert.assertEquals(-1, findFirstUniqueSimple(s));
	}

	@Test
	public void test3() {
		String s = "s";
		Assert.assertEquals(1, findFirstUniqueSimple(s));
	}

	private int findFirstUnique(String s) {
		if (s.length() == 1)
			return 1;
		int[] ascii = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ascii[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (ascii[s.charAt(i) - 'a'] == 1)
				return i + 1;
		}
		return -1;
	}

	private int findFirstUniqueSimple(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i + 1;
		}
		return -1;
	}
}
