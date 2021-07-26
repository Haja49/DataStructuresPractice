package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharacters {

	@Test
	public void test1() {
		char[] input = { 'a', 'a', 'b', 'k', 'h' };
		Assert.assertArrayEquals(new char[] { 'h', 'k', 'b' }, uniqueCharacters(input));
	}

	@Test
	public void test2() {
		char[] input = { 'a', 'a' };
		Assert.assertArrayEquals(new char[] {}, uniqueCharacters(input));
	}

	@Test
	public void test3() {
		char[] input = { 'a', 'b', 'z', 'e' };
		Assert.assertArrayEquals(new char[] { 'e', 'z', 'b', 'a' }, uniqueCharacters(input));
	}

	private char[] uniqueCharacters(char[] input) {
		int[] inputArray = new int[26];
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < input.length; i++) {
			inputArray[input[i] - 'a']++;
		}
		for (int i = 0; i < input.length; i++) {
			if (inputArray[input[i] - 'a'] == 1)
				list.add(input[i]);
		}
		char[] output = new char[list.size()];
		int j = 0;
		for (int i = list.size(); i > 0; i--) {
			output[j] = list.get(i - 1);
			j++;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
}
