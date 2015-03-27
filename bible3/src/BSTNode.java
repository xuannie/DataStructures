/**
 * Binary search tree node
 * 
 * @author Alexis Chuah
 * @version 2/17/2015
 */
public class BSTNode {
	Word data;
	BSTNode left, right;
	
	/**
	 * Binary search tree node.
	 * 
	 * <p> 
	 * Consists of data which is a word, and a left and right pointer.
	 * </p>
	 */
	public BSTNode(){
		this.data = null;
		left = right = null;
	}
	
	/**
	 * A node is created 
	 * @param insert
	 */
	public BSTNode(String insert){
		this.data = new Word(insert);
		left = right = null;
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
