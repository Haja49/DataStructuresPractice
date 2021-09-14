package com.ds.week7;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindTargetValues {

	@Test
	public void test1() {
		String s = "abbccaadf";
		int[] targetedValues = { 4, 2, 5, 3, 7 };
		int numTargets = 5;
		Assert.assertArrayEquals(new boolean[] { true, true, false, true, false },
				findTargetValues(s, targetedValues, numTargets));
	}
	
	@Test
	public void test2() {
		String s = "abbbbccaadg";
		int[] targetedValues = { 4, 2, 5, 3, 7 };
		int numTargets = 5;
		Assert.assertArrayEquals(new boolean[] { true, true, false, true, true },
				findTargetValues(s, targetedValues, numTargets));
	}

	/*
	 * 1. Initialize a HashMap.
	 * 2. initialize 2 pointers, left as 0, right as 1;
	 * 3. Iterate through the String from left till end
	 * 		a) If map does not contain the char, put the char into map with value based on its ascii - 'a' +1
	 * 		b) if char at left == char at right, append the same char with a String and add its value multipled by 2
	 * 			Also, increment right.
	 * 4. Create an output boolean array of size equal to target num
	 * 5. Iterate through the target values,
	 * 		a) if map contains the value, add true to output array
	 * 		b) else, add false to output array
	 * 6. Finally return output
	 */
	
	private boolean[] findTargetValues(String s, int[] targetedValues, int numTargets) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int right = 1;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(String.valueOf(s.charAt(i)))) {
				map.put(String.valueOf(s.charAt(i)), s.charAt(i) - 'a' + 1);
			}
			int count = 1;
			if (right < s.length() - 1) {
				if (s.charAt(i) != s.charAt(right))
					right++;
				while (s.charAt(i) == s.charAt(right)) {
					count++;
					int tempCount = count;
					String str = String.valueOf(s.charAt(i));
					while (tempCount > 1) {
						str += String.valueOf(s.charAt(i));
						tempCount--;
					}
					map.put(str, map.get(String.valueOf(s.charAt(i))) * count);
					right++;
				}
			}
		}
		System.out.println(map);
		boolean[] output = new boolean[numTargets];
		for (int i = 0; i < targetedValues.length; i++) {
			if (map.containsValue(targetedValues[i])) {
				output[i] = true;
			} else
				output[i] = false;
		}
		return output;
	}
}
