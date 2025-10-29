package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1)summary
 * - N개의 섬들을 모두 연결하는 교통시스템 설계
 * - 가중치: 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
 *           E * ( |x1-x2|^2 + |y1-y2|^2 ) - long
 * - 최소비용
 * 2)strategy
 * 2-1)Kruskal (O(ElogE))
 *   union-find
 * 2-2)prim (섬-정점중심) O(N^2) 
 *   - 입력처리
 *   - 모든 섬 간의 거리제곱(L^2) 구하기(가중치로 사용)
 *   - Prim 알고리즘이용 MST total(총 거리 제곱합)구하기
 *     인접행렬
 *   - total * E 소수 첫째자리 반올림해서 출력
 *  * 
 * 2-3)prim + java.util.PriorityQueue (정렬기준-Comparable(compareTo(o1)),Comparator(compare(o1,o2)
 *     (O(E logV)) 
 *   - 입력처리
 *   - 모든 섬 간의 거리제곱(L^2) 구하기(가중치로 사용)
 *   - Prim +PQ 알고리즘이용 MST total(총 거리제곱합)구하기
 *     - PriorityQueue -정렬기준
 *       Node implements Comparable - 가중치 오름차순
 *   - total * E 소수 첫째자리 반올림해서 출력
 * 
 * 3)note
 * -입력
 * 10			//testcase
 * 2			//섬 개수 N ( 1≤N≤1,000)
 * 0 0			//X좌표
 * 0 100		//Y좌표
 * 1.0			//환경 부담 세율 E(0≤E≤1)
 * 
 * -출력
 * #testcase 최단경로이동거리 (소수 첫째 자리에서 반올림하여 정수 형태로 출력)
 * 
 */
public class Solution_1251_Prim {
 
	static int N;			  	//섬 개수
	static double E;		  	//세율
	static long[][] adjMatirx; 	//가중치 행렬(거리 제곱)
	static int[] x, y; 			// x, y 좌표
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T = Integer.parseInt(in.readLine()); //테스트 케이스
		for(int testCase=1; testCase <=T; testCase++) {
			//1.입력
			N = Integer.parseInt(in.readLine()); //섬 수
			x = new int[N];
			y = new int[N];
			adjMatirx = new long[N][N];
			//x좌표 입력
			st = new StringTokenizer(in.readLine());
			for(int i=0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			//y좌표 입력
			st = new StringTokenizer(in.readLine());
			for(int i=0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			//환경부담 세율입력
			E = Double.parseDouble(in.readLine());
			
			//2. 거리 제곱 계산 및 인접행렬 생성 
			for(int i=0; i<N; i++) {
				for(int j=0; j < N; j++) {
					long disX = Math.abs(x[i]-x[j]);
					long disY = Math.abs(y[i]-y[j]);
					adjMatirx[i][j] =disX*disX + disY*disY;
				}
			}
			
			//prim 실행
			long total = prim();
			
			//환경 부담 세율 곱하고 반올림;
			long answer = Math.round(total * E);
			
			//3.출력
			sb = new StringBuilder("#").append(testCase).append(" ").append(answer);
			System.out.println(sb.toString());

		}

	}

	/**
	 * prim 알고리즘 구현
	 * @return 최소비용 total: long
	 */
	private static long prim() {
		boolean [] visited = new boolean[N]; 	//방문여부
		long [] minEdge = new long[N]; 			//각 정점까지 최소 거리 제곱
		Arrays.fill(minEdge, Long.MAX_VALUE); 	//초기값 설정
		minEdge[0]=0; 							//시작 정점 0
		
		long total=0;
		
		for(int i=0; i < N ; i++) {
			long min = Long.MAX_VALUE;
			int minVertex = -1;
			
			//방문하지 않은 정점 중 최소 간선 선택
			for(int v=0; v < N; v++) {
				if(!visited[v] && min > minEdge[v]) {
					min = minEdge[v];
					minVertex =v;
				}
			}
			
			visited[minVertex] = true; 	//방문처리
			total += min; 				//비용 누적	
			
			//인접 정점들에 대해 최소 거리 갱신
			for(int v=0; v<N; v++) {
				if(!visited[v] && adjMatirx[minVertex][v] < minEdge[v]) {
					minEdge[v] = adjMatirx[minVertex][v];
				}
			}
		}
	
		return total;
	}

}


