package swea;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1)summary
 * 회사->N명고객방문->집 (순열-완탐)
 * 거리 : 맨해튼 (|x1-x2| + |y1-y2|)
 * 모든 고객 방문 -가장 짧은 경로 이동거리 구하기(초기값-MAX)
 * 2)strategy
 *  2-1) 순열(o(N!*N))
 *  - 입력처리
 *  - 순열생성(permutation) : 고객 방문순서로 재귀
 *  - 기저조건 : 각 순열에 대한 거리 계산 최단거리 갱신 
 *  
 *  2-2) DFS + prunning(백트래킹) : 가중치없는 최단거리
 *  - 입력처리
 *  - 모든 순열 탐색 대신 현재 경로의 누적거리가 최소거리보다 크면 탐색 중지
 *  - visited[] : 고객 방문 체크
 *  - 재귀로 고객 방문하면서 누적 거리계산
 *  - sum >= minDistance 일 경우 탐색 중단
 *  2-3)만약 N 10보다 큰경우 : DP+bitmask 
 *    - ref)외판원 문제 (TSP: Traveling Salesman Problem)
 *   - 상태정의 : dp[visited][current]
 *             visited - 비트마스크로 방문한 고객 표현(0~(1<<N)-1 범위) 
 *             current - 현재 위치한 고객 인덱스(0~N-1)
 *   - DP 점화식 : dp[visited][current] = 
 *                       Math.min(dp[vistited][current],
 *                                dp[visited | (1<<next)][next]+dist[current][next])
 *               모든 next 고객 중 방문하지 않은 곳만 탐색
 *   - 거리테이블 미리 계산  :
 *   			dist[company][i] = 회사~고객 사이의 거리 
 *              dist[i][j] = i번째 고객~j번째 고객 사이의 거리
 *              dit[i][home] = 고객 ~ 집 사이의 거리 
 * 3)note
 *  고객 수 (N) 2<=N<=10 
 *  -입력
 *  10  // testCase
 *  5	// 고객 수 N
 *  //회사좌표  집좌표     고객들 좌표(N) - java.awt.Point
 *    0 0    100 100  70 40 30 10 10 5 90 70 50 20
 *  -출력 (출력은 문제보기가 아니라 ouput.txt가 맞습니다.)
 *  #testcase 최단경로이동거리
 */
public class Solution_1247_DFS_Pruning{
	
	static int T, N; //테스트케이스, 고객 수
	static Point company; //회사 좌표 Point 클래스 정의하거나 java.awt.Point 이용
	static Point home;	  //집 좌표	
	static Point [] customers; //고객들 좌표 
	static int minDistance; //최단경로이동거리 출력할 정답!
	static boolean [] visited; //방문체크

	
	public static void main(String[] args) throws Exception{ //시험볼때 일단 던져 놓자!
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		T = Integer.parseInt(in.readLine()); //테스트 케이스
		for(int testCase=1; testCase <=T; testCase++) {
			//1.입력
			N = Integer.parseInt(in.readLine()); // 고객 수
			//testCase별 초기화
			visited = new boolean[N]; //고객 방문여부
			customers = new Point[N]; //고객배열 생성
			minDistance = Integer.MAX_VALUE; //최소 거리 초기화
			
			//좌표
			st = new StringTokenizer(in.readLine());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));//회사
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));//집
			
			for(int i=0; i<N; i++)
				customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //고객들
			
			//2.dfs
			dfs(0,home, 0);
			
			//3.출력
			sb = new StringBuilder("#").append(testCase).append(" ").append(minDistance);
			System.out.println(sb.toString());

		}
	}

	private static void dfs(int cur, Point from, int count) {
		if(cur == N) {
			count += getDistance(from, company);
			minDistance = Math.min(minDistance, count);
			return;
		}
		
		for(int i=0; i <N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cur+1, customers[i],count+getDistance(from, customers[i]));
				visited[i]=false;
			}
		}
	}
	
	
	//맨해튼거리 계산
	static int getDistance(Point c1, Point c2) {
		return Math.abs(c1.x - c2.x) + Math.abs(c1.y-c2.y);
	}
	

}
