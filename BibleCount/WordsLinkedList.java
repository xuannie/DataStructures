/**
 * Word Linked List class
 * 
 * @author achuah
 * @version 1/16/2015
 *
 */
class WordsLinkedList {
	Word head;
	int n;
	
	/**
	 * Default constructor creates a head with the value null and 0 number of words 
	 */
	public WordsLinkedList(){
		head = null;
		n=0;
	}
	
	/**
	 * Prints out word and count in an orderly fashion
	 */
	public void show(){
		Word a;
		
		for(a = head; a!=null; a=a.next){
			System.out.printf("Word: %-10s, Count: %-4d %n", a.word, a.count);
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
				System.out.print(find.word);
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

	public void sortWords() {
		// TODO Auto-generated method stub
		
	}
}
