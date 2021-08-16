package com.ds.week6;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindPalindromesInString {

	@Test
	public void test1() {
		String s = "abc";
		findPalindromesUsingRecursion(s);
	}

	@Test
	public void test2() {
		String s = "aac";
		findPalindromesUsingRecursion(s);
	}

	@Test
	public void test3() {
		String s = "aaa";
		findPalindromesUsingRecursion(s);
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

	private void findPalindromesUsingRecursion(String s) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			set.add(String.valueOf(s.charAt(i)));
		}
		StringBuilder sb = new StringBuilder(s);
		StringBuilder reverse = sb.reverse();
		if (s.equals(reverse.toString()))
			set.add(s);
		findPalindromesUsingRecursion(s.substring(0,s.length()-1));
		System.out.println(set);
	}
}
