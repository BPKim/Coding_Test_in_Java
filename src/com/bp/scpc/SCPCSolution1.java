package com.bp.scpc;

import java.util.Scanner;

/**
 * ���ڰ��ױ�
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
			int length = sc.nextInt();
			arr = new int [length][32];
			int readyNum = 0;
			// ���̽� �� �Է� �ޱ�
			for (int i = 0; i < length; i++) {
				tt = sc.nextInt();
				// ¦���� �ԷµǸ� ���� 
				if (arr[i][0] == 0) {
					readyNum++;
					arr[i][0] = tt;
				}
				else{ 
					readyNum--;
					arr[i][0] = 0;
				}
			}
			
			
			// ����ȭ
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
		// // ����ȭ
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
