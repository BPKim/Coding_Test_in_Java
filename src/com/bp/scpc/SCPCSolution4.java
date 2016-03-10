package com.bp.scpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SCPCSolution4 {

	static int[] subject;
	static double[] pan;

	static double getDistance(int x, int y) {

		return Math.sqrt(Math.pow(x, 2) +  Math.pow(y, 2));
	}

	static int getPoint(int x, int y) {

		if (y == 0 && x < 0)
			return 11;
		else if (y == 0 && x > 0)
			return 9;
		else if( x== 0 && y >0 )
			return 20;
		else if( x==0 && y <0)
			return 3;
		
		double tan_xy = x / y;
		// 13
		if ((pan[0] < tan_xy) && (tan_xy < pan[1]))
			return 13;
		// 4
		else if ((pan[1] < tan_xy) && (tan_xy < pan[2]))
			return 4;
		// 18
		else if ((pan[2] < tan_xy) && (tan_xy < pan[3]))
			return 18;
		else if ((pan[3] < tan_xy) && (tan_xy < pan[4]))
			return 1;
		else if ((pan[4] < tan_xy) && (tan_xy < pan[5]))
			return 20;
		else if ((pan[5] < tan_xy) && (tan_xy < pan[6]))
			return 5;
		else if ((pan[6] < tan_xy) && (tan_xy < pan[7]))
			return 12;
		else if ((pan[7] < tan_xy) && (tan_xy < pan[8]))
			return 9;
		else if ((pan[8] < tan_xy) && (tan_xy < pan[9]))
			return 14;
		else if ((pan[9] < tan_xy) && (tan_xy < pan[10]))
			return 11;
		else if ((pan[10] < tan_xy) && (tan_xy < pan[11]))
			return 8;
		else if ((pan[11] < tan_xy) && (tan_xy < pan[12]))
			return 16;
		else if ((pan[12] < tan_xy) && (tan_xy < pan[13]))
			return 7;
		else if ((pan[13] < tan_xy) && (tan_xy < pan[14]))
			return 19;
		else if ((pan[14] < tan_xy) && (tan_xy < pan[15]))
			return 3;
		else if ((pan[15] < tan_xy) && (tan_xy < pan[16]))
			return 17;
		else if ((pan[16] < tan_xy) && (tan_xy < pan[17]))
			return 2;
		else if ((pan[17] < tan_xy) && (tan_xy < pan[18]))
			return 15;
		else if ((pan[18] < tan_xy) && (tan_xy < pan[19]))
			return 10;
		else if ((pan[19] < tan_xy) && (tan_xy < pan[0]))
			return 9;

		return 0;
	}

	static void setPan() {
		pan = new double[20];

		for (int i = 0; i < 20; i++){
			System.out.println(9 + i * 18);
			pan[i] = Math.tan(Math.toRadians(9 + i * 18));
		}

	}

	public static void main(String[] args) throws Exception	 {


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
		int bea;
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ����
		 * ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� �߰��ϸ�, �� �Ʒ�����
		 * �Է��� ������ �� ǥ�� �Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ���� ������ PC ����
		 * �׽�Ʈ �� ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �˴ϴ�. ��, �� �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� ��
		 * �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
		
		 Scanner sc = new Scanner(System.in);
		setPan();
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			score = 0;
			// bull, double, triple ��ġ
			bull = sc.nextInt();
			d_start = sc.nextInt();
			d_end = sc.nextInt();
			t_start = sc.nextInt();
			t_end = sc.nextInt();

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

				if (distance < bull) {
					score += 50;
					bea = 0;
				} 
				else if((bull<distance)&&(distance<d_start))
					bea=1;
				else if ((d_start < distance) && (distance < d_end))
					bea = 2;
				else if((d_end < distance)&&(distance <t_start))
					bea=1;
				else if ((t_start < distance) && (distance < t_end))
					bea = 3;
				else if (distance > t_end)
					bea = 0;
				else
					bea=1;

				score += (getPoint(x, y) * bea);
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}
}
