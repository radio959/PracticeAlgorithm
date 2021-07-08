package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11508_투플러스원_세일 {
	
	static int N, answer;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		answer=0;
		
		for(int i=N-1; i>=0; i=i-3) {
			if(i>=0)
				answer+=arr[i];
			if(i-1>=0)
				answer+=arr[i-1];
		}
		System.out.println(answer);
	}
}
