package com.jitesh.dp;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {

	List<ArrayList<Integer>> generateSubsets(int n,List<ArrayList<Integer>> subsets){
		List<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		result.addAll(subsets);
		for(int i=0;i<subsets.size();i++){
			ArrayList<Integer> set=new ArrayList<Integer>();
			set.addAll(subsets.get(i));
			
			set.add(n);
			result.add(set);
		}
		//result.add(new ArrayList<Integer>());
		return result;
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> set=new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		List<ArrayList<Integer>> subset=new ArrayList<ArrayList<Integer>>();
		subset.add(new ArrayList<Integer>());
		for(int i=0;i<set.size();i++){
		subset=new AllSubSets().generateSubsets(set.get(i), subset);	
		}
		System.out.println(subset);
	}

}
