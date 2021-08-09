package week4;

import org.junit.Test;

import junit.framework.Assert;

public class FindSecondLeastCharacter {

	@Test
	public void test1() {
		String s = "amazon";
		Assert.assertEquals('m' - 'a', findLeast(s));
	}

	@Test
	public void test2() {
		String s = "amzon";
		Assert.assertEquals('m' - 'a', findLeast(s));
	}

	@Test
	public void test3() {
		String s = "";
		Assert.assertEquals(0, findLeast(s));
	}

	private int findLeast(String s) {
		int[] chArray = new int[26];
		for (int i = 0; i < s.length(); i++) {
			chArray[s.charAt(i) - 'a']++;
		}
		int max = 0;
		int secondMax = 0;
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] > max) {
				secondMax = max;
				max = i;
			}
			if (chArray[i] < max && chArray[i] > secondMax) {
				secondMax = i;
				break;
			}
		}
		return (char) secondMax;
	}
}
