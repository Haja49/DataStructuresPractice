package week2;

import org.junit.Assert;
import org.junit.Test;

public class SortColors {

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
		int[] input = { 2, 0, 2, 1, 1, 0 };
		Assert.assertArrayEquals(sortColors(input), new int[] { 0, 0, 1, 1, 2, 2 });
	}

	@Test
	public void test2() {
		int[] input = { 2, 0, 1 };
		Assert.assertArrayEquals(sortColors(input), new int[] { 0, 1, 2 });
	}

	@Test
	public void test3() {
		int[] input = { 0 };
		Assert.assertArrayEquals(sortColors(input), new int[] { 0 });
	}

	/*
	 * Initialize 3 variables (left=0,centre=1, right=length-1)
	 * While mid<=high
	 * 1. a[mid] = 0 swap low with mid , increment low and mid
	 * 2. a[mid] = 1  mid++;
	 * 3. a[mid] = 2 swap mid with high, decrement high 
	 */
	private int[] sortColors(int[] input) {
		int low=0, mid=0, high=input.length-1;
		int temp;
		while (mid<=high) {
			if(input[mid]==0) {
				temp = input[mid];
				input[mid++] = input[low];
				input[low++] = temp;
			} else if(input[mid]==1) {
				mid++;
			} else {
				temp = input[high];
				input[high--] = input[mid];
				input[mid] = temp;
			}
		}
		return input;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
