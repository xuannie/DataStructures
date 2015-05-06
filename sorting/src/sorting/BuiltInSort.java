/**
 * Reading a file containing first and last name of a person and sorting by income (highest to lowest) using a built-in collections sort.
 * 
 * @author Alexis Chuah
 * @version 4/23/15
 *
 */
package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BuiltInSort {

	static int numOfElements;
	static ArrayList<Person> personIncome = new ArrayList<Person>();
	
	static boolean sort;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start, stop;
		double processing, sorting;

		sort = false;
		
		System.out.println("Built-in Sort");
		System.out.println("----------------------------------");
		
		try{
			start = System.currentTimeMillis();
			
			loadFile(args[0]);		
				
			stop = System.currentTimeMillis();
			processing = stop-start;

			start = System.currentTimeMillis();
 
			collectionsSort();
			
			stop = System.currentTimeMillis();
			sorting = stop - start;
			
			display();
			
			System.out.println("Number of elements sorted: " + numOfElements);
			System.out.println("Processing Time: " + ((processing)/1000.0));
			System.out.println("Sorting Time: " + ((sorting)/1000.0));
			System.out.println("Total Time: " + ((processing + sorting)/1000.0));
			
		} catch (IOException e) {
			System.out.println("Invalid file format.");	
		} catch (NumberFormatException e){
			System.out.println("Invalid file format. Please try again.");
		} catch (Exception e){
			System.out.println("No file inserted.");
		}

		

	}
	
	/**
	 * Loads file and stores in memory
	 * 
	 * @param fileName: passed from arguments
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void loadFile(String fileName) throws IOException, FileNotFoundException{
		File file = new File(fileName);
		
		//Checks if file is a valid file.
		if(file.isFile())
		{
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String str;
		
			int i=0;

			while((str=reader.readLine())!=null){
				String[]nums = str.split("\\s+");	
				
				int income = Integer.parseInt(nums[2]);
				
				personIncome.add(new Person(nums[0], nums[1], income));

				i++;
			}
			numOfElements = i;
			reader.close();	
		}	
		else
			System.out.println(fileName + " does not exist.");
	}
	
	/**
	 * Built-in sort method
	 */
	private static void collectionsSort(){
		Collections.sort(personIncome);
		sort = true;	
	}
	
	/**
	 * Display method. Displays all elements in the array if it is sorted. 
	 */
	public static void display(){
		if (!sort)
			System.out.println("Sort array first. Call selection sort.");
		else{
			System.out.printf("%-15s %-15s %-6s\n","First Name","Last Name", "Income");
			System.out.println("------------------------------------------------");
			
			for(Person s : personIncome){
				System.out.printf("%-15s %-15s %-6d\n", s.firstName, s.lastName, s.income);
			}
			System.out.println("------------------------------------------------");
		}
	}

}
