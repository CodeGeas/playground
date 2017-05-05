package com.jitesh.arrays;

public class MaxSumSubArray {

	public int getMaxSumSubarray(int arr[]) {

		int sum = 0;
		int max_sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sum < arr[i]) {
				sum = arr[i];
			}

			if (sum > max_sum) {
				max_sum = sum;
			}
		}
		return max_sum;
	}

	public static void main(String[] args) {
		int arr[] = { -2, -3, -4, -1, -2, 1, 5, -3 };

		System.out.println("Max sum of subarray is "
				+ new MaxSumSubArray().getMaxSumSubarray(arr));
	}

}
