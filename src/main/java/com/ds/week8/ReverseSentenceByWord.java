package com.ds.week8;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseSentenceByWord {

	/*
	 * Reverse the given sentence by its words.
	 * 
	 * Input: today is beautiful day
	 * Output: day beautiful is today
	 */
	
	/*
	 * Input: String
	 * Output: String
	 */
	
	/*
	 * Psuedocode:
	 * 
	 * 1. Split the String with space
	 * 2. Initialize 2 pointers, left at 0, right at array length-1
	 * 3. While left < right
	 * 		a) swap left and right;
	 * 4. Initialize a String builder and append each word with space in between
	 * 5. Return the string
	 */
	
	@Test
	public void test1() {
		String str = "today is beautiful day";
		Assert.assertEquals("day beautiful is today", reverseSentence(str));
	}

	private String reverseSentence(String str) {
		String[] words = str.split(" ");
		int left = 0, right = words.length - 1;
		while (left < right) {
			String temp = words[left];
			words[left++] = words[right];
			words[right--] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]).append(" ");
		}
		return sb.toString().trim();
	}
	
	private String reverseSentenceUsingSpace(String str) {
		String[] words = str.split(" ");
		int left = 0, right = words.length - 1;
		while (left < right) {
			String temp = words[left];
			words[left++] = words[right];
			words[right--] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]).append(" ");
		}
		return sb.toString().trim();
	}
	
}
