package com.ds.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OperationBasedReverse {

	@Test
	public void test1() {
		int[] nums = { 5, 3, 1, 2, 5 };
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		int[][] operations = { { 0, 1 }, { 1, 3 } };
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		List<Integer> sub = new ArrayList<Integer>();
		sub.add(0);
		sub.add(2);
		List<Integer> sub1 = new ArrayList<Integer>();
		sub1.add(1);
		sub1.add(2);
		List<Integer> sub2 = new ArrayList<Integer>();
		sub2.add(0);
		sub2.add(2);
		list2.add(sub);
		list2.add(sub1);
		list2.add(sub2);
		List<Integer> asList = Arrays.asList(2, 1, 3);
		Assert.assertEquals(asList, performOperations(list1, list2));
	}

	private int[] reverseArray(int[] nums, int[][] operations) {
		for (int i = 0; i < operations.length; i++) {
			int temp = nums[operations[i][0]];
			nums[operations[i][0]] = nums[operations[i][1]];
			nums[operations[i][1]] = temp;
		}
		return nums;
	}

	/*
	 * public static List<Integer> performOperations(List<Integer> arr,
	 * List<List<Integer>> operations) { for (int i = 0; i < operations.size(); i++)
	 * { List<Integer> list = operations.get(i); int temp = arr.get(list.get(0));
	 * System.out.println(temp); arr.set(list.get(0), arr.get(list.get(1)));
	 * arr.set(list.get(1), temp); } System.out.println(arr); return arr; }
	 */
	
	public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        for(int i=0;i<operations.size();i++){
            List<Integer> list = operations.get(i);
            arr = reverse(arr, list.get(0), list.get(1));
        }
        return arr;
    }
    
    public static List<Integer> reverse(List<Integer> arr, int start, int end){
        int left = start, right = end;
        while (left<right){
            int temp = arr.get(left);
            arr.set(left++, arr.get(right));
            arr.set(right--, temp);
        }
        return arr;
    }
}
