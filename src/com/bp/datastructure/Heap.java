package com.bp.datastructure;


/**
 * 
 * @author BP Heap 구현
 * 
 *         삼성 가자 고고싱 에스케이도 가자 고고싱 !!! 제발!!!! ㅜㅜ 울고 싶다 .
 *         
 *         시간복잡도 O(nlogn) 빠르다.
 */
public class Heap {

	final static int MAX_SIZE = 100;

	int heap[];
	int idx;

	Heap() {
		heap = new int[MAX_SIZE];
		idx = -1;
	}

	int getParentIdx(int idx) {
		if(idx == 1)
			return 0;
		
		if(idx%2 != 0)
			return idx/2;
		else
			return idx/2-1;
	}

	int getLeftChildIdx(int idx) {
		return idx*2+1;
	}

	int getRightChildIdx(int idx) {
		return idx*2+2;
	}

	public void insertHeap(int n) {

		int i;
		
		if(idx == MAX_SIZE)
			return;
		
		System.out.println("들어옴 "+ n);
		
		heap[++idx] = n;
		
		i = idx;
		

		while((i!=0) && (heap[ getParentIdx(i) ] > heap[i])){

			Swap(getParentIdx(i), i);
			i = getParentIdx(i);
			
		}

	}
	
	int [] sortHeap(int arr[], int i){
		
		int pIdx = getParentIdx(i);
		if(i==0)
			return arr;
		
		if(arr[pIdx] > arr[i]){
			Swap( pIdx, i);
			i = pIdx;
		}
		
		return sortHeap(arr, i);
		
	}
	public int popHeap(){
		
		int result = heap[0];
		int i = 0;
		int cIdx, rIdx, lIdx;
		
		heap[0] = heap[idx];
		heap[idx--] = 0;
		

		while(true){
			// 우선순위가 높은 놈 가져오기 
			rIdx = getRightChildIdx(i);
			lIdx = getLeftChildIdx(i);
			
			cIdx = (heap[lIdx] < heap[rIdx]) ? lIdx: rIdx;
			
			System.out.println(i +"/ "+cIdx);
			
			if(heap[cIdx]<1)
				break;
			
			if(heap[i]>heap[cIdx]){
				Swap(i, cIdx);
				i=cIdx;
			}
			else{
				break;
			}
			
		}
		

		return result; 
	}
	public int[] getHeap(){
		
		return heap;
	}
	
	
	private void Swap( int to, int from){
		
		int temp = heap[to]; 
		heap[to] = heap[from];
		heap[from] = temp;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input[] = {1, 2, 10, 12, 7, 6, 3, 11, 8, 4};
		int result[];
		Heap h = new Heap();
		for( int i = 0 ; i < input.length ; i ++){
			h.insertHeap(input[i]);
		}
		result = h.getHeap();
		
		for( int i = 0 ; i < input.length ; i ++){
			System.out.println(h.heap[i]);
		}/*
		System.out.println("----");
		for( int i = 0 ; i < input.length ; i ++){
			System.out.println(h.popHeap());
		}*/
	}

}
