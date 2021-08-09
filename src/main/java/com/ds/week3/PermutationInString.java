package com.ds.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class PermutationInString {

	/*
	 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.
	 *
	 * Input = String, String
	 * Output = boolean
	 */
	@Test
	public void test1() {
		String s1 = "ab";
		String s2 = "eidbaooo";
		Assert.assertEquals(true, permutationUsingSW(s1, s2));
	}

	@Test
	public void test2() {
		String s1 = "ab";
		String s2 = "eidboaoo";
		Assert.assertEquals(false, permutationUsingSW(s1, s2));
	}

	@Test
	public void test3() {
		String s1 = "a";
		String s2 = "eidba";
		Assert.assertEquals(true, permutationUsingSW(s1, s2));
	}

	@Test
	public void test4() {
		String s1 = "a";
		String s2 = "";
		Assert.assertEquals(false, permutationUsingSW(s1, s2));
	}

	/*
	 * 1. Iterate through s1 and add the occurrence of char to a map
	 * 2. Iterate through s2 till s2-s1 length and add the occurrence of char based on length of s1 to another map
	 * 3. If both maps are equal, return true
	 * 4. Else return false
	 */
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 */
	private boolean permutation(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			Map<Character, Integer> map2 = new HashMap<Character, Integer>();
			for (int j = 0; j < s1.length(); j++) {
				map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j), 0) + 1);
			}
			if (map.equals(map2)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 1. Initialize 2 integer arrays of size 128
	 * 2. Iterate through s1 and increment the count of specific character
	 * 3. Iterate through s2-s1 length, increment the count in 2nd array
	 * 		a) Remove the first value and add value at end
	 * 4. Compare both arrays. If equal, return true else false
	 */
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private boolean permutationUsingSW(String s1, String s2) {
		if (s2.length() < s1.length())
			return false;
		int[] s1Array = new int[26];
		int[] s2Array = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1Array[s1.charAt(i) - 'a']++;
			s2Array[s2.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (Arrays.equals(s1Array, s2Array))
				return true;
			s2Array[s2.charAt(i + s1.length()) - 'a']++;
			s2Array[s2.charAt(i) - 'a']--;
		}
		return Arrays.equals(s1Array, s2Array);
	}
}
