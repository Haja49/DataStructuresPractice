package com.ds.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class DecodeString {

	@Test
	public void test1() {
		String s = "a3[c]";
		Assert.assertEquals("accc", decode(s));
	}
	
	@Test
	public void test2() {
		String s = "4[a3[b2[c]]]";
		Assert.assertEquals("abccbccbccabccbccbccabccbccbccabccbccbcc", decode(s));
	}
	
	@Test
	public void test3() {
		String s = "a[ac]";
		Assert.assertEquals("aac", decode(s));
	}
	
	@Test
	public void test4() {
		String s = "2[a[ac]]";
		Assert.assertEquals("aacaac", decode(s));
	}
	
	@Test
	public void test5() {
		String s = "ab";
		Assert.assertEquals("ab", decode(s));
	}
	
	@Test
	public void test6() {
		String s = "ab2";
		Assert.assertEquals("ab2", decode(s));
	}

	/*
	 * Things to Remember => When to stop (closing), When to start (open) !
	 * 
	 * Create a empty stack
	 * Convert String to charArray
	 * Traverse through every char
	 * ** if it is not closing char	-> push each char to stack
	 * ** if it is closing char -> 
	 * 		-> pop the char
	 * 		-> add it to the list
	 * 		-> When the pop is open bracket, do nothing!
	 * 		-> pop the next number and make your list multiplied with that
	 * 		-> Reverse and push back!
	 * **Continue till the stack is empty
	 */
	private String decode(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ']') {
				stack.push(s.charAt(i));
			} else {
				List<Character> list = new ArrayList<Character>();
				while (stack.peek() != '[') {
					list.add(stack.pop());
				}
				stack.pop();
				int k = 1;
				if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					k = Character.getNumericValue(stack.pop());
				}
				while (k > 0) {
					for (int j = list.size() - 1; j >= 0; j--) {
						stack.push(list.get(j));
					}
					k--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}
