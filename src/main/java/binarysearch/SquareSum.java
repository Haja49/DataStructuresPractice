package binarysearch;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class SquareSum {

	@Test
	public void test1() {
		int c = 2147483646;
		Assert.assertEquals(true, judgeSquareSum(c));
	}

	public boolean judgeSquareSum(int c) {
		long low = 0, high = (long) Math.sqrt(c);
		while (low <= high) {
			if (low * low + high * high == c) {
				return true;
			} else if (low * low + high * high > c) {
				high--;
			} else {
				low++;
			}
		}
		return false;
	}

	// Time Limit Exceeded
	public boolean judgeSquareSumUsingMap(int c) {
		Map<Integer, Integer> map = new HashMap<>();
		for (long i = 0; i * i <= c; i++) {
			map.put((int) (i * i), (int) i);
			if (map.containsKey(c - (int) (i * i))) {
				return true;
			}
		}
		return false;
	}

	public boolean judgeSquareSumBruteForce(int c) {
		for (long i = 0; i * i <= c; i++) {
			for (long j = 0; j * j <= c; j++) {
				if (i * i + j * j == c)
					return true;
			}
		}
		return false;
	}

	public boolean judgeSquareSumBS(int c) {
		for (long i = 0; i * i <= c; i++) {
			int j = c - (int) (i * i);
			long low = 0, high = j;
			while (low <= high) {
				long mid = (low + high) / 2;
				if (mid * mid == j) {
					return true;
				} else if (mid * mid > j) {
					high = mid - 1;
				} else
					low = mid + 1;
			}
		}
		return false;
	}

}
