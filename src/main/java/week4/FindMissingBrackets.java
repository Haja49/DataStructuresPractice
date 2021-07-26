package week4;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindMissingBrackets {

	@Test
	public void test1() {
		String s = "((((";
		Assert.assertEquals(4, findMissingBracket(s));
	}

	@Test
	public void test2() {
		String s = "(()((";
		Assert.assertEquals(3, findMissingBracket(s));
	}

	@Test
	public void test3() {
		String s = ")";
		Assert.assertEquals(1, findMissingBracket(s));
	}

	private int findMissingBracket(String s) {
		char[] charArray = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < charArray.length; i++) {
			if (stack.isEmpty() || stack.peek() == charArray[i])
				stack.push(charArray[i]);
			else
				stack.pop();
		}
		return stack.size();
	}

	private int findMissingBracket1(String s) {
		int open = 0, closed = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				open++;
			else
				closed++;
		}
		return Math.abs(open-closed);
	}
}
