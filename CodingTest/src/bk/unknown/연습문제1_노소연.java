package bk.unknown;

public class 연습문제1_노소연 {

	// 전체를 보지말고
	// 이전것들에서 추가된 부분만 신경쓰자. 
	// 이전까지의 것들은 이미 모든 경우의 수가 나와있는 거임!!
	// 거기에 뭘더 붙이는 식
	public static void main(String[] args) {
		
		int N = 8;
		
		int[] dp = new int[N+1];
		
		dp[1] = 2;
		dp[2] = 3;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}
}
