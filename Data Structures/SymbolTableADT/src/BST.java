

public class BST <Key extends Comparable<Key>, Value >{

	//Node
	private Node root;

	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int count;

		public Node(Key key, Value val){
			this.key = key;
			this.val = val;
		}	
	}


	//Size
	public int size(){
		return size(root);
	}

	private int size(Node x){
		if(x==null){
			return 0;
		}
		return x.count;
	}


	//Get & Put
	
	
	public void put(Key key, Value val){
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val){
		if(x==null){
			return new Node(key, val);
		}
		int cmp = key.compareTo(x.key);
		if(cmp<0){
			x.left = put(x.left, key, val);
		}else if(cmp>0){
			x.right = put(x.right, key, val);
		}else{
			x.val = val;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public Value get(Key key){
		Node x = root;
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if (cmp<0){
				x = x.left;
			}else if (cmp>0){
				x = x.right;
			}
			else{
				return x.val;
			}
		}
		return null;
	}


	//Floor & Ceiling
	
	
	public Key floor(Key key){
		Node x  = floor(root, key);
		if(x==null){
			return null;
		}
		return x.key;
	}

	private Node floor(Node x, Key key){
		if(x==null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp==0){
			return x;
		}else if(cmp < 0){
			return floor(x.left, key);
		}
		Node t = floor(x.right, key);
		if(t!=null){
			return t;
		}else{
			return x;
		}
	}

	public Key ceiling(Key key){
		Node x = ceiling(root, key);
		if (x == null){
			return null;
		}else{
			return x.key;
		}
	}

	private Node ceiling(Node x, Key key){
		if (x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0){
			return x;
		}
		if (cmp < 0) { 
			Node t = ceiling(x.left, key); 
			if (t != null) return t;
			else return x; 
		} 
		return ceiling(x.right, key); 
	}


	//Rank & Select
	public int rank(Key key){
		return rank(key, root);
	}

	private int rank(Key key, Node x){
		if(x==null){
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return rank(key, x.left);
		}else if(cmp > 0){
			return 1 + size(x.left) + rank(key, x.right);
		}else{
			return size(x.left);
		}
	}

	public Key select(int n){
		if(n < 0 || n > size()){
			return null;
		}
		Node x = select(root, n);
		return x.key;
	}

	private Node select(Node x, int n){
		if(x==null){
			return null;
		}
		int t = size(x.left);
		if(t > n){
			return select(x.left, n);
		}else if(t < n){
			return select(x.right, n-t-1);
		}else{
			return x;
		}
	}
	
	
	//Min & Max Empty
	
	public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    
    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 


	//Deletion

	public void deleteMin(){
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if(x.left==null){
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
    	root = delete(root, key);
    }
    
    private Node delete(Node x, Key key){
    	if(x==null){
    		return null;
    	}
    	int cmp = key.compareTo(x.key);
    	if(cmp < 0){
    		x.left = delete(x.left, key);
    	}else if(cmp > 0){
    		x.right = delete(x.right, key);
    	}else{
    		if(x.right == null){
    			return x.left;
    		}
    		if(x.left == null){
    			return x.right;
    		}
    		
    		Node t = x;
    		x = min(t.right);
    		x.right = deleteMin(t.right);
    		x.left = t.left;
    	}
    	x.count = 1 + size(x.left) + size(x.right);
    	return x;
    }


}
