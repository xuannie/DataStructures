package biblehash2;
/**
 * 
 * @author Alexis Chuah
 * @version 3/17/15
 */

public class Node {
	Word data;
	Node next;
	
	/**
	 * Node for storing a word.
	 * 
	 * <p> 
	 * Consists of data which is a word, and a next pointer.
	 * </p>
	 */
	public Node(){
		this.data = null;
		this.next = null;
	}
	
	/**
	 * Creating a node with a String parameter.  
	 * @param insert
	 */
	public Node(String insert){
		this.data = new Word(insert);
		this.next = null;
	}
	
	/**
	 * Creating a node with a Word parameter.
	 * @param insert
	 */
	public Node(Word insert){
		this.data = insert;
		this.next = null;
	}

	/**
	 * Gets the word in the node.
	 * @return the String of the word in the node.
	 */
	public String getWord() {
		return this.data.word;
	}

	/**
	 * Gets the count of the word in the node.
	 * @return the total count of the word in the node.
	 */
	public int getCount() {
		return this.data.count;
	}
}
