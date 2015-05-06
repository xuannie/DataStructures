/**
 * Reading a file containing first and last name of a person and sorting by income (highest to lowest) using Radix sort.
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
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

	static int numOfElements;
	static ArrayList<Person> personIncome = new ArrayList<Person>();
	static int maxDigits;
	
	static boolean sort;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start, stop;
		double processing, sorting;

		sort = false;
		maxDigits = 0;
		
		System.out.println("Radix Sort");
		System.out.println("----------------------------------");
		
		try{
			start = System.currentTimeMillis();
			
			loadFile(args[0]);		
				
			stop = System.currentTimeMillis();
			processing = stop-start;
	
			start = System.currentTimeMillis();
	 
			radixSort();
				
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
			//e.printStackTrace();
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
				
				if(nums[2].length() > maxDigits)
					maxDigits = nums[2].length();
				
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
	 * Radix sort method
	 */
	private static void radixSort(){
		
		ArrayList<Person>[] bucket = new ArrayList [10];
		
		for(int i=0; i<10; i++){
			bucket[i] = new ArrayList<Person>();
		}
		
		int exp = 1; 
		
		for (int i=0; i<maxDigits; i++){
			
			for (int j=0; j<numOfElements; j++){
				bucket[(personIncome.get(j).income/exp)%10].add(personIncome.get(j));
			}
			
			personIncome.clear();
			
			for(int k=9; k>=0; k--){
				personIncome.addAll(bucket[k]);
				bucket[k].clear();
			}
			
			exp = exp*10;
		}
		
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
