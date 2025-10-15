package bk.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13903_출근 {

	/**
	 * 문제 이해
	 * - 시작은 첫번째 row 세로 블록 중 아무곳 
	 * - 세로 블록만 밟기 
	 * - 특정 규칙으로 이동
	 * - 마지막 row에 도착하면 출근 성공
	 * - 최소 걸음 
	 * 
	 * 입력
	 * - 보도블럭 R, C
	 * - 가로블럭 0, 세로블럭 1
	 * - 이동가능 규칙 개수
	 * - N개줄 - 규칙
	 * 
	 * 출력
	 * - 최소 몇 걸음 or -1 (출근불가) 
	 * @throws IOException 
	 */
	
	static int R, C, N;
	static int max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr;
	static int[] dc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R+2][C+2];
		visited = new boolean[R+2][C+2];
		for(int r = 1; r < R+1; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c < C+1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dr = new int[N];
		dc = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			dr[i] = Integer.parseInt(st.nextToken());
			dc[i] = Integer.parseInt(st.nextToken());
		}
		// 입력끝
		
		for(int c = 1; c < C+1; c++) {
			if(map[1][c] == 0) continue; // 가로면 ㅂㅂ 
			bfs(c); // 시작 좌표 c 찾기 
		}
		
		if(max == 0) {
			System.out.println(-1);
		}else {
			System.out.println(max);
		}
	}
	
	private static void bfs(int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,c, 0}); //배열 add할때 이렇게 해야하는지 몰라서 검색함
		// depth도 추가해줌 
		visited[1][c] = true;
		
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < N; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nDepth = now[2] + 1;
				
				// 사방을 0으로 만들어서 범위체크 필요 x 
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					if(nr == R && max < nDepth) {
						max = nDepth;
					}
					q.add(new int[] {nr, nc, nDepth});
					visited[nr][nc] = true;		
				}
			}
			
		}
		
		
		
	}

}
