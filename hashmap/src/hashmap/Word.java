package hashmap;

/**
 * Constructor for word class
 * 
 * @author Alexis Chuah
 * @version 3/25/2015
 * 
 * <p>
 * Implements comparable to use java built-in sorting methods and arraylist.
 * </p>
 */
public class Word implements Comparable<Object>{
	
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
	 * Creates a word with the count.
	 * @param text
	 * @param num
	 */
	public Word(String text, int num){
		word = text;
		count = num;
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

	/**
	 * Overrides compareTo method so words can be sorted by frequency in order of most frequent to least frequent.
	 */
	@Override
	public int compareTo(Object o) {
		Word compare = (Word) o;
		if (this.count == compare.count)
			return 0;
		if(this.count > compare.count)
			return -1;
		return 1;
	}
	
	
}
