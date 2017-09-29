package Sorting;

public class MergeSortArray {
	
	public String[] mergeSort(String[] In_Array, int low, int high){
		String[] left, right;
		String[] result = new String[high-low];
		
		if(high-low<=2){
			//Special Cases
			if(high-low==1){
				result[0] = In_Array[low];
			}else{
				if(LessThen(In_Array[low], In_Array[low+1])){
					result[0] = In_Array[low+1];
					result[1] = In_Array[low];
				}else{
					result[0] = In_Array[low];
					result[1] = In_Array[low+1];
				}
			}
		}else{
			int mid;
			if((low+high)%2==0){
				mid = (low+high)/2;
			}else{
				mid = (low+high+1)/2;
			}
			left = mergeSort(In_Array, low, mid);
			right = mergeSort(In_Array, mid, high);
			result = merge(left, right);
		}
		return result;
	}
	
	public String[] merge(String[]left, String[]right){
		int len = left.length+right.length;
		String[]result = new String[len];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<left.length && j<right.length){
			if(LessThenOrEqual(left[i], right[j])){
				result[k] = left[i];
				i++;
			}else{
				result[k] = right[j];
				j++;
			}
			k++;
		}
		if(i >= left.length){
			while(j <right.length){
				result[k] = right[j];
				j++;
				k++;
			}
		}
		if(j >= right.length){
			while(i < left.length){
				result[k] = left[i];
				i++;
				k++;
			}
		}
		return result;
	}
	
	public boolean LessThen(String a, String b){
		return true;
	}
	
	public boolean LessThenOrEqual(String a, String b){
		return true;
	}

}
