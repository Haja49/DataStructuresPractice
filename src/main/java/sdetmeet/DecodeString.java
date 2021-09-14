package sdetmeet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class DecodeString {

	/*
	 * Initialize a Character stack, List
	Iterate through the characters in the String
	If the character is not )
		push the values to stack
	else until there (, pop the values from stack and add them to list
	Initialize count as 1
	If stack is not empty and Character is digit, if so assign it to count variable
	Until the count becomes 0, push the values from the list in reverse order to stack.
	StringBuilder in which append the values from stack until the stack becomes empty.
	 */
	
	@Test
	public void test1() {
		String s = "3(ab(4(c)))";
		Assert.assertEquals("abccccabccccabcccc", decodeString(s));
	}
	
	@Test
	public void test2() {
		String s = "3(ab)2(cc)";
		Assert.assertEquals("abababcccc", decodeString(s));
	}
	
	@Test
	public void test3() {
		String s = "3((abc))";
		Assert.assertEquals("abcabcabc", decodeString(s));
	}

	private String decodeString(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')') {
				stack.push(s.charAt(i));
			} else {
				List<Character> list = new ArrayList<Character>();
				while (stack.peek() != '(')
					list.add(stack.pop());
				stack.pop();
				int count = 1;
				if(!stack.isEmpty() && Character.isDigit(stack.peek()))
					count = Integer.parseInt(stack.pop()+"");
				while(count>0) {
					for (int j = list.size()-1; j >=0; j--) {
						stack.push(list.get(j));
					}
					count--;
				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop());
		return sb.reverse().toString();
	}
}
