package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리잡기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			int maxTotal = 0;
			// 파리채의 왼쪽 상단을 기준으로 탐색
			// 	탐색 장소가 유효한지 for문내부 조건으로 해결 
			for(int r = 0; r < N-M; r++) {
				for(int c = 0; c < N-M; c++) {
					// total은 계속 초기화 시켜줘야하기 때문에 내부에 있어야 한다. (위치 실수)
					int total = 0;
					// 이제 잡힌 파리 합을 구하는 로직
					// 현재 위치 r,c에서 이중 for문을 통해 입력받을 때와 같이 돌림
					for(int dx = 0; dx < M; dx++) {
						for(int dy = 0; dy < M; dy++) {
							
							// 여기서 실수가 발생
							// r+dx를 해서 기존 위치 + 이동위치를 작성해줘야한다.
							total += arr[r + dx][c + dy];
						}
					}
					// 여기서 꼭짓점 1개마다의 total값을 max비교해줘야함 (위치실수)
					if( maxTotal < total) {
						maxTotal = total;
					}
				}
				
			}
			// 탐색을 마치면 가장 큰 합이  maxTotal에 저장되어 있음
			System.out.println("#" + t + " " + maxTotal);
		}
	}
}
