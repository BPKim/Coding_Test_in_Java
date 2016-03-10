package com.bp.scpc;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * �������
 * �׽�Ʈ���̽��Է�
 * ���� �Է� ������ �� �մ� ���� �Է�
 * �����Է� ����ŭ ���� �Է�
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
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ����
		 * ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�, �� �Ʒ�����
		 * �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ���� ������ PC ����
		 * �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�. ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� ��
		 * �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		 //Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			score = 0;
			// �����
			num = sc.nextInt();
			subject = new int[num];
			// ������ �� �ִ� �����
			study = sc.nextInt();

			// �����ޱ�
			for (int i = 0; i < num; i++)
				subject[i] = sc.nextInt();

			// ����
			sort(subject, 0, num - 1);

			// ���� ū ����� ���ϱ�
			for (int i = 0; i < study; i++) {
				score += subject[i];
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}

}
