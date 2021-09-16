package slidingwindow;

import org.junit.Test;

import junit.framework.Assert;

public class LongestTurbulentSubArray {

	@Test
	public void test1() {
		int[] arr = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
		Assert.assertEquals(5, maxTurbulenceSize(arr));
	}

	@Test
	public void test2() {
		int[] arr = { 4, 8, 12, 16 };
		Assert.assertEquals(2, maxTurbulenceSize(arr));
	}

	@Test
	public void test3() {
		int[] arr = { 100 };
		Assert.assertEquals(1, maxTurbulenceSize(arr));
	}

	public int maxTurbulenceSize(int[] arr) {
		if (arr.length == 1)
			return 1;
		int i = 1;
		boolean flag = arr[0] < arr[1];
		int count = arr[0] != arr[1] ? 2 : 1;
		int max = count;
		while (i < arr.length - 1) {
			if ((flag && arr[i] > arr[i + 1]) || (!flag && arr[i] < arr[i + 1])) {
				count++;
				max = Math.max(max, count);
			} else {
				count = arr[i] != arr[i + 1] ? 2 : 1;
			}
			flag = arr[i] < arr[i + 1];
			i++;
		}
		return max;
	}
}
