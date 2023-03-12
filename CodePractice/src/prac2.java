import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class prac2 {

	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3}; //1 = 1, 2 = 2, 3 = 2, 4 = 1, 5 = 2
		
		int k2 = 4;
		int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3}; //1 = 1, 2 = 2, 3 = 2, 4 = 1, 5 = 2
		
		int k3 = 2;
		int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3}; //1 = 1, 2 = 2, 3 = 2, 4 = 1, 5 = 2
		
		solution(k, tangerine);
//		solution(k2, tangerine2);
//		solution(k3, tangerine3);

	}

	public static int solution(int k, int[] tangerine) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(tangerine);
		
		for (int tan : tangerine) {
			if (map.containsKey(tan)) {
				map.put(tan, map.get(tan) + 1);
			} else
				map.put(tan, 1);
		}
		
		ArrayList<Integer> lists=new ArrayList<>(map.values());
        Collections.sort(lists, Collections.reverseOrder());
        
        for(int list  : lists) {
        	k -= list;
        	answer++;
        	if(k<=0)
        		break;
        }
        //System.out.println(answer);
		return answer;
	}

}
