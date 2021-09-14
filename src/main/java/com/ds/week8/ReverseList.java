package com.ds.week8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseList {

	@Test
	public void test1() {
		List<Integer> input  = Arrays.asList(2, 4, 5, 3);
		Assert.assertTrue(reverseList(input).equals(Arrays.asList(3, 5, 4, 2)));
	}
	
	@Test
	public void test2() {
		List<Integer> input  = Arrays.asList(2, 4, 5, 3, 9);
		Assert.assertTrue(reverseList(input).equals(Arrays.asList(9, 3, 5, 4, 2)));
	}
	
	@Test
	public void test3() {
		List<Integer> input  = Arrays.asList(2, 3);
		Assert.assertTrue(reverseList(input).equals(Arrays.asList(3, 2)));
	}

	/*
	 * 1. Initialize 2 pointers left at 0, right at input size-1
	 * 2. while left < right
	 * 		a) swap left and right, increment left and decrement right
	 * 3. return input 
	 */
	// Time - (n)
	// Space - O(1)
	private List<Integer> reverseList(List<Integer> input) {
		int left = 0, right = input.size()-1;
		while (left<right) {
			int temp = input.get(left);
			input.set(left++, input.get(right));
			input.set(right--, temp);
		}
		return input;
	}
	
}
