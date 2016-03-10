package com.bp.scpc;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 시험공부
 * 테스트케이스입력
 * 과목 입력 공부할 수 잇는 과목 입력
 * 과목입력 수만큼 점수 입력
 * @author BP
 *
 */
public class SCPCSolution3 {

	static int[] subject;

	static void sort(int arr[], int l, int r) {

		if (l == r)
			return;

		int h_l = l;
		int h_r = r;
		int pivot = arr[h_l];

		while (l < r) {

			while ((arr[r] <= pivot) && (l < r))
				r--;

			if (l != r) {
				arr[l] = arr[r];
				l++;
			}
			while ((arr[l] >= pivot) && (l < r))
				l++;

			if (l != r) {
				arr[r] = arr[l];
				r--;
			}
		}

		arr[l] = pivot;
		pivot = l;

		if (h_l < pivot)
			sort(arr, h_l, pivot - 1);
		if (pivot < h_r)
			sort(arr, pivot + 1, h_r);

	}

	public static void main(String[] args) throws FileNotFoundException {

		int T;
		int test_case;
		int num;
		int study;
		int score;
		/*
		 * 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다. 만약
		 * 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면, 그 아래에서
		 * 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 따라서 본인의 PC 에서
		 * 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다. 단, 이 시스템에서 "제출하기" 할 때에는 반드시 이
		 * 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		 //Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			score = 0;
			// 과목수
			num = sc.nextInt();
			subject = new int[num];
			// 공부할 수 있는 과목수
			study = sc.nextInt();

			// 점수받기
			for (int i = 0; i < num; i++)
				subject[i] = sc.nextInt();

			// 정렬
			sort(subject, 0, num - 1);

			// 가장 큰 놈부터 더하기
			for (int i = 0; i < study; i++) {
				score += subject[i];
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}

}
