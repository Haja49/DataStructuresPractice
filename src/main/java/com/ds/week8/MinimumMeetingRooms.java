package com.ds.week8;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class MinimumMeetingRooms {

	@Test
	public void test1() {
		String[][] meetingTimes = { { "09 00", "09 45" }, { "09 30", "10 30" }, { "10 40", "12 00" },
				{ "11 00", "13 00" }, { "11 45", "14 00" }, { "16 00", "17 00" } };
		Assert.assertEquals(3, findMinRooms(meetingTimes));
	}

	private int findMinRooms(String[][] meetingTimes) {
		// Create a 2-d array to make a pair of start and end times
		int[][] times = new int[meetingTimes.length][2];

		// Add the start and End times to the array
		for (int i = 0; i < times.length; i++) {
			times[i][0] = Integer.parseInt(meetingTimes[i][0].replaceAll(" ", ""));
			times[i][1] = Integer.parseInt(meetingTimes[i][1].replaceAll(" ", ""));
		}

		// Sort the array by using Comparator based on start and end times
		Arrays.sort(times, (a, b) -> {
			if (a[1] != b[1])
				return a[1] - b[1]; // end times
			else
				return a[0] - b[0]; // start times
		});

		// start with min as maximum meetings
		int minRooms = meetingTimes.length;

		// initialize start and end
		int start = 0, end = 0;

		// Iterate over meetings
		while (start < times.length) {
			if (times[start++][0] > times[end][1]) { // if start > end
				minRooms--; // decrement rooms
				end++; // increment end
			}
			// increment start
		}

		return minRooms;
	}
}
