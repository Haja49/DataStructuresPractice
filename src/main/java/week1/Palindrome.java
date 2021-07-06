package week1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Palindrome {

	@Test
	public void test1() {
		int input = 121;
		Assert.assertEquals(checkPalindrome(input), true);
	}

	@Test
	public void test2() {
		int input = 1234421;
		Assert.assertEquals(checkPalindrome(input), false);
	}

	@Test
	public void test3() {
		int input = 2147483647;
		Assert.assertEquals(checkPalindrome(input), false);
	}
	
	@Test
	public void test4() {
		int input = 1;
		Assert.assertEquals(checkPalindrome(input), true);
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
}
