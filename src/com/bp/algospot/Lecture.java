package com.bp.algospot;

import java.util.ArrayList;
import java.util.Scanner;

import com.bp.datastructure.Sort;

public class Lecture {

	void sortLecture(char arr[]) {

		if (arr.length < 3) {
			System.out.println(arr);
			return;
		}

		int ab[] = new int[arr.length / 2];

		for (int i = 0; i < arr.length; i += 2) {

			ab[i / 2] = (((int) arr[i]) - 80) * 100 + (((int) arr[i + 1]) - 80);
		}

		// sorting
		int j;
		for (int i = 1; i < ab.length; i++) {

			int temp = ab[i];
			j = i - 1;
			while ((j >= 0) && (ab[j] > temp)) {
				ab[j + 1] = ab[j];
				j--;
			}

			ab[j + 1] = temp;
		}

		for (int i = 0; i < ab.length; i++) {
			arr[i * 2] = (char) ((ab[i] / 100) + 80);
			arr[(i * 2) + 1] = (char) ((ab[i] % 100) + 80);
			System.out.print(arr[i * 2] + "" + arr[(i * 2) + 1]);
		}
		System.out.println();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		Lecture l = new Lecture();
		int in_Line = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < in_Line; i++) {
			String temp = sc.nextLine();
			list.add(temp);
		}

		for (int i = 0; i < in_Line; i++)
			l.sortLecture(list.get(i).toCharArray());
	}

}
