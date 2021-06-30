package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[100000];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int value  = arr[0];
		int max = value;
		for(int i = 1; i < n; i++) {
		    value = Math.max(arr[i], arr[i] + value);
		    max = Math.max(value, max);
		}
		
//		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//			if(i==0) {
//				dp[0] = arr[0];
//				MAX = dp[0];
//			}
//			dp[i] = dp[i-1]+arr[i];
//			if(MAX<dp[i]) {
//				MAX = dp[i];
//			}
//		}
		System.out.println(max);
	}

}
