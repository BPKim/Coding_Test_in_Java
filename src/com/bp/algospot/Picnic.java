package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Picnic {


	int function(int student, int y, int table[][], int check[], int couple) {

		if (couple * 2 == student) {
			return 1;
		}
		int num = 0;

		if (check[y] > 0) {
			for (int i = 0; i < student; i++) {
				if (check[i] < 1)
					return num += function(student, i, table, check, couple);
			}

		}
		for (int i = 0; i < student; i++) {
			if ((table[y][i] > 0) && (check[i] < 1)) {
				int[] check_copy = check.clone();
				int couple_copy = couple + 1;
				check_copy[y] = 1;
				check_copy[i] = 1;
				num += function(student, i, table, check_copy, couple_copy);
			}

		}
		// System.out.println(num);
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Picnic p = new Picnic();

		

		int[][] table = null;/*
							 * = { { 0, 1, 1, 0, 0, 0 }, { 1, 0, 1, 1, 1, 0 }, {
							 * 1, 1, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 0, 1,
							 * 1, 0, 0, 1 }, { 0, 0, 0, 1, 1, 0 } };
							 */

		int[] check = null;// = { 0, 0, 0, 0, 0, 0 };
		// System.out.println(p.function(0, table, check, 0));

		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("Picnic.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int TC;
		int student;
		int st_couple;
		int x, y;
		TC = sc.nextInt();
		for (int testcase = 0; testcase < TC; testcase++) {

			student = sc.nextInt();
			st_couple = sc.nextInt();

			check = new int[student];
			table = new int[student][student];
			
			for (int i = 0; i < st_couple; i++) {
				y = sc.nextInt();
				x = sc.nextInt();

				table[y][x] = 1;
				table[x][y] = 1;
			}
			System.out.println(p.function(student, 0, table, check, 0));
			
		}

	}

}
