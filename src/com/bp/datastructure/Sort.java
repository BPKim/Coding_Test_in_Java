package com.bp.datastructure;

public class Sort {

	int p = 0;

	/**
	 * Bubblesort 시간복잡도 O(n^2)
	 * 
	 * @param a
	 * @return
	 */
	public int[] BubbleSort(int a[]) {

		for (int i = 0; i < a.length - 1; i++) {

			for (int j = 0; i < a.length - 1 - i; j++) {

				if (a[j] > a[j + 1])
					Swap(a, j, j + 1);
			}
		}
		return a;
	}

	/**
	 * SelectSort 시간복잡도 O(n)
	 * 
	 * @param a
	 * @return
	 */
	public int[] SelectSort(int a[]) {

		int minIdx;
		boolean isSwap = false;
		for (int i = 0; i < a.length - 1; i++) {
			minIdx = i;

			for (int j = i + 1; j < a.length; j++) {

				if (a[j] < a[minIdx]) {
					System.out.println(j + " - " + minIdx);
					minIdx = j;
					isSwap = true;
				}
			}
			// System.out.println(i + "<->" +minIdx);
			// System.out.println(a[i] + "<=>" +a[minIdx]);
			if (isSwap) {
				 System.out.println(i + "<->" +minIdx);
				 System.out.println(a[i] + "<=>" +a[minIdx]);
				a = Swap(a, i, minIdx);
				
				isSwap = false;
			}

		}

		return a;
	}

	/**
	 * InsertSort 시간복잡도 O(n^2)
	 * 
	 * @param a
	 * @return
	 */
	public int[] InsertSort(int a[]) {

		int temp;
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];
			j = i - 1;

			while ((j >= 0) && (a[j] > temp)) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = temp;

		}

		return a;
	}

	/**
	 * QuickSort 시간복잡도 O(nlog2n) 가장 빠르다.
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] QuickSort(int a[], int left, int right) {

		// 피봇 설정
		int pivot = a[left];
		int h_left = left;
		int h_right = right;

		// left < right
		// while
		while (left < right) {

			// left ++ 조건 while
			while ((a[left] <= pivot) && (left <= right))
				left++;
			// right -- 조건 while
			while ((a[right] <= pivot) && (left <= right))
				right--;

			// left < right 이변 변경
			if (left < right) {
				a = Swap(a, left, right);
			}
		}

		// 피봇 움직이기
		a[h_left] = a[right];
		a[right] = pivot;

		pivot = right;

		// 나눠서 재귀형식
		if (h_left < pivot)
			QuickSort(a, h_left, pivot - 1);
		if (h_left < pivot)
			QuickSort(a, pivot + 1, h_right);
		return a;
	}

	private int[] Swap(int a[], int to, int from) {
		System.out.println(++p);
		int temp = a[to];
		a[to] = a[from];
		a[from] = temp;

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sort s = new Sort();
		int[] A = { 1, 5, 3, 3, 7 };
		/*
		 * s.BubbleSort(A); s.SelectSort(A); s.QuickSort(A, 0, A.length-1);
		 */
		s.SelectSort(A);
	}

}
