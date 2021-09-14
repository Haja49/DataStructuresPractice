package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class MagicalString {

	@Test
	public void test1() {
		int n = 6;
		Assert.assertEquals(3, magicalString(n));
	}

	@Test
	public void test2() {
		int n = 38;
		Assert.assertEquals(19, magicalString(n));
	}

	private int findMagicalString(int n) {
		int count = 0;
		String s = "1221121221221121122";
		int p1 = 12, p2 = s.length();
		while (n > s.length()) {
			if (s.charAt(p1) == '1') {
				if (s.charAt(p2 - 1) == '1') {
					s += '2';
				} else {
					s += '1';
				}
				p2++;
			} else {
				if (s.charAt(p2 - 1) == '1') {
					s += "22";
				} else {
					s += "11";
				}
				p2 += 2;
			}
			p1++;
		}
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	private int magicalString(int n) {
		if (n == 0)
			return 0;
		if (n <= 3)
			return 1;
		int[] S = new int[n + 1];
		S[0] = 1;
		S[1] = 2;
		S[2] = 2;
		int i = 2, j = 3, res = 1, num = 1;
		while (j < n) {
			for (int k = 0; k < S[i]; ++k) {
				if (num == 1 && j < n)
					++res;
				S[j++] = num;
			}
			num ^= 3;
			++i;
		}
		return res;
	}
}
