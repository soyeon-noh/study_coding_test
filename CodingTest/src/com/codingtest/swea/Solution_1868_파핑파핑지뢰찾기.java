package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기 {

	// '*' 지뢰 있음
	// '.' 지뢰 없음
	// BFS  
	static int ans;
	static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[][] visited = new int[N][N];
			
			for(int c = 0; c < N; c++) {
				map[c] = br.readLine().toCharArray();
				if(map[c] == '.') {
					
				}
			}
			
			
			bfs();
			
			sb.append("#").append(tc).append(" ").append(ans);
			ans = 0;
		}
		
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[] = 0;
		queue.add(e)
		
		
	}
}
