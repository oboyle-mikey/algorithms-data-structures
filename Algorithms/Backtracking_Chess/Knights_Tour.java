package Backtracking_Chess;

public class Knights_Tour {

	int[][]board;
	int size;
	boolean success;
	
	int[]row_offset;
	int[]col_offset;
	
	int xStart, yStart;
	int xEnd, yEnd;
	
	public Knights_Tour(
			int r, int c,
			int x0, int y0,
			int xn, int yn
						)
	{
		this.board = new int[r][c];
		this.size = r*c;
		this.xStart = x0;
		this.xEnd = xn;
		this.yStart = y0;
		this.yEnd = yn;
		board[xStart][yStart] = 1;
		this.success = false;
		isTour(2, xStart, yStart);
	}
	
	public void initOffsets(){
		int k = 0;
		row_offset = new int[8];
		col_offset = new int[8];
		for(int i = -2; i<3; i++){
			for(int j = -2; j<3; j++){
				if(i*i + j*j == 5){
					row_offset[k] = i;
					col_offset[k] = j;
					k++;
				}
			}
		}
	}

	public boolean acceptable(int s, int t){
		return( 0<=s && s<board.length &&
				0<=t && t<board[1].length &&
				board[s][t]==0);
	}

	public void isTour(int k, int x, int y){
		int d = 0;
		int new_x, new_y;
		
		if(k>size){
			success = true;
		}else{
			while(d!=8 && !success){
				new_x = x+row_offset[d];
				new_y = y+col_offset[d];
				if(acceptable(new_x, new_y)){
					board[new_x][new_y] = k;
					isTour(k+1, new_x, new_y);
					if(!success){
						board[new_x][new_y] = 0;
					}
				}
				d++;
			}
		}
	}
	
	
}
