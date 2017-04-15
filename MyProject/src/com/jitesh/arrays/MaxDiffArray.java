package com.jitesh.arrays;

public class MaxDiffArray {

	
	public int maxDiff(int arr[]){
		int curr_diff=arr[0],max_diff=Integer.MIN_VALUE,start=0;
		for(int i=1;i<arr.length;i++){
			curr_diff=arr[i]-arr[start];
			
			if(arr[start]>arr[i])
			{
				start=i;
			}
			if(curr_diff>max_diff){
				max_diff=curr_diff;
				
			}
			
		}
		return max_diff;
	}
	
	
	public static void main(String[] args) {

		int arr[]={1,2,3,0,10};
		//int arr[]={2,3,10,6,4,8,1};
		//int arr[]={1,2,90,10,110};
		System.out.println(new MaxDiffArray().maxDiff(arr));
	}

}
