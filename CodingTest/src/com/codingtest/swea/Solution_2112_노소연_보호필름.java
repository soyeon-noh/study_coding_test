package com.codingtest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_노소연_보호필름 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int D, W, K; // 두께 D, 가로크기 W, 합격기준 K
		
		
		StringTokenizer st;
		for(int tc = 1; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] figArr = new int[D][W];
			
			for(int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					figArr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
	}
}
