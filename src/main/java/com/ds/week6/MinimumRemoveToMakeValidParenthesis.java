package com.ds.week6;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumRemoveToMakeValidParenthesis {

	@Test
	public void test1() {
		String s = "lee(t(c)o)de)";
		Assert.assertEquals("lee(t(c)o)de", minimumRemove(s));
	}

	@Test
	public void test2() {
		String s = "a)b(c)d";
		Assert.assertEquals("ab(c)d", minimumRemove(s));
	}

	@Test
	public void test3() {
		String s = "))((";
		Assert.assertEquals("", minimumRemove(s));
	}

	@Test
	public void test4() {
		String s = "(a(bd)";
		Assert.assertEquals("a(bd)", minimumRemove(s));
	}

	/*
	 * Psudocode:
	 * 1. Convert the String to char array
	 * 2. Initialize a counter
	 * 3. Iterate through the array
	 * 		a) if char = (, increment counter
	 * 		b) else if char = ), decrement couner
	 * 		c) if counter < 0, replace char with space and reset counter
	 * 4. Reset counter
	 * 5. Repeat the process by traversing from back to front
	 * 6. Convert char array to String and replace space with empty string
	 */

	// Time - O(n)
	// Space - O(n)
	private String minimumRemove(String s) {
		char[] charArray = s.toCharArray();
		int count = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(')
				count++;
			else if (charArray[i] == ')')
				count--;
			if (count < 0) {
				charArray[i] = ' ';
				count = 0;
			}
		}
		count = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (charArray[i] == ')')
				count++;
			else if (charArray[i] == '(')
				count--;
			if (count < 0) {
				charArray[i] = ' ';
				count = 0;
			}
		}
		return String.valueOf(charArray).replaceAll(" ", "");
	}
}
