package com.ds.week6;

import org.junit.Test;

import junit.framework.Assert;

public class FindSubstring {

	@Test
	public void test1() {
		Assert.assertEquals(2, findSubstring("Welcome to to TestLeaf", "to"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, findSubstring("Welcome TestLeaf", "to"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, findSubstring("", "to"));
	}
	
	private int findSubstring(String s1, String sub) {
		if(s1.contains(sub))
			return 1 + findSubstring(s1.replaceFirst(sub, ""), sub);
		return 0;
	}
}
