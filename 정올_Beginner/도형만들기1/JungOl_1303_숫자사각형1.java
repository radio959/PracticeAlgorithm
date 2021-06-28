package beginner_도형만들기;

import java.util.Scanner;

public class JungOl_1303_숫자사각형1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n, m;
		
		n = sc.nextInt();
		m = sc.nextInt();
		int num=1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.printf("%d ",num++);
			}System.out.println();
		}
	}

}
