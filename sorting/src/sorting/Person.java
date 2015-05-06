package sorting;

/**
 * Person class stores name and age.
 * 
 * @author Alexis Chuah
 * @version 2/22/2015
 */
public class Person implements Comparable<Person>{
	
	String firstName;
	String lastName;
	int income;
	
	public Person(String first, String last, int income){
		this.firstName = first;
		this.lastName = last;
		this.income = income;
	}
	
	public String toString(){
		return firstName + " " + lastName + " " + income;
	}

	@Override
	public int compareTo(Person o) {
		if(o.income > this.income)
			return 1;
		if(o.income < this.income)
			return -1;
		return 0;
	}
	
	

}
