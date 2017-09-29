

public class StackOfStringsLL {
	
	private LLNode first = null;
	
	private class LLNode{
		String item;
		LLNode next;
	}

	StackOfStringsLL(){
		
	}
	
	public boolean isEmpty(){
		return(first.next==null);
	}
	
	public void push(String item){
		LLNode oldFirst = first;
		first = new LLNode();
		first.item = item;
		first.next = oldFirst;
	}
	
	public String pop(){
		String item = first.item;
		first = first.next;
		return item;
	}
	
	
}
