package com.ds.week7;

import java.util.Collections;
import java.util.List;

public class ProgrammingContest {

	public int minimizeBias(List<Integer> ratings) {
		Collections.sort(ratings);
		int sum = 0;
		for (int i = 0; i < ratings.size()-1; i+=2)
			sum += ratings.get(i+1) - ratings.get(i);
		return sum;
	}
}
