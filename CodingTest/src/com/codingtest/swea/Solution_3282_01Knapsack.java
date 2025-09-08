package com.codingtest.swea;

import java.util.*;
import java.io.*;

public class Solution_3282_01Knapsack {

	static int N, K; // 100개 물건 / 100개 부피
	static int[] pList, nList, temp;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			pList = new int[K+1];
			nList = new int[K+1];
			
			
			
			// 각 물건 별로 for문을 돌아서 배열 갱신
			for(int n = 0; n < N; n++) {
				int v, c;
				
				st = new StringTokenizer(br.readLine(), " ");
				
				v = Integer.parseInt(st.nextToken()); // 부피
				c = Integer.parseInt(st.nextToken()); // 가치
				
				// 가방 부피만큼 for
				for(int k = 1; k < K+1; k++) {
					if(v > k) {
						nList[k] = pList[k]; continue;
					}
					nList[k] = Math.max(pList[k], pList[k-v] + c); 
//					System.out.println("뭐임?: nList[" + k + "] = " + nList[k]);
				}
				if(n < N-1) {
//					pList = nList;
//					nList = new int[K+1];
					for (int i = 0; i < K+1; i++) {
						pList[i] = nList[i];
					}
				}
			}
			System.out.println("#" + tc + " " + nList[K]);
		}
		
	}
}

