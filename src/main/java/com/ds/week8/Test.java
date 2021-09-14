package com.ds.week8;

import java.util.Arrays;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test1() {
		numDuplicates(Arrays.asList("ball", "box", "ball", "ball", "box"), Arrays.asList(2,2,2,2,2), Arrays.asList(1,2,1,1,3));
	}
	
	public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
		int count = 0;
		for (int i = 0; i < name.size() - 1; i++) {
			for (int j = i + 1; j < name.size(); j++) {
				if (name.get(i) == name.get(j) && price.get(i) == price.get(j) && weight.get(i) == weight.get(j)) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		return count;
	}

}
