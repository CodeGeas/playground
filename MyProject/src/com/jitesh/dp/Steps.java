package com.jitesh.dp;

import java.util.HashMap;
import java.util.Map;

public class Steps {
	Map<Integer,Integer> map=new HashMap<Integer, Integer>();
	
	int ways(int n){
		if(n==0){
			return 1;
		}
		else if(n<0){
			return 0;
		}
		
		return ways(n-1)+ways(n-2)+ways(n-3);
	}
	
	
	int waysDP(int n){
		Integer ways=map.get(n);
		if(ways!=null){
			return ways;
		}
		
		if(n==0){
			ways=1;
		}
		else if(n<0){
			ways= 0;
		}
		else
		{
		ways=waysDP(n-1)+ways(n-2)+ways(n-3);
	
	}
		map.put(n, ways);
		return ways;
	}

	public static void main(String[] args) {
		
		System.out.println(new Steps().ways(8));
		System.out.println(new Steps().waysDP(8));


	}

}
