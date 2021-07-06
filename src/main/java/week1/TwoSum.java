package week1;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSum {

	@Test
	public void test1() {
		int[] input = { 2, 4, 6, 8, 12, 5 };
		int target = 10;
		Assert.assertEquals(twoSum(input, target), new int[] { 0, 3 });
	}

	@Test
	public void test2() {
		int[] input = { 2, 4, 6, 8, 12, 5 };
		int target = 15;
		Assert.assertEquals(twoSum(input, target), new int[] { -1, -1 });
	}

	@Test
	public void test3() {
		int[] input = { 7, 4, 5, 7 };
		int target = 10;
		Assert.assertEquals(twoSum(input, target), new int[] { -1, -1 });
	}

	/*
	 * 1. Iterate over the elements of the array.
	 * 2. Compare the Elements of the array with the next element
	 * 		a) If the element matches, then return the indices of both elements
	 *		b) Else, return {-1, -1}.
	 */
	
	// O(n^2)
	private int[] twoSum(int[] input, int sum) {
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == sum) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array.
	 * 3. For every element in the array:
	 * 		a) Check if it’s difference (target - element) exists in the Map or not. 
	 * 		   If the difference exists then return the indices of the current element and the difference.
	 *		b) Else, put the element in the Map.
	 */
	
	// O(n)
	private int[] twoSumUsingMap(int[] input, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			int difference = sum - input[i];
			if (map.containsKey(difference)) {
				return new int[] { map.get(difference), i };
			}
			map.put(input[i], i);

		}
		return new int[] { -1, -1 };
	}
}
