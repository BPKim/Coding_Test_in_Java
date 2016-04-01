package com.bp.algospot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quadtree {

	public String function(String quadTree) {
		return function(quadTree, 0);
	}

	private String function(String quadTree, int index) {

		char ch = quadTree.charAt(index);

		if (ch == 'x') {
			String LT = function(quadTree, ++index);
			index += LT.length();
			String RT = function(quadTree, index);
			index += RT.length();
			String LD = function(quadTree, index);
			index += LD.length();
			String RD = function(quadTree, index);
			return "x" + LD + RD + LT + RT;
		} else {
			return Character.toString(ch);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Quadtree q = new Quadtree();
		
		int TC;
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("Quadtree.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TC = sc.nextInt();
		
		for(int testcase = 0 ; testcase < TC; testcase++){
			String quadTree = sc.next();
			System.out.println(q.function(quadTree));
		}
		
	}

}
