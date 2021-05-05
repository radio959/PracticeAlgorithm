package practiceBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	static int N, M;
	static boolean [] visit;
	static ArrayList<Integer>[] list;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans=0;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		BFS(1);
		System.out.println(ans-1);
	}
	private static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(!visit[temp]) {
				visit[temp] = true;
				ans++;
			}
			for(int i: list[temp]) {
				if(!visit[i]) {
					q.add(i);
				}
			}
		}
		
	}

}
