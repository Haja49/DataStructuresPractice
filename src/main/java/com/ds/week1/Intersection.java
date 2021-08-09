package com.ds.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class Intersection {

	/*
	 * 3) Given two integer arrays nums1 and nums2, return an array of their intersection. 
	 * 	  Each element in the result must be unique and you may return the result in any order.
	 * 		Example 1:
	 * 		Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 *		Output: [2]
	 */

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? 
	 *    2 inputs => both are int[], int[]
	 *    What is the expected output? int[]
	 *    Do I have constraints to solve the problem?
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
		int[] input1 = { 1, 2, 3 };
		int[] input2 = { 1, 2, 4, 6, 2 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[]{1, 2});
	}

	@Test
	public void test2() {
		int[] input1 = { 1, 2, 3 };
		int[] input2 = { 6, 5, 4 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[]{});
	}

	@Test
	public void test3() {
		int[] input1 = { 14, 8, 3 };
		int[] input2 = { 8, 14, 8, 12, 6 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[]{14, 8});
	}

	@Test
	public void test4() {
		int[] input1 = { 1, 2, 4, 6, 2 };
		int[] input2 = { 1, 2, 3 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[]{1, 2});
	}

	@Test
	public void test5() {
		int[] input1 = {};
		int[] input2 = { 1, 2, 3 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[] {});
	}
	
	@Test
	public void test6() {
		int[] input1 = {1, 2, 3};
		int[] input2 = { 1, 2, 3 };
		Assert.assertEquals(intersectionUsingTwoPointer(input1, input2), new int[] {1, 2, 3});
	}

	/*
	 *	1. If the size of any input is 0, return empty array
	 *	2. Initialize an empty array with size of input array.
	 *	3. Compare the array elements and add it to a list if it is not present in list
	 *		a) Also add it to the output array 
	 *	4. Finally return the output array with only the size based on the list
	 */
	
	/*
	 * Time Complexity - O(n^2)
	 * Space Complexity - O(n)
	 */
	private int[] intersection(int[] input1, int[] input2) {
		if (input1.length == 0 || input2.length == 0)
			return new int[] {};
		int[] output = new int[input1.length];
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input2.length; j++) {
				if (input1[i] == input2[j] && !list.contains(input1[i])) {
					output[count++] = input1[i];
					list.add(input1[i]);
				}
			}
		}
		return Arrays.copyOf(output, count);
	}
	
	private int[] intersection1(int[] input1, int[] input2) {
		if (input1.length == 0 || input2.length == 0)
			return new int[] {};
		Arrays.sort(input1);
		Arrays.sort(input2);
		int i = 0;
		int j = 0;
		Set<Integer> set = new HashSet<Integer>();
		while (i < input1.length && j < input2.length) {
			if (input1[i] == input2[j]) {
				set.add(input1[i]);
				i++;
				j++;
			} else if (input1[i] < input2[j])
				i++;
			else
				j++;
		}

		List<Integer> list = new ArrayList<Integer>(set);
		int[] output = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			output[k] = list.get(k);
		}
		return output;
	}


	// O(2n)
	private int[] intersection2(int[] input1, int[] input2) {
		Set<Integer> list = new HashSet<Integer>();
		for (int i = 0; i < input1.length; i++) {
			list.add(input1[i]);
		}
		int[] output = new int[list.size()];
		int count = 0;
		for (int i = 0; i < input2.length; i++) {
			if(input1[i] == input2[i])
				output[count++] = input2[i];
		}
		return Arrays.copyOf(output, count);
	}
	
	/*
	 * 1. Sort the Given input arrays
	 * 2. Initialize an output array of size equal to the min of length of input arrays
	 * 3. Initialize 2 pointers for the 2 arrays
	 * 4. while the length of either of array is less than pointer value,
	 * 		a) If the value of both pointer elements are equal
	 * 			i) add the value to output array and increment both pointers
	 * 		b) Else if 1st pointer element is less than 2nd pointer element
	 * 			ii) increment 1st pointer
	 * 		c) Else increment 2nd pointer
	 * 5. Finally return the output array of size equal to the count
	 */
	private int[] intersectionUsingTwoPointer(int[] input1, int[] input2) {
		if (input1.length == 0 || input2.length == 0)
			return new int[] {};
		Arrays.sort(input1);
		Arrays.sort(input2);
		int[] output = new int[Math.min(input1.length, input2.length)];
		int left1 = 0, left2 = 0;
		int count = 0;
		while (left1 < input1.length && left2 < input2.length) {
			if(input1[left1]==input2[left2]) {
				output[count++] = input2[left2++];
				left1++;
			} else if (input1[left1] < input2[left2])
				left1++;
			else
				left2++;
		}
		return Arrays.copyOf(output, count);
	}

}
