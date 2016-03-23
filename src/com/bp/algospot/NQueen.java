package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NQueen {

	static int MAX_SIZE = 12;
	int CHESS[][];

	NQueen() {
		CHESS = new int[MAX_SIZE][MAX_SIZE];
	}

	int findQueen(int n) {

		if (n == 1)
			return 1;
		else if (n == 2)
			return 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (CHESS[i][j] != 1) {
					CHESS[i][j] = 1;
					// 좌 우 줄 긋기
					// 상 하 줄 긋기
					// 대각선 줄 긋기

				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;// = new Scanner(System.in);

		try {
			sc = new Scanner(new FileInputStream("NQueen.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int TC = sc.nextInt();
		int n;
		int a, b, i, j;
		int result;
		boolean end, fpoint;
		sc.nextLine();

		int pan[][];
		for (int testcase = 0; testcase < TC; testcase++) {
			a = 0;
			b = 0;
			end = false;
			fpoint = false;
			result = 0;
			n = sc.nextInt();
			// sc.nextLine();

			pan = new int[n][n];
			// System.out.println(pan[0][0]);

			for (int q = 0; q < n; q++) {
				for (int w = 0; w < n; w++) {
					System.out.print(pan[q][w] + " ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			while (true) {

				for ( i = 0; i < n; i++) {
					for ( j = 0; j < n; j++) {
						if (pan[i][j] == 0) {
							System.out.println("-- " + i + ", " + j);
							a = i;
							b = j;
							i = n;
							j = n;
						}
						if ((i == n - 1) && (j == n - 1)) {
							end = true;
							break;
						}
					}
				}

				if (end)
					break;
				// 체스 놓고 못놓을곳 체크
				pan[a][b] = 1;

				result++;
				// 가로 // 세로
				for (int k = 0; k < n; k++) {
					// 가로
					pan[a][k] = 1;
					// 세로
					pan[k][b] = 1;
					// 대각선
					if ((a - k > -1) && (b - k > -1))
						pan[a - k][b - k] = 1;
					if ((a + k < n) && (b - k > -1))
						pan[a + k][b - k] = 1;
					if ((a + k < n) && (b + k < n))
						pan[a + k][b + k] = 1;
					if ((a - k > -1) && (b + k < n))
						pan[a - k][b + k] = 1;
				}

				for (int q = 0; q < n; q++) {
					for (int w = 0; w < n; w++) {
						System.out.print(pan[q][w] + " ");
					}
					System.out.println();
				}
				System.out.println(pan[a][b] + "=" + a + "," + b
						+ "====================");

			}
			for (int q = 0; q < n; q++) {
				for (int w = 0; w < n; w++) {
					System.out.print(pan[q][w] + " ");
				}
				System.out.println();
			}

			System.out.println();
			System.out.println(result);
		}
	}
}
