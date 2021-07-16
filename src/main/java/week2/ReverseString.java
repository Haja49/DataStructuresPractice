package week2;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {

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
		String input = "ab-cd";
		Assert.assertEquals(reverseLetters(input), "dc-ba");
	}

	@Test
	public void test2() {
		String input = "ab-cd";
		Assert.assertEquals(reverseLetters(input), "dc-ba");
	}

	@Test
	public void test3() {
		String input = "ab-cd";
		Assert.assertEquals(reverseLetters(input), "dc-ba");
	}

	private String reverseLetters(String input) {
		StringBuilder ans = new StringBuilder();
		int j = input.length() - 1;
		for (int i = 0; i < input.length(); ++i) {
			if (Character.isLetter(input.charAt(i))) {
				while (!Character.isLetter(input.charAt(j)))
					j--;
				ans.append(input.charAt(j--));
			} else {
				ans.append(input.charAt(i));
			}
		}

		return ans.toString();
	}
}
