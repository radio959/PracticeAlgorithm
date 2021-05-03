package make.up.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의_개수_bfs {
	
	static int W,H,ans;
	static int[][] map;
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}; // 좌측상단부터 시계방향
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		do { // 둘 중 하나라도 0이 아니면 계속 돌리기. 즉, 둘 다 0 이면 종료
			st = new StringTokenizer(br.readLine()," "); // W와 H 입력
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W]; 						// map 크기 설정
			visit = new boolean[H][W];
			ans=0;

			for(int i=0 ; i<H; i++) { // map 입력
				st = new StringTokenizer(br.readLine()," ");
				for(int j =0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0 ; i<H; i++) { // map 입력
				for(int j =0; j<W; j++) {
					BFS(i,j);
				}
			}
			
			if(W!=0 && H!=0)
				sb.append(ans).append("\n");
			
		}while( W!=0 || H!=0 );
		
		System.out.println(sb);
		
	}
	private static void BFS(int r, int c) {
		if(visit[r][c]) return;
		
		if(map[r][c]==0) return;
		
		if(map[r][c]==1) ans++;
		
		Queue<int[]> q = new LinkedList<int[]> ();
		q.offer(new int[] {r,c});
		visit[r][c] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0; i<8; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if(nr>=0 && nr <H && nc>=0 && nc<W && map[nr][nc]==1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new int[] {nr,nc});
				}
			}
		}
	}

}
