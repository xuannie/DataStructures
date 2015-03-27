/**
 * Binary search tree constructor. 
 * 
 * @author Alexis Chuah
 * @version 2/17/2015
 * 
 * <p>
 * Implements insert, display, search, and remove methods.
 * </p>
 */
public class BST{
	
	private BSTNode root;
	protected int count;
	protected static BSTNode[] frequency= new BSTNode[15000]; //Store array of words to allow sort by frequency
	
	/**
	 * Initializes Binary search tree to null root with no elements. 
	 */
	public BST(){
		root = null;
		count=0;
	}
	
	/**
	 * Creates a binary search tree using the insert method if a word is passed. 
	 * @param text
	 */
	public BST(String text){
		this.insert(text);
	}
	
	/**
	 * Searches for a word in a node in the Binary search tree. 
	 * @param find 	Word to look for.
	 * @return 		Pointer to node.
	 */
	public BSTNode search(String find){
		BSTNode p = root;
		
		while(p!=null && !find.equals(p.data.word)){
			if(find.compareTo(p.data.word)>0)
				p = p.right;
			else
				p = p.left;
		}
		return p;
	}
	
	/**
	 * Inserts a word into the binary search tree.
	 *  
	 * @param data	Word to insert
	 */
	public void insert(String data){
		BSTNode p,q,n;
		n = new BSTNode(data);
		frequency[count] = n;
		count++;

		
		p = root;
		q = null;
		
		while(p!=null){
			q = p;
			if (data.compareTo(p.data.word)>0)
				p = p.right;
			else
				p = p.left;
		}
		if (root == null)
			root = n;
		else if(data.compareTo(q.data.word)>0)
			q.right = n;
		else
			q.left = n;
	}
	
	/**
	 * Orders elements in the binary search tree in alphabetical order. 
	 * @param p
	 */
	private void inorder(BSTNode p){
		if (p!= null){
			inorder(p.left);
			System.out.print(p.data.word);
			System.out.println();
			inorder(p.right);
		}
	}
	
	/**
	 * Delete node
	 */
	public boolean remove(String data){
		BSTNode x, y, z;
		
		x = root;
		y= root;
		//x.data!=data
		while(x!=null && !x.data.word.equalsIgnoreCase(data)){
			y = x;
			//if (data>x.data)
			if (data.compareToIgnoreCase(x.data.word)>0)
				x = x.right;
			else
				x = x.left;
		}
		
		if(x==null)
			return false;
		
		if(x.left!=null && x.right!=null){
			//case 3
			z=x;
			y=x;
			x=x.right;
			while(x.left!=null){
				y=x;
				x=x.left;
			}
			z.data = x.data;
		}
		
		if (x.left==null)
			z=x.right;
		else
			z=x.left;
		
		if (x==root)
			root=z;
		else if (x==y.left)
			y.left=z;
		else
			y.right=z;
		
		return true;
	}
	
	/**
	 * Displays elements in the binary search tree in order using the inorder method.
	 */
	public void display(){
		System.out.println();
		inorder(root);
	}
	
	/**
	 * Sorts the word by frequency.
	 */
	public void sortCount(){
		quickSort(0,count-1);
		displayTop();
	}
	
	/**
	 * Displays the top 20 words by frequency. 
	 */
	private void displayTop(){
		if(count==0){
			System.out.println("There are no words to display");
		}else{
			System.out.printf("%25s %-6s\n","Word","Count");
			System.out.println("------------------------------------------------");
			for(int i=0; i<20; i++)
				System.out.printf("%25s %-6d\n", frequency[i].getWord(),frequency[i].getCount());	
		}
	}
	
	/**
	 * Using recursive quicksort to sort array of words by frequency in descending order.
	 * 
	 * @param left
	 * @param right
	 * 
	 */
	private static void quickSort(int left, int right){
		
		int l=left;
		int r=right;
	      
		int midvalue = (frequency[(l+r)/2]).getCount();
	      
		while (l<=r){
	      
			while (frequency[l].getCount()>midvalue)
	            l++;
			while (frequency[r].getCount()<midvalue)
	            r--;
	         
	         if(l<=r){
	         
	            BSTNode temp = frequency[l];
	            frequency[l] = frequency[r];
	            frequency[r] = temp;
	            
	            l++;
	            r--;
	         }
	      }
	      
	      int index = l;
	      
	      if (left<index -1) {
	         quickSort(left, index-1);
	      }
	      if (index<right){
	         quickSort(index, right);
	      }
	}
}
