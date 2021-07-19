package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int [N];
		
		int cnt = 1;
		
		dp[0] = cnt;
		int MAX = 1;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i>0) {
				if(arr[i-1]>arr[i]) {
					MAX = MAX < cnt ? cnt : MAX;
					
					cnt = 0;
					dp[i] = cnt;
					continue;
				}
				dp[i] = ++cnt;
			}
		}
		System.out.println(MAX);
	}

}
