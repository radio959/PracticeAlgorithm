package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501_주식 {
	static int T, N;
	static long answer;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int MAX;
		
		for(int i=0; i<T; i++) {
			answer = 0;
			MAX = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=N-1; j>=0; j--) {
				if(arr[j]>MAX) {
					MAX = arr[j];
				}
				if(arr[j]<MAX) {
					answer += MAX - arr[j];
				}
			}

			System.out.println(answer);
		}
	}
}
