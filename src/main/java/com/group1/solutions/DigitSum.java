package com.group1.solutions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class DigitSum {

	@Test
	public void test1() {
		int[] A = { 51, 71, 17, 42 };
		Assert.assertEquals(93, solution(A));
	}

	@Test
	public void test2() {
		int[] A = { 01, 10, 02, 20, 11 };
		Assert.assertEquals(31, solution(A));
	}

	@Test
	public void test3() {
		int[] A = { 51, 32, 36 };
		Assert.assertEquals(-1, solution(A));
	}

	private int solution(int[] A) {
		int left = 0, right = 1;
		int max = -1;
		while (right < A.length) {
			int leftSum = digitSum(A[left]);
			int rightSum = digitSum(A[right]);
			if (leftSum == rightSum) {
				max = Math.max(A[left] + A[right], max);
				left++;
				right++;
			} else if (leftSum < rightSum)
				right++;
			else {
				left++;
				right = left == right ? left + 1 : right;
			}
		}
		return max;
	}

	public int solution1(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxSum = -1;
		for (int num : A) {
			int sum = digitSum(num);
			if (map.containsKey(sum)) {
				maxSum = Math.max(maxSum, map.get(sum) + num);
				if (map.get(sum) < num) {
					map.put(sum, num);
				}
			} else {
				map.put(sum, num);
			}
		}
		return maxSum;
	}

	public int digitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}
}
