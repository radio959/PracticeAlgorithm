package com.exam.ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	static int w, h, p, q, t;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int[] dd = { 2, 3, 0, 1 };
	static int[] dud = { 3, 2, 1, 0 };
	static int[] drl = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h + 1][w + 1];

		st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());

		if (t % (w * h) == 0) {
			System.out.println(p + " " + q);
			return;
		}

		move(q, p, 0, t % (w * h));
		
		System.out.println(p + " " + q);

	}

	public static void move(int r, int c, int d, int rest) {
		int nx, ny;
		if (rest == 0) {
			p = r;
			q = c;
			return;
		}
		
		// 파라미터를 받아와서 움직이기
		if (r > 0 && r < h && c > 0 && c < w) {
			nx = r + dx[d];
			ny = c + dx[d];

			move(nx, ny, d, rest - 1);
		}

		if (r == h && c == w) { // 오른쪽 위 구석에 박혔을 경우
			move(r - 1, c - 1, 2, rest - 1);
		}
		if (r == 0 && c == w) { // 오른쪽 아래 구석
			move(r + 1, c - 1, 1, rest - 1);
		}
		if (r == h && c == 0) { // 왼쪽 위 구석
			move(r - 1, c + 1, 3, rest - 1);
		}
		if (r == 0 && c == 0) { // 왼쪽 아래 구석
			move(r + 1, c + 1, 0, rest - 1);
		}

		if (r == h) { // 윗 벽
			if (d >= 1) {
				nx = r + dx[dud[d]];
				ny = c + dy[dud[d]];
				move(nx, ny, d + 2, rest - 1);
			} else {
				nx = r + dx[d];
				ny = c + dy[d];
				move(nx, ny, d, rest - 1);
			}

		}

		if (r == 0) { // 아래 벽
			if (d >= 1) {
				nx = r + dx[d];
				ny = c + dy[d];
				move(nx, ny, d, rest - 1);
			} else {
				nx = r + dx[dud[d]];
				ny = c + dy[dud[d]];
				move(nx, ny, d + 2, rest - 1);
			}

		}

		if (c == w) { // 오른 벽
			if (d == 1 || d == 2) {
				nx = r + dx[d];
				ny = c + dy[d];
				move(nx, ny, d, rest - 1);
			} else {
				nx = r + dx[drl[d]];
				ny = c + dy[drl[d]];
				move(nx, ny, drl[d], rest - 1);
			}

		}

		if (c == 0) { // 왼 벽
			if (d == 1 || d == 2) {
				nx = r + dx[drl[d]];
				ny = c + dy[drl[d]];
				move(nx, ny, drl[d], rest - 1);
			} else {
				nx = r + dx[d];
				ny = c + dy[d];
				move(nx, ny, d, rest - 1);
			}

		}


	}

}


