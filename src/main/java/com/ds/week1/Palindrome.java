package com.ds.week1;

import org.junit.Test;

import junit.framework.Assert;

public class Palindrome {
	
	/*
	 * 1) Given an integer x, return true if x is palindrome integer.
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
		int input = 121;
		Assert.assertEquals(checkPalindromeAsString(input), true);
	}

	@Test
	public void test2() {
		int input = 1234421;
		Assert.assertEquals(checkPalindromeAsString(input), false);
	}

	@Test
	public void test3() {
		int input = 2147483647;
		Assert.assertEquals(checkPalindromeAsString(input), false);
	}
	
	@Test
	public void test4() {
		int input = 010;
		Assert.assertEquals(checkPalindromeAsString(input), true);
	}

	/*
	 * 1. Store the number in a temporary variable for future reference
	 * 2. If number is greater than 0, Reverse the number
	 * 		a) by performing mod and div operation
	 * 3. Compare the reversed number with the reference taken earlier
	 * 		a) if both matches, return true
	 * 		b) Else, return false
	 */
	
	// O(n)
	private boolean checkPalindrome(int input) {
		int rev = 0;
		int temp = input;
		while (input > 0) {
			rev = (rev * 10) + input % 10;
			input /= 10;
		}
		return rev == temp;
	}
	
	private boolean checkPalindromeAsString(int input) {
		if (input < 0) {
			return false;
		}
		String rev = "";
		String originalValue = String.valueOf(input);
		for (int i = originalValue.length() - 1; i >= 0; i--) {
			rev += originalValue.charAt(i);
		}
		return rev.equals(originalValue);
	}
}
