package com.group1.solutions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class CountLargestGroup {

	@Test
	public void test1() {
		int n = 13;
		Assert.assertEquals(4, countLargestGroup(n));
	}

	@Test
	public void test2() {
		int n = 2;
		Assert.assertEquals(2, countLargestGroup(n));
	}

	public int countLargestGroup1(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = digitSum(i);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			max = Math.max(max, map.get(sum));
		}
		int count = 0;
		for (Integer eachValue : map.values()) {
			if (eachValue == max)
				count++;
		}
		return count;
	}

	public int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	public int countLargestGroup(int n) {
		if (n < 10)
			return n;
		int[] sum = new int[n];
		int max = 0, count = 0;
		for (int i = 1; i <= n; i++) {
			sum[digitSum(i)]++;
			max = Math.max(sum[digitSum(i)], max);
		}
		for (int i : sum) {
			if (i == max) {
				count++;
			}
		}
		return count;
	}
}
