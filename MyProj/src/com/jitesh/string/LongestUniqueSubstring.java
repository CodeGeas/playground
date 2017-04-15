package com.jitesh.string;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
	
	
	public String uniqueSubstring(String input){
		
		char arr[]=input.toCharArray();
		Map<Character,Integer> uniqueCharMap=new HashMap<Character,Integer>();
		int startIndex=0,endIndex=0,maxStart=0,maxEnd=0,maxLength=0;
		
		
		for(int i=0;i<arr.length;i++){
		
			if(!uniqueCharMap.containsKey(arr[i])){
				uniqueCharMap.put(arr[i], i);
				endIndex=i;
			}
			else
			{
				int pos=uniqueCharMap.get(arr[i]);
				if(startIndex<=pos)
					{
					startIndex=pos+1;
					}
				uniqueCharMap.put(arr[i], i);
				endIndex=i;
			}
			
			if(endIndex-startIndex + 1> maxLength){
				maxStart=startIndex;
				maxEnd=endIndex;
				maxLength=endIndex-startIndex +1;
				System.out.println("maxStart="+maxStart+" ,maxEnd="+maxEnd+",maxLength="+maxLength+" ,string so far="+input.substring(maxStart, maxEnd+1));
			}
		}
		
		return input.substring(maxStart, maxEnd+1);
	}
	
	public static void main(String args[]){
	
		String input="geeksforgeeks";
		
		LongestUniqueSubstring longestUniqueSubstring=new LongestUniqueSubstring();
		String substr=longestUniqueSubstring.uniqueSubstring(input);
		System.out.println(substr);
	}
	
	

}
