package com.jitesh.dp;

public class ZeroOneKnapsack {
	
	

	public static void main(String[] args) {

		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    
	    ZeroOneKnapsack zeroOneKnapsack=new ZeroOneKnapsack();
	    int value=zeroOneKnapsack.solveKnapsack(W,wt,val,0);
	    int value2=zeroOneKnapsack.solveKnapsackDP(W,wt,val,val.length);
	    System.out.println(value);
	    System.out.println(value2);
	}

	private int solveKnapsackDP(int W, int wt[], int val[], int n) {

		   int i, w;
		     int K[][] = new int[n+1][W+1];
		      
		     // Build table K[][] in bottom up manner
		     for (i = 0; i <= n; i++)
		     {
		         for (w = 0; w <= W; w++)
		         {
		             if (i==0 || w==0)
		                  K[i][w] = 0;
		             else if (wt[i-1] <= w)
		                   K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
		             else
		                   K[i][w] = K[i-1][w];
		         }
		      }
		      
		      return K[n][W];
	}

	private int solveKnapsack(int w, int[] wt, int[] val,int n) {

		
		if((w==0)||(n==wt.length)){
			return 0;
		}
		else if(wt[n]>w)
		{
			return solveKnapsack(w,wt,val,n+1);
		}	
		else
			
		{
			return Math.max(val[n]+solveKnapsack(w-wt[n],wt,val,n+1), solveKnapsack(w,wt,val,n+1));
		}
		
		
	}

}
