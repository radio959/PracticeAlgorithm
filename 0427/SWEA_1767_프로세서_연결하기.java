package com.exam.ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서_연결하기 {
	
	static class pos {
		int x, y;
		public pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, ans;
	static int[][] processor;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static ArrayList<pos> list;
	static int min,max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			processor = new int[N][N];
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					processor[i][j] = Integer.parseInt(st.nextToken());
					if(processor[i][j] == 1) {
						if(i-1<0 || j-1 <0 || i+1 >=N || j+1>=N) continue;
						
						list.add(new pos(i,j));
					}
				}
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			dfs(0,0,0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int coreCnt, int length) {
		// idx : 코어의 번호
		// coreCnt : 연결할 수 있는 코어의 수.
		// length : 전선의 길이.
		
		if(idx == list.size()) {
			if(max<coreCnt) {
				max = coreCnt;
				min = length;
			}
			else if(max == coreCnt) {
				if(min>length)
					min = length;
			}
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		for(int dir=0; dir<4; dir++) {
			int cnt =0;
			int startX = x;
			int startY = y;
			int nx = x;
			int ny = y;
			
			
			while(true) { // 전선을 바로 깔지 않고 일단은 체크를 먼저 해본다.
				nx += dx[dir];
				ny += dy[dir];
				
				if(nx<0 || ny <0 || nx>=N || ny>=N) break;
				
				if(processor[nx][ny] ==1) { // 전선이면 못가니까 카운트 0하고 브레이크
					cnt =0;
					break;
				}
				cnt++;
			}
			
			
			for(int j=0; j<cnt; j++) { // 모든 체크가 끝나면 카운트 만큼 돌면서 전선을 채워준다.
				startX +=dx[dir];
				startY +=dy[dir];
				
				processor[startX][startY] = 1;
			}
			
			if(cnt ==0) { //전선을 연결할 수 없는 코어라면 다음 코어로 이동.
				dfs(idx+1,coreCnt,length); // 이동만 함.
			}
			else {
				dfs(idx+1,coreCnt+1,length+cnt); // 이동하면서 현재 전선의 길이 넘겨줌.
				
				startX = x;
				startY = y;
				for(int i=0; i<cnt; i++) { // 다시 돌아왔을 때 원래 상태로 해놔야 함.
					startX +=dx[dir];
					startY +=dy[dir];
					
					processor[startX][startY] = 0;
				}
			}
			
		}
		
	}
}
