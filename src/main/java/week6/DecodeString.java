package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class DecodeString {

	@Test
	public void test1() {
		String data = "3[a]2[bc]";
		Assert.assertEquals(decodeString(data), "aaabcbc");
	}

	@Test
	public void test2() {
		String data = "3[a2[c]]";
		Assert.assertEquals(decodeString(data), "accaccacc");
	}

	@Test
	public void test3() {
		String data = "2[abc]3[cd]ef";
		Assert.assertEquals(decodeString(data), "abcabccdcdcdef");
	}

	@Test
	public void test4() {
		String data = "abc3[cd]xyz";
		Assert.assertEquals(decodeString(data), "abccdcdcdxyz");
	}

	@Test
	public void test5() {
		String data = "10[test]";
		Assert.assertEquals(decodeString(data), "testtesttesttesttesttesttesttesttesttest");
	}

	private String decodeString(String data) {
		StringBuilder sb = new StringBuilder();
		if (!data.contains("]")) {
			return data;
		}
		int count = 1;
		int closeIndex = 0, openIndex = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ']') {
				closeIndex = i;
				break;
			}
			if (data.charAt(i) == '[')
				openIndex = i;
		}
		String str = "";
		int index = openIndex;
		while (index != 0 && Character.isDigit(data.charAt(index - 1))) {
			str = data.charAt(index - 1) + str;
			index--;
		}
		// count = Character.getNumericValue(data.charAt(openIndex - 1));
		int c = 0;
		if (!str.equals("")) {
			count = Integer.parseInt(str);
			c = openIndex - String.valueOf(count).length();
		}
		while (count > 0) {
			sb.append(data.substring(openIndex + 1, closeIndex));
			count--;
		}
		String decodeString = decodeString(data.replace(data.substring(c, closeIndex + 1), sb.toString()));
		StringBuilder sb1 = new StringBuilder();
		String stri = sb1.append(decodeString).toString();
		System.out.println(stri);
		return stri;
	}

	public String decodeStringUsingStack(String s) {
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
				String str = "";
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					str = stack.pop() + str;
				}
				int k = Integer.parseInt(str);
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

	// 2,3,7,5

}
