package com.group1.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CamelCase {
	// 1023

	@Test
	public void test1() {
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FB";
		Assert.assertTrue(Arrays.asList(true, false, true, true, false).equals(camelMatch(queries, pattern)));
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> output = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			output.add(isMatch(queries[i], pattern));
		}
		return output;
	}

	public boolean isMatch(String query, String pattern) {
		int p1 = 0, p2 = 0;
		while (p1 < query.length() && p2 < pattern.length()) {
			if (query.charAt(p1) == pattern.charAt(p2)) {
				p1++;
				p2++;
			} else if (Character.isUpperCase(query.charAt(p1)))
				return false;
			else
				p1++;
		}
		while (p1 < query.length()) {
			if (Character.isUpperCase(query.charAt(p1++)))
				return false;
		}
		return p2 == pattern.length();
	}
}
