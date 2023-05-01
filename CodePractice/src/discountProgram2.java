import java.util.HashMap;
import java.util.Map;

public class discountProgram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		solution(want, number, discount);
	}
	
	
	 private static int ans;

	    public static int solution(String[] want, int[] number, String[] discount) {
	        Map<String, Integer> wantMap = new HashMap<>();
	        ans = 0;

	        for (int i = 0; i < number.length; i++) {
	            wantMap.put(want[i], number[i]);
	        }
	        for (int i = 0; i <= discount.length - 10; i++) {
	            go(new HashMap<>(wantMap), discount, i);
	        }

	        return ans;
	    }

	    private static void go(Map<String, Integer> wantMap, String[] discount, int startIdx) {
	        Map<String, Integer> map = new HashMap<>();
	        for (int i = startIdx; i < startIdx + 10; i++) {
	            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
	        }
	        for (String discountKey : map.keySet()) {
	            if (wantMap.containsKey(discountKey)) {
	                wantMap.put(discountKey, wantMap.get(discountKey) - map.get(discountKey));
	                if (wantMap.get(discountKey) <= 0) {
	                    wantMap.remove(discountKey);
	                }
	            }
	        }
	        if (wantMap.isEmpty()) {
	            ans++;
	        }
	    }

}
