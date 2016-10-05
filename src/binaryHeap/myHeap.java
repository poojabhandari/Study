
package binaryHeap;
import java.util.ArrayList;
import java.util.List;


public class myHeap {

	List<Integer> l;
	
	@Override
	public String toString() {
	return l.toString();
	}
	public myHeap(List<Integer> mylist) {
		l=new ArrayList<Integer>();
		for (int i = 0; i <mylist.size(); i++) {
			l.add(mylist.get(i));
		}
	}
	
	public void buildMaxHeap() {
		
		int iterationStart= l.size()/2;
		
		for (int i = iterationStart; i >=0 ; i--) {
			maxHeapify(i);
		}
		
	}
	private void maxHeapify(int i) {
		int largest = i,temp;
		int   left = 2 * i + 1;
        int  right = 2 * i + 2;

        if(left < l.size() && l.get(left) > l.get(largest))
            largest = left;
		if(right < l.size() && l.get(right) > l.get(largest))
            largest = right;
        if(largest != i)
        {   temp=l.get(i);
        	l.set(i, l.get(largest));
        	l.set(largest, temp);
        	maxHeapify(largest);
        }
	}
	public int extractMax() {
		
		if(l==null ||l.size()==0)
			System.out.println("No element in heap");
		
		int maxEleemnt=l.get(0);
		l.set(0, l.get(l.size()-1));
		l.remove(l.size()-1);
		maxHeapify(0);
		return maxEleemnt;
	}
	
	
	

}
