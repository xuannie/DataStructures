/**
 * @author Alexis Chuah
 *
 */
public class MyList {
	protected ListNode head;
	
	public MyList(){
		head = null;
	}
	
	public void add(Seat booked){
		head = new ListNode(booked,head);
	}
	
	public ListNode copyPlane(){
		if (this.head == null)
			return null;
		else{
			
			MyList copy = new MyList();
			copy.head = this.head;
			
			ListNode p = copy.head;
			ListNode q = this.head;
			
			for(q=head; q!=null;q=q.next){
				p.next = q.next;
				p= p.next;
			}
			return copy.head;
		}

	}
	
	public void display(){
		if (this.head==null){
			System.out.println("Empty.");
		}
		else{
			ListNode p=head;
			for (p=head; p!=null; p=p.next)
				System.out.println(p.s.name);
		}
	}
}
