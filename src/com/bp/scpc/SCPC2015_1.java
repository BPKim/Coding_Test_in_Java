package com.bp.scpc;

import java.util.Scanner;

/*
 * ���ϼ� 
 */
public class SCPC2015_1 {

	int function(int N) {

		for (int b = 2; b < N; b++) {

			int value = function(N / b, b, N % b);

			if (value < 0)
				continue;
			else
				return value;

		}
		return N + 1;
	}

	int function(int N, int b, int pre) {

		// ������ ������ ������� ���� �� �����ϱ� �̰� ����
		if (N == 0)
			return b;

		int now = (N % b);
		// �߰� ������ �����͵� Ȯ���ؾ��ϴϱ�
		if (now == pre) {
			return function(N / b, b, now);
		}
		// �ٸ��ϱ� ū �� ����
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();

		SCPC2015_1 a = new SCPC2015_1();

		for (int testcase = 0; testcase < TC; testcase++) {
			System.out.println("Case #1");
			a.function(sc.nextInt());
		}

	}
}
