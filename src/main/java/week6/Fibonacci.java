package week6;

import org.junit.Test;

import junit.framework.Assert;

public class Fibonacci {

	@Test
	public void test1() {
		Assert.assertEquals(5, findFibonacci(5));
	}

	private int findFibonacci(int num) {
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		return findFibonacci(num - 1) + findFibonacci(num - 2);
	}
}
