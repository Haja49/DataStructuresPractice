package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class GroupAnagrams {

	/*
	 * 	Question 5:
	Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
	List<List<String>>
	 
	Example 1:
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	Example 2:
	Input: strs = [""]
	Output: [[""]]
	Example 3:
	Input: strs = ["a"]
	Output: [["a"]]
	 */
	
	@Test
	public void test1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> childList1 = new ArrayList<String>();
		childList1.add("eat");
		childList1.add("tea");
		childList1.add("ate");
		List<String> childList2 = new ArrayList<String>();
		childList2.add("bat");
		List<String> childList3 = new ArrayList<String>();
		childList3.add("tan");
		childList3.add("nat");
		list.add(childList1);
		list.add(childList2);
		list.add(childList3);
		Assert.assertEquals(list, groupAnagrams(strs));
	}
	
	@Test
	public void test2() {
		String[] strs = { };
		List<List<String>> list = new ArrayList<List<String>>();
		Assert.assertEquals(list, groupAnagrams(strs));
	}
	
	@Test
	public void test3() {
		String[] strs = { "a"};
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> childList1 = new ArrayList<String>();
		childList1.add("a");
		list.add(childList1);
		Assert.assertEquals(list, groupAnagrams(strs));
	}

	private List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			int[] chArray = new int[26];
			for (int j = 0; j < strs[i].length(); j++) {
				chArray[strs[i].charAt(j) - 'a']++;
			}
			List<String> strList = new ArrayList<String>();
			if (map.containsKey(Arrays.toString(chArray))) {
				strList.addAll(map.get(Arrays.toString(chArray)));
			}
			strList.add(strs[i]);
			map.put(Arrays.toString(chArray), strList);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
