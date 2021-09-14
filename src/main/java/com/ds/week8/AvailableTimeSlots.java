package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import junit.framework.Assert;

public class AvailableTimeSlots {

	@Test
	public void test1() {
		int[][] slots1 = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int[][] slots2 = { { 0, 15 }, { 60, 70 } };
		int duration = 8;
		Assert.assertTrue(minAvailableDurationUsing2Pointer(slots1, slots2, duration).equals(Arrays.asList(60, 68)));
	}

	@Test
	public void test2() {
		int[][] slots1 = { { 0, 15 }, { 140, 150 } };
		int[][] slots2 = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int duration = 10;
		Assert.assertTrue(minAvailableDurationUsing2Pointer(slots1, slots2, duration).equals(Arrays.asList(140, 150)));
	}

	@Test
	public void test3() {
		int[][] slots1 = { { 10, 50 }, { 60, 120 }, { 140, 210 } };
		int[][] slots2 = { { 0, 15 }, { 60, 70 } };
		int duration = 12;
		Assert.assertTrue(minAvailableDurationUsing2Pointer(slots1, slots2, duration).equals(Arrays.asList()));
	}

	private List<Integer> minAvailableDurationUsing2Pointer(int[][] slots1, int[][] slots2, int duration) {

		// Sort slots1 based on start time
		Arrays.sort(slots1, (a, b) -> {
				return a[0] - b[0]; // start times
		});

		// Sort slots2 based on start time
		Arrays.sort(slots2, (a, b) -> {
				return a[0] - b[0]; // start times
		});
		
		// Initialize 2 pointers for 2 slots
		int start1 =0, start2=0;
		
		// Iterate through the slots
		while (start1 < slots1.length && start2 < slots2.length) {
			// if slots1 start time is greater than slots2 start time, increment start2
			if (slots1[start1][0] > slots2[start2][0])
				start2++;
			// else if slots1 start time is less than slots2 start time, increment start1
			else if (slots1[start1][0] < slots2[start2][0])
				start1++;
			// if slots1 start time is equal to slots2 start time
			if (slots1[start1][0] == slots2[start2][0]) {
				// verify if both start times are within the duration, 
				// if yes -> return the start time and start time + duration as a list
				if (slots1[start1][0] + duration <= slots1[start1][1]
						&& slots2[start2][0] + duration <= slots2[start2][1])
					return Arrays.asList(slots1[start1][0], slots1[start1][0] + duration);
				// else increment both pointers
				else {
					start1++;
					start2++;
				}
			}
		}
		// Return empty list if no match found
		return new ArrayList<>();
	/*	if (slots1.length > slots2.length)
			return findDuration(slots2, slots1, duration);
		else
			return findDuration(slots1, slots2, duration);*/

	}

	private List<Integer> findDuration(int[][] slots1, int[][] slots2, int duration) {
		// Iterate through the array slots1 and slots2
		for (int i = 0; i < slots1.length; i++) {
			for (int j = 0; j < slots2.length; j++) {
				// if slots1 start time is equal to slots2 start time
				// verify if both start times are within the duration, 
				// if yes -> return the start time and start time + duration as a list
				if (slots1[i][0] == slots2[j][0] && slots1[i][0] + duration <= slots1[i][1]
						&& slots2[j][0] + duration <= slots2[j][1]) {
					return Arrays.asList(slots1[i][0], slots1[i][0] + duration);
				}
			}
		}
		// Return empty list if no match found
		return new ArrayList<>();
	}
	
	private List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		// Add both slots starting time to a queue by using a comparator to be in sorted order
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
		for (int[] s : slots1) {
			if (s[1] - s[0] >= duration) {
				pq.offer(s);
			}
		}
		for (int[] s : slots2) {
			if (s[1] - s[0] >= duration) {
				pq.offer(s);
			}
		}

		/*
		 * 1. Iterate through the queue
		 *  	a) if the first element is greater than the next element + duration
		 * 2. Finally return an empty array list if no match found
		 * 
		 */
		while (pq.size() > 1) {
			if (pq.poll()[1] >= pq.peek()[0] + duration) {
				return Arrays.asList(pq.peek()[0], pq.peek()[0] + duration);
			}
		}
		return Arrays.asList();
	}
}
