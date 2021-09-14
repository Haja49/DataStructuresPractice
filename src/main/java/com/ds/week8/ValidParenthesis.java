package com.ds.week8;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class ValidParenthesis {

	/*
	 * Confirm if the given string has all valid parenthesis
	 */
	
	@Test
	public void test1() {
		String parenthesis = "{{(()}}";
		Assert.assertEquals(false, isValid(parenthesis));
	}
	
	@Test
	public void test2() {
		String parenthesis = "{{()}}";
		Assert.assertEquals(true, isValid(parenthesis));
	}
	
	@Test
	public void test3() {
		String parenthesis = "}{";
		Assert.assertEquals(false, isValid(parenthesis));
	}
	
	@Test
	public void test4() {
		String parenthesis = "";
		Assert.assertEquals(true, isValid(parenthesis));
	}

	/*
	 * Pseudocode:
	 * 1. Initialize a Character Stack.
	 * 2. Put all valid parenthesis to a map
	 * 3. Iterate through each character in String
	 * 4. Iterate through each character
	 *  	a) check the char is present as key
	 *  	b) If No, push to stack
	 *  	c) If Yes, pop from stack and
	 *  			-> compare the value of map with popped value
	 *  			-> if it doesn't match, return false
	 *  			-> If stack is empty before pop, return false
	 *  Finally return a boolean confirm if stack is empty or not
	 */
	private boolean isValid(String parenthesis) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		char[] ch = parenthesis.toCharArray();
		for (char c : ch) {
			if (!map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || stack.pop() != map.get(c)) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
