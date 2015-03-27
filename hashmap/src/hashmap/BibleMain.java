/**
 * Counts the frequency of all the words in the bible. 
 * 
 * @author Alexis Chuah
 * @version 3/25/2015
 * 
 * <p>
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * Uses a linked list for a hash map. 
 * </p>
 * 
 */
package hashmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


public class BibleMain {
	
	static String str;
	static Integer count;
	static HashMap<String, Integer> words = new HashMap<String, Integer>();
	static ArrayList<Word> frequency = new ArrayList <Word>();

	public static void main(String[] args) throws IOException, FileNotFoundException{		
					
		long start, stop;
		double processing, sorting;
			
		start = System.currentTimeMillis();
			
		loadFile(args[0]);		
			
		stop = System.currentTimeMillis();
		processing = stop-start;
		System.out.println("Processing Time: " + ((processing)/1000.0));
			
		
		start = System.currentTimeMillis();;
		sortFrequency();

		stop = System.currentTimeMillis();
		sorting = stop - start;
		
		System.out.println("Sorting Time: " + ((sorting)/1000.0));

		
		System.out.println("Total Time: " + ((processing + sorting)/1000.0));
		
		System.out.println();
		
		//Displays top 20 words used in the bible.
		printTop();

		//To view all elements in hash table
		//display();
	}
	
	/**
	 * Prints top 20 repeated words in the bible.
	 */
	private static void printTop() {
		System.out.printf("%-8s %-6s\n","Word","Count");
		System.out.println("----------------------");
		for(int i=0; i<20; i++)
			System.out.printf("%-8s %-6d\n", frequency.get(i).word, frequency.get(i).count);
		System.out.println();
		
	}

	/**
	 * Use iterator to place words into an arraylist then use java Collections sort on Words.  
	 */
	private static void sortFrequency() {
		
		Iterator<HashMap.Entry<String,Integer>>  it;
		HashMap.Entry<String,Integer>            entry;
		
		it = words.entrySet().iterator();
		
		while (it.hasNext()) {
			entry = it.next();
			frequency.add(new Word(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(frequency);
	}

	/**
	 * Displays all words in the hashmap using iterator. 
	 */
	private static void display(){
		
		Iterator<HashMap.Entry<String,Integer>>  it;
		HashMap.Entry<String,Integer>            entry;

		System.out.printf("%-25s %-6s\n","Word","Count");
		System.out.println("----------------------------");
		it = words.entrySet().iterator();
		
		while (it.hasNext()) {
			entry = it.next();
			for(int i=0; i<20; i++)
				System.out.printf("%-25s %-6s\n", entry.getKey().toString(), entry.getValue().toString());
			System.out.println();
		}
	}

	/**
	 * Loads file and puts words into a hashmap using java's built-in hashmap.
	 * 
	 * @param fileName: passed from arguments
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void loadFile(String fileName) throws IOException, FileNotFoundException{
		
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		String str;
		
		while((str=reader.readLine())!=null){
			count = words.get(str);
			if(count == null){
				words.put(str, 1);
			}
			else
				words.put(str, count + 1);
		}
		
		reader.close();		
	}
}

