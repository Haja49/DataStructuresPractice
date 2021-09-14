package com.ds.week8;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveDuplicateCharacters {

	/*
	 * 	Question 4:
	You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together. We repeatedly make k duplicate removals on s until we no longer can.
	Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
	 
	Example 1:
	Input: s = "abcd", k = 2
	Output: "abcd"
	Explanation: There's nothing to delete.
	Example 2:
	Input: s = "deeedbbcccbdaa", k = 3
	Output: "aa"
	Explanation: 
	First delete "eee" and "ccc", get "ddbbbdaa"
	Then delete "bbb", get "dddaa"
	Finally delete "ddd", get "aa"
	Example 3:
	Input: s = "pbbcggttciiippooaais", k = 2
	Output: "ps"
	 */
	
	@Test
	public void test1() {
		String s= "deeedbbcccbdaa";
		int k =3;
		Assert.assertEquals("aa", removeDuplicates(s, k));
	}
	
	@Test
	public void test2() {
		String s= "abcd";
		int k =2;
		Assert.assertEquals("abcd", removeDuplicates(s, k));
	}
	
	@Test
	public void test3() {
		String s= "pbbcggttciiippooaais";
		int k =2;
		Assert.assertEquals("ps", removeDuplicates(s, k));
	}

	private String removeDuplicates(String s, int k) {
		Stack<Character> chStack = new Stack<Character>();
		Stack<Integer> countStack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!chStack.isEmpty() && chStack.peek() == s.charAt(i)) {
				countStack.push(countStack.peek() + 1);
			} else
				countStack.push(1);
			chStack.push(s.charAt(i));
			if (countStack.peek() == k) {
				for (int j = 0; j < k; j++) {
					chStack.pop();
					countStack.pop();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character ch : chStack) {
			sb.append(ch);
		}
		return sb.toString();
	}
}
