/**
 * Generic linked list element class for storing data.
 * 
 * @author Alexis
 * @version 2/23/2015
 *
 */
public class ListElem<Type> {
	
	public Type data;
	public ListElem<Type> next;
	
	/**
	 * Constructor created to add element to the beginning of a linked list. 
	 * 
	 * @param data	Data to be added to the list. 
	 * @param next	Pointer to next node. 
	 */
	public ListElem(Type data, ListElem<Type> next){
		this.data = data;
		this.next = next;
	}
}
