package com.ds.week3;

import org.junit.Test;

import junit.framework.Assert;

public class BiggestCharacter {

	/*
	 * Given a sorted character array and a target character, find the next biggest
	 * character in the array. char[] cha = {‘b’, ‘d’ , ‘h’}; char k = ‘e’ Output ->
	 * h
	 */

	@Test
	public void test1() {
		char[] input = { 'b', 'd', 'h' };
		char k = 'e';
		Assert.assertEquals('h', nextBiggestCharacterUsingBS(input, k));
	}

	@Test
	public void test2() {
		char[] input = { 'b', 'd', 'h' };
		char k = 'h';
		Assert.assertEquals(' ', nextBiggestCharacterUsingBS(input, k));
	}

	@Test
	public void test3() {
		char[] input = { 'b', 'd', 'h' };
		char k = 'd';
		Assert.assertEquals('h', nextBiggestCharacterUsingBS(input, k));
	}

	@Test
	public void test4() {
		char[] input = { 'b', 'c', 'd', 'e', 'h' };
		char k = 'b';
		Assert.assertEquals('c', nextBiggestCharacterUsingBS(input, k));
	}

	private char nextBiggestCharacter(char[] input, char k) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] > k)
				return input[i];
		}
		return ' ';
	}

	private char nextBiggestCharacterUsingBS(char[] input, char k) {
		int low = 0, high = input.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (input[mid] == k && mid!=high)
				return input[mid + 1];
			else if (input[mid] < k)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return ' ';
	}

}
