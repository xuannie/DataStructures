/**
 * Constructor for word and pointer
 * 
 * @author achuah
 * @version 1/20/2015
 *
 * 
 */

public class WordObject {
	protected Word b;
	protected WordObject next;
	
	public WordObject(){
		b = null;
		next = null;
	}
	
	public WordObject(String text){
		b = new Word(text);
	}
	
	public String getWord(){
		return b.word;
	}
	
	public int getCount(){
		return b.count;
	}
	
	public void increaseCount(){
		b.count++;
	}
}
