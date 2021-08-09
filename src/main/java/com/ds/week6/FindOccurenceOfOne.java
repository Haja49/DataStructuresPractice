package com.ds.week6;

import org.junit.Test;

import junit.framework.Assert;

public class FindOccurenceOfOne {

	@Test
	public void test1() {
		Assert.assertEquals(1, findOccurence(1000));
	}

	@Test
	public void test2() {
		Assert.assertEquals(5, findOccurence(11111));
	}

	@Test
	public void test3() {
		Assert.assertEquals(0, findOccurence(0000));
	}

	private int findOccurence(int num) {
		if (num <= 0)
			return 0;
		if (num % 10 != 0)
			return 1 + findOccurence(num / 10);
		return findOccurence(num / 10);
	}
}
