package com.bp.scpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 다트게임
 * testcase 수 입력
 * 다트 던지는 횟수입력
 * 횟수만큼 좌표 입력
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
	 * // 경계 if (y == 0 && x < 0){ System.out.println("경계좌");
	 * 
	 * return 11; } else if (y == 0 && x > 0){ System.out.println("경계우");
	 * 
	 * return 9; } if( x== 0 && y >0 ){ System.out.println("경계상");
	 * 
	 * return 20;} else if( x==0 && y <0){ System.out.println("경계하");
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

		// 경계
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
		// 1사분면
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
		// 2사분면
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
		// 3사분면
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
		// 4사분면
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
		int bull; // 불반지름
		int d_start; // 더블 스타트
		int d_end; // 더블 엔드
		int t_start; // 트리플 스타트
		int t_end; // 트리플 엔드
		int n; // 쏜 갯수
		int x, y; // 다트 위치
		int shoot[][];
		int score;
		double distance;

		// * 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다. 만약
		// * 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면, 그 아래에서
		// * 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 따라서 본인의 PC 에서
		// * 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다. 단, 이 시스템에서 "제출하기" 할 때에는 반드시
		// 이
		// * 메소드를 지우거나 주석 처리 하셔야 합니다.

		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		// Scanner sc = new Scanner(System.in);
		// setPanWithDegree();
		setPan();
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			score = 0;
			// bull, double, triple 위치
			bull = sc.nextInt();
			t_start = sc.nextInt();
			t_end = sc.nextInt();
			d_start = sc.nextInt();
			d_end = sc.nextInt();

			// 쏜 다트 개수
			n = sc.nextInt();
			shoot = new int[n][2];

			// 다트 위치
			for (int i = 0; i < n; i++) {
				shoot[i][0] = sc.nextInt();
				shoot[i][1] = sc.nextInt();
			}

			// 중심과의 거리 구하기
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

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}
}
