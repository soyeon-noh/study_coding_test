package bk.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 이해
 * 
 *
 */
public class Main_2816_디지털티비 {

	static int N, now;
	static int kbs1Idx, kbs2Idx;
	static String[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		list = new String[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = br.readLine();
			if(list[i].equals("KBS1")) kbs1Idx = i;
			if(list[i].equals("KBS2")) kbs2Idx = i;
		}// 입력 끝
		
		search();
		
		System.out.println(sb.toString());
	}
	
	private static void search() {
		boolean plus = false;
		

		list.toString();
		
		if(list[0].equals("KBS1") && list[1].equals("KBS2")) return;

		if(kbs1Idx > kbs2Idx) plus = true;
		
		
		System.out.println(now  + " 시작");
		// KBS1을 먼저 맞추기
		if(!list[0].equals("KBS1")) {
			moveTo(kbs1Idx); //3
			switchTo(0, now);
		}
		
		// KBS2 맞추기
		for(int i = 0; i < Math.abs(now - kbs2Idx); i++) {
			if(plus) kbs2Idx++;
			moveTo(kbs2Idx);
			switchTo(0, now);
		}
		
			
		

	}

	private static void moveTo(int x) {
		
		System.out.println("이거 : " + Math.abs(now - x));
		for(int i = 0; i < Math.abs(now - x); i++) {
			System.out.println( i + "번 째 ");
			if(now < x) {
				sb.append(1);
				now++;
				System.out.println(now + " 화살표를 내림");
			}else {
				sb.append(2);
				now--;
				System.out.println(now + "화살표를 올림");
			}
			
		}
	}
	
	private static void switchTo(int x, int now) {
		
		for(int i = 0; i < Math.abs(now - x); i++) {
			if(now < x) {
				sb.append(3);
				now++;
				System.out.println(now + " 현재를 아래로 내림");
			}else {
				sb.append(4);
				now--;
				System.out.println(now + " 현재를 위로 올림");
			}
			
		}
	}
}
