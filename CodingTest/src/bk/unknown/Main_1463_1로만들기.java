package bk.unknown;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 완벽한 DP
// 1. X % 3 == 0 이면, 3으로 나눈다
// 2. X % 2 == 0 이면, 2로 나눈다.
// 3. 1을 뺀다.

// 정수 N이 주어졌을 때 연산을 사용하는 횟수의 최솟값

// 1 < N < 10^6 = 1,000,000 백만

// 시간제한 0.15초 -> 완탐 x
public class Main_1463_1로만들기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		
		dp[1] = 0;
		
		int result;
		
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			
			// 3으로 나누기, 2로 나누기, -1 하기 3가지 경우의 수를 전부 찾아서
			// 그중에서 min을 찾아서 dp[i] 에 넣음 
			// 오답노트 : 각 경우의 수의 min을 구해야함. 
			if(i%3 == 0) min = Math.min(1 + dp[i/3], min);
			if(i%2 == 0) min = Math.min(1+ dp[i/2], min);
			min = Math.min(1 + dp[i-1], min);
			
			
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}
}