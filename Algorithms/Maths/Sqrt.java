package Maths;

public class Sqrt {

	int linear_sqrt(double x){
		int r = 0;
		while((r+1)*(r+1)<x){
			r++;
		}
		return r;
	}
	
	double newton_sqrt(double n){
		double r = 1.0;
		double tiny = 0.0001;
		
		while(Math.abs((n-r*r))>tiny){
			r = (r*r+n)/2*r;
		}
		
		return r;
	}
	
	double binary_sqrt(double low, double high, double tol, double n){
		double mid;
		while(low+tol<high){
			mid = (low+high)/2.0;
			if((mid*mid) - n <= 0){
				low = mid;
			}else{
				high = mid;
			}
		}
		return low;
	}
}
