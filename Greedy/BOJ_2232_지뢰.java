package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2232_지뢰 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[0] = -99999;
		int MAX = Integer.MIN_VALUE;
		int idxToStart = -1;
		int idxToEnd = -1;
		
		ArrayList<Integer> ansList = new ArrayList();
				
				
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
			if(MAX<arr[i]) {
				MAX = arr[i];
				idxToStart = i-1;
				idxToEnd = i+1;
			}
		}
		
		ansList.add(idxToStart+1);
		
		while(idxToStart>=1 || idxToEnd<N) {
			int toStart = arr[idxToStart];
			int toEnd = arr[idxToEnd];
			if(--idxToStart>=1 && arr[idxToStart]>toStart) {
				ansList.add(idxToStart);
				toStart = arr[idxToStart];
			}
			
			if(++idxToEnd<N && arr[idxToEnd]>toEnd) {
				ansList.add(idxToEnd);
				toEnd = arr[idxToEnd];
			}
		}
		Collections.sort(ansList);
		
		for(int i : ansList) {
			System.out.println(i);
		}
		
		
	}
}
