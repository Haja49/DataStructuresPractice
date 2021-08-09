package com.ds.week2;

import org.junit.Test;

import junit.framework.Assert;

public class CustomerSatisfaction {

	/*
	 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
	 * 
	 * 
	 * 1) Did I understand the problem? Yes 
	 * 		-> If yes, go to next step !!
	 * 
	 *    What is the input(s)? int[], int[], int
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
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		int[] grumpy =    { 0, 1, 0, 1, 0, 1, 0, 1 };
		int x = 3;
		Assert.assertEquals(16, getSatisfiedCustomers(customers, grumpy, x));
	}

	@Test
	public void test2() {
		int[] customers = { 1, 0, 1, 2, 1, 0, 0, 0 };
		int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int x = 3;
		Assert.assertEquals(5, getSatisfiedCustomers(customers, grumpy, x));
	}

	@Test
	public void test3() {
		int[] customers = { 4, 10, 10 };
		int[] grumpy = { 1, 1, 0 };
		int x = 2;
		Assert.assertEquals(24, getSatisfiedCustomers(customers, grumpy, x));
	}

	/*
	 *	1. Iterate through the minutes and sum the customers when the owner is grumpy
	 *	2. Set the sum as max
	 *	3. Iterate through the customer array,
	 *		a) if grumpy, add the next customer to sum
	 *		b) sub the previous customer
	 *		c) get the max of sum and store it in max
	 *	4. Iterate thorugh the customer array and add remaining customers when owner is not grumpy
	 */

	private int getSatisfiedCustomers(int[] customers, int[] grumpy, int x) {
		int sum = 0;
		for (int i = 0; i < x; i++) {
			if (grumpy[i] == 1) {
				sum += customers[i];
			}
		}
		int maxSum = sum;
		for (int i = x; i < customers.length; i++) {
			if (grumpy[i] == 1) {
				sum += customers[i];
			}
			if (grumpy[i - x] == 1) {
				sum -= customers[i - x];
			}
			maxSum = Math.max(maxSum, sum);
		}
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0)
				maxSum += customers[i];
		}
		return maxSum;
	}
}
