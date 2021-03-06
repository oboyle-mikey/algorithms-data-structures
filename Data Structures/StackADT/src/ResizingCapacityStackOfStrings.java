
public class ResizingCapacityStackOfStrings {

	private String[]s;
	private int N;
	
	public ResizingCapacityStackOfStrings(){
		s = new String[1];
	}
	
	private void resize(int capacity){
		String[]copy = new String[capacity];
		for(int i = 0; i< N; i++){
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public void push(String item){
		if(N == s.length){
			resize(2*s.length);
		}
		s[N] = item;
		N++;
	}
	
	public String pop(){
		String item = s[N];
		N--;
		s[N] = null;
		if(N>0 && N == s.length/4){
			resize(s.length/2);
		}
		return item;
	}
}
