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
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ����
		 * ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�, �� �Ʒ�����
		 * �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ���� ������ PC ����
		 * �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�. ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� ��
		 * �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			winnum = 1;
			// ������ �� �Է�
			num = sc.nextInt();
			score = new int[num];

			// �� �������� ������ �Է�
			for (int i = 0; i < num; i++)
				score[i] = sc.nextInt();
			// System.out.println("b-" + win);
			sort(score, 0, num - 1);
			/*
			for(int i = 0 ; i < num ; i ++)
				System.out.print(score[i]);
			
			System.out.println();
			*/
			// i =n �϶� n+1��°�� ����� �� �ִ��� Ȯ��
			// ���� ������ ���� ����� 
			for (int i = 0; i < num-1; i++) {
				topscore = score[i] + num;
				
				//  ���� ū ���� ���� ������ �� 
				if((score[num-1]+1)<=topscore)
					winnum++;
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(winnum);
		}
	}

}
