package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거_분배 {
	
	static int N, K;
	static char[] arr;
	static Queue<Integer> Plist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Plist = new LinkedList<Integer>();
		
		arr = new char[N];
		String temp = br.readLine();
		
		for(int i=0; i<N; i++) {
			arr[i] = temp.charAt(i);
			if(arr[i]=='P') {
				Plist.add(i);
			}
		}
		
		int answer=0;
		boolean already=false;
		int size = Plist.size();
		while(!Plist.isEmpty()) {
			int t = Plist.poll();
			for(int i=K; i>0; i--) {
				if(t-i>=0 && arr[t-i]=='H') {
					arr[t-i]='P';
					answer++;
					already=true;
					break;
				}
			}
			for(int i=1; i<=K; i++) {
				if(already) break;
				
				if(t+i<N && arr[t+i]=='H') {
					arr[t+i]='P';
					answer++;
					break;
				}
			}
			already = false;
		}
		System.out.println(answer);
	}

}
