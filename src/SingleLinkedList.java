
public class SingleLinkedList {

	static Node head;
	static class Node{
		
		int val;
		Node next;
		
		Node(int val1){
			val=val1;
			next=null;
		}
		@Override
		public String toString() {
		return this.val+"";
		}
	}
    
    public void add(int val1){
    	Node n=new Node(val1);
//    	if(head==null)
//    		head=n;
//    	else{	
	    	n.next=head;
	    	head=n;
//    	}
    }
    void delete(int pos){
    	if(pos==0){
    		Node t=head;
    		head=head.next;
    		t.next=null;
    		System.gc();
    	}
    	else if(pos!=0){
    		Node t=head;
    		for(int i=0;i<pos-1;i++){
    			t=t.next;
    		}
    		Node temp=t.next;
    		t.next=temp.next;
    		temp.next=null;
    		System.gc();
    	}
    	
    }
    void print()
    {
    	System.out.println();
    	Node t=head;
    	while(t!=null){
    		System.out.print(t.val+" ");
    		t=t.next;
    	}
    	System.out.println();
    }
    private void reverse() {
	
    	if(head==null)
    		return;
    	Node curr=head;
    	Node prev=null;
    	Node temp;
    	while(curr!=null){
    		temp=curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=temp;
    	}
    	head=prev;
	}
	public static void main(String[] args) {
    SingleLinkedList ob=new SingleLinkedList();
    ob.add(10);
    ob.add(20);
    ob.add(30);
    ob.add(20);
    ob.add(10);
    ob.add(10);
    
    ob.print();
    
    System.out.println(ob.isPalindrome(head));
//    ob.delete(0);
//    ob.delete(3);
//    ob.delete(3);
//    
//    ob.print();
//    
//    ob.add(70);
//    ob.delete(2);
//    
//    ob.print();
//    
//    System.out.println("\nhead="+head);
//    
//    
//    ob.reverse();
//    
//    ob.print();
//    System.out.println("\nhead="+head);
//    ob.print();
//	
	}
	
Node reverse1(Node root){
        
        Node curr=root;
        Node prev=null;
        Node temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        return prev;
    }
    public boolean isPalindrome(Node head) {
       if(head==null)
          return true;
        if(head.next==null)
         return true;
        
       Node s=head;
       Node f=head;
       boolean flag=false;
       while(f.next!=null){
           
           s=s.next;
           f=f.next.next;
           if(f==null)
          {flag=true;
              break;
          }
       }
       if(flag==false)
       s=s.next;
       
       Node second=reverse1(s);
       Node first=head;
       
       while(second!=null){
           if(first.val!=second.val)
           return false;
           first=first.next;
           second=second.next;
       }
       return true;
    }
    
}
