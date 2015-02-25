/**
 * @author Alexis Chuah
 *
 */
public class Seat {
	public String name;
	public int bags;
	public double cost;
	public Seat(Seat ns){
		name = ns.name;
		bags = ns.bags;
		cost = ns.cost;
	}
	
	public Seat(String name, int bag, double cost){
		this.name = name;
		this.bags = bag;
		this.cost = cost;
	}
}
