package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import junit.framework.Assert;

public class SmallestNegativeBalance {

	@Test
	public void test1() {
		String[] strs = { "Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4",
				"Alez Casey 4" };
		Assert.assertEquals(Arrays.asList("Casey"), findSmallestNegativeBalanceOptimized(strs));
	}

	@Test
	public void test2() {
		String[] strs = { "Alex Blake 2", "Blake Alex 2" };
		Assert.assertEquals(Arrays.asList("Nobody has a Negative Balance"), findSmallestNegativeBalanceOptimized(strs));
	}

	@Test
	public void test3() {
		String[] strs = { "Alex Blake 2", "Casey Alex 2", "Alex Casey 4" };
		Assert.assertEquals(Arrays.asList("Blake", "Casey"), findSmallestNegativeBalanceOptimized(strs));
	}

	private List<String> findSmallestNegativeBalance(String[] strs) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			String[] str = strs[i].split(" ");
			String borrower = str[0];
			String lender = str[1];
			int value = Integer.valueOf(str[2]);
			map.put(borrower, map.getOrDefault(borrower, 0) + value);
			map.put(lender, map.getOrDefault(lender, 0) - value);
		}
		int min = Integer.MAX_VALUE;
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			min = Math.min(min, eachEntry.getValue());
		}
		if (min >= 0)
			return Arrays.asList("Nobody has a Negative Balance");
		Set<String> output = new TreeSet<String>();
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == min)
				output.add(eachEntry.getKey());
		}
		return new ArrayList<String>(output);
	}

	private List<String> findSmallestNegativeBalanceOptimized(String[] strs) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			map.put(strs[i].split(" ")[0],
					map.getOrDefault(strs[i].split(" ")[0], 0) + Integer.valueOf(strs[i].split(" ")[2]));
			map.put(strs[i].split(" ")[1],
					map.getOrDefault(strs[i].split(" ")[1], 0) - Integer.valueOf(strs[i].split(" ")[2]));
		}
		int min = Collections.min(map.values());
		if (min >= 0)
			return Arrays.asList("Nobody has a Negative Balance");
		List<String> output = new ArrayList<String>();
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == min)
				output.add(eachEntry.getKey());
		}
		return output;
	}
}
