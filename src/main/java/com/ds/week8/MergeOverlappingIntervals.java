package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeOverlappingIntervals {

	@Test
	public void test1() {
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 6, 9 } };
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}

	@Test
	public void test2() {
		int[][] intervals = { { 2, 4 }, { 1, 3 }, { 1, 4 } };
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}

	@Test
	public void test3() {
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 3, 9 } };
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}

	private int[][] mergeIntervals(int[][] intervals) {

		// Sort the array based on starting index
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// Initialize an array list
		List<int[]> mergedIntervals = new ArrayList<>();

		// Initialize a temp variable with first time interval
		int[] temp = intervals[0];

		// Add temp to list
		mergedIntervals.add(temp);

		// Iterate through the intervals
		for (int i = 1; i < intervals.length; i++) {
			int currentEnd = temp[1];
			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];
			// If current end is greater than or equal to next start
			if (currentEnd >= nextStart) {
				// find max of current end and next end and then reset temp[1]
				temp[1] = Math.max(currentEnd, nextEnd);
			} else {
				// Else add the interval to list
				mergedIntervals.add(new int[] { intervals[i][0], intervals[i][1] });
			}
		}

		// Finally return the list by converting to array
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}
}
