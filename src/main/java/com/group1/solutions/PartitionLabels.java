package com.group1.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class PartitionLabels {

	@Test
	public void test1() {
		String s = "ababcbacadefegdehijhklij";
		Assert.assertTrue(Arrays.asList(9, 7, 8).equals(findPartition(s)));
	}

	private List<Integer> findPartition(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		List<Integer> output = new ArrayList<>();
		int maxLength = 0;
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			maxLength = Math.max(maxLength, map.get(s.charAt(i)));
			if (i == maxLength) {
				output.add(i - temp + 1);
				temp = i + 1;
			}
		}
		return output;
	}
	
}
