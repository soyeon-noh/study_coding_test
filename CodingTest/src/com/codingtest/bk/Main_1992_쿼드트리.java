package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *영상이 모두 
 *	0 -> 압축 결과 "0"
 *	1 -> 압축 결과 "1"
 *
 *섞여있으면 4분할 
 * (0(0011)(0(0111)01)1)
 * 
 */
public class Main_1992_쿼드트리 {
	
	static int N;
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; // 오답노트 : 대체 언제 초기화를 안 까먹을래 
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		divide(0, 0, N); // 시작 row, 시작 col, 사이즈 
		System.out.print(sb);
	}
	
	private static void divide(int sr, int sc, int size) {
		
		if(isSame(sr, sc, size)) {
			sb.append(map[sr][sc]);
			return;
		}
		
		int halfSize = size/2;
		
		sb.append("(");
		
		divide(sr, sc, halfSize);  
		divide(sr, sc + halfSize, halfSize);
		divide(sr + halfSize, sc, halfSize);
		divide(sr + halfSize, sc + halfSize, halfSize);

		sb.append(")");
	}

	private static boolean isSame(int sr, int sc, int size) {
		char first = map[sr][sc];
		
		for(int i = sr; i < sr + size; i++) {
			for(int j = sc; j < sc + size; j++) {
				if(map[i][j] != first) return false;
			}
		}
		return true;
	}
}
