package com.jitesh.dp;

public class RobotWays {
	

	public static void main(String[] args) {
		int ways[][]=new int[10][10];
		int X=2,Y=2;
		System.out.println(waysCount(ways,X,Y));

	}

	private static int waysCount(int[][] ways, int x, int y) {
		if(ways[x][y]!=0){
			return ways[x][y];
		}
		if((x==0) || (y==0)){
			ways[x][y]= 1;
		}
		
		else
		{
		ways[x][y]=waysCount(ways,x-1,y)+waysCount(ways,x,y-1);
		}
		return ways[x][y];
	}

}
