package com.bp.scpc;
import java.util.Scanner;

public class SCPCSolution2 {

	static int[] score;

	static void sort(int arr[], int l, int r) {

		int h_l = l;
		int h_r = r;
		int pivot = arr[h_l];
		int temp;

		while (l < r) {
			while ((arr[l] <= pivot) && (l < r))
				l++;
			while ((arr[r] >= pivot) && (l < r))
				r--;

			if (l < r) {
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}

		}

		arr[h_l] = arr[r];
		arr[r] = pivot;
		pivot = r;

		if (h_l < pivot-1)
			sort(arr, h_l, pivot - 1);
		if (pivot+1 < h_l)
			sort(arr, pivot + 1, h_r);
	}

	public static void main(String[] args) {
		int T;
		int test_case;
		int num;
		int winnum;
		int topscore;
		/*
		 * 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다. 만약
		 * 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면, 그 아래에서
		 * 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 따라서 본인의 PC 에서
		 * 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다. 단, 이 시스템에서 "제출하기" 할 때에는 반드시 이
		 * 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			winnum = 1;
			// 응시자 수 입력
			num = sc.nextInt();
			score = new int[num];

			// 각 응시자의 점수합 입력
			for (int i = 0; i < num; i++)
				score[i] = sc.nextInt();
			// System.out.println("b-" + win);
			sort(score, 0, num - 1);
			/*
			for(int i = 0 ; i < num ; i ++)
				System.out.print(score[i]);
			
			System.out.println();
			*/
			// i =n 일때 n+1번째가 우승할 수 있는지 확인
			// 가장 점수가 작은 놈부터 
			for (int i = 0; i < num-1; i++) {
				topscore = score[i] + num;
				
				//  가장 큰 수가 꼴지 했을때 비교 
				if((score[num-1]+1)<=topscore)
					winnum++;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(winnum);
		}
	}

}
