package StringRelatedPrograms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Passage {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 String s;
		 
		    while ((s = in.readLine()) != null) {
		 
		    	List<String> listofPassages=new ArrayList<String>();
		    	String[] setofsentences=s.split("\\|");
		    	
		    	for(int i=0;i<setofsentences.length;i++){
		    		String istr=clean(setofsentences[i]);
		    		for(int j=i+1;j<setofsentences .length;j++){
		    			
		    			String jstr=clean(setofsentences[j]);
		    			
		    			 if(istr.equalsIgnoreCase(jstr)){
		    				if(setofsentences[i].length()<setofsentences[j].length())
		    					listofPassages.add(setofsentences[i]);
		    				else if (setofsentences[i].length()>setofsentences[j].length())
		    					listofPassages.add(setofsentences[j]);
		    				else if(setofsentences[i].length()==setofsentences[j].length()){
		    					listofPassages.add(setofsentences[i]);
		    				}
		    			} 
		    			 else {
		    				 if (istr.contains(jstr))
		    			{    boolean flag=false;
		                      for(String anyString:listofPassages){
		                    	  if(clean(anyString).contains(istr)){
		                    		  flag=true;
		                    		  break;
		                    	  }
		                      }
		                      if(flag!=true)
		                    	  listofPassages.add(setofsentences[i]);
		    			}
		    			 else if(jstr.contains(istr)){
		    				 boolean flag=false;
		                      for(String anyString:listofPassages){
		                    	  if(clean(anyString).contains(jstr)){
		                    		  flag=true;
		                    		  break;
		                    	  }
		                      }
		                      if(flag!=true)
		                    	  listofPassages.add(setofsentences[j]);
		    			
		    			}}
		    			
		    		}
		    	}
		    	String output="";
		    	for(String p:listofPassages){
		    		output=output+p+"|";
		    	}
		    	output=output.substring(0,output.length()-1);
		    	System.out.println(output);
		    }
		    
		   
		   
	}
	public static String clean(String ss){
		return ss.replaceAll("[^A-Za-z0-9 ]", "").replaceAll("\\s+", " ").trim();
	}
}	

//String s;
//while ((s = in.readLine()) != null) {
//	String[] ip=s.split(" ");
//    int N=Integer.parseInt(ip[0]);
//    int p=Integer.parseInt(ip[1]);
//    int q=Integer.parseInt(ip[2]);
//   
//    String output="";
//    String istr="";
//    int i=1;
//    while(i<=N)
//    {
//    	istr=""+i;
//    	if((i%p==0 || i%q==0 )&&(istr.contains(p+"")||istr.contains(q+""))){
//    		
//    		output=output+"OUTTHINK,";
//    	}
//    	else if(istr.contains(p+"")||istr.contains(q+"")){
//    		output=output+"THINK,";
//    	}else if(i%p==0 || i%q==0){
//    		output=output+"OUT,";
//    	}else{
//    		output=output+i+",";
//    	}
//    	i++;
//    }
//    output=output.substring(0,output.length()-1);
//    System.out.println(output);