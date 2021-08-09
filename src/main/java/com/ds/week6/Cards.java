package com.ds.week6;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class Cards {

	@Test
	public void test1() {
		int[] data = { 1, 7, 3 };
		Assert.assertEquals(false, pickTheCard(data));
	}

	@Test
	public void test2() {
		int[] data = { 1, 6, 23, 7 };
		Assert.assertEquals(true, pickTheCard(data));
	}

	@Test
	public void test3() {
		int[] data = { 1, 6, 7, 5, 6 };
		Assert.assertEquals(true, pickTheCard(data));
	}

	@Test
	public void test4() {
		int[] data = { 1, 20, 7, 3, 1, 10, 23 };
		Assert.assertEquals(false, pickTheCard(data));
	}

	int player1 = 0, player2 = 0;

	private boolean pickTheCard(int[] data) {
		if (data.length % 2 == 0)
			return true;
		if (data.length <= 1)
			return true;
		int[] output1 = new int[data.length - 1];
		if (data[0] >= data[data.length - 1]) {
			player1 += data[0];
			output1 = Arrays.copyOfRange(data, 1, data.length - 1);
		} else {
			player1 += data[data.length - 1];
			output1 = Arrays.copyOfRange(data, 0, data.length - 1);
		}
		int[] output2 = new int[data.length - 1];
		if (output1[0] >= output1[output1.length - 1]) {
			player2 += output1[0];
			output2 = Arrays.copyOfRange(output1, 1, output1.length - 1);
		} else {
			player2 += output1[output1.length - 1];
			output2 = Arrays.copyOfRange(output1, 0, output1.length - 1);
		}
		pickTheCard(output2);
		return player1 >= player2 ? true : false;
	}
}
