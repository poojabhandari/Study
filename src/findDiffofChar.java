import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class findDiffofChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A={4,3,2,6};
		System.out.println(maxRotateFunction(A));
		//System.out.println(findTheDifference("abckjnk", "kksnjabc"));
	}
	public static char findTheDifference(String s, String t) {
	     
	     HashMap<Character,Integer> h1=new HashMap<Character,Integer>();
	     HashMap<Character,Integer> h2=new HashMap<Character,Integer>();
	     int v;
	     for(int i=0;i<s.length();i++){
	         if(h1.containsKey(s.charAt(i)))
	           {
	               v=h1.get(s.charAt(i));
	               h1.put(s.charAt(i),v+1);
	           }
	           else
	           h1.put(s.charAt(i),1);
	      }
	     for(int i=0;i<t.length();i++){
	         if(h2.containsKey(t.charAt(i)))
	           {
	               v=h2.get(t.charAt(i));
	               h2.put(t.charAt(i),v+1);
	           }
	           else
	           h2.put(t.charAt(i),1);
	      }
	      

	     Iterator it=h1.entrySet().iterator();
	    Character c=null;
	    int val;
	    while(it.hasNext()){
	    	Map.Entry pair=(Map.Entry)it.next();
	    	 c=(Character) pair.getKey();
	    	 val=(int) pair.getValue();
	    	 if(val==h2.get(c))
	    		h2.remove(c);
	    }

	    Set<Character> set=h2.keySet();
	    for(Character cc:set){
	    	return cc;
	    }
		return c;
	  }


    public static int maxRotateFunction(int[] A) {
   
       if(A.length==0 || A==null)
        return 0;
        int len=A.length;
        int sum,k=0;
        int globalSum=Integer.MIN_VALUE;
        
        for(int i=0;i<len;i++){
            sum=0;
            k=0;
          if(i==1)
        	  System.out.println("hi");
           for(int j=i;j<i+len;j++){
                  
                  if(j==len)
                  j=0;
                  sum=sum+(j*A[k]);
                  k++;
              
           }
              
           
           globalSum =Math.max(globalSum,sum);
        }
        return globalSum;
      
    }
}
