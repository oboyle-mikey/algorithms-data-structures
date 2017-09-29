package Maths;

public class ExpPower {
	
	public double linear_exp(double a, int b){
		double r = 1.0;
		for(int k = 1; k<=b; k++){
			r = r*a;
		}
		return r;
	}
	
	public double f_exp(double a, int b){
		double x = a;
		int k = b;
		double result;
		
		if(k==0){
			result = 1.0;
		}else if(k%2==0){
			result = f_exp(x*x, k/2);
		}else{
			result = x*f_exp(x, k-1);
		}
		return result;
	}

}
