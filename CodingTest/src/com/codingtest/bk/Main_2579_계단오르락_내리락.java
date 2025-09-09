package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 이해
 * - 시작점부터 계단 꼭대기까지 올라가는데 계단을 밟으면 적힌 점수를 얻게 됨
 * 
 * 조건
 * - 한 번에 한 칸 or 두 칸 계단오름
 * - 연속된 3개 계단 xx
 * - 시작점은 계단이 아님
 * 
 * 입력
 * - 각 계단에 쓰여 있는 점수
 * 
 * 출력
 * - 얻을 수 있는 총 점수의 최댓값
 *
 */
public class Main_2579_계단오르락_내리락 {

	static int N; // 6
	static int[] arr; // 10 20 15 25 10 20
	static int[][] dp;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		recur();
		
		
	}


	private static void recur() {
		// TODO Auto-generated method stub
		
	}
}
