package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XEAENEUNG {

	static final String[] number = { "zero", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten" };
	static final String[] operation = { "+", "-", "*" };
	static final String NO = "No";
	static final String YES = "Yes";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = null;
		// sc = new Scanner(System.in);
		try {
			sc = new Scanner(new FileInputStream("XEAENEUNGinput.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int T;
		int i, j, k = 0;
		String result;
		String line;
		T = sc.nextInt();
		sc.nextLine();
		int A, B, C;
		for (int testcase = 0; testcase < T; testcase++) {

			line = sc.nextLine();
			result = NO;
			A = -1;
			B = -1;
			C = -1;
			String[] temp = line.split(" ");

			// ��� ���ڷ�
			for (i = 0; i < number.length; i++) {
				if (temp[0].equals(number[i])) {
					A = i;
				}
				if (temp[2].equals(number[i])) {
					B = i;
				}

				if ((A > -1) && (B > -1)) {
					break;
				}
			}
			// System.out.println(A + " " + B);

			int eq = 0;

			for (i = 0; i < 10; i++) {

				if (temp[4].length() != number[i].length())
					continue;

				char c_temp[] = temp[4].toCharArray();
				char n_temp[] = number[i].toCharArray();

				eq = 0;
				// System.out.println(temp[4] + " " + number[i]);

				for (j = 0; j < c_temp.length; j++) {
					for (k = 0; k < n_temp.length; k++) {

						// System.out.println(c_temp[k] + " == " + n_temp[j]);

						if (c_temp[k] == n_temp[j]) {
							eq++;
							c_temp[k] = '-';
							// System.out.println("--ok "+ eq);
							// System.out.println("eq- " + eq);
							break;
						}
					}

					// ���ڰ� �ƴҶ�
					if (eq != c_temp.length) {
						result = NO;
					}
					// ���ڰ� ������
					else {
						// System.out.println("find! " + eq);
						// System.out.println(i);
						C = i;

						break;
					}
				}

				if (C > -1)
					break;
			}
			// System.out.println(line);
			// System.out.println(A + " "+ temp[1] +" " + B + " = " + C);
			// ������ ���� �����϶� ��� �´��� Ȯ��
			if (C > -1) {
				// ����ϱ�
				// ���ϱ�
				if (temp[1].equals(operation[0])) {
					if ((A + B) == C)
						result = YES;
				}
				// ����
				else if (temp[1].equals(operation[1])) {
					if ((A - B) == C)
						result = YES;
				}
				// ���ϱ�
				else if (temp[1].equals(operation[2])) {
					if ((A * B) == C)
						result = YES;
				}
				// ���̶� Ȯ��
			}

			System.out.println(result);
		}

	}
}
