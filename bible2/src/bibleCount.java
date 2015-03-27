import java.io.*;

/*
 * Takes a text containing the entire Bible and displays the 20 most frequently used words.
 * 
 * @author Alexis Chuah
 * @version 2/5/2015
 * 
 * <p>
 * 
 * Use linked lists
 * </p>
 * 
 */

public class bibleCount {
	
	protected static MyOrderedList ordList = new MyOrderedList();

	public static void main(String[] args) throws IOException, FileNotFoundException{		
				
		long start, stop;
		double processing, sorting;
		
		start = System.currentTimeMillis();
		
		loadFile(args[0]);		
		
		stop = System.currentTimeMillis();
		
		processing = stop-start;
		
		start = System.currentTimeMillis();
		
		ordList.sortCount();
		ordList.display();
		
		stop = System.currentTimeMillis();
		
		sorting = stop - start;
		
		System.out.println("Processing Time: " + ((processing)/1000.0));
		System.out.println("Sorting Time: " + ((sorting)/1000.0));
		System.out.println("Total Time: " + ((processing + sorting)/1000.0));
	}

	/**
	 * Loads file and puts words into an ordered array in the container class.
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
			if(ordList.num==0)
				ordList.insertWord(str, 0);
			else{
				int i = ordList.binSearch(str, 0, ordList.num-1);
				if(i==-1)
					ordList.insertWord(str, -1);
				else
					ordList.increaseCount(i,str);
			}
			
		}
		
		reader.close();
		
	}

}
