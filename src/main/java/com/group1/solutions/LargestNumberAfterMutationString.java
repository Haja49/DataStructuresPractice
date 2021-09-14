package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class LargestNumberAfterMutationString {

	@Test
	public void test1() {
		String num = "132";
		int[] change = { 9, 8, 5, 0, 3, 6, 4, 2, 6, 8 };
		Assert.assertEquals("832", maximumNumber(num, change));
	}
	
	@Test
	public void test2() {
		String num = "9303332";
		int[] change = { 9, 8, 5, 0, 3, 6, 4, 2, 6, 8 };
		Assert.assertEquals("9393332", maximumNumber(num, change));
	}

	public String maximumNumber(String num, int[] change) {
		char[] number = num.toCharArray();
		boolean modified = false;
		for (int i = 0; i < number.length; i++) {
			int temp = number[i] - '0';
			if (temp < change[number[i] - '0']) {
				number[i] = (char) (change[number[i] - '0'] + '0');
				modified = true;
			} else if (temp == change[number[i] - '0']) {
				continue;
			} else {
				if (modified) {
					break;
				}
			}
		}
		System.out.println(String.valueOf(number));
		return String.valueOf(number);
	}
}
