package week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class SingleNumber {

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[]
	 *    What is the expected output? int
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
		int[] input = {1, 2, 2};
		Assert.assertEquals(findSingleNumber(input), 1);
	}

	@Test
	public void test2() {
		int[] input = {4, 1, 2, 1, 2};
		Assert.assertEquals(findSingleNumber(input), 4);
	}

	@Test
	public void test3() {
		int[] input = {4, 1, -1, 1, 4};
		Assert.assertEquals(findSingleNumber(input), -1);
	}
	
	@Test
	public void test4() {
		int[] input = {2, 2, 3, 3, 4, 5, 5, 6, 6};
		Assert.assertEquals(findSingleNumberUsingBS(input), 4);
	}

	@Test
	public void test5() {
		int[] input = {1, 2, 2, 3, 3};
		Assert.assertEquals(findSingleNumberUsingBS(input), 1);
	}

	@Test
	public void test6() {
		int[] input = {2, 2, 3, 3, 4, 4, 5, 5, 6};
		Assert.assertEquals(findSingleNumberUsingBS(input), 6);
	}

	/*
	 * 1. Iterate through the length of array
	 * 2. Initialize an output variable
	 * 3. Perform XOR operation between the output and the input array values
	 * 		a) If both values are same, XOR will return 0
	 * 		b) Else will return the sum.
	 */
	// Time ==> O(n)
	// Space ==> O(1)
	private int findSingleNumber(int[] input) {
		int output = 0;
		for (int i = 0; i < input.length; i++) {
			output ^= input[i];
		}
		return output;
	}

	/*
	 * 1. Find the occurrence of each element in the input array using Map
	 * 2. Iterate through the map and if occurrence of element is 1, return the key
	 * 		a) else return -1;
	 */
	private int findSingleNumberUsingMap(int[] input) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], map.getOrDefault(input[i], 0) + 1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return -1;
	}

	private int findSingleNumberUsingBS(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1])
				low = mid + 2;
			else
				high = mid;
		}
		return nums[low];
	}

}
