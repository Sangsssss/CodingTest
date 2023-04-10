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
	        int answer = 0;
	        //10�� ���� ȸ�� �ڰ� �ο�
	        //want, number ����ȭ
	        days= 0;
	        
	        
	        HashMap<String, Integer> wantN = new HashMap<>();
	        for(int i=0; i<want.length; i++) {
	        	wantN.put(want[i], number[i]);
	        }
	      
	        for(int i = 0; i<discount.length-9; i++) {
	        	int idx = i;
	        	calcu(want, discount, wantN, idx);
	        }
	        answer = days;
	        //System.out.println(answer);
	        return answer;
	    }

	private static void calcu(String[] want, String[] discount, HashMap<String, Integer> wantN, int idx) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=idx; i<idx+10; i++) {
		    map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
		}
		List<String> li = new ArrayList<String>(map.keySet());
		for(int i =0; i<want.length; i++) {
			 
			
			
			 if(!map.containsKey(want[i]))
				 break;
			 if(wantN.get(want[i]) == map.get(want[i])) {
		    	wantN.remove(want[i]);
		    }
		}
		if(wantN.size() == 0) 
			days++;
	}

}
