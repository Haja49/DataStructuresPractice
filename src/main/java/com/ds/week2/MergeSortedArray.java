package com.ds.week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray {

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]. int[], int, int
	 *    What is the expected output? int[]
	 *    Do I have constraints to solve the problem?
	 *    nums1.length == m + n
		  nums2.length == n
		  0 <= m, n <= 200
		  1 <= m + n <= 200
		  -109 <= nums1[i], nums2[j] <= 109
	 *    Do I have all informations to go to next step!!
	 *    How big is your test data set will be?
	 *    
	 * 2) Test data set
	 *  	
	 *  	Minimum of 3 data set !! Positive, Edge, Negative 
	 *      Validate with the interviewer if the data set is fine by his/her assumptions
	 * 
	 * 3) Do I know how to solve it?
	 * 		
	 * 		Yes - great, is there an alternate?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 *  
	 * 5) Do I know alternate solutions as well? No
	 * 
	 * 		No - That is still fine, proceed to solve by what you know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * 		Then, explain either both or the best (depends on the time)
	 * 
	 * 		Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * 		Approach 2: Write down the options and benefits and code the best 
	 * 
	 * 7) Start always with Psuedo code 
	 * 
	 * 8) Implement them in the code (editor)
	 * 
	 * 9) Test against the different data set 
	 * 
	 * 10) If it fails, debug them to solve it !!
	 * 
	 */

	@Test
	public void test1() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		Assert.assertArrayEquals(mergeSortedArrayUsingTwoPointer(nums1, m, nums2, n), new int[] { 1, 2, 2, 3, 5, 6 });
	}

	@Test
	public void test2() {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = {};
		int m = 3;
		int n = 0;
		Assert.assertArrayEquals(mergeSortedArrayUsingTwoPointer(nums1, m, nums2, n), new int[] { 1, 2, 3 });
	}
	
	@Test
	public void test4() {
		int[] nums1 = { 2, 3, 0, 0, 0, 0 };
		int[] nums2 = {1, 2, 5, 6};
		int m = 2;
		int n = 4;
		Assert.assertArrayEquals(mergeSortedArrayUsingTwoPointer(nums1, m, nums2, n), new int[] { 1, 2, 2, 3, 5, 6});
	}

	@Test
	public void test3() {
		int[] nums1 = { 0, 0 };
		int[] nums2 = { 1, 1 };
		int m = 0;
		int n = 2;
		Assert.assertArrayEquals(mergeSortedArrayUsingTwoPointer(nums1, m, nums2, n), new int[] { 1, 1 });
	}
	
	/*
	 * Brute Force
	 * 1. Iterate thorugh the length of 2nd array
	 * 2. Add them to the first array starting from index m
	 * 3. Sort the first array and return it
	 */
	private int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < nums2.length; i++) {
			nums1[i + m] = nums2[i];
		}
		Arrays.sort(nums1);
		return nums1;
	}

	/*
	 * Using Pointer
	 * 1. Initialize 3 pointers. 
	 * 		i with length of first array
	 * 		j with length of second array
	 * 		index with length of sum of both array
	 * 2. While i & j are greater than or equal to 0
	 * 		if num1[i] >= num2[j], add num1[i] to the last index of num1 and decrement i and index
	 * 		if num1[i] < num2[j], add num2[j] to the second last index of num1 and decrement j and index
	 * 3. While j becomes 0,
	 * 		add num2[j] to num1[index] and decrement j and index		
	 * 
	 */
	private int[] mergeSortedArrayUsingTwoPointer(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, index = m + n - 1;
		/*
		 * if(m==0) { return nums2; }
		 */	
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[index] = nums1[i--];
			} else {
				nums1[index] = nums2[j--];
			}
			index--;
		}
		while (j >= 0)
			nums1[index--] = nums2[j--];

		return nums1;
	}

}
