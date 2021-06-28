package beginner_도형만들기;

import java.util.Scanner;

public class JungOl_1291_구구단 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int s, e;
		
		
		s = sc.nextInt();
		e = sc.nextInt();
		
		while(s<2 || e <2 || s>9 || e>9) {
			System.out.println("INPUT ERROR!");
			s = sc.nextInt();
			e = sc.nextInt();
			
		}
//		if(s<2 || e <2 || s>9 || e>9) {
//			do{
//			}while(s<2 || e <2 || s>9 || e>9);
//		}
		
		printgugu(s,e);
//		while(s<2 || e <2 || s>9 || e>9) {
//			System.out.println("INPUT ERROR!");
//			s = sc.nextInt();
//			e = sc.nextInt();
//		}
	}

	private static void printgugu(int s, int e) {
		
		
		if(s>=e) {
			for(int j=1; j<=9; j++) {
				for(int i=s; i>=e; i--) {
					if((j*i<10)) {
						System.out.print(i+" * "+j+" =  "+(j*i));
					}else if((j*i>=10)) {
					System.out.print(i+" * "+j+" = "+(j*i));
					}
					System.out.print("   ");
				}System.out.println();
			}
		}
		if(s<e) {
			for(int j=1; j<=9; j++) {
				for(int i=s; i<=e; i++) {
					if((j*i<10)) {
						System.out.print(i+" * "+j+" =  "+(j*i));
					}else if((j*i>=10)) {
					System.out.print(i+" * "+j+" = "+(j*i));
					}
					System.out.print("   ");
				}System.out.println();
			}
		}
		
	}

}
