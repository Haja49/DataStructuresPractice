package com.ds.week1;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class SmallestNumbersCount {
	
	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
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
		int[] input = { 8, 1, 2, 2, 3 };
		Assert.assertEquals(findSmallestNumberCount2(input), new int[] { 4, 0, 1, 1, 3 });
	}

	@Test
	public void test2() {
		int[] input = { 6, 5, 4, 8 };
		Assert.assertEquals(findSmallestNumberCount2(input), new int[] { 2, 1, 0, 3 });
	}
	
	@Test
	public void test3() {
		int[] input = { 1, 1, 1 };
		Assert.assertEquals(findSmallestNumberCount2(input), new int[] { 0, 0, 0 });
	}

	/*
	 * 1. Get the length of the Array and iterate through its length
	 * 2. Create an output array of size equal to input array
	 * 3. Initialize a counter and compare elements of array
	 * 4. If the current element is greater than other elements
	 * 		a) Increment the counter
	 * 		b) At end of loop, add the counter value to output array
	 * 5. Finally return the output array
	 */

	// O(n^2)
	private int[] findSmallestNumberCount(int[] input) {
		int length = input.length;
		int[] output = new int[length];
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (input[i] > input[j]) {
					count++;
				}
			}
			output[i] = count;
			count = 0;
		}
		return output;
	}

	/*
	 * 1. Create an output array of size equal to input array
	 * 2. Initialize an empty HashMap and add the array elements to it
	 * 3. Copy array elements to temp array and sort it
	 * 4. Iterate through the temp array
	 * 		a) Add the values to map with key as array element and value as position
	 * 5. Iterate through input array
	 * 		a) Get the value of each element from Map
	 * 		b) Add it to output array
	 * 6. Finally return output array
	 */

	// O(nlogn) ==> 2 Pass
	private int[] findSmallestNumberCount1(int[] input) {
		int[] output = new int[input.length];
        int[] temp = new int[input.length];
        for(int i = 0; i < input.length; i++){
            temp[i] =  input[i];
        }
        
        Arrays.sort(temp);
        HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < temp.length; i++){ // O(n)
            if(!f.containsKey(temp[i])){ // O(1)
                f.put(temp[i], i); // O(1)
            }
        }
        
        for(int i = 0; i < input.length; i++){ // O(n)
        	output[i] = f.get(input[i]);
        }
        
        return output;
	}
	
	//O(n) ==> Multiple Passes
	private int[] findSmallestNumberCount2(int[] input) {
		int[] output = new int[input.length];
		int[] counter = new int[101];
		for (int num : input) {
			counter[num]++;
		}
		for (int i = 1; i < counter.length; i++) {
			counter[i] += counter[i - 1];
		}
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0)
				output[i] = 0;
			else
				output[i] = counter[input[i] - 1];
		}
		return output;
	}

}
