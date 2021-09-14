package com.ds.week8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class FindErrorInSelling {

	@Test
	public void test1() {
		List<String> list1 = Arrays.asList("tomato", "chocolate", "cheese");
		List<Integer> list2 = Arrays.asList(10, 10, 30);
		List<String> list3 = Arrays.asList("tomato", "chocolate", "cheese");
		List<Integer> list4 = Arrays.asList(10,20,30);
		Assert.assertEquals(1, findError(list1, list2, list3, list4));
	}
	
	@Test
	public void test2() {
		List<String> list1 = Arrays.asList("egg", "milk");
		List<Integer> list2 = Arrays.asList(33, 44);
		List<String> list3 = Arrays.asList("egg", "milk", "egg");
		List<Integer> list4 = Arrays.asList(11, 42, 22);
		Assert.assertEquals(3, findError(list1, list2, list3, list4));
	}
	
	@Test
	public void test3() {
		List<String> list1 = Arrays.asList("egg", "milk");
		List<Integer> list2 = Arrays.asList(33, 44);
		List<String> list3 = Arrays.asList("egg", "milk", "milk");
		List<Integer> list4 = Arrays.asList(11, 32, 22);
		Assert.assertEquals(3, findError(list1, list2, list3, list4));
	}

	private int findError(List<String> list1, List<Integer> list2, List<String> list3, List<Integer> list4) {
		Map<String, Integer> actual = new HashMap<String, Integer>();
		for (int i = 0; i < list1.size(); i++) {
			actual.put(list1.get(i), actual.getOrDefault(list1.get(i), 0) + list2.get(i));
		}
		/*Map<String, Integer> sold = new HashMap<String, Integer>();
		for (int i = 0; i < list3.size(); i++) {
			sold.put(list3.get(i), sold.getOrDefault(list3.get(i), 0) + list4.get(i));
		}
		int count = 0;
		for (Entry<String, Integer> soldProduct : sold.entrySet()) {
			if(actual.containsKey(soldProduct.getKey())) {
				int actualValue = actual.get(soldProduct.getKey());
				int soldValue = soldProduct.getValue();
				if (Math.abs(actualValue -soldValue)>0)
					count++;
			} else
				count++;
		}*/
		int count =0;
		for (int i = 0; i < list3.size(); i++) {
			if(actual.containsKey(list3.get(i))) {
				int actualValue = actual.get(list3.get(i));
				int soldValue = list4.get(i);
				if(actualValue != soldValue) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
	    Set<String> set = new HashSet<String>();    
	    int error = 0;
	    for(int i=0; i<products.size(); i++){
	        set.add(products.get(i)+"-"+productPrices.get(i));
	    }
	    for(int i=0; i<productSold.size(); i++){
	        if(set.add(productSold.get(i)+"-"+soldPrice.get(i))){
	            error++;
	            //System.out.println(error);
	        }
	    }
	    return error;
	}
}
