package com.jitesh.dp;

import java.util.Arrays;

public class MinCostPath {

	public static void main(String[] args) {
		 int cost[][] = new int[][]{ {1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3} };
		 
		 int minCost=minCost(0,0,2,2,cost);
		 System.out.println(minCost);

	}

	private static int minCost(int startX,int startY,int endX, int endY, int[][] cost) {
		int minCost=0;
		if(endX<startX || endY<startY ){
			minCost=Integer.MAX_VALUE;
		}
		else if(endX==startX && endY==startY){
			return cost[startX][startY];
		}
		else {
		minCost=cost[endX][endY]+min(minCost(startX, startY, endX, endY-1,cost), minCost(startX, startY, endX-1, endY,cost),minCost(startX, startY, endX-1, endY-1,cost));
		}
		return minCost;
	}

	private static int min(Integer... arr) {
	int min=Arrays.asList(arr).stream().min(Integer::compare).get();
//int min=Integer.MAX_VALUE;
//for(int i:arr)
//		
	return min;
	}

}
