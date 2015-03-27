package biblehash2;
/**
 * Creating an array of hashmap utilizing the chaining strategy. 
 * @author Alexis Chuah
 *<p>
 *Use an array of nodes to store pointers to the nodes. Enables easier sorting by frequency.
 *</p>
 */
public class LinkedHash {
	private Node[]table;
	private int size;
	private int arraySize;
	private int bucketUsed;
	private int maxList;
	private int posMax;
	protected static Node[]frequency = new Node[15000];
	private int collisions;
	
	/**
	 * Constructor
	 * @param tablesize
	 */
	public LinkedHash(int tablesize){
		table = new Node[tablesize];
		size = 0;
		arraySize = tablesize;
		bucketUsed = 0;
		maxList = 0;
		collisions = 0;
	}
	
	/**
	 * Check if Linked hash is empty.
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Get number of words. 
	 * @return
	 */
	public int getSize(){
		return this.size;
	}
	
	/**
	 * Insert a word. Search function would already determine if the word was in the list.
	 * @param val
	 * <p>
	 * Inserts at end of link list so it's easier to count the length of the longest list.
	 * </p>
	 */
	public void insert(Word val){
		
		Node a = new Node(val);
		frequency[size] = a;
		
		size++;
		int counter = 1;
		int pos = hash(val.getWord());
		Node head = table[pos];
		if(table[pos] == null){
			this.bucketUsed++;
			table[pos] = a;
		}
		else{
			collisions++;
			while(head.next!=null){
				head = head.next;
				counter ++;
			}
			head.next = a;
			if(counter>this.maxList){
				maxList = counter;
				posMax = pos;
			}
		}
	}
	
	/**
	 * Search for the words with override equals
	 * @param val
	 * @return
	 */
	public Node search(Word val){
		
		int pos = hash(val.getWord());
		
		Node start = table[pos];
		
		while(start!=null && !(start.data.equals(val))){
			start = start.next;
		}
		
		return start;
		
	}

	/**
	 * Using default hashing.
	 * @param val
	 * @return
	 */
	public int hash(String str) {
		
		int val = 1;
		
		for(int i=0; i<str.length(); i++)
			val = Math.abs(val*33 ^ (int)str.charAt(i));
		
		return (int)(val%arraySize);
		
		//return Math.abs(str.hashCode()%arraySize);
		
	}
	
	/**
	 * Display all the words in the list. 
	 */
	public void display(){
		System.out.println();
		
		for(int i=0; i<table.length; i++){
			System.out.print(i + ": ");
			Node start = table[i];
			while(start!=null){
				System.out.print(start.data.getWord() + " | " + start.getCount() + "; ");
				start = start.next;
			}
			System.out.println();
		}
	}
	
	/**
	 * Calculate load factor.
	 * @return
	 */
	public double getLoad(){
		return Math.round((double)size/arraySize *1000) / 1000.0;
	}
	
	/**
	 * Calculates average list length.
	 * @return
	 */
	public double getAverageLength(){
		return Math.round((double)size/bucketUsed*1000) / 1000.0;
	}
	
	/**
	 * Gets longest list length.
	 * @return
	 */
	public int getMaxList(){
		return this.maxList;
	}
	
	/**
	 * Displays longest list length.
	 */
	public void displayMax(){
		Node start = table[posMax];
		System.out.println();
		System.out.println("Longest list at bucket " + posMax + ": ");
		System.out.printf("%25s %-6s\n","Word","Count");
		System.out.println("------------------------------------------------");
		while(start!=null){
			System.out.printf("%25s %-6d\n", start.getWord(), start.getCount());
			start = start.next;
		}
		System.out.println();
	}
	
	/**
	 * Sorts the word by frequency.
	 */
	public void sortCount(){
		quickSort(0,size-1);
	}
	
	/**
	 * Displays the top 20 words by frequency. 
	 */
	public void displayTop(){
		System.out.println();
		if(size==0){
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
	         
	            Node temp = frequency[l];
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
	
	/**
	 * Get number of collisions when trying to insert an item.
	 * @return
	 */
	public int getCollisions(){
		return this.collisions;
	}
}
