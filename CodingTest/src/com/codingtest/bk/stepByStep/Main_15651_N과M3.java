package com.codingtest.bk.stepByStep;

import java.util.Scanner;

// 중복순열
public class Main_15651_N과M3 {

	static int N, R;
	static int result[];
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		result = new int[R];
		
		permutation(0);	
		System.out.println(sb.toString());
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			for(int n :result) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i = 1; i <= N; i++) {
			result[cnt] = i;
			permutation(cnt+1);
		}
		
	}
	
	

}
