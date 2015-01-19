import java.io.*;
import java.util.ArrayList;

/*
 * Main of Bible count program.
 * 
 * @author Alexis Chuah
 * @version 1/16/2015
 * 
 * <p>
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * Use linked lists
 * </p>
 * 
 */

public class bibleCount {
	
	protected static WordsLinkedList wordLink = new WordsLinkedList();
	//protected static ArrayList<Word> wordArray = new ArrayList<Word>();

	public static void main(String[] args) throws IOException, FileNotFoundException{		
				
		long start, stop;
		double processing, sorting;
		
		start = System.currentTimeMillis();
		
		loadFile(args[0]);		
		
		stop = System.currentTimeMillis();
		processing = stop-start;
		System.out.println("Processing Time: " + ((processing)/1000.0));
		
		wordLink.show();
		//System.out.println(wordLink.searchList("GOD"));
		
		start = System.currentTimeMillis();
		wordLink.sortWords();
		stop = System.currentTimeMillis();
		
		sorting = stop - start;
		System.out.println("Sorting Time: " + ((sorting)/1000.0));
		
		start = System.currentTimeMillis();	
		
		stop = System.currentTimeMillis();
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
		
		int i = 0;
		
		while((str=reader.readLine())!=null){
			wordLink.insertWord(str);
		}
		
		reader.close();
		
	}

}
