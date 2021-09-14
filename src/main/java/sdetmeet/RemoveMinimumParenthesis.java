package sdetmeet;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveMinimumParenthesis {

	/*
	 * Remove the minimum number of parentheses ( '(' or ')', in any positions ) so
	 * that the resulting parentheses string is valid and return any valid string.
	 * 
	 * Formally, a parentheses string is valid if and only if:
	 * 
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings, or It
	 * can be written as (A), where A is a valid string.   Example 1:
	 * 
	 * Input: s = “abc(a(c)e)de)" Output: “abc(a(c)e)de" Explanation:
	 * “abc(a(ce)de)" , “abc(a(c)ede)" would also be accepted.
	 * 
	 * Example 2:
	 * 
	 * Input: s = "a)b(c)d" Output: "ab(c)d"
	 * 
	 * Example 3:
	 * 
	 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
	 * 
	 * Example 4:
	 * 
	 * Input: s = "(a(b(c)d)" Output: "a(b(c)d)"
	 * 
	 * 
	 * Input: String
	 * Output: String
	 */
	
	@Test
	public void test1() {
		String s = "abc(a(c)e)de)";
		Assert.assertEquals("abc(a(c)e)de", removeMinimumParenthesis(s));
	}
	
	@Test
	public void test2() {
		String s = "a)b(c)d";
		Assert.assertEquals("ab(c)d", removeMinimumParenthesis(s));
	}
	
	@Test
	public void test3() {
		String s = "))((";
		Assert.assertEquals("", removeMinimumParenthesis(s));
	}
	
	@Test
	public void test4() {
		String s = "(a(b(c)d)";
		Assert.assertEquals("a(b(c)d)", removeMinimumParenthesis(s));
	}

	private String removeMinimumParenthesis(String s) {
		//Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			
		}
		return null;
	}
}
