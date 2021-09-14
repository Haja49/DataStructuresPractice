package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class CompareVersionNumbers {

	@Test
	public void test1() {
		String version1 = "1.01";
		String version2 = "1.001";
		Assert.assertEquals(0, compareVersionNumbers(version1, version2));
	}

	@Test
	public void test2() {
		String version1 = "1.0";
		String version2 = "1.0.0";
		Assert.assertEquals(0, compareVersionNumbers(version1, version2));
	}

	@Test
	public void test3() {
		String version1 = "0.1";
		String version2 = "1.1";
		Assert.assertEquals(-1, compareVersionNumbers(version1, version2));
	}

	@Test
	public void test4() {
		String version1 = "1.0.1";
		String version2 = "1";
		Assert.assertEquals(1, compareVersionNumbers(version1, version2));
	}

	@Test
	public void test5() {
		String version1 = "7.2.5.4";
		String version2 = "7.5.3";
		Assert.assertEquals(-1, compareVersionNumbers(version1, version2));
	}

	private int compareVersionNumbers(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int length = Math.max(s1.length, s2.length);
		for (int i = 0; i < length; i++) {
			int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
			int v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v2 > v1) {
				return -1;
			}
		}
		return 0;
	}
}
