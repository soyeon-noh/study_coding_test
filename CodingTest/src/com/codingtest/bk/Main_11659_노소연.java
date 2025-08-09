package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 4

// 아이디어 : 누적 합
// 시간제한 : 1초
// 시간복잡도 : N: 100,000 M: 100,000이므로 다 탐색하면 1초 넘을 것 같음
public class  Main_11659_노소연 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수의 개수 N
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M
		int[] arr = new int[N];
		
		// N 배열 담기
		st = new StringTokenizer(br.readLine());
		int sum = 0; //누적합 담을 변수 선언
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int startIdx, endIdx;
			st = new StringTokenizer(br.readLine());
	
			startIdx = Integer.parseInt(st.nextToken()) - 1;
			endIdx = Integer.parseInt(st.nextToken()) - 1;
			
			// startIndex가 0이면 OBE 뜨니까 이 경우 값을 0으로 처리해주기 
			if(startIdx == 0) {
				sb.append(arr[endIdx]).append("\n");
			} else {
				sb.append(arr[endIdx] - arr[startIdx-1]).append("\n");
				
			}
		}
		System.out.println(sb.toString());

	}
}
