package com.ds.week7;

import java.util.List;

public class CutThemAll {

	public static String cutThemAll(List<Long> lengths, long minLength) {
		long max = 0;
		for (int i = 0; i < lengths.size()-1; i++)
			max = Math.max(max,  lengths.get(i) + lengths.get(i+1));
		
		if (max >= minLength) return "Possible";
		else return "Impossible";
	}

}
