package com.group1.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class ShortestBalancedString {

	@Test
	public void test1() {
		String s = "azABaabza";
		Assert.assertEquals(5, findBalancedFragment(s));
	}

	@Test
	public void test2() {
		String s = "TacoCat";
		Assert.assertEquals(-1, findBalancedFragment(s));
	}

	@Test
	public void test3() {
		String s = "AcZCbaBz";
		Assert.assertEquals(8, findBalancedFragment(s));
	}

	@Test
	public void test4() {
		String s = "aA";
		Assert.assertEquals(2, findBalancedFragment(s));
	}

	public int solution(String S) {
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length() - i + 1; j++) {
				Set<Character> lower = new HashSet<>();
				Set<Character> upper = new HashSet<>();
				String minBalanced = S.substring(j, j + i);
				char[] minChar = minBalanced.toCharArray();
				for (char ch : minChar) {
					if (Character.isLowerCase(ch))
						lower.add(ch);
					else
						upper.add(ch);
				}
				if (convertToLower(upper).containsAll(lower) && lower.containsAll(convertToLower(upper)))
					return minBalanced.length();
			}
		}
		return -1;
	}

	private Set<Character> convertToLower(Set<Character> set) {
		Set<Character> lower = new HashSet<>();
		for (Character ch : set)
			lower.add(Character.toLowerCase(ch));
		return lower;
	}

	private int findBalancedString(String s) {
		int k = 2;
		String balString = "";
		while (k <= s.length()) {
			String str = "";
			for (int i = 0; i < k; i++) {
				str += s.charAt(i);
			}
			if (isBalanced(str)) {
				balString = str;
			}
			for (int j = k; j < s.length(); j++) {
				String s2 = str.substring(1);
				str = s2 + s.charAt(j);
				if (isBalanced(str)) {
					if (balString.length() < str.length()) {
						balString = str;
					}
				}
			}
			k++;
		}
		return balString.length() <= 0 ? -1 : balString.length();
	}

	private boolean isBalanced(String str) {
		for (int i = 0; i < str.length(); i++) {
			if ((Character.isLowerCase(str.charAt(i)) && !str.contains(String.valueOf(str.charAt(i)).toUpperCase()))
					|| (Character.isUpperCase(str.charAt(i))
							&& !str.contains(String.valueOf(str.charAt(i)).toLowerCase()))) {
				return false;
			}
		}
		return true;
	}

	private int findBalancedFragment(String s) {
		HashSet<Character> lowerSet = new HashSet<>();
		HashSet<Character> upperSet = new HashSet<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(s.charAt(i)))
				lowerSet.add(chars[i]);
			else
				upperSet.add(chars[i]);
		}
		int left = 0, right = 0, length = -1;
		while (right < s.length()) {
			if (lowerSet.contains(Character.toLowerCase(s.charAt(right)))
					&& upperSet.contains(Character.toUpperCase(s.charAt(right)))) {
				length = Math.max(length, right - left + 1);
				right++;
			} else {
				right = left += 2;
			}
		}
		return length == 1 ? -1 : length;
	}
}
