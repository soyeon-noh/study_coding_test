package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구슬 좌,우 이동.
// 맨 위에 있는 벽돌 깰 수 있다.
// 벽돌 숫자 1~9
// 명중한 벽돌은 상하좌우, 벽돌에 적힌숫자 -1칸 만큼 같이 제거됨
public class Solution_5656_벽돌깨기 {
 
	static int N, W, H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; )
	}
}
