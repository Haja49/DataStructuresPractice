package com.ds.week2;

import org.junit.Test;

import junit.framework.Assert;

public class Calories {

	/*
	 * 
	 * A dieter consumes calories[i] calories on the i-th day. For every consecutive
	 * sequence of k days, they look at T, the total calories consumed during that
	 * sequence of k days:
	 * 
	 * If T < lower, they performed poorly on their diet and lose 1 point; If T >
	 * upper, they performed well on their diet and gain 1 point; Otherwise, they
	 * performed normally and there is no change in points. Return the total number
	 * of points the dieter has after all calories.length days.
	 * 
	 * Note that: The total points could be negative.
	 * 
	 * Example 1: Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3 Output:
	 * 0 Explaination: calories[0], calories[1] < lower and calories[3], calories[4]
	 * > upper, total points = 0.
	 * 
	 * Example 2: Input: calories = [3,2], k = 2, lower = 0, upper = 1 Output: 1
	 * Explaination: calories[0] + calories[1] > upper, total points = 1.
	 * 
	 * Example 3: Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5 Output: 0
	 * Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] <
	 * lower, total points = 0
	 * 
	 * 1) Did I understand the problem? Yes -> If yes, go to next step !!
	 * 
	 * What is the input(s)? int[], int, int, int What is the expected output? int
	 * Do I have constraints to solve the problem? Do I have all informations to go
	 * to next step!! How big is your test data set will be?
	 * 
	 * 2) Test data set
	 * 
	 * Minimum of 3 data set !! Positive, Edge, Negative Validate with the
	 * interviewer if the data set is fine by his/her assumptions
	 * 
	 * 3) Do I know how to solve it?
	 * 
	 * Yes - great, is there an alternate?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 * 
	 * 5) Do I know alternate solutions as well? No
	 * 
	 * No - That is still fine, proceed to solve by what you know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * Then, explain either both or the best (depends on the time)
	 * 
	 * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * Approach 2: Write down the options and benefits and code the best
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
		int[] calories = { 1, 2, 3, 4, 5 };
		int k = 1;
		int lower = 3;
		int upper = 3;
		Assert.assertEquals(getCalories(calories, k, lower, upper), 0);
	}

	@Test
	public void test2() {
		int[] calories = { 3, 2 };
		int k = 2;
		int lower = 0;
		int upper = 1;
		Assert.assertEquals(getCalories(calories, k, lower, upper), 1);
	}

	@Test
	public void test3() {
		int[] calories = { 6, 5, 0, 0, 0 };
		int k = 2;
		int lower = 1;
		int upper = 5;
		Assert.assertEquals(getCalories(calories, k, lower, upper), -1);
	}

	@Test
	public void test4() {
		int[] calories = { 6, 5, 6, 5 };
		int k = 2;
		int lower = 1;
		int upper = 5;
		Assert.assertEquals(getCalories(calories, k, lower, upper), 3);
	}

	/*
	 * 1. Iterate till k and get the sum 2. If sum is less than lower, decrement
	 * counter a) else if greater, increment counter 3. Iterate through the length
	 * of array from k 4. Remove first element and add k+1 5. If sum is less than
	 * lower, decrement counter a) else if greater, increment counter 6. Finally
	 * return count
	 */

	private int getCalories(int[] calories, int k, int lower, int upper) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i <= k - 1; i++) {
			sum += calories[i];
		}
		if (sum < lower)
			count--;
		else if (sum > upper)
			count++;
		for (int i = k; i < calories.length; i++) {
			sum += calories[i] - calories[i - k];
			if (sum < lower)
				count--;
			else if (sum > upper)
				count++;
		}
		return count;
	}

}
