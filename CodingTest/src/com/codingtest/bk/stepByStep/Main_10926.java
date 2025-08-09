package com.codingtest.bk.stepByStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		sb.append(name).append("??!");
		System.out.println(sb.toString());
	}
}
