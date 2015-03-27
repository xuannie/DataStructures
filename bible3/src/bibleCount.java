import java.io.*;

/*
 * Counts the frequency of words in the bible. 
 * 
 * @author Alexis Chuah
 * @version 2/17/2015
 * 
 * <p>
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * Use binary search tree.
 * </p>
 * 
 */

public class bibleCount {
	
	protected static BST binaryBible = new BST();

	public static void main(String[] args) throws IOException, FileNotFoundException{		
				
		long start, stop;
		double processing, sorting;
		
		start = System.currentTimeMillis();
		
		loadFile(args[0]);		
		
		stop = System.currentTimeMillis();
		processing = stop-start;
		System.out.println("Processing Time: " + ((processing)/1000.0));
		
		//Displays all words in the bible in alphabetical order
		//binaryBible.display();
		
		start = System.currentTimeMillis();
		binaryBible.sortCount();
		stop = System.currentTimeMillis();
		
		sorting = stop - start;
		System.out.println("Sorting Time: " + ((sorting)/1000.0));
		
		start = System.currentTimeMillis();	
		
		stop = System.currentTimeMillis();
		
		System.out.println("Total Time: " + ((processing + sorting)/1000.0));

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
			if (binaryBible.count==0)
				binaryBible.insert(str);
			else{
				
				BSTNode find = new BSTNode();
				find = binaryBible.search(str);

				if (find == null)
					binaryBible.insert(str);
				else
					find.data.count++;
			}
		}
		
		reader.close();
		
	}

}
