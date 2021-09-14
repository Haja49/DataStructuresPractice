package com.ds.week7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzz {
	
	/*
	 * Input: int
	 * Output: String[]
	 * Constraint: To solve using HashMap and Two pointer
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * 
	 */

	@Test
	public void test1() {
		int n=15;
		Assert.assertArrayEquals(new String[] {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"}, findFizzBuzz(n));
	}
	
	@Test
	public void test2() {
		int n=2;
		Assert.assertArrayEquals(new String[] {"1","2"}, findFizzBuzz(n));
	}
	
	@Test
	public void test3() {
		int n=3;
		Assert.assertArrayEquals(new String[] {"1","2","Fizz"}, findFizzBuzz(n));
	}

	/*
	 * Pseduocode
	 * 1. Initialize a map and put 3 as Fizz and 5 as Buzz
	 * 2. Initialize a String array of size equal to n
	 * 3. Initialize 2 pointers, left = 1 and right=n
	 * 3. Iterate till left crosses n
	 * 		a) If the current value is divisible by 3, get the value of 3 from map and add it to String array
	 * 		b) If the current value is divisible by 5, get the value of 5 from map and add it to String array
	 * 		c) If the current value is divisible by 3 & 5, get the value of 3 and 5 from map, append it and add it to String array
	 * 4. Return the String array
	 */
	private String[] findFizzBuzz(int n) {
		Map<Integer, String> fizzBuzzMap = new HashMap<Integer, String>();
		fizzBuzzMap.put(3, "Fizz");
		fizzBuzzMap.put(5, "Buzz");
		String[] output = new String[n];
		int left = 0, right = n - 1, leftValue = 1, rightValue = n;
		while (left <= right) {
			if (leftValue % 3 == 0 && leftValue % 5 == 0) {
				output[left++] = fizzBuzzMap.get(3) + fizzBuzzMap.get(5);
			} else if (leftValue % 5 == 0) {
				output[left++] = fizzBuzzMap.get(5);
			} else if (leftValue % 3 == 0) {
				output[left++] = fizzBuzzMap.get(3);
			} else
				output[left++] = String.valueOf(leftValue);
			leftValue++;
			if (rightValue % 3 == 0 && rightValue % 5 == 0) {
				output[right--] = fizzBuzzMap.get(3) + fizzBuzzMap.get(5);
			} else if (rightValue % 5 == 0) {
				output[right--] = fizzBuzzMap.get(5);
			} else if (rightValue % 3 == 0) {
				output[right--] = fizzBuzzMap.get(3);
			} else
				output[right--] = String.valueOf(rightValue);
			rightValue--;
		}

		return output;
	}
}
