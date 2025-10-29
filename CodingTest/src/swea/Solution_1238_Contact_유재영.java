package swea;

import java.util.*;
import java.io.*;
/*
1)summary
	비상연락망과 연락 시작 당번에 대한 정보가 주어질 때, 
	가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하기

2)strategy
시작 정점으로부터 시작해서 단계별로 연락 가능한 모든 정점들을 "동시에" 처리하면서 진행해야 함. 	
레벨별로 접근(BFS)
int 타입 visit 배열에 방문한 순서를 저장함

3)note
1.중간 중간에 비어있는 번호가 있을 수 있다.
2.연락 인원은 최대 100명이며, 부여될 수 있는 번호는 1이상, 100이하이다.
3.연락을 전하는 속도는 일정하며 연락 가능한 사람들에게 동시에 전달된다. 
4.동일한 {from, to}쌍이 여러 번 반복되는 경우도 있다.
5.입력받는 데이터는 {from, to, from, to, …} 의 순서로 들어온다.

  
 * */
public class Solution_1238_Contact_유재영 {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 입력데이터 총갯수(from, to)		
			int start = sc.nextInt();//시작정점
			
			map = new int[101][101];//1~100

			for (int i = 1; i <= N/2 ; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;				
			}
			
			int result = bfs(start);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[101];//방문 여부와 함께 방문 순서
		
		q.offer(start);
		visited[start] = 1;		
		
		int from = 0;
		while(!q.isEmpty()) {			
			from = q.poll();
			
			for (int to = 0; to < 101; to++) {
				if(map[from][to] == 1 && visited[to] == 0) {
					q.offer(to);
					visited[to] = visited[from] + 1;
				}
			}			
		}//연결되어 있는 모든 정점들이 방문체크 끝남
		
		//가장 나중에 방문한 정점 찾아야 돼
		int last = visited[from];//q에서 제일 마지막으로 꺼내진 정점의 방문 순서
				
		int ans = 0;
		for (int no = 1; no < 101; no++) {
			if(visited[no] == last) {
				ans = ans < no ? no: ans;
			}				
		}		
		return ans;		
	}
}
