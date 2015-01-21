/**
 * Constructor for word class
 * 
 * @author achuah
 * @version 1/20/2015
 * 
 */
public class Word {
	
	protected String word;
	protected int count;
	protected Word next;
	
	public Word(){
		word = null;
		count = 0;
		next = null;
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
}
