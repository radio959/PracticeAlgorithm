package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무_자르기 {
	
	static int MIN = Integer.MAX_VALUE;
	static long M, ans;
	static int N;
	static long[] arr;

	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		ans=-1;
		
		arr = new long[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		ans=binarySearch();
		
		System.out.println(ans);
		
		
	}

	private static long binarySearch() {
		long start =0;
		long end = arr[N-1];
		long mid = arr[N-1]/2;
		
		while(start<=end) {
			long tmp =0;
			for(int i=0; i<N; i++) {
				if(mid<arr[i]) {
					tmp += arr[i]-mid;
				}
			}
			if(tmp==M) {
				return mid;
			}
			if(tmp>M) {
				start=mid+1;
			}
			if(tmp<M) {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		return mid;
	}

}
