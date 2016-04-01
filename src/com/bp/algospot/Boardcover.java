package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Boardcover {

	int function(int H, int W, int y, int x, char[][] board, char[][] block) {

		if (y < 0 || y > H - 1)
			return 0;
		if (x < 0 || x > W - 1)
			return 0;

		if (board[x][y] == '#')
			return 0;

		int num = 0;

		return num;
	}

	// delta가 1이면 덮기
	// delta가 -1이면 블록 치우기
	boolean set(int[][] board, int y, int x, int type, int delta,
			int[][][] coverType) {

		boolean ok = true;

		for (int i = 0; i < 3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];

			if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length)
				ok = false;
			else if ((board[ny][nx] += delta) > 1)
				ok = false;

		}
		return ok;
	}

	int cover(int[][] board, int[][][] coverType) {
		int y = -1, x = -1;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if (y != -1)
				break;
		}
		// 기저사례 : 모든 칸 채웠을 때
		if (y == -1)
			return 1;

		int ret = 0;

		for (int type = 0; type < 4; type++) {
			// 만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출하면서 블록 채우기 
			if (set(board, y, x, type, 1, coverType))
				ret += cover(board, coverType);
			// 덮었던 블록 치우기
			set(board, y, x, type, -1, coverType);
		}
		return ret;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Boardcover bc = new Boardcover();

		Scanner sc = new Scanner(new FileInputStream("Boardcover.txt"));

		int TC;
		int H, W;
		int[][] board = null;
		int[][][] coverType = { { { 0, 0 }, { 1, 0 }, { 0, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 1, -1 } } };
		TC = sc.nextInt();
		for (int testcase = 0; testcase < TC; testcase++) {

			H = sc.nextInt();
			W = sc.nextInt();

			board = new int[H][];

			// board
			for (int i = 0; i < H; i++) {
				char[] tempLine = sc.next().toCharArray();
				int j = 0;
				board[i] = new int[W];
				for (char temp : tempLine) {
					if (temp == '#')
						board[i][j] = 1;
					else
						board[i][j] = 0;

					j++;
				}

			}
			
			System.out.println(bc.cover(board, coverType));

		}
	}
}
