
public class LLQueueOfStrings {

	private LLNode first, last;

	private class LLNode{
		String item;
		LLNode next;
	}

	public LLQueueOfStrings(){

	}

	public boolean isEmpty(){
		return first == null;
	}

	public void enqueue(String item){
		LLNode oldLast = last;
		last = new LLNode();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
	}

	public String dequeue(){
		String item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		return item;
	}
}
