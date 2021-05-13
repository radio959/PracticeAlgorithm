package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3272_두_수의_합_two_pointer {

	static int n,x,cnt;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		cnt=0;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0 ;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		twoPointer();
		
		System.out.println(cnt);
	}

	private static void twoPointer() {
		int start =0;
		int end = arr.length-1;
		while(start<=end) {
			int sum = arr[start]+arr[end];
			if(sum == x) {
				cnt++;
			}if(sum>=x) {
				end--;
			}if(sum<=x) {
				start++;
			}
		}
	}
}
