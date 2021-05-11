package make.up.lesson;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1238_Contact_BFS {
	static int[][] adj; // 인접행렬
	static int ans; // 가장 늦게 연락받는 애들 중 숫자 젤 큰놈.
	static int N, start; // a->b 세트가 N/2개 임.
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		
		for(int tc=1; tc<=TC; tc++) {
			adj = new int[101][101];
			N = sc.nextInt();
			start = sc.nextInt();
			ans = 0;
			visit = new boolean[101];
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adj[from][to] = 1;
			}
			bfs(start);
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
	
	static void bfs(int start) {
		Queue<Point> queue = new LinkedList<>(); // 공중 전화 사용 스케줄 작성표.
		
		queue.add(new Point(start, 0)); // 담임쌤이 연락하는 것도 공중전화로 함.
		visit[start] = true; // 우리반 모두가 공유하는 연락받는 사람 체크에 반장 연락 받음으로 체크함
		
		
		int maxTime =0;
		
		while(!queue.isEmpty()) { // 공중전화 쓸 사람 남았으면 계속 킵 고잉
			Point now = queue.poll(); // 연락을 받음.
			
			if(maxTime <now.time) {
				maxTime = now.time;
				ans = now.num;
			}else if(maxTime == now.time && ans < now.num) { // 똑같이 3시간 걸린 애면 출석번호 큰 애
				
			}
			
			for(int i=1; i<=100; i++) { // 연락 받았으니 내가 연락처 가지고 있는 친구들 찾아보자.
				if(adj[now.num][i] == 1 && !visit[i]) {
					visit[i] = true; 
					
				}
			}
		}
		
		
	}
	static class Point{
		int num, time;
		Point(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
}







