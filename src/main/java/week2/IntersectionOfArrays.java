package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfArrays {

	/*
	 * 2) Given two integer arrays nums1 and nums2, return an array of their intersection. 
	 * 	Each element in the result must appear as many times as it shows in both arrays and
	 *  you may return the result in any order
	 */

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
	 *    What is the expected output? int[]
	 *    Do I have constraints to solve the problem? 1 <= nums1.length, nums2.length <= 1000
	 *    											  0 <= nums1[i], nums2[i] <= 1000
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
		int[] input1 = { 1, 2, 2, 1 };
		int[] input2 = { 2, 2 };
		Assert.assertArrayEquals(intersection(input1, input2), new int[] { 2, 2 });
	}

	@Test
	public void test2() {
		int[] input1 = { 1, 2, 3 };
		int[] input2 = { 4, 5, 6 };
		Assert.assertArrayEquals(intersection(input1, input2), new int[] { });
	}
	
	@Test
	public void test3() {
		int[] input1 = {};
		int[] input2 = { 1, 2, 3 };
		Assert.assertArrayEquals(intersection(input1, input2), new int[] {});
	}
	
	@Test
	public void test4() {
		int[] input1 = { 1, 2, 3, 2 };
		int[] input2 = { 1, 2, 3, 2 };
		Assert.assertArrayEquals(intersection(input1, input2), new int[] { 1, 2, 2, 3 });
	}

	/*
	 * 1. Sort the Given input arrays
	 * 2. Initialize a list
	 * 3. Initialize 2 pointers for the 2 arrays
	 * 4. while the length of either of array is less than pointer value,
	 * 		a) If the value of both pointer elements are equal
	 * 			i) add the value to list and increment both pointers
	 * 		b) Else if 1st pointer element is less than 2nd pointer element
	 * 			i) increment 1st pointer
	 * 		c) Else increment 2nd pointer
	 * 5. Convert the list to array and return it
	 */
	
	// Time Complexity ==> O(nlogn)
	// Space Complexity ==> O(n)
	public int[] intersectionUsingTwoPointers(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] output = new int[Math.min(nums1.length, nums2.length)];
		int left1 = 0;
		int left2 = 0;
		int count = 0;
		// List<Integer> list = new ArrayList<Integer>();
		while (left1 < nums1.length && left2 < nums2.length) {
			if (nums1[left1] == nums2[left2]) {
				// list.add(nums1[i++]);
				output[count++] = nums1[left1++];
				left2++;
			} else if (nums1[left1] < nums2[left2]) {
				left1++;
			} else {
				left2++;
			}
		}
		/* int[] output = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			output[i] = list.get(i);
		}
		return output*/
		return Arrays.copyOf(output, count);
	}
	
	/*
	 *	1. If the size of any input is 0, return empty array
	 *	2. Initialize an empty array with size of minimum length of both arrays.
	 *	3. Compare the array elements and add it to the output array 
	 *	4. Finally return the output array with only the size based on the list
	 */
	
	/*
	 * Time Complexity - O(n^2)
	 * Space Complexity - O(n)
	 */
	private int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		int[] output = new int[Math.min(nums1.length, nums2.length)];
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					output[count++] = nums1[i];
					list.add(nums1[i]);
					break;
				}
			}
		}
		return Arrays.copyOf(output, count);
	}

}
