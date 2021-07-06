package week1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveElement {

	/*
	 * Brute Force
	 * 
	 * 1. Iterate thorugh the array 
	 * 2. Verify if target matches the value within array 
	 * 		a) get the count of matches. 
	 * 		b) create a new array with target - count
	 * 3. If target matches the value, add remaining values to a new Array 
	 * 4. Return the new array
	 */

	@Test
	public void test1() {
		int[] input = { 2, 3, 3, 4, 5 };
		int target = 3;
		Assert.assertEquals(removeElement(input, target), new int[] {2, 4, 5});
	}

	@Test
	public void test2() {
		int[] input = { 5, 5, 5, 5 };
		int target = 5;
		Assert.assertEquals(removeElement(input, target), new int[] {});
	}

	@Test
	public void test3() {
		int[] input = { 2, 3, 3, 4, 5 };
		int target = 6;
		Assert.assertEquals(removeElement(input, target), new int[] {2, 3, 3, 4, 5 });
	}

	// Two Pass --> O (2n)
	private int[] removeElement(int[] input, int target) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == target) {
				count++;
			}
		}
		if (count == 0)
			return input;
		int[] output = new int[input.length - count];
		count = 0;
		for (int i = 0; i < input.length; i++) {
			if (target != input[i])
				output[count++] = input[i];
		}
		return output;
	}

}
