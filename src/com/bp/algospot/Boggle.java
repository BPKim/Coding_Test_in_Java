package com.bp.algospot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Boggle {
	// 범위는 5X5
	static final int RANGE = 5;

	// 팔방 위치 움직이기
	static int dy[] = { 0, -1, 1, -1, 0, 1, -1, 1 };
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

	/**
	 * 
	 * @param y : table [y][]
	 * @param x : table [y][x];
	 * @param what_wod : what_word;
	 * @param word_idx : word_idx;
	 * @param table : table;
	 * @param word : word;
	 * @return
	 */
	boolean hasWord(int y, int x, int what_word, int word_idx, char [][]table, char [][]word) {

		// 테이블 범위를 벗어났을 때
		if ((y < 0 || y >= RANGE))
			return false;
		if ((x < 0 || x >= RANGE))
			return false;

		// 글자가 다를때
		if (table[y][x] != (word[what_word][word_idx]))
			return false;

		// 맨 끝까지 단어 맞으면 성공!!
		if (word_idx == 0)
			return true;

		word_idx--;

		for (int i = 0; i < 8; i++) {
			// 위, 아래, 좌, 우, 그리고 대각선 4개 
			int ny = y + dy[i], nx = x + dx[i];

			if (hasWord(ny, nx, what_word, word_idx, table, word))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isOk = false;

		Boggle boggle = new Boggle();
//		Scanner sc = null;

		int TC;
		int word_num;
		char[][] table = null;
		char[][] word = null;
		boolean isWord[] = null;
//		try {
//			sc = new Scanner(new FileInputStream("Boggle.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();

		for (int testcase = 0; testcase < TC; testcase++) {

			table = new char[5][];

			for (int i = 0; i < 5; i++) {
				String temp = sc.next();
				table[i] = temp.toCharArray();
			}
			
			word_num = sc.nextInt();
			word = new char[word_num][];
			isWord = new boolean[word_num];
			
			for(int i = 0 ; i < word_num ; i ++){
				String temp = sc.next();
				word[i] = temp.toCharArray();
				isWord[i] = false;
			}
			
			for(int i = 0 ; i < 25 ; i ++){
				for(int j = 0 ; j < word_num ; j ++)
				{
					if(boggle.hasWord(i/5, i%5, j, word[j].length-1, table, word)){
						isWord[j] = true;
						continue;
					}
				}
			}
			
			for(int i = 0 ; i < word_num ; i ++){
				for(int j = 0 ; j < word[i].length; j ++)
					System.out.print(word[i][j]);
				
				if(isWord[i])
					System.out.println(" YES");
				else
					System.out.println(" NO");
			}
				
			
			
			
		}

		

	}

}
