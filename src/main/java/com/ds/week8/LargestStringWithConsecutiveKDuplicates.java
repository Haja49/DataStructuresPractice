package com.ds.week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class LargestStringWithConsecutiveKDuplicates {

	@Test
	public void test1() {
		String s = "azzxxx";
		int k = 2;
		Assert.assertEquals("zzxxax", largestString(s, k));
	}

	@Test
	public void test2() {
		String s = "zzzzzy";
		int k = 2;
		Assert.assertEquals("zzyzz", largestString(s, k));
	}
	
	@Test
	public void test3() {
		String s = "bbacccccaa";
		int k = 2;
		Assert.assertEquals("ccbccbcaa", largestString(s, k));
	}

	private String findLargestString(String s, int k) {
		// Add all characters in String to int array
		int[] ascii = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ascii[s.charAt(i) - 'a']++;
		}

		// Initialize a String
		String op = "";

		// Iterate from reverse to get the max value first
		int i = 25;
		while (i >= 0) {

			// If the current value count is > k, first add the value k times and then add
			// next char
			if (ascii[i] > k) {

				// Add k times and decrement the count in int array
				int count = k;
				while (count > 0) {
					op += (char) (i + 'a');
					count--;
				}
				ascii[i] -= k;

				// Find the next char
				int j = i - 1;
				while (j > 0 && ascii[j] <= 0) {
					j--;
				}

				// Add the char just once and then decrement its count
				if (j >= 0 && ascii[j] > 0) {
					op += (char) (j + 'a');
					ascii[j]--;
				} else {
					// if no char found, break
					break;
				}

				// If the count is between 1 and k, add all to String
			} else if (ascii[i] > 0) {
				int count = ascii[i];
				while (count > 0) {
					op += (char) (i + 'a');
					count--;
				}
				ascii[i] = 0;

			}
			// Move to the next element
			else
				i--;
		}
		System.out.println(op);
		return op;
	}
	
	private static String largestString(String s, int k) {
		char[] chs = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : chs) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		Set<Entry<Character, Integer>> set = map.entrySet();
		ArrayList<Entry<Character, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, (a, b) -> (b.getKey().compareTo(a.getKey()))); // nlogn

		int i = 0;
		while (i < list.size()) {
			Entry<Character, Integer> firstEntry = list.get(i);
			char firstKey = firstEntry.getKey();
			int firstVal = firstEntry.getValue();

			if (firstVal > k) {
				// reduce by k
				int count = 0;
				while (count < k) {
					sb.append(firstKey);
					count++;
				}
				firstEntry.setValue(firstVal - k);

				// Just add 1 next character
				Entry<Character, Integer> secondEntry = list.get(i + 1);
				char secondKey = secondEntry.getKey();
				int secondVal = secondEntry.getValue();

				if (secondVal > 0) {
					sb.append(secondKey);
					secondEntry.setValue(secondVal - 1);
				} else
					break;
			} else if (firstVal > 0 && firstVal <= k) {
				int count = 0;
				while (count < firstVal) {
					sb.append(firstKey);
					count++;
				}
				firstEntry.setValue(0);
			} else {// firstVal == 0
				i++;
			}
		}

		return sb.toString();
	}
}
