package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 설계 (시뮬레이션 + 완탐<중복순열> + 격자그래프 D/BFS 탐색
 * 
 * 1. 구슬 낙하시킬 위치 선택 (W개의 열 중 하나의 열을 선택)
 * 2. 구슬 낙하 (가장 위쪽에 있는 벽돌 꺠짐)
 * 3. 벽돌 연쇄 깨트리기
 * 4. 남은 벽돌 정리(벽돌 내리기)
 * 5. 다음 구슬 낙하
 * 		- 재귀 호출
 * 6. 구슬을 던지기 전 상태로 원복
 * 
 * 자료구조
 * - 벽돌 맵 : 2차원 배열
 * - 매 구슬 던지기 로직마다 기존 구슬처리 상태의 백업 : 2차원 배열
 */
public class Solution_5656_태희쌤1 {

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int N, W, H, min;
	
	static class Point{
		int r,c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
			for(int r = 0; r < H; ++r) {
				st = new StringTokenizer(br.readLine());
				for(int c  = 0; c < W; ++c) {	
					
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;// 초기화
			drop(0, map); // 아직아무것도 안던졌고 맵은 이걸로 시작
		
			// min값을 drop에서 업데이트할거니 min은 남아있는 벽돌의 최소수 
			System.out.println("#" + tc + " " + min); 
		}
	}
	
	private static boolean drop(int count, int[][] map) { // 해당 구슬을 던져보기
		
		int remainCnt = getRemain(map);
		if(remainCnt == 0) {
			min = 0;
			return true; // 남은 벽돌이 없다. 최적해다!!
		}
		if(count == N) {
			min = Math.min(min, remainCnt);
			return false; // 남은 벽돌이 있다 . 다른 시나리오도 고려해봐야한다!!
		}
		
		// 전달받은 배열을 백업으로 사용해야하므로 새로운 배열 생성해서 작업
		int[][] newMap = new int[H][W];
		
		// 구슬을 모든 열에 던지는 시도 (중복순열)
		// 모든 열 가자 W번!
		for(int c = 0; c < W; c++) {
			// step1. c열에 던졌을 때 깨지는 맨 위 벽돌 찾기
			int r = 0;
			while(r < H && map[r][c] == 0) ++r; // 계속내려가
			// 내려가도 벽돌이 없다면 비어있는 열이므로 다음 열로 구슬 던지기
			if(r == H ) continue;
			
			// step2. 깨질 벽돌을 찾았으니 연쇄 작업 처리
			copy(map, newMap);
			// 깨지는 벽돌 주변으로 함께 깨지는 벽돌 찾기
			boom(newMap, r, c);
			// 남은 벽돌 정리
			down(newMap);
			
			// 다음 구슬 던지러 가기
			if(drop(count + 1, newMap)) return true;
		}
		return false;
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(map[r][c] > 0) ++count;
			}
		}
		return count;
	}

	static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) {
		for(int c = 0; c < W; c++) {
			for(int r = 0; r < H; r++) {
				if(map[r][c] == 0) continue;
				stack.push(map[r][c]); // 벽돌이면 넣기
				map[r][c] = 0; // 빈칸으로 만듦
			}// 남은 벽돌 알아내기
			int r = H - 1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
				
			}
		}
		
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		if(map[r][c] > 1) queue.offer(new Point(r,c, map[r][c]));
		map[r][c] = 0; // 큐에 안들어가는 애들도 빼야해서?
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur.r, nc = cur.c;
				for (int k = 0; k < cur.cnt - 1; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) queue.offer(new Point(nr,nc, map[nr][nc]));
						map[nr][nc] = 0;
					}
					
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];	
			}
		}
	}
	
	private static void print(int i, int j, int[][] map, boolean flag) {
		
		System.out.println(i + ", " + j + (flag?" 전":" 후") + " =======");
		for(int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
}
