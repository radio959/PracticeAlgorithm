package com.ssafy.back;

import java.util.Scanner;

public class B1_NQueenTest {

	static int ans, N;
	static int[] col;

	// 같은 행에는 놓지 않는 방식
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N + 1];
		
		setQueen(0);
		System.out.println(ans);

	}
	
	public static void setQueen(int rowNo) {
		
		// 현재 노드가 유망하지 않다면 돌아가기
		if(!isAvailable(rowNo)) {
			return;
		}
		
		//퀸이 끝까지 닿았을 때
		if(rowNo == N) {
			ans++;
			return;
		}
		
		//자식노드의 가지를 파생
		for(int i=1; i<=N; i++) {
			col[rowNo+1] =i;
			setQueen(rowNo+1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		
		for(int i=1; i<rowNo; i++) {
			//퀸이 서로 위협적인 위치면 false 반환
			//i는 이전 단계의 퀸
			// 왼쪽은 같은 열에 있는지 check, 오른쪽은 대각선에 서로 위치해 있는지 check하는 조건.
			if(col[rowNo]==col[i] || Math.abs(col[rowNo]-col[i])==rowNo-i) return false;
				
		}
		
		return true;
	}

}
