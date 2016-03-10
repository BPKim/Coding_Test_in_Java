package com.bp.algospot;

import java.util.ArrayList;
import java.util.Scanner;

public class URIDecoding {

	URIDecoding() {

	}

	private String getCharater(String str) {

		if (str.equals("%20"))
			return " ";
		else if (str.equals("%21"))
			return "!";
		else if (str.equals("%24"))
			return "$";
		else if (str.equals("%25"))
			return "%";
		else if (str.equals("%28"))
			return "(";
		else if (str.equals("%29"))
			return ")";
		else if (str.equals("%2a"))
			return "*";
		else
			return str;

	}

	public String goDecoding(String str) {

		int i = str.indexOf("%");

		if (i < 0)
			return str;
		else
			return str.substring(0, i) + getCharater(str.substring(i, i + 3))
					+ goDecoding(str.substring(i + 3));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URIDecoding u = new URIDecoding();

		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int in_Line = 0;

		in_Line = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < in_Line; i++)
			list.add(sc.nextLine());

		for (int i = 0; i < in_Line; i++)
			System.out.println(u.goDecoding(list.get(i)));

	}

}
