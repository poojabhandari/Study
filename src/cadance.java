import java.util.ArrayList;
import java.util.List;

public class cadance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> l=new ArrayList<Integer>();
		l.add(-1);
		l.add(-6);
		l.add(-3);
		l.add(-4);
		l.add(-3);
		l.add(-1);
		l.add(0);
		
		int currSum=l.get(0);
		int globalSum=l.get(0);
		for (int i = 1; i < l.size(); i++) {
		   currSum=Math.max(currSum+l.get(i), l.get(i));
		   globalSum=Math.max(currSum, globalSum);
		}
		
		System.out.println(globalSum);
	}
	

	
}
