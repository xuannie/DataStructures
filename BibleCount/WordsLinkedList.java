/**
 * Word Linked List class
 * 
 * @author achuah
 * @version 1/20/2015
 *
 */

class WordsLinkedList {
	Word head;
	int n;
	protected static Word[]sortArray;
	
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
		Word a;
		
		for(a = head; a!=null; a=a.next){
			System.out.printf("Word: %-25s, Count: %-10000d\n", a.word, a.count);
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
			Word a = new Word(text);
			a.next = head;
			head = a;
			n++;
		}
		else{
			Word find;
			find = this.searchList(text);
		
			if (find!=null){
				find.count++;
			}else{
				Word a = new Word(text);
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
	public Word searchList(String search){
		Word pointer; 
		pointer = head;
		
		while(pointer!=null && !((pointer.word).equals(search))){
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
		
		Word pointer;
		pointer = head;
		
		sortArray = new Word[n];
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
			System.out.printf("Word: %-25s | Frequency: %-6d\n", sortArray[j].word, sortArray[j].count);
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
	      
	      int midvalue = (sortArray[(l+r)/2]).count;
	      
	      while (l<=r){
	      
	         while (sortArray[l].count>midvalue)
	            l++;
	         while (sortArray[r].count<midvalue)
	            r--;
	         
	         if(l<=r){
	         
	            Word temp = sortArray[l];
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
