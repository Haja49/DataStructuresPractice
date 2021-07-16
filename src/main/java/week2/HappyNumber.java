package week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumber {

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
		int input = 19;
		Assert.assertEquals(findHappyNumber(input), true);
	}

	@Test
	public void test2() {
		int input = 2;
		Assert.assertEquals(findHappyNumber(input), false);
	}
	
	@Test
	public void test3() {
		int input = 25;
		Assert.assertEquals(findHappyNumber(input), false);
	}

	/*
	 * 1. Initialize a Hash set and a variable with 0
	 * 2. Add the input to set and find the sum of squares of given number
	 * 3. If sum is equal to 1
	 * 		a) return true
	 * 		b) else, assign the value of sum to input and set the input again to set
	 * 4. Continue the iteration until the original input is duplicated and return false
	 */
	private boolean findHappyNumber(int input) {
		Set<Integer> set = new HashSet<Integer>();
		int sum;
		while (set.add(input)) { //O(n)
			sum = 0;
			while (input > 0) { //O(logn)
				int rem = input % 10;
				input = input / 10;
				sum += rem * rem;
			}
			if (sum == 1)
				return true;
			else
				input = sum;
		}
		return false;
	}
	
	public int sumOfDigits(int input) {
        int totalSum = 0;
        while (input > 0) {
            int mod = input % 10;
            input = input / 10;
            totalSum += mod * mod;
        }
        return totalSum;
    }

    public boolean findHappyNumberUsingTwoPointer(int input) {
        int slow = input;
        int fast = sumOfDigits(input);
        while (fast != 1 && slow != fast) {
        	slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
        }
        return fast == 1;
    }

}
