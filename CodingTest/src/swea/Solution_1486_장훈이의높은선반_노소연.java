package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반_노소연 {
	
	static int N, B; // N =< 20
	static int ans = Integer.MAX_VALUE;
	static int[] persons;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			
			// 입력 받기 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			persons = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				persons[i] = Integer.parseInt(st.nextToken());
			}
			
			
			makeTop(1, 0);
			
			//출력 
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
			
			ans = Integer.MAX_VALUE;; // 초기화
		}
		
	}

	private static void makeTop(int cnt, int total) { 
		// 목적 높이보다 크거나 같다면 탐색 끝내기(종결조건) 
		if(total >= B) {
			// 계산한 total이랑 이전에 계산했던 ans중 작은거 
			ans = Math.min(ans, total-B);
			return; 
		}

		// 기저조건
		if(cnt == N + 1) {// 오답노트 : 기저조건을 종결조건보다 위에올려서 답이안나옴 
			return;
		}
		
		makeTop(cnt + 1, total + persons[cnt]);
		makeTop(cnt + 1, total);
		
	}
}
