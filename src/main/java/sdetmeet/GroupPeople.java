package sdetmeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GroupPeople {

	@Test
	public void test1() {
		int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(0, 1, 2));
		list.add(Arrays.asList(5));
		list.add(Arrays.asList(3, 4, 6));
		Assert.assertEquals(list, groupPeople(groupSizes));
	}

	private List<List<Integer>> groupPeople(int[] groupSizes) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		for (int i = 0; i < groupSizes.length;) {
			int temp = groupSizes[i];
			List<Integer> list = new ArrayList<Integer>();
			int count = 0;
			while (i < groupSizes.length && count < temp) {
				if (groupSizes[i] == temp) {
					list.add(i);
					count++;
				}
				i++;
			}
			if (count == temp)
				out.add(list);
		}
		return out;
	}

	private List<List<Integer>> groupPeopleUsingMap(int[] groupSizes) {
		List<List<Integer>> out = new ArrayList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			int curr = groupSizes[i];
			List<Integer> list = new ArrayList<>();
			if (map.containsKey(curr))
				list = map.get(curr);
			list.add(i);
			map.put(curr, list);
			if (list.size() == curr) {
				out.add(list);
				map.remove(curr);
			}
		}
		return out;
	}
}
