package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 정리 
 * - 아홉 난쟁이의 키가 주어졌을 때, 
 * - 키의 합이 100이 되는 일곱 난쟁이를 오름차순으로 출력
 * 
 * 전략  
 * - 9개 중 7개를 고르는 '조합+백트래킹'으로 풀 수도 있지만
 * - 제외할 2명을 찾는 방식이 더 간단하다.
 * ( 사실상 9C7 = 9C2 = 36 으로 동일함) 
 * 
 * - 
 * 
 *
 */
public class Main_2309_일곱난쟁이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] person = new int[9];
		for(int i = 0; i < 9; i++ ) {
			person[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	}
}
