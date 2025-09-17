package com.codingtest.bk.stepByStep;

import java.util.Scanner;

// 중복순열
public class Main_15651_N과M3 {

	static int N, R;
	static int result[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		result = new int[R];
		
		permutation(0);	
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			for(int n :result) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i = 1; i <= N; i++) {
			result[cnt] = i;
			permutation(cnt+1);
		}
		
	}
	
	

}
