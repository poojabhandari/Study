package managerProblem;

public class Employee {

	
	private String name;
	private Employee manager;
	
	public String toString() {
		return this.getName();
	};
	Employee(String n){
		name=n;
	}
	
	public void setManager(Employee m){
			manager=m;
		}
	
	public Employee getManager(){
		return manager;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(((Employee)obj).getName().equals(this.getName()))
			return true;
			else
				return false;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
