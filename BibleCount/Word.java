/**
 * Constructor for word class
 * 
 * @author achuah
 * @version 1/16/2015
 * 
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
	
	/**
	 * Compare to method to automatically sort array list by frequency of count
	 * @param o
	 * @return
	 */
	public int compareTo(Object o){
		Word w = (Word) o;
		
		if(this.count > w.count)
			return this.count;
		if(this.count < w.count)
			return w.count;
		
		return 0;
		
	}
}
