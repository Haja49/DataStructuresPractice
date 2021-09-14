package com.ds.week8;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class TruckBoxes {

	/*
	 * You are assigned to put some amount of boxes onto one truck. You are given a
	 * 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi,
	 * numberOfUnitsPerBoxi]:
	 * 
	 * numberOfBoxesi is the number of boxes of type i. numberOfUnitsPerBoxi is the
	 * number of units in each box of the type i. You are also given an integer
	 * truckSize, which is the maximum number of boxes that can be put on the truck.
	 * You can choose any boxes to put on the truck as long as the number of boxes
	 * does not exceed truckSize.
	 * 
	 * Return the maximum total number of units that can be put on the truck.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4 Output: 8 Explanation:
	 * There are: - 1 box of the first type that contains 3 units. - 2 boxes of the
	 * second type that contain 2 units each. - 3 boxes of the third type that
	 * contain 1 unit each. You can take all the boxes of the first and second
	 * types, and one box of the third type. The total number of units will be = (1
	 * * 3) + (2 * 2) + (1 * 1) = 8. Example 2:
	 * 
	 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10 Output: 91
	 */

	/*
	 * Input: 2D int[], int Output: int
	 * 
	 * 
	 */

	@Test
	public void test1() {
		int[][] boxTypes = {  { 2, 2 }, { 1, 3 },{ 3, 1 } };
		int truckSize = 4;
		Assert.assertEquals(8, findNumberOfBoxes(boxTypes, truckSize));
	}

	@Test
	public void test2() {
		int[][] boxTypes = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
		int truckSize = 10;
		Assert.assertEquals(91, findNumberOfBoxes(boxTypes, truckSize));
	}

	@Test
	public void test3() {
		int[][] boxTypes = { { 5, 10 }, { 2, 7 }, { 3, 9 } };
		int truckSize = 10;
		Assert.assertEquals(91, findNumberOfBoxes(boxTypes, truckSize));
	}
	
	@Test
	public void test4() {
		int[][] boxTypes = { { 5, 10 }, { 2, 7 }, { 3, 9 } };
		int truckSize = 0;
		Assert.assertEquals(0, findNumberOfBoxes(boxTypes, truckSize));
	}

	/*
	 * Pseudocode:
	 * 1. Iterate through 2D array and add each pair to a Tree map
	 * 2. Sort the values of map using comparator.
	 * 3. Iterate through the entry set
	 * 		a) keep adding the key until it reaches truckSize.
	 * 			i) if sum of keys exceeds truckSize, start decrementing the key by 1 until it becomes equal to
	 * 				truckSize.
	 * 		b) Also keep adding the key*values.
	 * 			i) if sum of keys exceeds truckSize, start decrementing the value by value times until 
	 * 				it becomes equal to truckSize.
	 * 4. Finally return sum;
	 * 
	 * 
	 * 1. Sort the 2D array based on 2nd value first and then 1st value.
	 * 2. Iterate through the array,
	 * 		a) keep adding the key until it reaches truckSize.
	 * 			i) if sum of keys exceeds truckSize, start decrementing the key by 1 until it becomes equal to
	 * 				truckSize.
	 * 		b) Also keep adding the key*values.
	 * 			i) if sum of keys exceeds truckSize, start decrementing the value by value times until 
	 * 				it becomes equal to truckSize. 
	 * 3. Finally return sum;
	 */

	//{ { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }
	private int findNumberOfBoxes(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < boxTypes.length; i++) {
			count += boxTypes[i][0];
			sum += (boxTypes[i][0] * boxTypes[i][1]);
			int temp = count;
			while (temp > truckSize) {
				count--;
				sum -= boxTypes[i][1];
				temp--;
			}
		}
		return sum;
	}
}
