package Maths;


class Matrix
{ 
	int rows;           // #rows
	int cols;           // #columns
	double[][] item;       // 2-d array     

	Matrix(int r, int c)
	{// create r x c matrix of 0's
		rows = r;
		cols = c;
		item = new double[r][c];
	} // Matrix_Math

	Matrix(int[][] arr_2d) 
	{ // create matrix based on 2d array,
		rows = arr_2d.length;
		cols = arr_2d[0].length;
		item = new double[rows][cols];
		for (int i = 0; i < rows; i=i+1)
			for (int j = 0; j < cols; j=j+1)
				item[i][j] = arr_2d[i][j];
	} // Matrix_Math

	public Matrix transpose() 
	{ 
		Matrix result = new Matrix(cols, rows);
		for (int i = 0; i < cols; i=i+1)
			for (int j = 0; j < rows; j=j+1)
				result.item[i][j] = item[j][i];
		return result;
	} // transpose

	Matrix identity(int n) 
	{ 
		Matrix Id = new Matrix(n,n);
		for (int i = 0; i < n; i=i+1)
			Id.item[i][i] = 1;
		return Id;
	} // identity

	public boolean eq(Matrix B) 
	{// Matrix equality
		assert( (B.rows == rows) && (B.cols == cols) );
		int i, j, r, c ;
		r = rows; 
		i = 0;
		while ( i < r )
		{
			j = 0;  c = cols;
			while ( j < c )
				if ( B.item[i][j] ==  item[i][j] )
					j = j+1;
				else
					c = j;
			if ( j == cols )
				i = i+1;
			else
				r = i;
		}
		return ( i == rows );
	} // eq

	Matrix copy_mat()
	{
		Matrix result = new Matrix(rows, cols);
		for (int i = 0; i < rows; i=i+1)
			for (int j = 0; j < cols; j=j+1)
				result.item[i][j] = item[i][j];
		return result;
		// result.eq(this)
	} // copy_mat

	public Matrix times(Matrix B) 
	{ 
		assert( cols == B.rows );
		Matrix C = new Matrix(rows, B.cols);
		for (int i = 0; i < C.rows; i=i+1)
			for (int j = 0; j < C.cols; j=j+1)
				for (int k = 0; k < cols; k=k+1)
					C.item[i][j] = C.item[i][j] + (item[i][k] * B.item[k][j]);
		return C;
	}

	Matrix exp(int n)
	{ // rows = cols  (square matrix) && n >= 0 

		Matrix result = new Matrix(rows,cols);
		Matrix mm= new Matrix(rows,cols);

		if ( n == 0 )
			result = identity(rows);
		else if ( n == 1 )
			result = copy_mat();
		else
		{
			mm = copy_mat();
			int k = n;
			result = identity(rows);
			while ( k != 0 )
				if ( k%2 == 0 )
				{
					mm = mm.times(mm);
					k = k/2;
				}
				else
				{
					result = result.times(mm);
					k = k-1;
				}
		}     
		return result;
		// result = this^n   
	} // f_exp_mat

	public double[] minRow(){
		double [] result;
		double [] row_k;
		result = new double [rows];
		for (int k=0; k < rows; k = k+1)
		{
			row_k = item[k];
			result[k] = row_k[min_index(row_k)]; 
		}
		return result;
	}

	public int min_index(double[]arr){
		int i = 0;
		int j = arr.length-1;
		while ( i != j )
			if (arr[i] > arr[j] )
				i = i+1;
			else
				j = j-1;

		return i;
	}



	/*
    boolean eq(Matrix_Math B) 
    {// Matrix equality
        assert( (B.rows == rows) && (B.cols == cols) );
        for (int i = 0; i < rows; i=i+1)
            for (int j = 0; j < cols; j=j+1)
                if ( B.item[i][j] != item[i][j] ) return false;
        return true;
    } //eq
	 */

} // Matrix_Math
