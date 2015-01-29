/**
 * 
 * @author alexis
 * @version 1/21/2015
 * 
 * implement power (x,n)
 */

import java.util.Scanner;

public class algorithm {

	public static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
<<<<<<< HEAD
		int n, x, output;
		
		System.out.print("Enter product: ");
		x = kb.nextInt();
		
		do{
			System.out.print("Enter exponent: ");
			n = kb.nextInt();
			if (n<0)
				System.out.println("Invalid number.");
		}while(n<0);
		
		output = power(x,n);
		
		System.out.println("Output of " + x + "^" + n + " is " + output + ".");
	}

	private static int power(int x, int n) {
		// TODO Auto-generated method stub
		int y;
		if (n==0){
			return 1;
		}
		if (n%2==1){
			y = power(x, (n-1)/2);
			return x*y*y;
		}
		else{
			y = power(x,n/2);
			return y*y;
		}
=======
		String cons, exp;
		do{
			System.out.print("Enter consonant: ");
			cons = kb.next();
			n = checkInt(cons);
		}while (n==0);

		
		System.out.print("Enter exponent: ");
		exp = kb.next();
		System.out.println();
		x = checkInt(exp);
		
	}
	
	private static int checkInt(String num){
		int number=0;
			try{
				number = Integer.parseInt(num);
			}catch(Exception e){
				System.out.println("Not a valid number. Try again.");
			}		
		return number;
>>>>>>> ebc3bd862264a7b6aca057ed3fb65a442144c269
	}

}
