package managerProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConflictResolutionBySimpleHashMap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    while ((s = in.readLine()) != null) {
		   
		    	String[] input=s.split(",");
		    	
		    	String p1=input[input.length-1];
		    	String p2=input[input.length-2];
		    	
//		    	System.out.println(p1+" "+p2);
		    	HashMap<String,List<String>> hm=new HashMap<String,List<String>>();
		    	
		    	for (int i = 0; i < input.length-2; i++) {
		    		String[] ip=input[i].split("->");
		    		ip[0]=ip[0].trim();
		    		ip[1]=ip[1].trim();
		    		if(hm.containsKey(ip[0]))
		    		{
		    			List<String> l=hm.get(ip[0]);
		    			l.add(ip[1]);
		    		}
		    		else
		    		{
		    		List<String> l=new ArrayList<String>();
		    		l.add(ip[1]);
		    		hm.put(ip[0].trim(), l);
		    		}
		    		
				}
		    	
//		    	for(String k:hm.keySet()){
//		    		System.out.println(k+"  "+hm.get(k));
//		    	}
		    	
		    	List<String> p1managers=managerList(p1,hm);
		    	//System.out.println(p1managers);
		    	List<String> p2managers=managerList(p2,hm);
		    	//System.out.println(p2managers);
		    	
		    	String commonparent=findcommon(p1managers,p2managers);
		    	System.out.println(commonparent);
		    }
	}

	private static String findcommon(List<String> p1managers, List<String> p2managers) {
	for(String s1:p1managers){
		for(String s2:p2managers){
			if(s1.equals(s2))
				return s1;
		}
	}
		return null;
	}

	private static List<String> managerList(String p1, HashMap<String, List<String>> hm) {
		List<String> managers=new ArrayList<String>();
		for (String ss:hm.keySet()){
			List l=hm.get(ss);
			if(l.contains(p1))
				{managers.add(ss);
				managers.addAll(managerList(ss, hm));
				}
		}
		return managers;
	}

}
