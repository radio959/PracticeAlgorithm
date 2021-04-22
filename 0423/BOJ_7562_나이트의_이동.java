package practiceBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의_이동 {
	
	static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	static int[][] board;
	static boolean[][] visit;
	
	static int N,T;
	static int destx,desty;
	static class pos{
		int x, y, count;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {

			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visit = new boolean[N][N];
			st = new StringTokenizer(br.readLine()," ");
			pos start = new pos(Integer.parseInt(st.nextToken())
						,Integer.parseInt(st.nextToken()));	
			
			st = new StringTokenizer(br.readLine()," ");
			destx = Integer.parseInt(st.nextToken());
			desty = Integer.parseInt(st.nextToken());
			
			BFS(start);
			sb.append(board[destx][desty]).append("\n");
		}
		System.out.println(sb);
	}
	private static void BFS(pos a) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(a);
		
		while(!q.isEmpty()) {
			pos temp = q.poll();
			
			if(temp.x == destx && temp.y == desty)
				return;
			
			for(int i=0; i<8; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				int cnt = board[temp.x][temp.y]+1;
				
				if(nx>=N || ny>=N || nx<0 || ny<0) {
					continue;
				}
				if(visit[nx][ny]) {
					continue;
//					board[nx][ny] = cnt;
//					q.add(new pos(nx, ny));
				}
				if(!visit[nx][ny]) {
					board[nx][ny] = cnt;
					visit[nx][ny] = true;
					q.add(new pos(nx, ny));
				}
				
			}
		}
	}

}
