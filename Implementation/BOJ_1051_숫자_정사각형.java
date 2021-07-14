package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자_정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] square = new int[N][M];
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				square[i][j] = temp.charAt(j)-'0';
			}
		}
		
		int max_length = M<N ? M : N;
		while(max_length>0) {
			for(int i=0; i<=N-max_length; i++) {
				for(int j=0; j<=M-max_length; j++) {
					if(checkCorner(i,j,square,max_length-1)) {
						System.out.println(max_length*max_length);
						return;
					}
				}
			}
			max_length--;
		}
	}

	private static boolean checkCorner(int i, int j, int[][] square, int length) {
		if(square[i][j]==square[i+length][j]&&
				square[i+length][j]==square[i][j+length]&&
						square[i][j+length]==square[i+length][j+length]) {
			return true;
		}
		return false;
	}

}
