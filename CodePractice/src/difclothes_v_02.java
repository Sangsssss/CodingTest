import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class difclothes_v_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes= {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2= {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
		//combination(0,0);
		solution(clothes);
		solution(clothes2);
	}
	 

		public static int solution(String[][] clothes) {
		 int answer = 0;
			HashMap<String, Integer> map = new LinkedHashMap<>();

			for (int i = 0; i < clothes.length; i++) {
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
			}

			// System.out.println(map.get("headgear"));
			ArrayList<String> kA = new ArrayList<String>(map.keySet());
			
			int count = 1;
			for (String k : kA) {
				count *= (map.get(k) + 1);
			}
			answer = count-1;
			System.out.println(answer);
			return answer;
		}

	
}
