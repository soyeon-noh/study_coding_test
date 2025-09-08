package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제이해
 * - N개의 집
 * - 거리는 선분
 * - 1~N번 집
 * - 집은 빨, 초, 파 색으로 칠해야함
 * - 칠하는 비용이 주어졌을 때 모든 집을 칠하는 비용의 최솟값 구하라
 * 
 * 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * 3. i(2<=i<=N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * 
 * 입력
 * - 집의 수
 * - 빨강 초록 파랑으로 칠하는 비용 x n번
 */
public class Main_1149_RGB거리 {

	
	static int N;
	static int R, G, B;
	static int[][] list;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new int[N][2]; // [0] 여기까지의 최소값 / [1] 0,1,2 = R,G,B
		
		int min;
		for(int n = 1; n <= N; n++) {
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			if(n==1) {
				if(R > G)
				min = Math.min(R,G);
				min = Math.min(min, B);
				
			}else if(n>1){
				
			}
			
		}
		
	}
}
