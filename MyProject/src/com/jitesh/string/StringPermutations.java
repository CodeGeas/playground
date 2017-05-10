package com.jitesh.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	
	
	public static void main(String[] args) {

		
		String input="ABCD";
		List<String> perm=new ArrayList<String>();
		perm.add(input.charAt(0)+"");
		System.out.println(findPermutations(1,input,perm));
	}

	private static List<String> findPermutations(int index, String input,
			List<String> perm) {
if(index==input.length()){
	return perm;
}
else
{
	List<String> result=new ArrayList<String>();
	for(String p:perm){
	char arr[]=p.toCharArray();
	for(int i=0;i<arr.length;i++){
		StringBuffer sb=new StringBuffer();
		int j=0;
		for(j=0;j<i;j++)
			
		{
		sb.append(arr[j]);
		}
		sb.append(input.charAt(index));
		while(j<arr.length)
			
		{
			sb.append(arr[j]);
			j++;
		}
		result.add(sb.toString());
	}
	result.add(p+input.charAt(index));
	}
	return findPermutations(index+1, input, result);

}
		
	}

}
