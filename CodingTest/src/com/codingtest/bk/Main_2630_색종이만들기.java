package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 정리
 * - 주어진 2차원 배열에서
 * 	- 모두 같은 색이 아니면 N/2 x N/2 씩 자름 
 * 	- 전체가 같은 색이거나 더이상 자를 수 없을 때까지 반복
 * 
 * 입출력 
 * 	- 종이의 한변의 길이 N
 *  - 정사각형칸의 색 (0 or 1) 
 *  - 각 색의 종이가 몇개인지 출력 
 * 
 * 전략 
 * - 분할정복
 * - 2차원 배열 
 * - DFS로 풀다가 구역이 통일되면 멈추고 값을 더해주는 방식 
 *
 *
 */
public class Main_2630_색종이만들기 {
	
	static int N; // 128 이하 
	static int[][] map; 
	static int[] ans; // 0인덱스 하얀색종이 수 , 1인덱스 파란색종이 수 
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; //오답노트 : 초기화좀 제발 까먹지 말아라 
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝 
		
		ans = new int[2];
		
		dfs(0, 0, N-1, N-1);
		
		sb.append(ans[0]).append("\n").append(ans[1]);
		System.out.println(sb.toString());
	}


	private static void dfs(int startR, int startC, int endR, int endC) {
		int firstColor = map[startR][startC];
		boolean isOne = true;
		
		// 종이가 한칸만 남은 경우 카운팅 후 종료 
		if(startR == endR && startC == endC) {
			ans[firstColor]++;
			return;
		}
		
		// 종이의 색이 통일되지 않은 경우 탐색 종료하고 재귀 
		next :for(int r = startR; r <= endR; r++) { // 오답노트 : <= 를 하지 않아 마지막 행렬을 확인안함 
			for(int c = startC; c <= endC; c++) {
				if(map[r][c] != firstColor) {
					isOne = false;
					break next;
				}
				
  			}
		}
		
		// 분할 
		int midR = (endR + startR) /2;  // 오답노트 : 중간좌표 구하는 수학 공식 이해를 못함 (실화?) 
		int midC = (endC + startC) /2;
		if(!isOne) {
			dfs(startR, startC, midR, midC); // 좌상 (0,0)(2,2)
			dfs(startR, midC + 1, midR, endC); // 우상
			dfs(midR + 1, startC, endR, midC); // 좌하 
			dfs(midR + 1, midC + 1, endR, endC); // 우하
		// 종이 색이 통일되어 있어 
		}else {
			// 각 색별로 카운팅 
			if(firstColor == 0) {
				ans[0] += 1;
			} else {
				ans[1] += 1;
			}	
		}
		
	}
	
	
}
