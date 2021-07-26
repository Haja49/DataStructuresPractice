package week3;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class RomanToInteger {

	/*
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

		Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		Given a roman numeral, convert it to an integer.

		Example 1:

		Input: s = "III"
		Output: 3
		Example 2:

		Input: s = "IV"
		Output: 4
		Example 3:

		Input: s = "IX"
		Output: 9
		Example 4:

		Input: s = "LVIII"
		Output: 58
		Explanation: L = 50, V= 5, III = 3.
		Example 5:

		Input: s = "MCMXCIV"
		Output: 1994
		Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

	 *
	 * Input: String
	 * Output: Integer
	 */

	@Test
	public void test1() {
		String s = "III";
		Assert.assertEquals(3, romanToInteger(s));
	}

	@Test
	public void test2() {
		String s = "IV";
		Assert.assertEquals(4, romanToInteger(s));
	}

	@Test
	public void test3() {
		String s = "LVIII";
		Assert.assertEquals(58, romanToInteger(s));
	}

	@Test
	public void test4() {
		String s = "MCMXCIV";
		Assert.assertEquals(1994, romanToInteger(s));
	}

	@Test
	public void test5() {
		String s = "XI";
		Assert.assertEquals(11, romanToInteger(s));
	}

	/*
	 * 1. Add all roman values to a map
	 * 2. Initialize a output variable with value of last index
	 * 3. Iterate through the input backwards
	 * 4. If character is greater than or equal to next index
	 * 		a) add it to output
	 * 		b) else, sub from output
	 */
	// O(n) / O(n)
	private int romanToInteger(String s) {
		if (s.length() == 0)
			return -1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int output = map.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
				output += map.get(s.charAt(i));
			else
				output -= map.get(s.charAt(i));
		}
		return output;
	}

	/*
	 * 1. Add all roman values to an array
	 * 2. Initialize a output variable with value of last index
	 * 3. Iterate through the input backwards
	 * 4. If character is greater than or equal to next index
	 * 		a) add it to output
	 * 		b) else, sub from output
	 */
	// O(n) / O(1)
	private int romanToIntegerUsingAscii(String s) {
		if (s.length() == 0)
			return -1;
		int[] roman = new int[26];
		roman['I' - 'A'] = 1;
		roman['V' - 'A'] = 5;
		roman['X' - 'A'] = 10;
		roman['L' - 'A'] = 50;
		roman['C' - 'A'] = 100;
		roman['D' - 'A'] = 500;
		roman['M' - 'A'] = 1000;
		int output = roman[s.charAt(s.length()-1)-'A'];
		for (int i = s.length() - 2; i >= 0; i--) {
			if (roman[s.charAt(i)-'A'] >= roman[s.charAt(i+1)-'A'])
				output += roman[s.charAt(i)-'A'];
			else
				output -= roman[s.charAt(i)-'A'];
		}
		return output;
	}
}
