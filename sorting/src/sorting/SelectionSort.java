/**
 * Reading a file containing first and last name of a person and sorting by income (highest to lowest) using selection sort.
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

public class SelectionSort {

	static int numOfElements;
	static ArrayList<Person> personIncome = new ArrayList<Person>();
	static Person sorted[];
	
	static boolean sort;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start, stop;
		double processing, sorting;

		sort = false;
		
		System.out.println("Selection Sort");
		System.out.println("----------------------------------");
		
		try{
			start = System.currentTimeMillis();
			
			loadFile(args[0]);		
				
			stop = System.currentTimeMillis();
			processing = stop-start;

			System.out.println("Processing Time: " + ((processing)/1000.0));

			start = System.currentTimeMillis();
			
			System.out.println("Number of elements sorted: " + numOfElements); 
			selectionSort();
			
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
	 * Selection sort method
	 */
	private static void selectionSort(){
		
		int i, j, max;
		
		sorted = new Person[numOfElements];
		
		i=0;
		
		for(int x=0; x<numOfElements; x++){
			sorted[x] = personIncome.get(x);
			i++;
		}
		
		max = 0;
		
		for(i=0; i<sorted.length; i++){
			max = i;
			
			for(j=i+1; j< sorted.length; j++){
				if(sorted[j].income > sorted[max].income)
					max= j;
			}
			
			if(max!= i){
				Person temp = sorted[i];
				sorted[i] = sorted[max];
				sorted[max] = temp;
			}
		}
		sort = true;
		
	}
	
	/**
	 * Display method.
	 */
	public static void display(){
		if (!sort)
			System.out.println("Sort array first. Call selection sort.");
		else{
			System.out.printf("%-15s %-15s %-6s\n","First Name","Last Name", "Income");
			System.out.println("------------------------------------------------");
			
			for(Person s : sorted){
				System.out.printf("%-15s %-15s %-6d\n", s.firstName, s.lastName, s.income);
			}
			System.out.println("------------------------------------------------");
		}
	}

}
