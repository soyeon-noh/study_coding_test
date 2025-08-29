package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구슬 좌,우 이동.
// 맨 위에 있는 벽돌 깰 수 있다.
// 벽돌 숫자 1~9
// 명중한 벽돌은 상하좌우, 벽돌에 적힌숫자 -1칸 만큼 같이 제거됨
/**
 * 전략
 * 1. N개의 구슬 던지는 방법 - 중복순열
 * 2. 벽돌 깨기 - 4방탐색 - 그래프탐색 (DFS, DFS)
 * 3. 벽돌 내리기 - 배열탐색 - 자료구조이용(스택, 큐 등)
 * 4. 남은 벽돌 수 구하기  - min
 *
 */
public class Solution_5656_벽돌깨기 {
 
	static int N, W, H; // 구슬 수, 열, 행
	static int min; // 최소 남은 벽돌수
	static int[][] map;
	static int[][] copy; // map을 초기화할 때 사용할 배열
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 초기화
			min = Integer.MAX_VALUE;
			
			// 처리
			drop();
			
			// 출력
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
		
		
		
	}

	private static void drop() {
		
		
	}



}
