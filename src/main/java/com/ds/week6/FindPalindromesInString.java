package com.ds.week6;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindPalindromesInString {

	@Test
	public void test1() {
		String s = "abc";
		findPalindromes(s);
	}

	@Test
	public void test2() {
		String s = "aac";
		findPalindromes(s);
	}

	@Test
	public void test3() {
		String s = "aaa";
		findPalindromes(s);
	}

	private void findPalindromes(String s) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String str = s.substring(i, j);
				StringBuilder sb = new StringBuilder(str);
				StringBuilder reverse = sb.reverse();
				if (str.equals(reverse.toString()))
					set.add(str);
			}
		}
		System.out.println(set);
	}

}
