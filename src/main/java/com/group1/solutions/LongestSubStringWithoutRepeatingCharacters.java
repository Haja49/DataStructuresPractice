package com.group1.solutions;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class LongestSubStringWithoutRepeatingCharacters {

	@Test
	public void test1() {
		String s = "abcabcbb";
		Assert.assertEquals(3, lengthOfLongestSubstring(s));
	}

	@Test
	public void test2() {
		String s = "bbbbb";
		Assert.assertEquals(1, lengthOfLongestSubstring(s));
	}

	@Test
	public void test3() {
		String s = "pwwkew";
		Assert.assertEquals(3, lengthOfLongestSubstring(s));
	}

	private int findLongestSubstring(String s) {
		int count = 0;
		int i = 0, j = 0;
		Set<Character> set = new HashSet<Character>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				count = Math.max(count, set.size());
			} else
				set.remove(s.charAt(i++));
		}
		return count;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2)
			return s.length();
		int left = 0, max = 0;
		int[] asciiArr = new int[128];
		for (int right = 0; right < s.length(); right++) {
			asciiArr[s.charAt(right)]++;
			while (asciiArr[s.charAt(right)] > 1) {
				asciiArr[s.charAt(left)]--;
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
