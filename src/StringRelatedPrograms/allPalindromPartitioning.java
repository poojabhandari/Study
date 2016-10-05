package StringRelatedPrograms;

import java.util.*;

public class allPalindromPartitioning {
	static final List<ArrayList<String>> mainList=new ArrayList<ArrayList<String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="nitin";
		palpartition(s);
	}

	private static void palpartition(String s) {
		
		ArrayList<String> current=new ArrayList<String>();
		
		partition(current,0,s.length(),s);
		
	}
	public static boolean istPalindrom(String string){
	    int i1 = 0;
	    int i2 = string.length() - 1;
	    while (i2 > i1) {
	        if (string.charAt(i1) != string.charAt(i2)) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
	
	private static void partition( ArrayList<String> current, int start, int length,String s) {
		if(start==length)
		{
			System.out.println(current);
			System.out.println(current.size());
			return;
		}
		
		for (int i = start; i <length ; i++) {
			
			if(istPalindrom(s.substring(start,i+1)))
			{
				current.add(s.substring(start, i+1));
			    partition(current,i+1,length,s);
				System.out.println("current: "+current);
			    current.remove(current.size()-1);
				System.out.println("current2: "+current);
				
			}
			
		}
		
		
	}

}
