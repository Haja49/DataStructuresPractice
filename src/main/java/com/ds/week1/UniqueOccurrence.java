package com.ds.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class UniqueOccurrence {
	
	/*
	 * 5) Given an array of integers arr, write a function that returns true 
	 * if and only if the number of occurrences of each value in the array is unique.
	 *		Example 1:
	 *		Input: arr = [1,2,2,1,1,3]
	 *		Output: true
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
		int[] input = { 1, 2, 2, 1, 1, 3 };
		Assert.assertEquals(uniqueOccurrence(input), true);
	}

	@Test
	public void test2() {
		int[] input = { 1, 2, 3 };
		Assert.assertEquals(uniqueOccurrence(input), false);
	}

	@Test
	public void test3() {
		int[] input = { -1, 1, 2, 1, 1, 2, 0, 0, 2, 2 };
		Assert.assertEquals(uniqueOccurrence(input), true);
	}


	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array and add them to map with value of its count.
	 * 3. Initialize an empty HashSet.
	 * 4. Iterate through the map values and them to the HashSet
	 * 5. If size of map and set are equal:
	 * 		a) return true;
	 * 		b) Else, return false
	 */

	// O(n)
	private boolean uniqueOccurrence(int[] input) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i]))
				map.put(input[i], map.get(input[i]) + 1);
			else
				map.put(input[i], 1);
		}
		Set<Integer> set = new HashSet<Integer>(map.values());
		/*
		 * for (Entry<Integer, Integer> entry : map.entrySet()) {
		 * 		set.add(entry.getValue()); 
		 * }
		 */
		return set.size() == map.size();
	}
}
