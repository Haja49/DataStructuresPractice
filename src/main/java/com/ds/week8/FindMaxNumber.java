package com.ds.week8;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class FindMaxNumber {

	@Test
	public void test1() {
		int num = 1996;
		Assert.assertEquals(9916, findMax(num));
	}
	
	@Test
	public void test2() {
		int num = 9793;
		Assert.assertEquals(9973, findMax(num));
	}
	
	@Test
	public void test3() {
		int num = 99916;
		Assert.assertEquals(99961, findMax(num));
	}

	/*
	 * 1. Convert the given number to char array
	 * 2. Initialize a int array of size 10 and add the position of each char in the array
	 * 3. Iterate through the char array and int array
	 * 		a) If the position is greater than the current position, swap the number and return it as int
	 * 4. Else, return num itself
	 */
	public int findMax(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		int[] positionArray = new int[10];
		for (int i = 0; i < digits.length; i++) {
			positionArray[digits[i] - '0'] = i;
		}
		for (int i = 0; i < digits.length; i++) {
			for (int k = 9; k > digits[i] - '0'; k--) {
				if (positionArray[k] > i) {
					char temp = digits[i];
					digits[i] = digits[positionArray[k]];
					digits[positionArray[k]] = temp;
					return Integer.valueOf(new String(digits));
				}
			}
		}
		return num;
	}
}
