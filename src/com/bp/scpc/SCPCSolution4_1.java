package com.bp.scpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * ��Ʈ����
 * testcase �� �Է�
 * ��Ʈ ������ Ƚ���Է�
 * Ƚ����ŭ ��ǥ �Է�
 * 
 * @author BP
 *
 */
public class SCPCSolution4_1 {

	static int[] subject;
	static double[] pan;

	static double getDistance(int x, int y) {

		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/*
	 * static int getPointDegree(int x, int y) {
	 * System.out.println(x+", "+y+" = ");
	 * 
	 * // ��� if (y == 0 && x < 0){ System.out.println("�����");
	 * 
	 * return 11; } else if (y == 0 && x > 0){ System.out.println("����");
	 * 
	 * return 9; } if( x== 0 && y >0 ){ System.out.println("����");
	 * 
	 * return 20;} else if( x==0 && y <0){ System.out.println("�����");
	 * 
	 * return 3;}
	 * 
	 * double degree_xy = Math.atan(x/y)*180/Math.PI;
	 * 
	 * if((0<degree_xy)&&(degree_xy<pan[0])) return 9; else
	 * if((pan[0]<degree_xy)&&(degree_xy<pan[1])) return 13; else
	 * if((pan[1]<degree_xy)&&(degree_xy<pan[2])) return 4; else
	 * if((pan[2]<degree_xy)&&(degree_xy<pan[3])) return 18; else
	 * if((pan[3]<degree_xy)&&(degree_xy<pan[4])) return 1; else
	 * if((pan[4]<degree_xy)&&(degree_xy<pan[5])) return 20; else
	 * if((pan[5]<degree_xy)&&(degree_xy<pan[6])) return 5; else
	 * if((pan[6]<degree_xy)&&(degree_xy<pan[7])) return 12; else
	 * if((pan[7]<degree_xy)&&(degree_xy<pan[8])) return 9; else
	 * if((pan[8]<degree_xy)&&(degree_xy<pan[9])) return 14; else
	 * if((pan[9]<degree_xy)&&(degree_xy<pan[10])) return 11; else
	 * if((pan[10]<degree_xy)&&(degree_xy<pan[11])) return 8; else
	 * if((pan[11]<degree_xy)&&(degree_xy<pan[12])) return 16; else
	 * if((pan[12]<degree_xy)&&(degree_xy<pan[13])) return 7; else
	 * if((pan[13]<degree_xy)&&(degree_xy<pan[14])) return 19; else
	 * if((pan[14]<degree_xy)&&(degree_xy<pan[15])) return 3; else
	 * if((pan[15]<degree_xy)&&(degree_xy<pan[16])) return 17; else
	 * if((pan[16]<degree_xy)&&(degree_xy<pan[17])) return 2; else
	 * if((pan[17]<degree_xy)&&(degree_xy<pan[18])) return 15; else
	 * if((pan[18]<degree_xy)&&(degree_xy<pan[19])) return 10; else
	 * if(degree_xy>pan[19]) return 9;
	 * 
	 * else return 0; }
	 */

	static int getPoint(int x, int y) {

		// ���
		if (y == 0) {
			if (x < 0)
				return 11;
			else if (x > 0)
				return 6;
		}

		if (x == 0) {
			if (y > 0)
				return 20;
			else if (y < 0)
				return 3;
		}
		// 1��и�
		if ((x > 0) && (y > 0)) {
			double tan_xy = (double) y / x;

			if ((0 < tan_xy) && (tan_xy < pan[0]))
				return 6;
			else if ((pan[0] < tan_xy) && (tan_xy < pan[1]))
				return 13;
			else if ((pan[1] < tan_xy) && (tan_xy < pan[2]))
				return 4;
			else if ((pan[2] < tan_xy) && (tan_xy < pan[3]))
				return 18;
			else if ((pan[3] < tan_xy) && (tan_xy < pan[4]))
				return 1;
			else if ((pan[4] < tan_xy) && (tan_xy < pan[5]))
				return 20;
		}
		// 2��и�
		else if ((x < 0) && (y > 0)) {
			double tan_xy = -((double) y / x);

			if ((0 < tan_xy) && (tan_xy < pan[0]))
				return 11;
			else if ((pan[0] < tan_xy) && (tan_xy < pan[1]))
				return 14;
			else if ((pan[1] < tan_xy) && (tan_xy < pan[2]))
				return 9;
			else if ((pan[2] < tan_xy) && (tan_xy < pan[3]))
				return 12;
			else if ((pan[3] < tan_xy) && (tan_xy < pan[4]))
				return 5;
			else if ((pan[4] < tan_xy) && (tan_xy < pan[5]))
				return 20;
		}
		// 3��и�
		else if ((x < 0) && (y < 0)) {
			double tan_xy = (double) y / x;

			if ((0 < tan_xy) && (tan_xy < pan[0]))
				return 11;
			else if ((pan[0] < tan_xy) && (tan_xy < pan[1]))
				return 8;
			else if ((pan[1] < tan_xy) && (tan_xy < pan[2]))
				return 16;
			else if ((pan[2] < tan_xy) && (tan_xy < pan[3]))
				return 7;
			else if ((pan[3] < tan_xy) && (tan_xy < pan[4]))
				return 19;
			else if ((pan[4] < tan_xy) && (tan_xy < pan[5]))
				return 3;
		}
		// 4��и�
		else if ((x > 0) && (y < 0)) {
			double tan_xy = -((double) y / x);

			if ((0 < tan_xy) && (tan_xy < pan[0]))
				return 6;
			else if ((pan[0] < tan_xy) && (tan_xy < pan[1]))
				return 10;
			else if ((pan[1] < tan_xy) && (tan_xy < pan[2]))
				return 15;
			else if ((pan[2] < tan_xy) && (tan_xy < pan[3]))
				return 2;
			else if ((pan[3] < tan_xy) && (tan_xy < pan[4]))
				return 17;
			else if ((pan[4] < tan_xy) && (tan_xy < pan[5]))
				return 3;
		} else {
		}

		return 0;
	}

	static void setPan() {
		pan = new double[6];

		for (int i = 0; i < 5; i++)
			pan[i] = Math.tan(Math.toRadians(9 + i * 18));

		pan[5] = Math.tan(Math.toRadians(90));

	}

	/*
	 * static void setPanWithDegree() { pan = new double[20];
	 * 
	 * for (int i = 0; i < 20; i++){ System.out.println(9 + i * 18); pan[i] = 9
	 * + i * 18; } }
	 */
	public static void main(String[] args) throws Exception {

		System.out.println((Math.atan(1)*180)/Math.PI);
		int T;
		int test_case;
		int bull; // �ҹ�����
		int d_start; // ���� ��ŸƮ
		int d_end; // ���� ����
		int t_start; // Ʈ���� ��ŸƮ
		int t_end; // Ʈ���� ����
		int n; // �� ����
		int x, y; // ��Ʈ ��ġ
		int shoot[][];
		int score;
		double distance;

		// * �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ����
		// * ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�, �� �Ʒ�����
		// * �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ���� ������ PC ����
		// * �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�. ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ��
		// ��
		// * �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.

		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		// Scanner sc = new Scanner(System.in);
		// setPanWithDegree();
		setPan();
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			score = 0;
			// bull, double, triple ��ġ
			bull = sc.nextInt();
			t_start = sc.nextInt();
			t_end = sc.nextInt();
			d_start = sc.nextInt();
			d_end = sc.nextInt();

			// �� ��Ʈ ����
			n = sc.nextInt();
			shoot = new int[n][2];

			// ��Ʈ ��ġ
			for (int i = 0; i < n; i++) {
				shoot[i][0] = sc.nextInt();
				shoot[i][1] = sc.nextInt();
			}

			// �߽ɰ��� �Ÿ� ���ϱ�
			for (int i = 0; i < n; i++) {

				x = shoot[i][0];
				y = shoot[i][1];

				distance = getDistance(x, y);

				if (distance < bull)
					score += 50;
				else if ((bull < distance) && (distance < t_start))
					score += getPoint(x, y);
				else if ((t_start < distance) && (distance < t_end))
					score += getPoint(x, y) * 3;
				else if ((t_end < distance) && (distance < d_start))
					score += getPoint(x, y);
				else if ((d_start < distance) && (distance < d_end))
					score += getPoint(x, y) * 2;
				else if (distance > d_end)
					score += 0;
				else {
				}

			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}
}
