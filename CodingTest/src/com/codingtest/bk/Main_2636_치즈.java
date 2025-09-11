package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int R, C, map[][];
	static boolean[][] visited; // 1까지는 v넣어주면 false인 경우가 치즈가됨
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(cnt != 0) {
			cnt = 0;
			
			bfs(0,0);
		}
		
		
	}

	private static void bfs(int r, int c) {
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(isIn(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if(map[nr][nc] == 0) {
					bfs(nr, nc);
				}			
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr > 0 && nc > 0 && nr < R && nc < C;
	}
}

