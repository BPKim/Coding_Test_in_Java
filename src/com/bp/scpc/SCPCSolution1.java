package com.bp.scpc;

import java.util.Scanner;

/**
 * 숫자골라네기
 * 
 * @author BP
 *
 */
public class SCPCSolution1 {

	/**
	 * 
	 * @param dec
	 * @return
	 */
	int[] invertToBinay(int dec) {
		int binary[] = new int[32];
		int i = 31;
		while (dec != 0) {
			binary[i] = dec % 2;
			dec = dec / 2;
			i--;
		}

		return binary;
	}

	int invertToDec(int binary[]) {
		int dec = 0;

		for (int i = 0; i < 32; i++)
			dec += binary[31 - i] * ((int) Math.pow(2, i));

		return dec;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	int[] xor(int a[], int b[]) {

		int result[] = new int[32];
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			if (b[i] == 1) {
				sum++;
				break;
			}
		}
		if (sum == 0)
			return a;

		for (int i = 0; i < 32; i++)
			result[i] = ((a[i] != b[i]) ? 1 : 0);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SCPCSolution1 scpc = new SCPCSolution1();

		int T;
		int test_case;
		int tt;
		int arr[][];
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
			int length = sc.nextInt();
			arr = new int [length][32];
			int readyNum = 0;
			// 케이스 당 입력 받기
			for (int i = 0; i < length; i++) {
				tt = sc.nextInt();
				// 짝수로 입력되면 제거 
				if (arr[i][0] == 0) {
					readyNum++;
					arr[i][0] = tt;
				}
				else{ 
					readyNum--;
					arr[i][0] = 0;
				}
			}
			
			
			// 이진화
			int[][] ready = new int[readyNum][32];
			int[] temp = new int[32];
			int[] result = new int[32];
			int l=0;
			for(int i = 0 ; i < length ; i++){
				if (arr[i][0] != 0){
					temp = scpc.invertToBinay(arr[i][0]);
					for (int j = 0; j < 32; j++)
						ready[l][j] = temp[j];
					
					l++;
				}
			}
			for (int i = 0; i < readyNum; i++)
				 result = scpc.xor(ready[i], result);
			
			 System.out.println("Case #" + test_case);
			 System.out.println(scpc.invertToDec(result));
		}
		// {
		// int l = 0;
		// int[][] ready = new int[readyNum][32];
		// 
		// int[] result = new int[32];
		//
		// // 이진화
		// for (int i = 0; i < 3000000; i++) {
		// if (arr[i][0] != 0) {
		// temp = scpc.invertToBinay(arr[i][0]);
		//
		// for (int j = 0; j < 32; j++)
		// ready[l][j] = temp[j];
		//
		// l++;
		// }
		// }
		//
		// for (int i = 0; i < readyNum; i++)
		// result = scpc.xor(ready[i], result);
		//
		// System.out.println("Case #" + test_case);
		// System.out.println(scpc.invertToDec(result));
		// }

	}
}
