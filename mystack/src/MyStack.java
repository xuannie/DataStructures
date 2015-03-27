/**
 * Generic LIFO stack. Allows different types of elements to be placed in the stack using the last in first out principle.   
 * 
 * @author Alexis Chuah
 * @version 2/24/2015
 * 
 * <p>
 * Allows for the following functions:
 * 1. Check for an empty stack.
 * 2. Return size of stack. 
 * 3. Return element at the top of the stack.
 * 4. Add elements to the top of the stack.
 * 5. Remove elements from the top of the stack. 
 * 6. Display all elements left in the stack.
 */
public class MyStack<Type> {
	
	protected ListElem<Type> head;
	protected int number;
	
	/**
	 * Constructor for MyStack class. 
	 */
	public MyStack(){
		head = null;
		number = 0;
	}
	
	/**
	 * Checks if class is empty. 
	 * 
	 * @return Returns true if empty, false otherwise. 
	 */
	public boolean empty(){
		if(head == null)
			return true;
		return false;
	}
	
	/**
	 * Gets size of the stack. 
	 * 
	 * @return number of elements in the stack. 
	 */
	public int size(){
		return this.number;
	}
	
	/**
	 * Returns element that is removed, reduces size of stack and changes head to next element after it is popped. 
	 * 
	 * @return Returns element that is popped. Returns null if set is empty. 
	 */
	public Type pop(){
		if (number == 0){
			System.out.println("Empty stack. Nothing to pop");
			return null;
		}
		else{
			Type remove = head.data;
			head = head.next;
			number --;
			return remove;
		}
	}
	
	/**
	 * Gets element at the top of the set. 
	 * @return Element at the top of the set. 
	 */
	public Type top(){
		return head.data;
	}
	
	/**
	 * Adds an element to the stack of any type then increments size of stack.  
	 * 
	 * @param b
	 */
	public void push(Type b){
		head = new ListElem<Type>(b, head);
		number ++;
	}
	
	/**
	 * Displays all the elements left in the stack. 
	 */
	public void display(){
		if(head == null)
			System.out.println("Stack is empty.");
		else{
			ListElem<Type> p = head;
			for (p=head; p!=null; p=p.next)
				System.out.print(p.data + ", ");
		}					
	}
}
