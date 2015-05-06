package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Checks if a file containing an adjacency matrix has an Euler Cycle.
 * 
 * @author Alexis Chuah
 * @version 4/16/15
 *
 */
public class EulerMain {

	/**
	 * @param args
	 */
	
	static int[][] matrix;
	static int lines=0;
	
	public static void main(String[] args) {
	
		try{
			
			loadFile(args[0]);
			System.out.println("Existence of Euler Cycle: " + eulerCycle());
			
		} catch (IOException e) {
			System.out.println("Invalid file format.");	
		} catch (NumberFormatException e){
			System.out.println("Invalid file format. Please try again.");
		} catch (Exception e){
			System.out.println("No file inserted in command line.");
		}
	}
	
	/**
	 * Returns true if Euler Cycle exist. False otherwise.
	 * @return
	 */
	private static boolean eulerCycle(){
		boolean euler = true;
		
		for(int i=0; i<lines; i++){
			int lineCount = 0;
			
			for(int j=0; j<lines; j++){
				lineCount = lineCount + matrix[i][j];
			}
			
			if(lineCount%2 == 1)
				euler = false;
		}
		
		return euler;
	}
	
	/**
	 * Display all elements in the adjacency matrix.
	 */
	private static void displayMatrix(){
		for(int i=0; i<lines; i++){
			for(int j=0; j<lines; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
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
		
			str=reader.readLine();
		
			lines = Integer.parseInt(str);
		
			matrix = new int[lines][lines];
		
			while((str=reader.readLine())!=null){
				String[]nums = str.split("\\s+");
			
				//Start at 1 to eliminate first element in split array that is a blank space.
				for(int j=1; j<nums.length; j++){
					matrix[i][j-1] = Integer.parseInt(nums[j]);
				}
				i++;
			}
			reader.close();	
		}	
		else
			System.out.println(fileName + " does not exist.");
	}
}
