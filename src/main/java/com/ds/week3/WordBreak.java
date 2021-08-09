package com.ds.week3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class WordBreak {
	
	/*
	 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
	 * Note that the same word in the dictionary may be reused multiple times in the segmentation
	 *
	 * Input: String, StringList
	 * Output: boolean
	 */
	
	@Test
	public void test1() {
		String s = "leetcode";
		List<String> dict = new LinkedList<String>();
		dict.add("leet");
		dict.add("code");
		Assert.assertEquals(true, wordBreak(s, dict));	
	}
	
	@Test
	public void test2() {
		String s = "applepenapple";
		List<String> dict = new LinkedList<String>();
		dict.add("apple");
		dict.add("pen");
		Assert.assertEquals(true, wordBreak(s, dict));	
	}
	
	@Test
	public void test3() {
		String s = "catsandog";
		List<String> dict = new LinkedList<String>();
		dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cat");
		Assert.assertEquals(false, wordBreak(s, dict));	
	}

	/*
	 * 1. Initialize boolean array of size equal to length of String
	 * 2. Set 0 index as true for comparison
	 * 3. Iterate through the String and check if the substring is present in set
	 * 4. If yes, set array index as true
	 * 5. Finally return last array index
	 */
	// O(n^2) / O(n)
	public boolean wordBreak(String s, List<String> dict) {
		boolean[] bool = new boolean[s.length() + 1];
		bool[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (bool[j] && dict.contains(s.substring(j, i))) {
					bool[i] = true;
					break;
				}
			}
		}
		return bool[s.length()];
	}
}
