package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jumpgame {

	static int n;
	static int map[][] = null;
	static int isGo[][] = null;

	static boolean function(int y, int x) {

		// »ßÁ® ³ª°¬À»¶§
		if (x >= n || y >= n)
			return false;

		// ¸¶Áö¸· µµÂø
		if (x == n - 1 && y == n - 1)
			return true;

		if (isGo[y][x] > -1) {
			if (isGo[y][x] == 0)
				return false;
			else
				return true;
		}

		int jump = map[y][x];

		boolean a = function(y + jump, x) || function(y, x + jump);
		if (a) {
			isGo[y][x] = 1;
			return true;
		} else {
			isGo[y][x] = 0;
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = null;

		try {
			sc = new Scanner(new FileInputStream("Jumpgame.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int TC;

		TC = sc.nextInt();

		for (int testcase = 0; testcase < TC; testcase++) {
			n = sc.nextInt();
			map = new int[n][n];
			isGo = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					isGo[i][j] = -1;
				}
			}
			
			if(function(0, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
