package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	
	static int ans;
	static int[] startPos = new int[2];
	static int[][] map = new int[100][100];
	static int[] dx = {-1, 1, 0, 0 };
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10; // 테스트 케이스 수  10개
		
		for(int tc = 1; tc <= T; tc++) {
			br.readLine(); // 테케 번호 빼내기
			
			for(int i = 0; i < 100; i++) {

				String input = br.readLine();
//				System.out.println(input);
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));	
					if(map[i][j] == 2) {
						startPos[0] = i;
						startPos[1] = j;
					} 
				}
			}// 입력끝
			
			
			dfs(startPos[0], startPos[1]);
			

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			// 초기화
			ans = 0;
		}
		
		System.out.println(sb);
	}

	private static void dfs(int cx, int cy) {
		
		
		// 방문처리
		map[cx][cy] = 1;
		
		for(int d = 0; d < dx.length; d++) {
		
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if(map[nx][ny] == 0) {
				dfs(nx, ny);
			} else if(map[nx][ny] == 3) {
				ans = 1;
				return;
			}
			
		}
		
	}
}

