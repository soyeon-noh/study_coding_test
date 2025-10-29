package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 현재 수연이 위치 S
 * 여신의 공간 D
 * 돌 X
 * 악마 *
 * 
 * 문제
 * - BFS 탐색문제 (시뮬레이션 + 최단 경로 탐색)
 */
public class Solution_7793_오나의여신님 {

	
	static int N, M, ans; // 행, 열, 안전 지역에 도달하는 최소 시간 (도달 불가시 -1) 
	static char[][] map;
	static boolean[][] visited;
	
//	수연  : BFS (최단경로 찾기)
//	악마  : BFS (확산 시뮬레이션)
	static Queue<int[]> suyeon; // {r, c, time}
	static Queue<int[]> demons; // {r, c}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			visited = new boolean[N][M];
			suyeon = new ArrayDeque<int[]>();
			demons = new ArrayDeque<int[]>();
			ans = -1; // 초기값 : 도달 못하면 -1
			
			// 오답노트 : 공백으로 분리되지 않은 경우 st보다 line을 통째로 받아서 cahrAt(i)하자
			for(int r = 0; r < N; r++) {
				String line = br.readLine();
				for(int c = 0; c < M; c++) {
					map[r][c] = line.charAt(c);
					if(map[r][c] == 'S') {
						suyeon.add(new int[] {r, c, 0}); // 행, 열, 시간
						visited[r][c] = true; // 현재위치 방문처리
					}else if(map[r][c] == '*') {
						demons.add(new int[] {r, c});
					}
					
				}
			}// 수연, 여신, 악마 위치 입력 끝
			
			bfs();
			
			sb.append("#").append(tc).append(" ");
			if(ans == -1 ) sb.append("GAME OVER");
			else sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		// BFS 루프 : 매 초마다  (1) 악마 확장 -> (2) 수연 이동
		
		// 수연이 방문 순서를 큐로 관리
		while(!suyeon.isEmpty()) {
			
			// 1) 악마 확장 (현재 큐에 있는 악마 들만 확장)
			int dSize = demons.size(); // 미리 demons.size를 선언해놔서 큐에 들어간 악마가 다시 size에 반영되지 않음 (아마도?)
			for(int i = 0; i < dSize; i++) { // 현재 턴에서 처리할 악마 수 (demons.add()로 들어온건  다음턴에 확장)
				// 꺼내
				int[] demon = demons.poll();
				int r = demon[0];
				int c = demon[1];
				
				// 사방 탐색하면서 -> 유효한 구간에 악마를 확장시키고 -> 악마를 다시 큐에 넣기
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 맵 밖으로 나가면 x
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					// 평지나 수연이면 악마 확장
					// 수연이도 같은 턴이 이동하므로 포함할 필요가 있음 (주의!)
					if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
						map[nr][nc] = '*';
						demons.add(new int[] {nr, nc});
					}
				}
			}
			// 2) 수연 이동 (현재 큐에 있는 수연 위치들만 이동)
			int sSize = suyeon.size();
			for(int i = 0; i < sSize; i++) {
				// 꺼내
				int[] sy = suyeon.poll();
				int r = sy[0];
				int c = sy[1];
				int t = sy[2]; // 시간
				
				// 사방탐색하면서 갈 수 있는 곳 좌표를 찾고 -> 큐에 넣어
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 맵 밖으로 나가면 x
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					if(map[nr][nc] == 'D') {
						ans = t + 1; // 다음턴에 이동한다면 만날 수 있으므로 +1
						return;
					}
					// 평지거나 방문하지 않은 경우
					if(map[nr][nc] == '.' && !visited[nr][nc]) {
						// 큐에 다음 수연이 이동좌표를 넣은 후 + 방문처리
						suyeon.add(new int[] {nr, nc, t + 1});
						visited[nr][nc] = true;
					}
				}
			}
			
			// 더 갈 수 있는 곳이 없어 큐가 비어 있는데 도달 못하면 ans = -1
		}
		
	}
}
