package Maths;

public class Fibonacci {

	public int fib(int k){
		if(k==0){
			return 0;
		}else if(k==1){
			return 1;
		}else{
			return (fib(k-2)+fib(k-1));
		}
	}
	
	public int fib_iter(int k){
		int c = 0;
		int n = 1;
		for(int j = 1; j<k; j++){
			n = n+c;
			c = n-c;
		}
		return n;
	}
	
	public int fib_golden(int k){
		double phi, s5;
		long result;
		ExpPower ep;
		Sqrt sr;
		
		ep = new ExpPower();
		sr = new Sqrt();
		
		s5 = sr.newton_sqrt(5.0);
		phi = (1+s5)/2;
		result = (long)ep.f_exp(phi, k);
		
		return Math.round(result);
	}
	
	public int fib_fast(int k){
		if(k==0){
			return 0;
		}else if(k==1||k==2){
			return 1;
		}else{
			int k2 = k/2;
			if(k%2==0){
				return(fib_fast(k2)*(2*fib_fast(k2+1)-fib_fast(k2)));
			}else{
				return( fib_fast(k2)*fib_fast(k2) + fib_fast(k2+1)*fib_fast(k2+1));
			}
		}
	}
	
	public int fib_mat(int k){
		int result;
		Matrix fMat;
		int[][]init = {{0,1},{1,1}};
		fMat = new Matrix(init);
		if(k == 0){
			result = 0;
		}else if(k==1 || k==2){
			result = 1;
		}else{
			result = (int) fMat.exp(k-1).item[1][1];
		}
		return result;
	}
}
