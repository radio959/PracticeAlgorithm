package beginner_도형만들기;

import java.util.Scanner;

public class JungOl_1856_숫자사각형2 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n, m;
		
		n = sc.nextInt();
		m = sc.nextInt();
		int num=1;
		for(int i=0; i<n; i++) {
			if(i%2==0) {
				for(int j=0; j<m; j++) {
					System.out.printf("%d ",num++);
				}System.out.println();
			}
			else {
				num = num+m;
				for(int j=0; j<m; j++) {
					System.out.printf("%d ",num-j-1);
				}System.out.println();
			}
		}
	}

}
