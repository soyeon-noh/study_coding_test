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
public class Main_1149_노소연 {
	
	// 생각을 해봤는데. DP문제든 뭐든
	// 나머지는 알바가 아니라는 태도가 필요한 것 같음
	static int N;
	static int R, G, B;
	static int[][] list;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		list = new int[N][3]; // Nx3 배열로 만들 생각을 어떻게 하는 거임?
		// N+1로 해서 0인덱스를 만들어야 아래의 초기값을 안 적어도됨.
		// 집을 하나도 안칠했을 때 0원이라는 0인덱스가 있으면 점화식 가능
		
		// 초기값 입력
		st = new StringTokenizer(br.readLine(), " ");
		list[0][0] = Integer.parseInt(st.nextToken()); 
		list[0][1] = Integer.parseInt(st.nextToken()); 
		list[0][2] = Integer.parseInt(st.nextToken()); 
		
		for(int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			R = Integer.parseInt(st.nextToken()); 
			G = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
			
			list[n][0] = R + Math.min(list[n-1][1], list[n-1][2]);
			list[n][1] = G + Math.min(list[n-1][0], list[n-1][2]);
			list[n][2] = B + Math.min(list[n-1][0], list[n-1][1]);
		}
		
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, list[N-1][i]);
		}
		
		sb.append(min);
		System.out.println(sb.toString());
	}
}
