package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private  static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
		
		public static List<List<Integer>> permuteL(int[] num) {
		    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		    res.add(new ArrayList<Integer>());
		    for (int n : num) {
		        int size = res.size();
		        for (; size > 0; size--) {
		            List<Integer> r = res.pollFirst();
		            for (int i = 0; i <= r.size(); i++) {
		                List<Integer> t = new ArrayList<Integer>(r);
		                t.add(i, n);
		                res.add(t);
		            }
		        }
		    }
		    return res;
		}
		
		public static void main(String[] args) {
			permuteL(new int[] {2,1,3});
		}
}
