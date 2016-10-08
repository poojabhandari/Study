
public class DoubleLinkedList {

	
	static Node head;
	
	class Node{
		int data;
		Node next;
		Node prev;
	
		Node(int val){
			data=val;
			next=null;
			prev=null;
		}
		
		@Override
		public String toString() {
		return ""+this.data;
		}
	}
	
	void add(int val){
		Node n=new Node(val);
		
		if(head==null)
			head=n;
		else{
			n.next=head;
			head.prev=n;
			head=n;
		}
	}
	void print(){
		System.out.println();
		Node t=head;
		while(t!=null){
			System.out.print(t.data+" ");
			t=t.next;
		}
		System.out.println();
	}
	void delete(int pos){
		if(pos==0){
			Node t=head;
			head=head.next;
			head.prev=null;
			t.next=null;
			t.prev=null;
			System.gc();
		}
		else{
			Node t=head;
			for (int i = 0; i < pos-1; i++) 
				t=t.next;
			
			Node temp=t.next;
			t.next=temp.next;
			if(temp.next!=null)
			temp.next.prev=t;
			temp.next=null;
			temp.prev=null;
			System.gc();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     DoubleLinkedList ob=new DoubleLinkedList();
     ob.add(10);
     ob.add(20);
     ob.add(30);
     ob.add(40);
     ob.add(50);
     ob.add(60);
     ob.print();
     ob.delete(0);
     ob.delete(3);
     ob.delete(3);
     
     ob.print();
     
     ob.add(70);
     ob.delete(2);
     
     ob.print();
     
     System.out.println("\nhead="+head);
     
//     ob.print();
//     System.out.println("\nhead="+head);
     
     ob.reverse();
     ob.print();
     System.out.println("\nhead="+head);
     
	}
	private void reverse() {
		
		Node temp=null;
		Node curr=head;
		while(curr!=null){
			temp=curr.next;
			curr.next=curr.prev;
			curr.prev=temp;
			curr=curr.prev;
			if(temp==null)
				break;
			head=temp;
		}
	}

}
