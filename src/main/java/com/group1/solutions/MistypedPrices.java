package com.group1.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class MistypedPrices {

	/*
	 * You have an old grocery shop that instead of scanning their sold proudcts
	 * once sold, they type in the prices, which leaves room for mistyping sold
	 * prices. Given 4 lists: soldItems = ['eggs', 'milk', 'apple'], soldPrices =
	 * [1.00, 2.50, 2.1], productsAvailable = ['eggs', 'lemons', 'milk', 'apple'],
	 * productPrices = [1.01, 0.5, 2.50, 2.1], Find the number of items with
	 * mistyped prices
	 */

	@Test
	public void test1() {
		String[] soldItems = { "eggs", "milk", "apple" };
		float[] soldPrices = { 1.00f, 2.50f, 2.1f };
		String[] productsAvailable = { "eggs", "lemons", "milk", "apple" };
		float[] productPrices = { 1.00f, 0.5f, 2.50f, 2.1f };
		Assert.assertEquals(0, findPrices(soldItems, soldPrices, productsAvailable, productPrices));
	}

	private int findPrices(String[] soldItems, float[] soldPrices, String[] productsAvailable, float[] productPrices) {
		int count = 0;
		Map<String, Float> sold = new HashMap<String, Float>();
		for (int i = 0; i < soldItems.length; i++) {
			sold.put(soldItems[i], soldPrices[i]);
		}

		Map<String, Float> available = new HashMap<String, Float>();
		for (int i = 0; i < productsAvailable.length; i++) {
			available.put(productsAvailable[i], productPrices[i]);
		}

		for (Entry<String, Float> soldItem : sold.entrySet()) {
			if (available.containsKey(soldItem.getKey())
					&& !soldItem.getValue().equals(available.get(soldItem.getKey()))) {
				count++;
			}
		}
		return count;
	}

	private int findPricesUsingSet(String[] soldItems, float[] soldPrices, String[] productsAvailable,
			float[] productPrices) {
		int count = 0;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < productsAvailable.length; i++) {
			set.add(productsAvailable[i] + "-" + productPrices[i]);
		}
		for (int i = 0; i < soldItems.length; i++) {
			if (set.add(soldItems[i] + "-" + soldPrices[i])) {
				count++;
			}
		}
		return count;
	}
}
