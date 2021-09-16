package slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class ReplaceSubstringForBalancedString {

	@Test
	public void test1() {
		String s = "WQWRQQQW";
		Assert.assertEquals(3, balancedString(s));
	}

	/*
	 * Pseudo code
	 * Calculate length as n/4
	 * Initialize 4 variables for Q,W,E,R count as 0
	 * Initialize a hash map and add characters as key & value as 0
	 * Traverse through the string
	 * 		Find count of each character and update the value with count-1/4th length
	 * If the values of all the characters in the map is 0, return 0
	 * Initialize min, start, end as 0
	 * Traverse through the string
	 * 		Decrement the value of the end char in the map to remove the extra characters [Expand the window]
	 * 		If values of all the characters in the map <= 0 [Substring contains same number of extra characters]
	 * 			Find min value btw min value & end-start+1
	 * 			Increment the value of the character at start
	 * 			Increment start 
	 * Return min
	 */


	public int balancedString(String s) {
		int length = s.length() / 4;
		int q = 0, w = 0, e = 0, r = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('Q', 0);
		map.put('W', 0);
		map.put('E', 0);
		map.put('R', 0);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'Q') {
				q++;
				map.put('Q', q - length);
			} else if (s.charAt(i) == 'W') {
				w++;
				map.put('W', w - length);
			} else if (s.charAt(i) == 'E') {
				e++;
				map.put('E', e - length);
			} else if (s.charAt(i) == 'R') {
				r++;
				map.put('R', r - length);
			}
		}
		if (map.get('Q') <= 0 && map.get('W') <= 0 && map.get('E') <= 0 && map.get('R') <= 0)
			return 0;
		int min = Integer.MAX_VALUE, start = 0, end = 0;
		for (end = 0; end < s.length(); end++) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) - 1);
			while (map.get('Q') <= 0 && map.get('W') <= 0 && map.get('E') <= 0 && map.get('R') <= 0) {
				min = Math.min(min, end - start + 1);
				map.put(s.charAt(start), map.getOrDefault(s.charAt(start++), 0) + 1);
			}
		}
		return min;
	}
}
