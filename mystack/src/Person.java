/**
 * Person class stores name and age.
 * 
 * @author Alexis Chuah
 * @version 2/22/2015
 */
public class Person {
	
	String name;
	int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return name + " " + age;
	}

}
