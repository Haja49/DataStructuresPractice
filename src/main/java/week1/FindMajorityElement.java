package week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindMajorityElement {

	@Test
	public void test1() {
		int[] input = {2, 1, 2, 2, 3, 4, 2};
		Assert.assertEquals(findMajorityElementUsingMap(input), 2);
	}

	@Test
	public void test2() {
		int[] input = {2, 3, 4};
		Assert.assertEquals(findMajorityElementUsingMap(input), -1);
	}

	@Test
	public void test3() {
		int[] input = {2, 2, 3, 4};
		Assert.assertEquals(findMajorityElementUsingMap(input), -1);
	}

	@Test
	public void test4() {
		int[] input = {2};
		Assert.assertEquals(findMajorityElementUsingMap(input), 2);
	}

	/*
	 * 1. Get the length of the Array and iterate through half of its length
	 * 2. Initialize a counter and compare with the remaining elements of array
	 * 3. If the count is more than half of the length, return the number
	 * 4. Else, return -1
	 */

	// O(n^2)
	private int findMajorityElement(int[] input) {
		int length = input.length;
		for (int i = 0; i <= length / 2; i++) {
			int count = 1;
			for (int j = i + 1; j < length; j++) {
				if (input[j] == input[i]) {
					count++;
				}
			}
			if (count > length / 2) {
				return input[i];
			}
		}
		return -1;
	}

	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array and add them to map with value of its count.
	 * 3. For every entry in the map:
	 * 		a) If the value is greater than half of its length, return the key.
	 *		b) Else, return -1.
	 */

	// O (2n) ==> 2 Pass
	private int findMajorityElementUsingMap(int[] input) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i]))
				map.put(input[i], map.get(input[i]) + 1);
			else
				map.put(input[i], 1);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > input.length / 2)
				return entry.getKey();
		}
		return -1;
	}
}
