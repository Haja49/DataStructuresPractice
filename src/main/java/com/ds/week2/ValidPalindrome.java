package com.ds.week2;

import org.junit.Test;

import junit.framework.Assert;

public class ValidPalindrome {

	@Test
	public void test1() {
		String s = "aba";
		Assert.assertEquals(true, validPalindrome(s));
	}
	
	@Test
	public void test2() {
		String s = "abc";
		Assert.assertEquals(false, validPalindrome(s));
	}
	
	@Test
	public void test3() {
		String s = "ababbab";
		Assert.assertEquals(true, validPalindrome(s));
	}
	
	/*
	 * 1. If length of String is <=1, return true
	 * 2.Initialize 2 pointers, left at 0, right at length -1
	 * 3. While left is less than right,
	 * 		a) if left value is not equal to right value, break
	 * 		b) increment left, decrement right
	 * 4. if false, Remove the last element and repeat step 3
	 * 5. if false, Remove the first element and repeat step 3
	 */
	public boolean validPalindrome(String s) {
		if (s.length() <= 1)
			return true;
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				break;
			left++;
			right--;
		}
		while (left < right - 1) {
			if (s.charAt(left) != s.charAt(right - 1))
				break;
			left++;
			right--;
		}
		while (left + 1 < right) {
			if (s.charAt(left + 1) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
