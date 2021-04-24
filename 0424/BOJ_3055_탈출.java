package during.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_3055_탈출 {

	static int R, C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visit;

	static class pos {
		int x, y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<pos> list;
	static Queue<pos> water;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		list = new LinkedList<>();
		water = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '*') {
					water.add(new pos(i, j));
				}
				if (map[i][j] == 'S') {
					list.add(new pos(i, j));
//					System.out.println("S 등록");
				}
			}
		}
		int ans = bfs();
		if (ans >= 0)
			System.out.println(ans);
		else
			System.out.println("KAKTUS");

	}

	private static int bfs() {
		int move = 0;
		
		while (!water.isEmpty() || !list.isEmpty()) {
			int wsize = water.size();
			for (int i = 0; i < wsize; i++) {
				pos temp = water.poll();
				int x = temp.x;
				int y = temp.y;
				for (int j = 0; j < 4; j++) {
					int nx = x + dr[j];
					int ny = y + dc[j];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;

					if (map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*')
						continue;

					map[nx][ny] = '*';
					water.add(new pos(nx, ny));
				}
			}

			int lsize = list.size();
			move++;
			for (int i = 0; i < lsize; i++) {
				pos temp = list.poll();
				int x = temp.x;
				int y = temp.y;
				for (int j = 0; j < 4; j++) {
					int nx = x + dr[j];
					int ny = y + dc[j];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny])
						continue;

					if (map[nx][ny] != '.' && map[nx][ny] != 'D')
						continue;

					if (map[nx][ny] == 'D')
						return move;

					map[x][y] = '.';
					visit[x][y] = true;

					map[nx][ny] = 'S';
					list.add(new pos(nx, ny));
				}
			}
		}

		return -1;
	}


}
