package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindMissingNumber {

	@Test
	public void test1() {
		int[] input = { 0, 1, 2, 3, 5 };
		Assert.assertEquals(findMissingNumber(input), 4);
	}

	@Test
	public void test2() {
		int[] input = { 0, 1, 2, 3, 4, 5 };
		Assert.assertEquals(findMissingNumber(input), -1);
	}

	@Test
	public void test3() {
		int[] input = { 1, 2, 3, 4 };
		Assert.assertEquals(findMissingNumber(input), 0);
	}

	@Test
	public void test4() {
		int[] input = { 0, 3, 2, 1 };
		Assert.assertEquals(findMissingNumber(input), -1);
	}

	/*
	 * 1. Iterate over the elements of the array.
	 * 2. Sort the Array.
	 * 3. If the iterator value is not equal to the value in the specific index
	 * 		a) return the index
	 * 4. Return -1 at the end
	 */

	// O(n)
	private int findMissingNumber(int[] input) {
		int length = input.length;
		Arrays.sort(input);
		for (int i = 0; i < length; i++) {
			if(input[i] !=i)
				return i;
		}
		return -1;
	}

	/*
	 * 1. Get the sum of n elements using Math (n * (n+1)/2).
	 * 2. Iterate over the elements of the array and add sum all the values.
	 * 3. If the difference of sum is not equal to the length of array:
	 * 		a) return the difference.
	 *		b) Return -1 at the end.
	 */

	// O (n)
	private int findMissingNumberUsingMath(int[] input) {
		int length = input.length;
		int totalSum = length * (length + 1) / 2;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		if (totalSum - sum != length)
			return totalSum - sum;
		return -1;
	}
}
