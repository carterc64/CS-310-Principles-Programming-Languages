//Carter Copen
//This assignment follows academic integrity
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Survey3 {
	public static void main(String[] Args) {
		
		List<Integer> before = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List<Integer> after = new ArrayList<Integer>(Arrays.asList(3,4,1,2));
		
		List<Integer> before2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		List<Integer> after3 = new ArrayList<Integer>(Arrays.asList(1,2));
		
		System.out.println(pivot(before, after));
		printList(pivot(before2));
		printList(pivot(after3));
	}
	
	
	
	
	public static boolean pivot(List<Integer> before, List<Integer> after) {
		
		if (after.size() == before.size()) {
			
			int length = before.size();
			int half = Math.round(length/2);
			
			if (half %2 != 0 && half != 1) {
				half++;
			}
		
			
			List<Integer> H1 = before.subList(0, half);
			List<Integer> H2 = before.subList(half, length);
			List<Integer> result = new ArrayList<Integer>();
			
			result.addAll(H2);
			result.addAll(H1);
			
			if(result.equals(after)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<Integer> pivot(List<Integer> list) {
		
		int length = list.size();
		int half = Math.round(length/2);
		
		if (half %2 != 0 && half != 1) {
			half++;
		}
		
		
		List<Integer> H1 = list.subList(0, half);
		List<Integer> H2 = list.subList(half, length);
		List<Integer> result = new ArrayList<Integer>();
		
		result.addAll(H2);
		result.addAll(H1);
		
	
		return result;
	}
	
	public static void printList(List<Integer> L) {
		int length = L.size();
		for (int i = 0; i < length; i++) {
			System.out.println(L.get(i));
		}
		
		System.out.println("end");
	}
}
