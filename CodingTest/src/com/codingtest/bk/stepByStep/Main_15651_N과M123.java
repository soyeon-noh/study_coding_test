package com.codingtest.bk.stepByStep;

import java.util.Scanner;

public class Main_15651_N과M123 {

	static int N, R;
	static boolean result[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		result = new boolean[N+1];
		
		subset(0);
		
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			for(int i = 1; i <= N; i++) {
				if(result[i] == false) continue;
				System.out.println(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			result[i] = true;
			subset(cnt+1);
			result[i] = false;
			subset(cnt+1);
		}
		
	}
}
