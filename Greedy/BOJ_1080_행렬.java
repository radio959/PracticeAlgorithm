package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
	
	static int N, M;
	static int arr[][];
	static int after[][];

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr  = new int[N][M];
		after  = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				after[i][j] = temp.charAt(j)-'0';
			}
		}
		
		if(N<3 || M<3) {
			if(bigyo()) {
				System.out.println(0);
				return;
			}
			System.out.println(-1);
			return;
		}
		
//		System.out.println("arr배열입니다.");
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}
//		
//		System.out.println("after배열입니다.");
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(after[i][j]+" ");
//			}System.out.println();
//		}
		
		int cnt =0;
		
		for(int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-3; j++) {
				if(arr[i][j]!=after[i][j]) {
					transform(i,j);
					cnt++;
				}
				
				if(bigyo()) {
					System.out.println(cnt);
					return;
				}
			}
		}
		System.out.println(-1);
		return;
		
		
	}
	private static boolean bigyo() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != after[i][j])
					return false;
			}
		}
		return true;
	}
	private static void transform (int a, int b) {
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				if(arr[i][j] ==0) arr[i][j] = 1;
				else arr[i][j] = 0;
			}
		}
	}

}
