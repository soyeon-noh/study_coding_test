package com.codingtest.bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Main_1991 { // 트리순회

	// 아이디어
	// - 이진 트리를 배열에 어떻게 담느냐가 관건.
	// - 2^h+1 만큼의 배열을 만들어서 자식 노드를 담는 조건을 이용하기로 함
	// - 하지만 노드 수만 주어져서 ArrayList 사용하기로 함
	// 아이디어 수정
	// - ArrayList의 add가 해당 인덱스를 밀어내는 문제 있어 권장되지 않음
	// - Node 클래스를 이용해서 푸는 풀이가 정석인 것 같음.
	
	// 시간복잡도
	// - ?
	
	// 자료구조
	// - DFS
	// - 재귀함수
	
	static int N;
	static Node head = new Node('A', null, null); //여기가 이해가 안됨

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0); // charAt(0)으로 문자하나 빼냄
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root, left, right);
		}	
		
		// 여기부터 모르겠음
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
		System.out.println();
	}
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		public Node(char value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void insertNode(Node temp, char root, char left, char right) {
		// 현재 탐색하고 있는 노드가 
		if(temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if(temp.left != null) insertNode(temp.left, root, left, right);
			if(temp.right != null) insertNode(temp.right, root, left, right);
		}
	}
	
	public static void preOrder(Node node) {
		if(node ==null) return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node ==null) return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node ==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}

}
