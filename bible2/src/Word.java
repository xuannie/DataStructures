/**
 * Constructor for word class
 * 
 * @author achuah
 * @version 2/5/2015
 * 
 * 
 */
public class Word {
	
	protected String word;
	protected int count;

	public Word(){
		word = null;
		count = 0;
	}
	
	/**
	 * Automatically creates a word with a counter of 1.
	 * 
	 * @param text word to add
	 */
	public Word(String text){
		word = text;
		count = 1;
	}
	
	/**
	 * Get the word in object.
	 * 
	 * @return word 
	 */
	public String getWord(){
		return this.word;
	}

	/**
	 * Get the count of object.
	 * 
	 * @return count of object
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Increase count of current word
	 */
	public void increaseCount() {
		this.count++;
		
	}

}
