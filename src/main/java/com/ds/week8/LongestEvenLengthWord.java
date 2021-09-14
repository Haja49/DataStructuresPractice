package com.ds.week8;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class LongestEvenLengthWord {

	@Test
	public void test1() {
		String s = "Time to write great code";
		Assert.assertEquals("Time", findlongestWithoutMap(s));
	}
	
	@Test
	public void test2() {
		String s = "Time to write great codes";
		Assert.assertEquals("Time", findlongestWithoutMap(s));
	}
	
	@Test
	public void test3() {
		String s = "";
		Assert.assertEquals("", findlongestWithoutMap(s));
	}

	private String findlongest(String s) {
		String[] word = s.split(" ");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < word.length; i++) {
			if (word[i].length() % 2 == 0)
				map.put(word[i], map.getOrDefault(word[i], 0) + word[i].length());
		}
		int max = Collections.max(map.values());
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == max)
				return eachEntry.getKey();
		}
		return "";
	}

	private String findlongestWithoutMap(String s) {
		String[] words = s.split(" ");
		int max = 0;
		String maxWord = "";
		for (String word : words) {
			if (word.length() % 2 == 0 && word.length() > max) {
				max = word.length();
				maxWord = word;
			}
		}
		return maxWord;
	}

}
