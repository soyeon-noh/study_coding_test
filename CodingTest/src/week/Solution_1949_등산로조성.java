package week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 이해
 * - N*N 크기 map
 * - 각 칸에는 지형의 높이가 숫자로 들어가 있음
 * 
 * 등산로 규칙
 * - 가장 높은 봉우리 시작
 * - 높은 지형에서 낮은 지형으로 사방 연결
 * - 딱한곳 최대 K깊이만큼 지형 깎을 수 있음
 * 
 * 
 * 목표
 * - 가장 긴 등산로 만들기
 *
 */
public class Solution_1949_등산로조성 {

	static int T;
	static int N, K;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			// 봉우리찾기
			List<Integer[]> head = new ArrayList<>();
			int max = 0;
			
			// 입력받기 
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					
					//봉우리찾기
					if(max < map[r][c]) {
						head.clear();
						head.add(new Integer[] {r,c});
					} else if(max == map[r][c]){
						head.add(new Integer[] {r,c});
					}
				}				
			}
			
		}
		
		
		for(Integer[] h : head){
			System.out.println();
		}
		System.out.println(sb.toString());
		
	}

}
