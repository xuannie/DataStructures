/**
 * Container class that has methods to sort, display, add a word into an array. Words are added in an alphabetical order.
 * 
 * @author Alexis
 * @version 2/5/2015
 *
 */

public class MyOrderedList {

	int num; //count of words in the file
	protected static Word[]ol; //array for ordered list
	private int insertLocation; //insert location for word after found using binary search
	protected static Word[]count; //array to store word ordered by count
	
	/**
	 * Constructor
	 */
	public MyOrderedList(){
		num = 0;
		ol = new Word[15000];
	}
	
	/**
	 * Displays all elements in array
	 */
	public void display(){
		if(num==0){
			System.out.println("There are no words to display");
		}else{
			System.out.printf("%25s %-6s\n","Word","Count");
			System.out.println("------------------------------------------------");
			for(int i=0; i<20; i++)
				System.out.printf("%25s %-6d\n", count[i].getWord(), count[i].getCount());	
		}	
	}
	
	/**
	 * Inserting words into sorted array.
	 * 
	 * @param text String to insert
	 * 
	 * <p>
	 * If element is not found, insert words using the recorded location when conducting the binary search.
	 * </p>
	 */
	public void insertWord(String text, int i){

		if (i==0)
			ol[0] = new Word(text);
		if(i==-1){	
			for(int x = this.num; x>insertLocation; x--){
				ol[x] = ol[x-1];
			}
			
			ol[insertLocation] = new Word(text);
		}
		
		num++;
		
	}
	
	/**
	 * Search for position of word with binary search.
	 * 
	 * @param search	Word to search for.
	 * @param start		Starting point.
	 * @param stop		Ending point.
	 * @return			Position of word. If not found, return -1.
	 * 
	 * <p>
	 * Records location to insert value if word is not found in the array. 
	 * </p>
	 */
	public int binSearch(String search, int start, int stop){
		
		if (start>stop){
			insertLocation = start;
			return -1;
		}
		
		int mid = (start+stop)/2;
		String current = ol[mid].getWord();
		
		if (current.equals(search))
			return mid;
		else if(current.compareTo(search)<0)
			return binSearch(search, mid+1, stop);
		else
			return binSearch(search, start, mid-1);
	}
	
	/**
	 * Using recursive quicksort to sort array of words by frequency in descending order.
	 * 
	 * @param left
	 * @param right
	 * 
	 */
	private static void quickSort(int left, int right){
		
		int l=left;
		int r=right;
	      
		int midvalue = (count[(l+r)/2]).getCount();
	      
		while (l<=r){
	      
			while (count[l].getCount()>midvalue)
	            l++;
			while (count[r].getCount()<midvalue)
	            r--;
	         
	         if(l<=r){
	         
	            Word temp = count[l];
	            count[l] = count[r];
	            count[r] = temp;
	            
	            l++;
	            r--;
	         }
	      }
	      
	      int index = l;
	      
	      if (left<index -1) {
	         quickSort(left, index-1);
	      }
	      if (index<right){
	         quickSort(index, right);
	      }
	}

	/**
	 * Increase count of word.
	 * 
	 * @param str to insert
	 */
	public void increaseCount(int i, String str) {
		// TODO Auto-generated method stub
			ol[i].count++;
	}

	/**
	 * Sort words by count.
	 */
	public void sortCount() {
		// TODO Auto-generated method stub
		count = new Word[num];
		for(int i=0; i<num; i++)
			count[i] = ol[i];
		
		quickSort(0, num-1);
		
	}
	
}
