package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// N은 5이상 100이하
// 
public class Solution_5650_노소연 {

	// 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// TEST CASE
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int t = 0; t < T; t++) {
			
			Pos[][] wormhole = new Pos[11][2];
			
			// 핀볼 판 배열 저장
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					
					// 웜홀 저장
					if(board[r][c] >= 6) {
						int wNum = board[r][c];
						if(wormhole[wNum][0] == null) {
							wormhole[wNum][0] = new Pos(r,c);
						} else {
							wormhole[wNum][1] = new Pos(r,c);
						}
						
					}
				}
			}
			
			int nx, ny;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(board[r][c] == -1) {
						break;
					} else if(board[r][c] >= 6){
						//웜홀타고 어떻게 이동해?
					}
					
					for(int d=0; d<4; d++) {
						nx = r + dx[d];
						ny = c + dy[d];
						
//						if(board[nx][ny] > ) {
//							
//						}
					}
					 
				}
			}
		}

	}
}
