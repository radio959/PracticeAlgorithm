package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15903_카드합체놀이 {
	
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for(int i=0; i<m; i++) {
			
			long temp = arr[0]+arr[1];
			arr[0] = temp;
			arr[1] = temp;
			Arrays.sort(arr);
			
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[j]+" ");
//			}System.out.println();
			
		}
		
		long answer=0;
		for(int i=0; i<n; i++) {
			answer+=arr[i];
		}
		System.out.println(answer);
	}

}
