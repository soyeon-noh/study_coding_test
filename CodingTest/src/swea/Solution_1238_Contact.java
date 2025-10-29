package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;



// 비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때, 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수

// 아이디어 : BFS 탐색을 통해 가장 깊은 깊이의 노드들을 도출해내고
// 주의사항 : 그 중 가장 숫자가 큰 것을 반환한다.
public class Solution_1238_Contact {
	
	static class Node {
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}

	}
	
	static Node[] adjList;
	static int maxV = 100; // 최대 노드수 
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 입출력 셋팅
		
		// tc = 10 고정
		for(int tc = 1; tc <= 10; tc++) {
			// 입력
			// N : 입력 데이터의 길이
			// S : 시작 노드 번호
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			// 연락 인원은 최대 100명, 부여될 수 있는 번호는 1이상 100이하
			adjList = new Node[maxV + 1];
			
			st = new StringTokenizer(br.readLine());
			// N은 무조건 짝수이므로 N/2를 해도 상관없다
			
			for(int i = 0; i < N/2; i++) {
				int from =Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from]);	
			}
			
			// 입력 확인
//			for(Node head: adjList) {
//				System.out.println(head);
//			}
			
			bfs(S);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);		
	}

	private static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[maxV + 1];
		
		queue.offer(start);
		visited[start] = true;
		int breadth = 0;
		int maxB = 0;
		ArrayList<Integer> maxBList = new ArrayList<>();
		

		while(!queue.isEmpty()) {
			int qSize = queue.size(); // qSize == 1
			
			// 사이즈 체크
			while(--qSize >= 0) { // qSize == 0 
				int current = queue.poll();
//				System.out.println("현재 노드: " + current + " 깊이: " + breadth);
				if(breadth > maxB) {
//					System.out.println("=== 현재 노드: " + current + " 깊이: " + breadth);
					maxBList.clear();
					maxBList.add(current);
					maxB = breadth; // 오답노트 : 갱신 안 함
				}else if(breadth == maxB) {
					maxBList.add(current);
				}
				
				// 지금 노드의 인덱스에 있는 걸 꺼내서 / 
				for(Node temp = adjList[current]; temp != null; temp = temp.next) {
					if(visited[temp.to]) continue;				
					queue.offer(temp.to);
					visited[temp.to] = true;
				}
			}
			++breadth;
		}
		
		ans = Collections.max(maxBList);
	}
}
