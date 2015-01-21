import java.io.*;

/*
 * Main of Bible count program.
 * 
 * @author Alexis Chuah
 * @version 1/20/2015
 * 
 * <p>
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * </p>
 * 
 */

public class bibleCount {
	
	protected static WordsLinkedList wordLink = new WordsLinkedList();

	public static void main(String[] args) throws IOException, FileNotFoundException{		
				
		long start, stop;
		double processing, sorting;
		
		start = System.currentTimeMillis();
		//loads file
		loadFile(args[0]);		
		stop = System.currentTimeMillis();
		
		processing = stop-start;
		
		start = System.currentTimeMillis();
		System.out.println("Top 20 words:");
		wordLink.sortWords();
		stop = System.currentTimeMillis();

		sorting = stop - start;
		
		System.out.println("Processing Time: " + ((processing)/1000.0));
		System.out.println("Sorting Time: " + ((sorting)/1000.0));
		System.out.println("Total Time: " + ((processing + sorting)/1000.0));
	}

	/**
	 * Loads file and puts words into linked list, unordered
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
			wordLink.insertWord(str);
		}
		
		reader.close();
	}
}
