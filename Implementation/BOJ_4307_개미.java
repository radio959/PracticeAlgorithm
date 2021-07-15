import java.util.Arrays;
import java.util.Scanner;
public class BOJ_4307_개미 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt(), l, n, min, max;
		
		for(int i = 0; i < tc; i++) {
			l = scan.nextInt(); n = scan.nextInt();
			int[] points = new int[n];
			min = 1000000; max = 0;
			
			for(int j = 0; j < n; j++) {
				points[j] = scan.nextInt();
				if(points[j] >= l/2)
					min = Math.min(min, points[j]);
				else
					max = Math.max(max, points[j]);
			}
			Arrays.sort(points);
			System.out.println(Math.max(l - min, max) + " " + Math.max(l - points[0], points[n-1]));
		}
	}
}
