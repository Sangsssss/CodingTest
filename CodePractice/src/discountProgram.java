import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class discountProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		solution(want, number, discount);
	}
	
	
	 private static int days;
	 public static int solution(String[] want, int[] number, String[] discount) {
	        //10일 동안 회원 자격 부여
	        //want, number 동기화
	        days= 0;   
	        
	        HashMap<String, Integer> wantN = new HashMap<>();
	        for(int i=0; i<want.length; i++) {
	        	wantN.put(want[i], number[i]);
	        }
	      
	        for(int i = 0; i<discount.length-10; i++) {
	        	calcu(want, new HashMap<String, Integer>(wantN), discount, i);
	        }
	        return days;
	    }

	private static void calcu(String[] want, HashMap<String, Integer> wantN, String[] discount, int idx) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=idx; i<idx+10; i++) {
		    map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
		}
		List<String> li = new ArrayList<String>(map.keySet());
		for(String k : li) {
			if(wantN.containsKey(k)) {
				wantN.put(k, wantN.get(k)-map.get(k));
				if(wantN.get(k) <= 0) {
					wantN.remove(k);
				}
			} else
				continue;
		}
		if(wantN.isEmpty()) 
			days++;
	}

}
