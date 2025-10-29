package bk.unknown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제 
//어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 
//그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
//단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 
//가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
//그림의 넓이란 그림에 포함된 1의 개수이다.

public class Main_1926 {
	// 따로 클래스를 선언하거나 메소드를 이용하려면 static 변수를 쓰는 게 낫다.
	// 나도 따라해본다.
	static int N, M;
	static int[][] map;
	static boolean[][] visited; // visited 배열이란 걸 써보자
	static int count = 0; // 그림 개수 카운트
	static int maxWidth = 0; // 가장 넓은 그림
	// 4방 탐색을 해야해서 deltas 배열 생성
	static int[][] deltas = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	
	
	// 큐에 넣을 좌표를 관리하기 쉽게 Pos클래스를 만들어주는 것 같음
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	

	// 가로 세로로 연결되어 있는 것을 묶어야함
	// 그림의 개수, 가장 넓은 그림의 넓이 출력
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken()); // 세로크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		
		// 일단 2차원 배열에 도화지 정보 저장
		map = new int[N][M];
		visited = new boolean[N][M]; // 와 이거 생성안하면 NPE뜸
	
		for(int i = 0; i < N; i++) {
			StringTokenizer stInFor = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stInFor.nextToken());
			}
		}
		
		// 탐색 시
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// map 숫자가 1이고, 방문하지 않은 경우 
				if(map[i][j] == 1 && !visited[i][j]) {
					// 방문처리하
					visited[i][j] = true;
					// bfs 탐색하자
					bfs(i,j); 
					// 탐색을 통해, 넓이비교를 끝냄.
					
					// bfs()함수 내의 방문 처리로 count를 셀 수 있게됨
					count++;
				}
			}
		}
		
		// 출력 조건
		// 첫 줄 : 그림 개수
		// 둘째 줄 : 그림 최대 넓이
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n").append(maxWidth);
		// string builder에 쌓은 문자열을 ... 문자열이아님?
		bw.write(sb.toString());
		bw.flush(); //결과출력
		bw.close();
		br.close(); //닫아야해..?

	}
	
	// BFS 함수를 만드는 이유
	// i, j 이중 for문 안에서 탐색을 생성하니 
	// 복잡하고 좌표 변수가 i,j가 되면서 가독성이 떨어짐.
	static void bfs(int r, int c) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(r, c));// 자 이제 시작이야. 큐에 탐색 시작하는 좌표 add
		int width = 1; // 위 좌표가 1이고 방문하지 않은 경우부터 시작이니까 1로 시작.
		// 큐가 빌 때까지 탐색
		while(!queue.isEmpty()) {
			// 하나 꺼내
			Pos current = queue.poll();
			// 꺼낸 걸로 4방향 탐색해
			for(int d = 0; d < deltas.length; d++) { // 오답노트 
				int nr = current.r + deltas[d][0]; // 여기서 current.r을 하지 않아 답이 옳게 나오지 않
				int nc = current.c + deltas[d][1];
				// 배열 방향탐색에서 주의해야할 것 : 범위를 벗어나지 않았나
				// 이 내용을 따로 메서드를 빼서 처리하는 법을 찾음 
				// inSpace 함수 생성
				
				// 1. 도화지를 벗어나지 않았나?
				// 2. 탐색 좌표 내부 값이 1인가?
				// 3. 방문하지 않은 곳인가?
				if(isSpace(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					// 조건을 만족하면 
					// 방문했다고 체크하고
					visited[nr][nc] = true;
					// queue에 좌표를 저장한다.
					queue.add(new Pos(nr, nc));
					width++; // 잊지마. 넓이를 증가시켜야해
				}
			}
		}
		
		// 이 그림이 가장 큰 넓이니?
		maxWidth = Math.max(maxWidth, width);
	}
	
	// 좌표가 도화지 범위 안에 있는지 확인
	static boolean isSpace(int r, int c) {
		if(r >= 0 && c >= 0 && r < N && c < M) {
			return true;
		}
		return false;
	}
}
