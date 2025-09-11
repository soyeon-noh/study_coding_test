package ssagorithm.bk.s;

import java.io.*;
import java.util.*;

/**
 * 문제 이해
 * - 주어진 2차원 배열의 모든 수를 같게 만들어야함
 * - 한칸을 -1 하는데에 2초의 시간
 * - 한칸을 +1 하는데에 1초의 시간이 걸림
 * 
 * 입력
 * - N : 행
 * - M : 열
 * - B : 블럭사용
 * - map
 * 
 * 출력
 * - 최소시간
 * - 같다면 높이가 높은 것
 * 
 * 전략
 * - 배열의 min값과 max값을 찾은 뒤
 * - 각 값들의 개수와 걸리는 시간을 곱해 비교한 뒤 유리한 것을 수행
 * - 그럼 결과적으로 고른 상태가 될 것
 * 
 * - 설치시 블럭이 부족한 경우 제거로 일괄 통일 
 * 
 * - 최소시간이 같은 경우 어떻게 해야할지 당장은 안 떠오름. 일단 짜보자.
 * 
 * 시간복잡도
 * - 0이랑 256이 같이 있으면 256 x 500 x 500 = 64,000,000
 * - 흠 드가보자
 * 
 * 후기
 * - 풀다보니 6천만은 무슨; 터지는 게 아닌가 걱정됨 지금
 */
public class Main_18111_실패 {

	static int N, M, B, map[][];
	static int min, max; // 현재상태의 min과 max로 유동적임 
	static int ans; //time;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		max = 0;// 초기화
		
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[r][c]);
				min = Math.min(min, map[r][c]);
			}
		}// 입력끝
		
		// 메모이제이션을 조금은 쓸 수 있지 않을까
		int[] cnt = new int[max-min+1];// min=7 이면, cnt[0]은 7의 카운트 // idx에 현재값-min하면될듯 // 엥! 안 됨;;
		int start = min; // 시작 min값을 빼놔야함 // min은 유동적이기 때문
		
		Arrays.fill(cnt, -1); // 값을 구하지 않은 경우를 구분하기 위해 -1로 채움
		
		// min과 max를 비교하며 차이를 줄여나가보자
		int loop = max-min; // max와 min이 유동적이므로 고정해야함
		for(int i = 0; i < loop; i++) { // 초기 max-min만큼 반복. 한번 반복을 돌 때마다 차이가 1씩 줄어들테니
			if(cnt[min-start] == -1) { // min값이 메모이제이션 배열에 없니?
				cnt[min-start] = getCnt(min); // 구했으니 메모이제이션 배열에 추가
			}
			if(cnt[max-start] == -1) { // max값이 메모이제이션 배열에 없니?
				cnt[max-start] = getCnt(max);
			}
			// 카운팅 완료
			
			int createTime = cnt[min-start];
			int removeTime = cnt[max-start] * 2;
			
			if(createTime <= removeTime) { // min값의 숫자들 전체에 블럭을 1개씩 설치하는 게 이득이다 //혹은 같다면 높은쪽을 출력해야하므로 <=
				if(B >= cnt[min-start]) { //그리고 설치할 블럭이 충분하면
					changeMap(min, 1); // 설 치 해 
					B -= cnt[min-start];
					ans += createTime; // 설치시간 더하기
					min++; // 설치했으니 1올려줌
				}else { // 가진 블럭이 없어?
					changeMap(max, -1); // 제 거 해 
					B += cnt[max-start]; // 블럭회수
					ans += removeTime; //제거시간 더하기
					max--; // 제거했으니 1빼줌
				}
			} else { // max값의 숫자들 전체에 블럭을 1개씩 제거하는 게 이득이다 
				changeMap(max, -1); // 제 거 해 
				B += cnt[max-start]; // 블럭회수
				ans += removeTime; //제거시간 더하기
				max--; // 제거했으니 1빼줌
			}
		}
		
		sb.append(ans).append(" ").append(min); //min이든 max든 상관없을듯
		System.out.println(sb.toString());
	}

	// map에서 파라미터 num의 숫자에 cal을 더함
	private static void changeMap(int num, int cal) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == num) map[r][c] = num+cal;
			}
		}
		
	}

	// map에서 파라미터 num의 개수를 return
	private static int getCnt(int num) {
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == num) ++cnt;
			}
		}
		return cnt;
	}
}
