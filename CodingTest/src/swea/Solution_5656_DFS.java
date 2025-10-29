package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1)summary
 * 	구슬 N번 던져서 벽돌 많이 깨기 -  최소 남은 벽돌 구하기
 *  문제유형 : 시뮬레이션
 * 2)strategy
 * 	2-1) 구슬 던지는 방법( 중복 순열) - solve()
 * 		 중복순열 완탐 시 시간복잡도- 3)번제약사항 참고: O(12^4)
 * 	 	 재귀 - 기저조건 : 구슬 다 던진경우(N - 최소남은 개수 체크)
 *                     구슬 던지는 회수 남았어도 벽돌이 모두 깨지면 중지 		 	
 * 	2-2) 벽돌 깨는 방법( 그래프 완탐 (BFS, DFS)) - boom()
 * 		 중력에 의해 연쇄 벽돌 깨짐 (weight-1)
 * 		 깨진벽돌의 weight=0으로 표시
 * 		 BFS(ArrayDeque) : 벽돌크기가 2이상이면 Queue에 넣고 자신은 0
 *                         queue가 empty가 아닌 동안 사방탐색해서 weight-1
 *                         제거처리할 벽돌 Queue에 넣고 자신은 0
 *       DFS :재귀  
 * 	2-3) 벽돌 내리기(배열탐색 - 열고정) - down()
 *    	 아래행부터 시작해서 0이 아닌거 리스트(스택)에 저장하고 모두 0으로 변경 후 
 *       아래 행부터 리스트(스택) 값 채우기
 * 		 
 * 	2-4) 남은 벽돌 세기 - blockCheck()
 *  
 * 3)note
 *  - 입력
 *  T testCase
 *  N 구슬던지는 수,  W 넓이 (열),  H 높이 (행)
 *  벽돌 weight
 *  
 *  -제약사항
 *   1 ≤ N ≤ 4
 *   2 ≤ W ≤ 12
 *   2 ≤ H ≤ 15
 * 
 */
public class Solution_5656_DFS {
	static int N, W, H ; 	//N:구슬던지는 회수, W:넓이(열), H:높이(행)
	static int min,bCnt;			//최소 남은 벽돌 수
	static class Block{
		int r,c,weight;

		public Block(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	
	}
	public static void main(String[] args) throws Exception{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			int T = Integer.parseInt(in.readLine());

			for(int testCase=1; testCase <=T; testCase++) {
				//입력
				StringTokenizer st = new StringTokenizer(in.readLine());
				N = Integer.parseInt(st.nextToken()); // 횟수
				W = Integer.parseInt(st.nextToken()); // 열크기
				H = Integer.parseInt(st.nextToken()); // 행크기
				int[][] map = new int[H][W];
				int total = 0;
				for (int r = 0; r < H; ++r) {
					st = new StringTokenizer(in.readLine());
					for (int c = 0; c < W; ++c) {
						map[r][c] = Integer.parseInt(st.nextToken());
						if(map[r][c] > 0 ) total++; 
					}
				}			
				min = Integer.MAX_VALUE;
				
				//처리
				solve(0,total,map);
				
				//출력
				StringBuilder sb=new StringBuilder("#")
									.append(testCase)
									.append(" ")
									.append(min);
				
				System.out.println(sb.toString());
			}
		}
	/**
	 * 구슬던지는 방법 : 중복순열
	 * @param count 구슬 던지는 회수
	 * @param map   시도해야하는 벽돌맵
	 * @return
	 */
	private static boolean solve(int count, int blockCount, int [][] map) {
		//기저조건 : 모든 벽돌 폭파면
		if(blockCount == 0) {
			min = 0;
			return true;
		}
		//기조조건 : 모두 구슬 다 던졌으면 최소값
		if(count == N) {
			min = Math.min(min, blockCount);
			return false;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; ++c) { // 매열마다 구슬 떨어드리는 시도.			
			// 구슬을 떨어뜨리면 맞는 벽돌이 있는 행 찾기
			int r=0;
			while(r<H && map[r][c]==0)r++;
			if(r==H) continue; // 모두 빈칸이면 다음 열로 시도
			
			// 터트리는 시도하기 전에 직전 count횟수까지의 맵 상태를 이용하여 배열 복사하여 초기화 
			copy(map,newMap);
			bCnt =0;
			boom(newMap,r,c,newMap[r][c]);
			down(newMap);
			if(solve(count+1,blockCount-bCnt,newMap)) return true; //다 폭파된 경우 재귀 종료 
		}	
		return false; //다 폭파된 상태가 아니면 구슬던지기
		
	}
	

	/**
	 * 벽돌깨기 : 사방탐색 -( weight-1) -0 
	 *         그래프 완탐(BFS, DFS)
	 */
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static void boom(int[][] map, int r, int c, int cnt) {
		bCnt++;
		map[r][c] = 0;
		if(cnt==1) return;
		
		for (int d = 0; d < 4; ++d) {
			int nr = r,nc = c;
			for (int k = 1; k < cnt; ++k) {
				nr += dr[d];
				nc += dc[d];
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]!=0) {
					boom(map,nr,nc,map[nr][nc]);
				}
			}
		}
		
	}
	
	/**
	 *  부서진 벽돌 정리(0인 자리 내리기) -배열 탐색 
	 *  List나 Stack 이용해서 0이 아닌 벽돌만 저장했다가 맨 아래부터 저장된 벽돌 할당(쌓기) 
	 */
	static void down(int[][] map) {
		for (int c = 0; c < W; ++c) {
			ArrayList<Integer> list = new ArrayList<>();
			int r;
			for (r = H-1; r >= 0; --r) {
				if(map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			r=H;
			for (int b : list) map[--r][c] = b;
		}
	}
	/**
	 * 남은 벽돌 세기
	 * @return
	 */
	static private int blockCheck(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}
	/**
	 * 배열 복사 deep copy
	 * @param map
	 * @param newMap
	 */
	private static void copy(int[][] map,int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

}
