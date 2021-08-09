package week4;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class DailyTemperatures {

	@Test
	public void test1() {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73, 72, 71, 73 };
		Assert.assertArrayEquals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0, 2, 1, 0 },
				dailyTemperaturesUsingTwoPointer(temperatures));
	}

	@Test
	public void test2() {
		int[] temperatures = { 30, 40, 50, 60 };
		Assert.assertArrayEquals(new int[] { 1, 1, 1, 0 }, dailyTemperaturesUsingTwoPointer(temperatures));
	}

	@Test
	public void test3() {
		int[] temperatures = { 73 };
		Assert.assertArrayEquals(new int[] { 0 }, dailyTemperaturesUsingTwoPointer(temperatures));
	}

	@Test
	public void test4() {
		int[] temperatures = { 73, -1, -2, 73 };
		Assert.assertArrayEquals(new int[] { 0, 2, 1, 0 }, dailyTemperaturesUsingTwoPointer(temperatures));
	}

	private int[] dailyTemperatures(int[] temperatures) {
		int[] warmer = new int[temperatures.length];
		for (int i = 0; i < temperatures.length - 1; i++) {
			int count = 1;
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[j] > temperatures[i]) {
					warmer[i] = count;
					break;
				} else
					count++;
			}
		}
		System.out.println(Arrays.toString(warmer));
		return warmer;
	}

	private int[] dailyTemperaturesUsingStack(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] warmer = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			System.out.println(temperatures[i]);
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				warmer[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}
		return warmer;
	}

	private int[] dailyTemperaturesUsingTwoPointer(int[] temperatures) {
		int[] warmer = new int[temperatures.length];
		if (temperatures.length <= 1)
			return warmer;

		int start = 0;
		int end = 1;
		int i = 0;
		while (i < temperatures.length - 1) {
			if (end > temperatures.length - 1) {
				warmer[i] = 0;
				i++;
				start++;
				end = start;
			} else if (temperatures[end] > temperatures[start]) {
				warmer[i] = end - start;
				start++;
				i++;
				end = start;
			}
			end++;
		}
		return warmer;
	}
}
