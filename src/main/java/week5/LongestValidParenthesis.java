package week5;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class LongestValidParenthesis {

	/*
	 * https://leetcode.com/problems/longest-valid-parentheses/solution/
	 */

	@Test
	public void test1() {
		String s = "(()";
		Assert.assertEquals(2, getValidParenthesis(s));
	}

	@Test
	public void test2() {
		String s = ")()())";
		Assert.assertEquals(4, getValidParenthesis(s));
	}

	@Test
	public void test3() {
		String s = "()(()";
		Assert.assertEquals(2, getValidParenthesis(s));
	}

	@Test
	public void test4() {
		String s = "(())(())";
		Assert.assertEquals(8, getValidParenthesis(s));
	}
	
	@Test
	public void test5() {
		String s = ")(";
		Assert.assertEquals(0, getValidParenthesis(s));
	}

	private int getValidParenthesis(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				Stack<Character> stack = new Stack<Character>();
				String ss = s.substring(i, j);
				for (int k = 0; k < ss.length(); k++) {
					if (ss.charAt(k) == '(') {
						stack.push('(');
					} else if (!stack.empty() && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(')');
						break;
					}
				}
				if (stack.isEmpty()) {
					max = Math.max(max, j - i);
				}
			}
		}
		return max;
	}

	private int getValidParenthesisUsingStack(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty())
					stack.push(i);
				else
					max = Math.max(max, i - stack.peek());
			}
		}
		return max;
	}

	private int getValidParenthesisUsingTwoPointer(String s) {
		int left = 0, right = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, 2 * right);
			} else if (right > left) {
                left = right = 0;
            }
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, 2 * left);
			} else if (left > right) {
                left = right = 0;
            }
		}
		return max;
	}
}
