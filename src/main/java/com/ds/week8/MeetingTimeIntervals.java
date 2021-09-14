package com.ds.week8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MeetingTimeIntervals {

	@Test
	public void test1() {
		List<Integer> startTimes = Arrays.asList(0, 5, 15);
		List<Integer> endTimes = Arrays.asList(30, 10, 20);
		Assert.assertEquals(false, findMax(startTimes, endTimes));
	}

	@Test
	public void test2() {
		List<Integer> startTimes = Arrays.asList(7, 10, 1);
		List<Integer> endTimes = Arrays.asList(10, 20, 4);
		Assert.assertEquals(true, findMax(startTimes, endTimes));
	}

	@Test
	public void test3() {
		List<Integer> startTimes = Arrays.asList(1, 2);
		List<Integer> endTimes = Arrays.asList(2, 3);
		Assert.assertEquals(true, findMax(startTimes, endTimes));
	}

	private boolean findMax(List<Integer> startTimes, List<Integer> endTimes) {
		// Create a 2-d array to make a pair of start and end times
		int[][] conferenceTimes = new int[startTimes.size()][2];

		// Add the start and End times to the array
		for (int i = 0; i < conferenceTimes.length; i++) {
			conferenceTimes[i][0] = startTimes.get(i);
			conferenceTimes[i][1] = endTimes.get(i);
		}

		// Sort the array by using Comparator based on start and end times
		Arrays.sort(conferenceTimes, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1]; // end times
			else
				return a[0] - b[0]; // start times
		});

		// Minimum number of presentations will be 1
		int maxPresentations = 1;

		// initialize, end time based on first meeting
		int endTime = conferenceTimes[0][1];

		// Iterate through conference start and end
		for (int i = 1; i < conferenceTimes.length; i++) {
			if (conferenceTimes[i][0] >= endTime) { // if start is greater than end
				maxPresentations++; // Increment max
				endTime = conferenceTimes[i][1]; // reset end time based on next meeting
			} else
				return false;
		}
		// return maxPresentations
		return maxPresentations == startTimes.size();
	}
}
