package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MoveOddToEnd {

	/*
	 * Given an integer array, move all odd numbers to the right
	 */
	
	/*
	 * Input: int[]
	 * Output: int[]
	 * 
	 * 
	 * 
	 * Pseudocode:
	 * 1. Iterate through the length of the array
	 * 2. Initialize a variable (j) with value as -1
	 * 3. If mod of element is equal to 0
	 * 		a) Increment j and swap the values of i and j
	 * 
	 */
	
	@Test
	public void test1() {
		int[] input = {1, 8, 5, 9, 2};
		Assert.assertArrayEquals(moveOddToEndUsingTwoPointer(input), new int[] {8, 2, 5, 9, 1});
	}
	
	@Test
	public void test2() {
		int[] input = {6, 2};
		Assert.assertArrayEquals(moveOddToEndUsingTwoPointer(input), new int[] {6, 2});
	}
	
	@Test
	public void test3() {
		int[] input = {-2, 0, 4, -3};
		Assert.assertArrayEquals(moveOddToEndUsingTwoPointer(input), new int[] {-2, 0, 4, -3});
	}

	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private int[] moveOddToEnd(int[] arr) {
		int j = -1, temp;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				j++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	/*
	 * 1. Initialize 2 pointers, one at start and other at end
	 * 2. while left is less than right
	 * 		a) if mod of left is 0, increment left
	 * 		b) if mod of right is not 0, decrement right
	 * 		c) if mod of left input is not 0 and modof right input is 0, swap left input and right input
	 * 			and increment left, decrement right
	 */
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private int[] moveOddToEndUsingTwoPointer(int[] input) {
		int left = 0, right = input.length - 1;
		while (left < right) {
			if (input[left] % 2 == 0) {
				left++;
			} else if (input[right] % 2 != 0) {
				right--;
			} else if (input[left] % 2 != 0 && input[right] % 2 == 0) {
				int temp = input[left];
				input[left++] = input[right];
				input[right--] = temp;
			}
		}
		System.out.println(Arrays.toString(input));
		return input;
	}
	
	
}
