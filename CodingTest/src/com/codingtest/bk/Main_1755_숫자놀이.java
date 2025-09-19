package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// eight five four nine one seven six three two zero
// 8 5 4 9 1 7 6 3 1
public class Main_1755_숫자놀이 {

	static StringBuilder sb;
	static class StringNumber implements Comparable<StringNumber>{
		int num;
		int tenNum;
		int oneNum;
		String stringNum;
		
		
		
		public StringNumber(int num) {
			super();
			this.num = num;
			this.oneNum = num%10;
			this.tenNum = num%100/10;
			System.out.println(tenNum +" " +oneNum);
			
			changeNumberToString(oneNum);
			changeNumberToString(tenNum);
			
			this.stringNum = tenNum + " " + oneNum;
		}



		public String changeNumberToString(int num) {
			switch(num) {
				case 0:
					return "zero";
				case 1: 
					return "one";
				case 2:
					return "two";
				case 3: 
					return "three";
				case 4:
					return "four";
				case 5: 
					return "five";
				case 6:
					return "six";
				case 7: 
					return "seven";
				case 8:
					return "eight";
				case 9: 
					return "nine";
				default:
					return null;
			}
			
		}

		@Override
		public int compareTo(StringNumber o) {
			
			return this.stringNum.compareTo(o.stringNum);
		}
	}
	
	static int M, N;
	static PriorityQueue<StringNumber> pq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //입력끝
		
		pq = new PriorityQueue<>();
		
		for(int i = M; i <=N; i++) {
			pq.add(new StringNumber(i));
		}
		
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll().num).append(" ");
			
			++cnt;
			if(cnt == 10) {
				sb.append("\n");
				cnt = 0;
			}
		}

		
		System.out.println(sb.toString());
	}
}
