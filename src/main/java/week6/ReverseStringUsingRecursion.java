package week6;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseStringUsingRecursion {
	
	/*
	 * Base Testcase - t
	 * Test cases - testleaf => faeltset
	 * Edge Case - ""
	 * Pattern substring(0, length-1)
	 */

	@Test
	public void test1() {
		Assert.assertEquals("faeltset", reverse("testleaf"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("tttt", reverse("tttt"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("", reverse(""));
	}

	private String reverse(String str) {
		if (str.length() <= 1)
			return str;
		return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
	}
}
