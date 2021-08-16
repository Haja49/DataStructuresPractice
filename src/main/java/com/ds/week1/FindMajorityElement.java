package com.ds.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class FindMajorityElement {
	
	/*
	 * 2) Given an array nums of size n, return the majority element. 
	 * 	  You may assume that the majority element always exists in the array.
	 * 	  The majority element is the element that appears more than [n/2] times.
	 */
	
	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)?
	 *    What is the expected output?
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
		int[] input = {2, 1, 2, 2, 3, 4, 2};
		Assert.assertEquals(findMajorityElementUsingMap1(input), 2);
	}

	@Test
	public void test2() {
		int[] input = {2, 3, 4};
		Assert.assertEquals(findMajorityElementUsingMap1(input), -1);
	}

	@Test
	public void test3() {
		int[] input = {2, 2, 3, 4};
		Assert.assertEquals(findMajorityElementUsingMap1(input), -1);
	}

	@Test
	public void test4() {
		int[] input = {2};
		Assert.assertEquals(findMajorityElementUsingMap1(input), 2);
	}
	
	@Test
	public void test5() {
		int[] input = {};
		Assert.assertEquals(findMajorityElementUsingMap1(input), -1);
	}

	/*
	 * 1. Get the length of the Array and iterate through half of its length
	 * 2. Initialize a counter and compare with the remaining elements of array
	 * 3. If the count is more than half of the length, return the number
	 * 4. Else, return -1
	 */

	// O(n^2)
	private int findMajorityElement(int[] input) {
		int length = input.length;
		int count = 1;
		for (int i = 0; i <= length / 2; i++) {
			for (int j = i + 1; j < length; j++) {
				if (input[j] == input[i]) {
					count++;
				}
			}
			if (count > length / 2) {
				return input[i];
			}
			count = 1;
		}
		return -1;
	}

	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array and add them to map with value of its count.
	 * 3. For every entry in the map:
	 * 		a) If the value is greater than half of its length, return the key.
	 *		b) Else, return -1.
	 */

	// O(n) ==> 2 Pass
	private int findMajorityElementUsingMap(int[] input) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i]))
				map.put(input[i], map.get(input[i]) + 1);
			else
				map.put(input[i], 1);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > input.length / 2)
				return entry.getKey();
		}
		return -1;
	}
	
	//O(n) ==> Single Pass
	private int findMajorityElementUsingMap1(int[] input) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], map.getOrDefault(input[i], 0) + 1);
			if (map.get(input[i]) > input.length / 2)
				return input[i];
		}

		return -1;
	}
	
	//Boyer-Moore
	// mid and mid+1
}
