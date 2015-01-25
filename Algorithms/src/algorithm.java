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
	protected static int n, x;
	
	public static void main(String[] args) {
		String cons, exp;
		
		System.out.print("Enter consonant: ");
		cons = kb.next();
		n = checkInt(cons);
		
		System.out.print("Enter exponent: ");
		exp = kb.next();
		System.out.println();
		x = checkInt(exp);
		
	}
	
	private static int checkInt(String num){
		int number=0;
		do{
			try{
				number = Integer.parseInt(num);
			}catch(Exception e){
				System.out.println("Not a valid number. Try again:");
			}
		}while(number==0);
		
		return number;
	}

}
