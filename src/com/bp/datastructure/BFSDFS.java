package com.bp.datastructure;

import java.util.LinkedList;
import java.util.Stack;

//0.07238 

/**
 * 
 * @author BP 너비 우선 탐색
 * 
 */
public class BFSDFS {
	
	static void BFS(int arr[][], int l) {

		 LinkedList<Integer> queue = new LinkedList<>();
		//QueueBFS queue = new QueueBFS();
		//QueueBFS();
		int check[] = new int[l];
		int i = 0;

		queue.add(arr[0][0]);

		while (!queue.isEmpty()) {
			i = queue.poll();

			if (check[i] > 0)
				continue;

			check[i] = 1;
			System.out.println(i);

			for (int j = 0; j < l; j++) {
				if ((arr[i][j] > 0) && (check[j] < 1))
					queue.add(j);
			}
		}
	}

	static void DFS(int arr[][], int l) {

		Stack queue = new Stack();
		//QueueBFS queue = new QueueBFS();
		//QueueBFS();
		int check[] = new int[l];
		int i = 0;

		queue.add(arr[0][0]);

		while (!queue.isEmpty()) {
			i = (int) queue.pop();

			if (check[i] > 0)
				continue;

			check[i] = 1;
			System.out.println(i+" ");

			for (int j = 0; j < l; j++) {
				if ((arr[i][j] > 0) && (check[j] < 1))
					queue.add(j);
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 34개
		// int tree[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
		// 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1};

		int[][] route = { { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, };

		BFS(route, 10);
		System.out.println();
		DFS(route, 10);
	}

}
