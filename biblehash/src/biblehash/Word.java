package biblehash;
/**
 * Constructor for word class
 * 
 * @author Alexis Chuah
 * @version 3/17/2015
 * 
 * 
 */
public class Word{
	
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
	 * Get the 
	 * @return
	 */
	public String getWord(){
		return this.word;
	}
	
	/**
	 * Overriding hashcode. 
	 */
	public int hashCode(){
		return word.hashCode();
	}
	
	/**
	 * Overriding .equals method.
	 */
	public boolean equals(Object obj){
		
		if(obj == this){
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		
		Word object = (Word) obj;
		return word == object.word || word !=null && word.equals(object.getWord());
	}
}
