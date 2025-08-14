package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울_노소연 {

	static int N; // 무게추 수
	static int[] W; // 무게추 무게 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		for(int tc = 1; tc < T; tc++) {
			N = Integer.parseInt(br.readLine()); // 무게추 수 입력
			W = new int[N]; // 무게추 수 에 맞춰 무게 수 배열 생성
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
