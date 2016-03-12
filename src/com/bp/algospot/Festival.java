package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Festival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int TC;
		int test_case;

		int i, j;
		int day;
		int l;
		double  schedule[];
		int sum;
		double min_price;
		double price;

		 Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();

		sc.nextLine();
		for (test_case = 1; test_case <= TC; test_case++) {

			min_price = 100;

			day = sc.nextInt();

			l = sc.nextInt();

			schedule = new double [day];

			for ( i = 0; i < day; i++) {

				schedule[i] = sc.nextDouble();
			}

			for ( i = 0; i < day; i++){
				sum = 0;
				for ( j = i; j < day; j++) {
					sum += schedule[j];			

					if (j - i + 1 >= l) {
						price = sum / (double)(j - i + 1);
						if (min_price > price)
							min_price = price;
					}
				}
			}

			System.out.println(min_price);
		}		
	}
}
