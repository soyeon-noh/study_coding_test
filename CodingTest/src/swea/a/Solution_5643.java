package swea.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 이해
 * - 1~N 번호를 가진  학생들 (N명)
 * - 키는 모두 다름
 * - 두 학생끼리 키를 비교한 결과의 일부가 주어짐
 * 
 * - 작은쪽이 from / 큰쪽이 to
 * 
 * - 자신의 키가 몇 번재인지 알 수 있는 학생이 몇 명인지 출력.
 * 
 * 전략
 * - 큰일났다. 이거뭐지?
 * -  4번 정점은 나보다 작은 사람 + 나보다 큰 사람  = N-1명
 * - 내가 갈수 있는 수 + 나에게 올 수 있는 거 
 */
public class Solution_5643 {

	static int ans;
	static ArrayList<ArrayList<Integer>> adjList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int V = Integer.parseInt(br.readLine());
			int E = Integer.parseInt(br.readLine());
			
			// 정점마다 ArrayList 초기화 해줘야함
			for(int i = 0; i < V; i++) {
				adjList.add(new ArrayList<>());
			}
			visited = new boolean[V];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adjList.get(a).add(b);
			}// 입력 끝
			
			
			ans = 0; // 카운터
			
			bfs(0); //뭐넣어야해?
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	private static void bfs(int cur) {
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(cur);
		
		
	}
}
