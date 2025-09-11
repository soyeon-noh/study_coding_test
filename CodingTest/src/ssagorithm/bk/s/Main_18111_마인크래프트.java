package ssagorithm.bk.s;

import java.io.*;
import java.util.*;

/**
 * 문제 이해
 * - 주어진 2차원 배열의 모든 수를 같게 만들어야함
 * - 한칸을 -1 하는데에 2초의 시간
 * - 한칸을 +1 하는데에 1초의 시간이 걸림
 * 
 * 입력
 * - N : 행
 * - M : 열
 * - B : 블럭사용
 * - map
 * 
 * 출력
 * - 최소시간
 * - 같다면 높이가 높은 것
 * 
 * 전략
 */
public class Main_18111_마인크래프트 {

	static int N, M, B, map[][];
	static int min, max; // 현재상태의 min과 max로 유동적임 
	static int ans; //time;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		max = 0;// 초기화
		
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[r][c]);
				min = Math.min(min, map[r][c]);
			}
		}// 입력끝
		
		
		
		sb.append(ans).append(" ").append(min); //min이든 max든 상관없을듯
		System.out.println(sb.toString());
	}

}
