package practiceBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	
	static int M, N,ans;
	static int[][] box;
	static Queue<pos> list = new LinkedList<>();
	static class pos {
		int x, y;
		public pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]>0) {
					list.add(new pos(i,j));
				}
				if(box[i][j]!=0) {
					visit[i][j] = true;
				}
			}
		}
		ans=1;
		BFS();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans-1);
		br.close();
		
	}
	public static void BFS() {
		
		while(!list.isEmpty()) {
			pos temp = list.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx>=0&& nx<N && ny >=0 && ny<M && box[nx][ny]==0 && !visit[nx][ny]) {
					box[nx][ny]=box[temp.x][temp.y]+1;
					visit[nx][ny] = true;
					list.add(new pos(nx, ny));
					ans=box[nx][ny];
				}
			}
		}
		
	}
}
