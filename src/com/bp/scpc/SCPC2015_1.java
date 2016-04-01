package com.bp.scpc;

import java.util.Scanner;

/*
 * 균일수 
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

		// 끝까지 왔을때 여기까지 오면 다 같으니까 이거 리턴
		if (N == 0)
			return b;

		int now = (N % b);
		// 중간 같으면 다음것도 확인해아하니까
		if (now == pre) {
			return function(N / b, b, now);
		}
		// 다르니까 큰 값 리턴
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
