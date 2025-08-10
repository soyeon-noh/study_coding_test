package com.codingtest.bk.stepByStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 1. 변수명 개선
// 		arr -> paper, grid
// 		x,y -> startX, startY
// 2. fhwlr
public class Main_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 100x100 배열 생성.
		// 0은 빈공간, 1은 색종이 덮인 공
		int[][] grid = new int[100][100];
		
		StringTokenizer st;
		
		// N장의 색종이를 도화지에 붙인다 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			
			// 시작 좌표를 기준으로 10x10 색종이 붙이기 
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					grid[startX+j][startY+k] = 1;
				}
			}
		}
		
		
		int totalArea = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				totalArea += grid[i][j];
			}
		}
		System.out.println(totalArea);
	}
	
}
