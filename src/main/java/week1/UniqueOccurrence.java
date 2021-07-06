package week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueOccurrence {

	@Test
	public void test1() {
		int[] input = { 1, 2, 2, 1, 1, 3 };
		Assert.assertEquals(uniqueOccurrence(input), true);
	}

	@Test
	public void test2() {
		int[] input = { 1, 2, 3 };
		Assert.assertEquals(uniqueOccurrence(input), false);
	}

	@Test
	public void test3() {
		int[] input = { -1, 1, 2, 1, 1, 2, 0, 0, 2, 2 };
		Assert.assertEquals(uniqueOccurrence(input), true);
	}


	/*
	 * 1. Initialize an empty HashMap.
	 * 2. Iterate over the elements of the array and add them to map with value of its count.
	 * 3. Initialize an empty HashSet.
	 * 4. Iterate through the map values and them to the HashSet
	 * 5. If size of map and set are equal:
	 * 		a) return true;
	 * 		b) Else, return false
	 */

	// O(2n)
	private boolean uniqueOccurrence(int[] input) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i]))
				map.put(input[i], map.get(input[i]) + 1);
			else
				map.put(input[i], 1);
		}
		Set<Integer> set = new HashSet<Integer>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			set.add(entry.getValue());
		}
		return set.size() == map.size();
	}
}
