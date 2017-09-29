package Sorting;

import java.util.LinkedList;

public class MergeSortLL {
	
	LinkedList<String> mergeSort(LinkedList<String> In_List){
		LinkedList<String> xs, ys, left, right, result;
		
		ys = In_List;
		
		if(In_List.size() < 2){
			result = ys;
		}else{
			//Split Lists
			xs = new LinkedList<String>();
			int k = 1;
			while(k <= In_List.size()/2){
				xs.addFirst(ys.removeFirst());
				k++;
			}
			left = mergeSort(xs);
			right = mergeSort(ys);
			result = merge(left, right);
		}
		return result;
	}
	
	LinkedList<String> merge(LinkedList<String> left, LinkedList<String> right){
		String x, y;
		LinkedList<String> xs = left;
		LinkedList<String> ys = right;
		LinkedList<String> result;
		
		if(xs.isEmpty()){
			return ys;
		}else if(ys.isEmpty()){
			return xs;
		}else{
			if(LessOrEqual(xs.getFirst(), ys.getFirst())){
				x = xs.removeFirst();
				result = merge(xs, ys);
				result.addFirst(x);
			}else{
				y = ys.removeFirst();
				result = merge(xs, ys);
				result.addFirst(y);
			}
		}
		return null;
	}
	
	public boolean LessOrEqual(String a, String b){
		return true;
	}

}
