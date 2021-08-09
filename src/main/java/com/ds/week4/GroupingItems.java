package com.ds.week4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class GroupingItems {

	@Test
	public void test1() {
		List<String> transactions = new ArrayList<String>();
		transactions.add("notebook");
		transactions.add("mouse");
		transactions.add("mouse");
		transactions.add("notebook");
		transactions.add("keyboard");
		List<String> output = new ArrayList<String>();
		output.add("mouse 2");
		output.add("notebook 2");
		output.add("keyboard 1");
		Assert.assertEquals(output, getGroupedItems(transactions));
	}
	
	@Test
	public void test2() {
		List<String> transactions = new ArrayList<String>();
		transactions.add("notebook");
		transactions.add("mouse");
		transactions.add("notebook");
		transactions.add("keyboard");
		List<String> output = new ArrayList<String>();
		output.add("notebook 2");
		output.add("keyboard 1");
		output.add("mouse 1");
		Assert.assertEquals(output, getGroupedItems(transactions));
	}

	private List<String> getGroupedItems(List<String> transactions) {
		if (transactions.isEmpty())
			return new ArrayList<String>();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < transactions.size(); i++) {
			map.put(transactions.get(i), map.getOrDefault(transactions.get(i), 0) + 1);
		}
		System.out.println(map);
		List<Entry<String,Integer>> entrySet = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(entrySet, (l1, l2) -> l2.getValue().compareTo(l1.getValue()));

		/*
		 * Map<String, Integer> result = new HashMap<String, Integer>();
		 * System.out.println(entrySet); for (Map.Entry<String, Integer> entry :
		 * entrySet) { result.put(entry.getKey(), entry.getValue()); }
		 * System.out.println(result);
		 */
		List<String> list = new ArrayList<String>();
		/*
		 * for (Entry<String, Integer> eachEntry : map.entrySet()) {
		 * list.add(eachEntry.getKey() + " " + eachEntry.getValue()); }
		 */
		
		for (int i = 0; i < entrySet.size(); i++) {
			list.add(entrySet.get(i).getKey() + " " + entrySet.get(i).getValue());
		}

	//	Collections.sort(list);
		System.out.println(list);
		 
		return list;
	}
}
