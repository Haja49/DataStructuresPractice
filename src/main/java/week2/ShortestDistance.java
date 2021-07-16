package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistance {

	/*
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? String, char
	 *    What is the expected output? int[]
	 *    Do I have constraints to solve the problem?
	 *    1 <= s.length <= 104
		  s[i] and c are lowercase English letters.
		  It is guaranteed that c occurs at least once in s
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
		String s = "loveleetcode";
		char c = 'e';
		Assert.assertArrayEquals(shortestDistance(s, c), new int[] { 3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0 });
	}

	@Test
	public void test2() {
		String s = "abaa";
		char c = 'b';
		Assert.assertArrayEquals(shortestDistance(s, c), new int[] { 1, 0, 1, 2 });
	}

	/*
	 * Brute Force
	 * 1. Initiate an output array of size equal to length of input string.
	 * 2. Initialize and integer with value equal to half of min int value
	 * 3. Iterate from 0 to n-1,
	 * 		if the current char is equal to the target, set the previous value as i
	 * 		Add the diff of i and previous value to output array
	 * 4. Reset the value of previous value to half of max int value
	 * 		if the current char is equal to the target, set the previous value as i
	 * 		Get the min of, diff of previous and i value to output array and current value in output array
	 * 		and add it to output array
	 */
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 */
	private int[] shortestDistance(String s, char c) {
		int n = s.length();
		int[] output = new int[n];
		int prevValue = -Integer.MIN_VALUE/2;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c)
				prevValue = i;
			output[i] = i - prevValue;
		}
		prevValue = Integer.MAX_VALUE/2;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == c)
				prevValue = i;
			output[i] = Math.min(output[i], prevValue - i);
		}
		System.out.println(Arrays.toString(output));
		return output;
	}

	public int[] shortestDistanceUsingIndex(String s, char c) {

		int[] result = new int[s.length()];
		for (int i = 0; i < result.length; i++) {
			String substring = s.substring(0, i);
			String substring2 = s.substring(i);
			int left = substring.lastIndexOf(c);
			int right = substring2.indexOf(c);

			if (left > -1 && right > -1)
				result[i] = Math.min(i - left, right);
			else if (left > -1)
				result[i] = i - left;
			else
				result[i] = right;
		}

		return result;
	}
}
