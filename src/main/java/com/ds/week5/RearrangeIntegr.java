package com.ds.week5;

import java.util.ArrayDeque;

import org.junit.Test;

public class RearrangeIntegr {
	
	@Test
	public void test1(){
		int [] arr={1,3,5,7,2,4,6,8};
		rearrangeArr(arr);
	}
	@Test
	public void test2(){
		int [] arr={1,2};
		rearrangeArr(arr);
	}
	@Test
	public void test3(){
		int [] arr={};
		rearrangeArr(arr);
	}

	private void rearrangeArr(int[] arr) {
		int left=0,right=arr.length/2,size=right;
		
		ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
		while( left < size) {
			queue.offer(arr[left++]);
			queue.offer(arr[right++]);
		}
		System.out.println(queue);
		
	}

}
