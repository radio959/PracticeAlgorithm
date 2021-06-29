package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린_괄호_answer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sub_st  = new StringTokenizer(br.readLine(),"-");
		int answer = Integer.MAX_VALUE;
		int temp;
		while(sub_st.hasMoreTokens()) {
			
			StringTokenizer add_st = new StringTokenizer(sub_st.nextToken(),"+");
			
			temp =0;
			while(add_st.hasMoreTokens()) {
				temp = temp + Integer.parseInt(add_st.nextToken());
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = temp;
			}else {
				answer-=temp;
			}
			
		}
		System.out.println(answer);
		
		
	}

}
