package com.ds.week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesis {

	@Test
	public void test1() {
		String brackets = "{()}";
		Assert.assertEquals(true, isValidBrackets(brackets));
	}
	
	@Test
	public void test2() {
		String brackets = "{()";
		Assert.assertEquals(false, isValidBrackets(brackets));
	}
	
	@Test
	public void test3() {
		String brackets = "{()}[]";
		Assert.assertEquals(true, isValidBrackets(brackets));
	}

	/*
	 * Algorithm
	 * Convert given String to char Array
	 * Create a map and stack
	 * Put to map with closing brackets as key and its partner as value
	 * Iterate through each character
	 *  -> check the char is present as key
	 *  	-> If 'No', push to stack
	 *  	-> If 'YES', pop from stack and
	 *  				-> compare the value of map with popped value
	 *  				-> if it doesn't match, STOP!
	 *  				-> If stack is empty before pop, STOP!
	 *  Finally return a boolean confirm if stack is empty or not
	 */

	private boolean isValidBrackets(String brackets) {
		char[] charArray = brackets.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		map.put('>', '<');
		for (char c : charArray) {
			if (!map.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.pop() != map.get(c))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
