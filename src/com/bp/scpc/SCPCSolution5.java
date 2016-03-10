package com.bp.scpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author BP
 *
 */
public class SCPCSolution5 {

	static int table[][][];

	static long nCk(int n, int k) {

		// if(table[n][k]!=0)
		// return table[n][k];

		if (n == k)
			return 1;
		if (k == 0)
			return 1;

		return nCk(n - 1, k - 1) + nCk(n-1, k);
	}

	static long sigma(long n) {

		if (n == 1)
			return 1;

		return n + sigma(n - 1);
	}

	public static void main(String args[]) throws Exception {
		int T;
		int test_case;
		int n;
		int m;
		int a,b;
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ����
		 * ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�, �� �Ʒ�����
		 * �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ���� ������ PC ����
		 * �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�. ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� ��
		 * �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		// Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			a=0;
			b=0;
			n = sc.nextInt();
			m = sc.nextInt();

			table = new int[n][m][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					table[i][j][0] = j+i;
					table[i][j][1] = i;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a+= table[i][j][0];
					b+= table[i][j][1];
				}
			}
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(nCk(a,b)%1000000007);

		}
	}
}
