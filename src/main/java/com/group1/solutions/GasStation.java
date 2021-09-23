package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class GasStation {

	@Test
	public void test1() {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		Assert.assertEquals(3, canCompleteCircuit(gas, cost));
	}

	@Test
	public void test2() {
		int[] gas = { 5, 2, 2, 3, 3 };
		int[] cost = { 4, 3, 1, 5, 1 };
		Assert.assertEquals(4, canCompleteCircuit(gas, cost));
	}

	@Test
	public void test3() {
		int[] gas = { 1, 2, 3 };
		int[] cost = { 3, 2, 1 };
		Assert.assertEquals(1, canCompleteCircuit(gas, cost));
	}

	@Test
	public void test4() {
		int[] gas = { 1, 2 };
		int[] cost = { 3, 2 };
		Assert.assertEquals(-1, canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0, currentSum = 0, index = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			currentSum += gas[i] - cost[i];
			if (currentSum < 0) {
				index = i + 1;
				currentSum = 0;
			}
		}
		return totalGas < totalCost ? -1 : index;
	}
}
