package com.codingtest.bk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2477_참외밭 {

	// 동 1
	// 서 2
	// 남 3
	// 북 4
	// 시작 꼭지점은 임의.
	
	// ㄱ : 서북서북  24
	// y대칭 : 남서남서  23
	// ㄴ : 동남동남  13
	// y대칭 : 북동북동 14
	
	// 각각 이동이 2번 나오는 방향이 다름 
	static int K;
	static int ans; // 밭에서 자라는 참외 수 
	static int[][] dir;
	static ArrayList<Integer> cm; // 이 2번씩 나오는 방향의 길이만 알면 됨 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		dir = new int[5][3];
		cm = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			int cm = sc.nextInt();
			dir[d][0] += 1;
			
			if(dir[d][1] == 0) {
				dir[d][1] = cm;
			}else {
				dir[d][2] = cm;
			}
		}
		
		ArrayList<Integer> cal = new ArrayList<>();
		for(int i = 1; i <= 4; i++) {
			if(dir[i][0] == 2) {
				cal.add(dir[i][1]);
				cal.add(dir[i][2]);
			}
		}
		for(int i : cal) {
			System.out.println(i);
		}
		
		ans = (cal.get(0) + cal.get(1)) * (cal.get(2) + cal.get(3))
			- cal.get(1) * cal.get(2);
		
		
		System.out.println(ans);
	}
}
