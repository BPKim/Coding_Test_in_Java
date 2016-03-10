package com.bp.algospot;

import java.util.Scanner;

public class NQueen {
	
	static int MAX_SIZE = 12;
	int CHESS [][];

	NQueen() {
		CHESS = new int[MAX_SIZE][MAX_SIZE];
	}
	
	int findQueen(int n){
		
		if(n==1)
			return 1;
		else if(n==2)
			return 0;
		
		for(int i =0 ; i <n ; i++){
			for(int j = 0 ; j < n ; j++ ){
				if(CHESS[i][j]!=1){
					CHESS[i][j]=1;
					// ÁÂ  ¿ì ÁÙ ±ß±â
					// »ó ÇÏ ÁÙ ±ß±â
					// ´ë°¢¼± ÁÙ ±ß±â
					
				}
			}
		}
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		//int in_N = sc.nextInt();
		
		//sc.nextLine();
		
	}

}
