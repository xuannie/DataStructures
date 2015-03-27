package biblehash2;

/**
 * Counts the frequency of all the words in the bible using a hashmap. Version 2.
 * 
 * @author Alexis Chuah
 * @version 3/17/2015
 * 
 * <p>
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * Uses a linked list for a hash map. 
 * </p>
 * 
 */


import java.io.*;

public class BibleMain {
	
	String str;
	protected static LinkedHash linkHash = new LinkedHash(12769);

	public static void main(String[] args) throws IOException, FileNotFoundException{		
					
		long start, stop;
		double processing, sorting;
			
		start = System.currentTimeMillis();
			
		loadFile(args[0]);		
			
		stop = System.currentTimeMillis();
		processing = stop-start;
		System.out.println("Processing Time: " + ((processing)/1000.0));
			
		
		start = System.currentTimeMillis();;
		linkHash.sortCount();
		stop = System.currentTimeMillis();
		sorting = stop - start;
		
		System.out.println("Sorting Time: " + ((sorting)/1000.0));

		
		System.out.println("Total Time: " + ((processing + sorting)/1000.0));
		
		System.out.println();
		System.out.println("Load Factor: " + linkHash.getLoad());
		System.out.println("Longest List Length: " + linkHash.getMaxList());
		System.out.println("Average List Length: " + linkHash.getAverageLength());
		//System.out.println("Collisions: " + linkHash.getCollisions());
		
		//Displays top 20 words used in the bible.
		//linkHash.displayTop();
		
		//To view elements in hash table
		linkHash.display();
		
		//To view longest linklist.
		//linkHash.displayMax();
	}

	/**
	 * Loads file and puts words into a binary search tree in alphabetical order.
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
			Word search = new Word(str);
			Node pos = linkHash.search(search);
			if(pos == null)
				linkHash.insert(search);
			else{
				pos.data.count++;
			}
				
		}
		
		reader.close();		
	}
}
