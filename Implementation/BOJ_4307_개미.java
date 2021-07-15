package Implementation;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_4307_개미 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int n, l;
		
		for(int tc = 0 ; tc<T; tc++) {
			int slow = Integer.MIN_VALUE;
			int fast = Integer.MIN_VALUE;
			
			l = sc.nextInt();
			n = sc.nextInt();
			for(int i=0; i<n; i++) {
				int temp = sc.nextInt();
				if(temp<l/2) {
					fast = Math.max(fast, temp);
					slow = Math.max(slow, l-temp);
				}else {
					fast = Math.max(fast, l-temp);
					slow = Math.max(slow, temp);
				}
			}
			System.out.println(fast+" "+slow);
			
		}
		
		
		
	}

}
