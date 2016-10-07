package oopPrinciplesProblems;
import java.util.*;

public class TwoDAndThreeD {

//	if(list==null)
//		return null;
//	
//	LinkedListNode current=list.next;
//	LinkedListNode prev=list;
//	LinkedListNode temp;
//	
//	Set<Character> s=new HashSet<Character>();
//	
//	s.add(list.val);
//	
//	while(current!=null){
//		if(s.contains(current.val))
//		  {
//			prev.next=current.next;
//			temp=current;
//			current=current.next;
//			temp.next=null;
//		  }
//	    else	{
//	    	s.add(current.val);	
//	    	prev=current;
//	    	current=current.next;
//	    }
//	      	 
//	}
//	return list;


 class Point2D {

	int x;
	int y;
	
	public Point2D(int x1,int y1) {
		// TODO Auto-generated constructor stub
		this.x=x1;
		this.y=y1;
	}
	
	double dist2D(Point2D p){
	
		return Math.sqrt(((this.x-p.x)*(this.x-p.x))+((this.y-p.y)*(this.y-p.y))); 	
	}
	
	void printDistance(double d){
		
		System.out.println("2D distance = "+(int) (Math.round(d)+1));
	}
}

class Point3D extends Point2D {

	int z;
	public Point3D(int x1,int y1,int z1) {
		// TODO Auto-generated constructor stub
      super(x1, y1);
      this.z=z1;
	}
	
	double dist3D(Point3D p){
	
		return Math.sqrt(((this.x-p.x)*(this.x-p.x))+((this.y-p.y)*(this.y-p.y))+((this.z-p.z)*(this.z-p.z))); 	
	}
	
	void printDistance(double d){
		
		System.out.println("3D distance = "+(int) (Math.round(d)+1));
	}
}

	public static void main(String args[]){
		
		System.out.println("hi");
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int z1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		int z2=sc.nextInt();
		
        TwoDAndThreeD d=new TwoDAndThreeD();
		Point2D p1=d.new Point2D(x1, y1);
		Point2D p2 =d.new Point2D(x2, y2);
		

		p1.printDistance(p1.dist2D(p2));
		
		Point3D p3=d.new Point3D(x1, y1,z1);
		Point3D p4=d.new Point3D(x2, y2,z2);
		
		p3.printDistance(p3.dist3D(p4));
		
		
	}
}
