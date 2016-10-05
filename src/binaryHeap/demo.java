
package binaryHeap;
import java.util.ArrayList;
import java.util.List;


public class demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> mylist=new ArrayList<Integer>();
		
		mylist.add(13);
		mylist.add(14);
		mylist.add(18);
		mylist.add(15);
		mylist.add(17);
		mylist.add(16);
		
         myHeap h1=new myHeap(mylist);
         h1.buildMaxHeap(); //O(n)
         
         System.out.println(h1);
         
         
        int maxElement= h1.extractMax();
        System.out.println(maxElement+" is the max element and is removed");
        System.out.println(h1);
        maxElement= h1.extractMax();
        System.out.println(maxElement+" is the max element and is removed");
	}

}
