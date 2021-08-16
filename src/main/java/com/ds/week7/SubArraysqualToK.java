package com.ds.week7;

import org.junit.Test;

import junit.framework.Assert;

public class SubArraysqualToK {

	@Test
	public void test1() {
		int[] nums = { 1, 2, 1, 2, 1 };
		int k = 3;
		Assert.assertEquals(4, subarraySum(nums, k));
	}
	
	 public int subarraySum(int[] nums, int k) {
	        int count=0;
	        for(int i=0;i<nums.length;i++){
	            int sum = 0;
	            for(int j=i;j<nums.length;j++){
	                sum += nums[j];
	                if(sum==k){
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
}
