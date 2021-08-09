package com.ds.week5;

import java.util.ArrayDeque;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ReverseArray {

	@Test
	public void test1(){
		int[] input={2,4,6,8,10};
		int k=3;
		Assert.assertArrayEquals(new int[]{6, 4,2,8,10},reverseArray(input,k));
				
	}
	
	@Test
	public void test2(){
		int[] input={2,4,6,8,10};
		int k=5;
		Assert.assertArrayEquals(new int[]{10, 8,6,4,2},reverseArray(input,k));
				
	}

	@Test
	public void test3(){
		int[] input={2,4,6,8,10};
		int k=0;
		Assert.assertArrayEquals(new int[]{2,4,6,8,10},reverseArray(input,k));
				
	}


	private int[] reverseArray(int[] input,int k) {
		if(k==0||k==1) return input;
		
		ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		
		for (int i = 0; i < k; i++) {
			stack.push(input[i]);			
		}
		for (int i = 0; i < k; i++) {
			queue.offer(stack.pop());		
		}
		for (int i = k; i < input.length; i++) {
			queue.offer(input[i]);			
		}
		for(int i=0;i<input.length;i++){
			input[i]=queue.poll();
		}
		return input;
	}
	
}
