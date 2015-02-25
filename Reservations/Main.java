/**
 * @author Alexis Chuah
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyList first = new MyList();
		Seat b = new Seat("Rebecca Lane", 2, 315.20);
		first.add(b);
		first.add(new Seat("John Smith", 1, 300.50));
		first.add(new Seat("Amber Rodney", 0, 280.99));
		
		MyList second = new MyList();
		second.head = first.copyPlane();
		
		System.out.println("First plane: ");
		first.display();
		
		System.out.println("Second plane: ");
		second.display();
	}
}
