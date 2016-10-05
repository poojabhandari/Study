package managerProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class conflictResolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String input[]=sc.nextLine().split(",");
		
		HashMap<String,Employee> employeeSet=new HashMap<String,Employee>();
		
		Employee p=new Employee(input[input.length-1]);
		employeeSet.put(input[input.length-1],p);
		Employee q=new Employee(input[input.length-2]);
		employeeSet.put(input[input.length-2],q);
		
		for (int i = 0; i < input.length-2; i++) {
		   	   String[] pair=input[i].split("->");
		   	   Employee m,u;
		   	   if(!employeeSet.containsKey(pair[0].trim())){
		   		m=new Employee(pair[0].trim());
			   	   employeeSet.put(pair[0].trim(), m);   
		   	   }
			   else
		   	   m=employeeSet.get(pair[0].trim());
		   	   
		   	   if(!employeeSet.containsKey(pair[1].trim()))
			   {
		   		   u=new Employee(pair[1].trim());
			   	   employeeSet.put(pair[1].trim(), u);
			   }
		   	   else
		   	    u=employeeSet.get(pair[1].trim());
		   	   
		   	   
			   u.setManager(m);	   
			   System.out.println(m.getName()+" - > "+u.getName());
		}
		
		
		ArrayList<Employee> list1=getManagerList(p);
		System.out.println(list1);
//
		ArrayList<Employee> list2=getManagerList(q);
		System.out.println(list2);
		
		for(Employee e:list1){
		for(Employee e1:list2){
			if(e.equals(e1))
				System.out.println(e);
		}
		}
	}

	private static ArrayList<Employee> getManagerList(Employee p) {
	
		ArrayList<Employee> list=new ArrayList<Employee>();
		
		while(p.getManager()!=null){
		list.add(p.getManager());
		p=p.getManager();
		}
		return list;
	}

}
