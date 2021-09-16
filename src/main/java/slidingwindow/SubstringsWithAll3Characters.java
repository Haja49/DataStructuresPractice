package slidingwindow;

import org.junit.Test;

import junit.framework.Assert;

public class SubstringsWithAll3Characters {

	@Test
	public void test1() {
		String s = "abcabc";
		Assert.assertEquals(10, findCount(s));
	}

	@Test
	public void test2() {
		String s = "aaabc";
		Assert.assertEquals(3, findCount(s));
	}

	@Test
	public void test3() {
		String s = "abc";
		Assert.assertEquals(1, findCount(s));
	}

	private int findCount(String s) {
		int count = 0;
		int[] chArray = new int[3];
		int i = 0, j = 0;
		while (j < s.length()) {
			chArray[s.charAt(j) - 'a']++;
			while (chArray[0] > 0 && chArray[1] > 0 && chArray[2] > 0) {
				chArray[s.charAt(i++) - 'a']--;
			}
			count += i;
			j++;
		}
		return count;
	}

	public int numberOfSubstrings(String s) {
		int l1 = -1;
		int l2 = -1;
		int l3 = -1;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				l1 = i;
			else if (s.charAt(i) == 'b')
				l2 = i;
			else
				l3 = i;
			int min = Math.min(l1, Math.min(l2, l3));
			count += min + 1;
		}
		return count;
	}

	public int numberOfSubstringsBruteForce(String s) {
		int n = s.length(), count = 0;
		char[] arr = s.toCharArray();
		int a, b, c;
		for (int i = 0; i < n - 2; i++) {
			a = b = c = 0;
			for (int j = i; j < n; j++) {
				if (arr[j] == 'a')
					a++;
				else if (arr[j] == 'b')
					b++;
				else
					c++;
				if (a != 0 && b != 0 && c != 0) {
					count += n - j;
					break;
				}
			}
		}
		return count;
	}
}
