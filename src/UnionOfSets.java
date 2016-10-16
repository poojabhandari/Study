import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UnionOfSets{
    class Interval implements Comparable<Interval>{
        private final int left;
        private final int right;
        Interval(int left,int right){
            this.left = left;
            this.right = right;
        }
        public int getRight(){
          return this.right;
        }
        public int getLeft(){
          return this.left; 
        }
        @Override
        public int compareTo(Interval interval){
            if(this.left > interval.left){
              return 1; 
            }else if(this.left < interval.left){
              return -1;    
            }else{
              return 0;
            }
        }
        @Override
        public String toString(){
         return "("+this.left+","+this.right+")";
        }
    }   

    public List<Interval> getUnion(List<Interval> intervals){
        Collections.sort(intervals);
      List<Interval> union = new ArrayList<Interval>();
        int result=0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(Interval i:intervals){
            int currentRight = i.getRight();
            int currentLeft = i.getLeft();
            if(currentLeft <= right && currentRight > right){
              right = currentRight;
            }
            if(currentLeft < left && currentRight >= right){
              left = currentLeft;
              right = currentRight; 
            }
            if(currentLeft > right){
              union.add(new Interval(left,right));
            result=result+(right-left)+1;
              left = currentLeft;
              right = currentRight;
            }
        }
        union.add(new Interval(left,right));
        result=result+(right-left)+1;
        System.out.println("Total number of integers after union: "+result);
        System.out.println("Sets are: ");
        
        return union;
    }
    public static void main(String[] args){
    	

    	System.out.println("Enter number of sets:");
    	Scanner sc=new Scanner(System.in);
    	String NString=sc.nextLine();
    	int N = Integer.parseInt(NString);

        UnionOfSets sol = new UnionOfSets();  
        List<UnionOfSets.Interval> listOfIntervals = new ArrayList<UnionOfSets.Interval>();
        List<String> input = new ArrayList<String>();
            
        
    	for (int i = 0; i < N; i++) {
    		
    		System.out.println("Enter set:");
    		String s=sc.nextLine();
			input.add(s);
			
		}
    	
    	
//    System.out.println(input);
    	for (String s:input) {
    	
    		if(s== null||s.equals(""))
                continue;
//    		System.out.println(s);
    		String[] line=s.split(" ");
    		Integer a=Integer.parseInt(line[0].trim());
    		Integer b=Integer.parseInt(line[1].trim());
    		UnionOfSets.Interval interval = sol.new Interval(a,b);
    		listOfIntervals.add(interval);	
		
    	}
    	
		
		for (UnionOfSets.Interval i:sol.getUnion(listOfIntervals)){
        System.out.println(i);
    }
 }
}