package com.ds.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class AnagramIndex {

	@Test
	public void test1() {
		String s1 = "cbaebabacd";
		String s2 = "abc";
		Assert.assertArrayEquals(anagramUsingSW(s1, s2), new int[] { 0, 6 });
	}
	
	@Test
	public void test2() {
		String s1 = "abab";
		String s2 = "ab";
		Assert.assertArrayEquals(anagramUsingSW(s1, s2), new int[] { 0, 1, 2 });
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 */
	private int[] findAnagram(String s2, String s1) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			Map<Character, Integer> map2 = new HashMap<Character, Integer>();
			for (int j = 0; j < s1.length(); j++) {
				map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j), 0) + 1);
			}
			if (map.equals(map2)) {
				list.add(i);
			}
		}
		int[] output = new int[list.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = list.get(i);
		}
		return output;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private int[] anagramUsingSW(String s2, String s1) {
		if (s2.length() < s1.length())
			return new int[] {};
		int[] s1Array = new int[26];
		int[] s2Array = new int[26];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s1.length(); i++) {
			s1Array[s1.charAt(i) - 'a']++;
			s2Array[s2.charAt(i) - 'a']++;
		}
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			if (Arrays.equals(s1Array, s2Array))
				list.add(i);
			if (i < s2.length() - s1.length()) {
				s2Array[s2.charAt(i + s1.length()) - 'a']++;
				s2Array[s2.charAt(i) - 'a']--;
			}
		}
		int[] output = new int[list.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = list.get(i);
		}
		return output;
	}
}
