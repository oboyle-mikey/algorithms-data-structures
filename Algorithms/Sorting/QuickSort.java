package Sorting;

public class QuickSort {
	
	public String[] arr;
	int L, R;

	public QuickSort(String[]a){
		int len = a.length;
		arr = a;
		qSort(0, len-1);
	}
	
	public void qSort(int Left, int Right){
		String pivot;
		int i, j;
		
		if(L<R){
			pivot = arr[(Left+Right)/2];
			partition(Left, Right, pivot);
			i = L;
			j = R;
			qSort(Left, j);
			qSort(i, Right);
		}
	}
	
	public void partition(int L0, int R0, String p){
		int L = L0;
		int R = R0;
		
		while(L<=R){ //Until scans cross
			
			//Left Scan
			while(LessThen(arr[L], p)){
				L = L+1;
			}
			//Right Scan
			while(LessThen(p, arr[R])){
				R = R-1;
			}
			//Exchange
			if(L<=R){
				exchange(L,R);
				L = L+1;
				R = R-1;
			}
		}
	}
	
	public boolean LessThen(String a, String b){
		return (a.compareTo(b) < 0);
	}
	
	public boolean LessOrEquals(String a, String b){
		return (a.compareTo(b) <= 0);
	}
	
	public void exchange(int i, int j){
		String temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
