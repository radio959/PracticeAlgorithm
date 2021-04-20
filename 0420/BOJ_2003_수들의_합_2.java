package during.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의_합_2 {
	
	static int N, M, numbers[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int s =0; // start
		int e = 0 ; //end
		int sum = 0; // 합이 M이 되어야 함
		int count =0 ; //  M이 되는 경우의 수
		
		while(true) {
			if(sum<M) { // M미만인 경우. 창 크기를 오른 쪽으로 늘려 나가야 함.
				if(e >= N ) 
					break;
				sum += numbers[e++];
			}else { // sum이 M보다 크거나 같은 경우
				sum -= numbers[s++];
			}
			if(sum == M) {
				count++;
			}
			
		}
		System.out.println(count);
	}
}
