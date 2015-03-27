/**
 * Testing MyStack for Person class, String and Integers. 
 * @author Alexis Chuah
 * @version 2/24/2015
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		System.out.println("Person stack:");
		System.out.println("-------------------------------------------------");
		MyStack<Person> testPerson = new MyStack<Person>();
		
		//Adding two 'Person' to the stack. 
		Person b = new Person("Richard", 23);
		testPerson.push(b);
		testPerson.push(new Person("Amanda",15));
		
		//Prints size of stack. 
		System.out.println("Size of stack: " + testPerson.size());
		
		//Checking who is on top.
		System.out.println("Top: " + testPerson.top());
		
		//Removing both people in the stack.
		System.out.println("Popped: " + testPerson.pop());
		System.out.println("Popped:" + testPerson.pop());
		
		//Check if stack is empty.
		System.out.println("Stack is empty? " + testPerson.empty());
		
		//Testing pop when stack is empty. 
		System.out.println("Popped when empty: " + testPerson.pop());
		
		System.out.println("-------------------------------------------------");
		System.out.println("Integer stack:");
		System.out.println("-------------------------------------------------");
		
		//Adding numbers to testNum.
		MyStack<Integer> testNum = new MyStack<Integer>();
		testNum.push(1);
		testNum.push(2);
		testNum.push(42);
		testNum.push(36);
		
		//Prints size of stack and element on top of stack. 
		System.out.println("Size of stack: " + testNum.size());
		System.out.println("Top of stack: " + testNum.top());
		
		System.out.println("Popped: " + testNum.pop());
		System.out.println("Popped:" + testNum.pop());
		
		System.out.println("Stack is empty? " + testNum.empty());
		System.out.println("Popped: " + testNum.pop());
		
		System.out.println("-------------------------------------------------");
		System.out.println("String stack:");
		System.out.println("-------------------------------------------------");
		
		//Adding to String stack. 
		MyStack<String> testString = new MyStack<String>();
		testString.push("What");
		testString.push("Is");
		testString.push("The");	
		testString.push("Life");
		
		//Check element on top.
		System.out.println("Top: " + testString.top());
		
		System.out.println("Popped: " + testString.pop());
		
		//Testing adding to String stack after popping. 
		testString.push("Answer");
		testString.push("To");		
		
		System.out.println("Size of stack: " + testString.size());		
		System.out.println("Popped:" + testString.pop());
		
		System.out.println("Stack is empty? " + testString.empty());
		System.out.println("Popped: " + testString.pop());
	}

}
