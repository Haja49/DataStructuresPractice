package week5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class StoneGame {

	@Test
	public void test1() {
		int[] nums = { 5, 3, 4, 5 };
		Assert.assertEquals(true, findWinner1(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 2, 3, 7, 5 };
		Assert.assertEquals(true, findWinner1(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = { 1, 7, 3 };
		Assert.assertEquals(true, findWinner(nums));
	}

	private boolean findWinner(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		int firstMax = 0, lastMax = 0;
		while (list.size() > 0) {
			int max = 0;
			int i = 0;
			if (max < nums[0])
				list.remove(0);
			else if (max < nums[list.size() - 1])
				list.remove(list.size() - 1);
			if (max < nums[0]) {
				max = nums[0];
			} else if (max < nums[list.size() - 1]) {
				max = nums[list.size() - 1];
			}
			if (i % 2 == 0)
				firstMax = firstMax + max;
			else
				lastMax = lastMax + max;
			i++;
		}
		if (firstMax > lastMax)
			return true;
		else
			return false;
	}

	private boolean findWinner1(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		int alexSum = 0, leeSum = 0;
		while (i < j) {
			alexSum += Math.max(nums[i], nums[j]);
			leeSum += Math.min(nums[i], nums[j]);
			i++;
			j--;
		}
		return alexSum > leeSum ? true : false;
	}

	private boolean findWinner2(int[] nums) {
		int j = nums.length - 1;
		int alexSum = 0, leeSum = 0;
		for (int k = 0; k < nums.length;k++) {
			if (nums[k] >= nums[j]) {
				alexSum +=nums[k];
				leeSum +=nums[j];
			} else {
				alexSum +=nums[j];
				leeSum +=nums[k];
				j--;
			}
		}
		return alexSum >= leeSum ? true : false;
	}
}
