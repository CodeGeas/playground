package com.jitesh.string;

public class LongestCommonSubsequence {

	//static int LCS[][];
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input1="AGGTAB";
		String input2="GXTXAYB";
		
		//LCS=new int[input1.length()][input2.length()];
		int length=LongestCommonSubsequence.longestCommonSubsequence(input1.toCharArray(),input2.toCharArray(),input1.length()-1,input2.length()-1);
		System.out.println(length);
	}

	private static int longestCommonSubsequence(char[] input1, char[] input2,int m,int n) {
		if(m==-1||n==-1)
		{
			return 0;
		}
		else if(input1[m]==input2[n]){
			return 1+longestCommonSubsequence(input1, input2, m-1, n-1);
		}
		else
		{
			return Math.max(longestCommonSubsequence(input1, input2, m-1, n), longestCommonSubsequence(input1, input2, m, n-1));
		}
		
	}

}
