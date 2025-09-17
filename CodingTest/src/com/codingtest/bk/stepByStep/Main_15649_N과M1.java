package com.codingtest.bk.stepByStep;

import java.util.Scanner;

// 순열
public class Main_15649_N과M1 {

	static int N, R;
	static int[] result;
	static boolean[] visited; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // n
		R = sc.nextInt(); // r
		result = new int[R];
		visited = new boolean[N+1];
		
		permutation(0);
	}

	private static void permutation(int cnt) {
		
		if(cnt == R) {
			for(int n : result) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			result[cnt] = i;
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
		
	}
}

