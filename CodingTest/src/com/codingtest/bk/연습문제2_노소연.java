package com.codingtest.bk;

public class 연습문제2_노소연 {
	
	// 아 열받아 태희쌤 숙제랑 같은 로직.
	// 제~~~~~~~~~~~~~발 이미 써있는 구조를 바꿀 생각하지마라
	// 그거 전전 것에 있을 것이다.
	public static void main(String[] args) {
		
		int N = 6;
		int[] dp = new int[N+1];
		
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i = 3; i <=N; i++) {
			dp[i] = 2 * dp[i-1] + dp[i-2]; 
		}
		
		System.out.println(dp[N]);
	}
}
