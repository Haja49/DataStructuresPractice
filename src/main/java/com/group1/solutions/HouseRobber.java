package com.group1.solutions;

import org.junit.Test;

import junit.framework.Assert;

public class HouseRobber {

	@Test
	public void test1() {
		int[] nums = { 1, 2, 3, 1 };
		Assert.assertEquals(4, rob(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 0 };
		Assert.assertEquals(4, rob(nums));
	}

	@Test
	public void test3() {
		int[] nums = { 2, 1, 1, 2 };
		Assert.assertEquals(4, rob(nums));
	}
	
	public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] out = new int[nums.length];
        out[0] = nums[0];
        out[1] = nums[1];
        out[2] = nums[0]+nums[2];
        for(int i=3;i<nums.length;i++){
            out[i] = nums[i] + Math.max(out[i-2],out[i-3]);
        }
        return Math.max(out[nums.length-1],out[nums.length-2]);

		/*
		 * nums[1] = Math.max(nums[0], nums[1]); for(int i=2;i<nums.length;i++){ nums[i]
		 * = Math.max(nums[i]+nums[i-2],nums[i-1]); } return
		 * Math.max(nums[nums.length-1],nums[nums.length-2]);
		 */
    }
}
