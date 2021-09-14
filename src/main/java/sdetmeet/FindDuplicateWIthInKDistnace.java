package sdetmeet;

import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class FindDuplicateWIthInKDistnace {
	
	
	@Test
	public void test1() {
		int[]nums= {1,2,3,1};
		int k=2;
		Assert.assertEquals(true, findDuplicateWithInK(nums,k));
	}
	@Test
	public void test2() {
		int[]nums= {1,2,1,1};
		int k=2;
		Assert.assertEquals(false, findDuplicateWithInK(nums,k));
	}
	
	
	public boolean findDuplicateWithInK(int[] nums, int k){
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
		if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k)return false;
		map.put(nums[i],i);
		}
		return true;
		}

}
