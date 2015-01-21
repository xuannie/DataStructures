/**
 * Word Linked List class
 * 
 * @author achuah
 * @version 1/20/2015
 *
 */

class WordsLinkedList {
	WordObject head;
	int n;
	protected static WordObject[]sortArray;
	
	/**
	 * Default constructor creates a head with the value null and 0 number of words 
	 */
	public WordsLinkedList(){
		head = null;
		n=0;
	}
	
	/**
	 * Prints out all words and count in an orderly fashion
	 */
	public void show(){
		WordObject a;
		
		for(a = head; a!=null; a=a.next){
			System.out.printf("Word: %-25s, Count: %-10000d\n", a.getWord(), a.getCount());
		}
	}
	
	/**
	 * Inserting words into linked list.
	 * 
	 * @param text String to insert
	 * 
	 * <p>
	 * If list is empty, automatically insert word. Next, search if word exists in list. If it does, increment count. Else, add word.
	 * </p>
	 */
	public void insertWord(String text){
				
		if (this.head == null){
			WordObject a = new WordObject(text);
			a.next = head;
			head = a;
			n++;
		}
		else{
			WordObject find;
			find = this.searchList(text);
		
			if (find!=null){
				find.increaseCount();
			}else{
				WordObject a = new WordObject(text);
				a.next = head;
				head = a;
				n++;
			}
		}
	}
	
	/**
	 * Search for word in List.
	 * 
	 * @param search String to search for.
	 * @return pointer Pointer of word searched.
	 * 
	 * If word is not found, pointer is null. 
	 */
	public WordObject searchList(String search){
		WordObject pointer; 
		pointer = head;
		
		while(pointer!=null && !((pointer.getWord()).equals(search))){
			pointer = pointer.next;
		}
		
		return pointer;
	}

	/**
	 * Place words from arraylist into an array and call sort method. 
	 * 
	 * <p>
	 * Prints out top 20 words after sorting by frequency.
	 * </p>
	 */
	public void sortWords() {
		
		WordObject pointer;
		pointer = head;
		
		sortArray = new WordObject[n];
		int i = 0;
		
		//put pointers to array
		while(pointer!=null){
			sortArray[i] = pointer;
			i++;
			pointer = pointer.next;
		}
		
		//sort words
		quickSort(0, n-1);
		
		for (int j=0; j<20; j++){
			System.out.printf("Word: %-25s | Frequency: %-6d\n", sortArray[j].getWord(), sortArray[j].getCount());
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
	      
	      int midvalue = (sortArray[(l+r)/2]).getCount();
	      
	      while (l<=r){
	      
	         while (sortArray[l].getCount()>midvalue)
	            l++;
	         while (sortArray[r].getCount()<midvalue)
	            r--;
	         
	         if(l<=r){
	         
	            WordObject temp = sortArray[l];
	            sortArray[l] = sortArray[r];
	            sortArray[r] = temp;
	            
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
