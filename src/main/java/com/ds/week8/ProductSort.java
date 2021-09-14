package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class ProductSort {

	/*
	 * 
	 */
	@Test
	public void test1() {
		int[] nums = { 4, 5, 6, 4, 5, 3 };
		Assert.assertTrue(findProductSort(nums).equals(Arrays.asList(3, 6, 4, 4, 5, 5)));
	}

	@Test
	public void test2() {
		int[] nums = { 4, 5, 6, 4, 5, 3, 4 };
		Assert.assertTrue(findProductSort(nums).equals(Arrays.asList(3, 6, 5, 5, 4, 4, 4)));
	}

	@Test
	public void test3() {
		int[] nums = { 4, 3, 1, 6 };
		Assert.assertTrue(findProductSort(nums).equals(Arrays.asList(1, 3, 4, 6)));
	}
	
	@Test
	public void test4() {
		int[] nums = { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		Assert.assertTrue(findProductSort(nums).equals(Arrays.asList(4, 3, 3, 2, 2, 2, 1, 1, 1, 1)));
	}

	
	/*
	 * 1. Initialize a Tree map
	 * 2. Find the occurrence of each number in nums and put it in map
	 * 3. Add all the entries to a new list
	 * 4. Compare the value in the list entries and sort them
	 * 5. Iterate through the list
	 * 		a) while the value becomes 0, add the key to a new list
	 * 6. Finally return the list
	 */
	// Time - O(nlogn)
	// Space - O(n)
	private List<Integer> findProductSort(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
	//	Collections.sort(list, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
		Collections.sort(list, Map.Entry.comparingByValue());
		List<Integer> output = new ArrayList<>();
		for (Entry<Integer, Integer> entry : list) {
			int value = entry.getValue();
			while (value!=0) {
				output.add(entry.getKey());
				value--;
			}
		}
		return output;
	}
}
