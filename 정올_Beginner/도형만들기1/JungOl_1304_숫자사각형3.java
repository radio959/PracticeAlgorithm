package beginner_도형만들기;

import java.util.Scanner;

public class JungOl_1304_숫자사각형3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n;
		
		n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		int num =1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[j][i] = num++;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
	}

}
