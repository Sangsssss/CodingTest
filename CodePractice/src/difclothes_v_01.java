import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class difclothes_v_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes= {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		//combination(0,0);
		solution(clothes);
	}
	 static int answer = 0;

		public static int solution(String[][] clothes) {

			HashMap<String, Integer> map = new LinkedHashMap<>();

			for (int i = 0; i < clothes.length; i++) {
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
			}

			// System.out.println(map.get("headgear"));
			ArrayList<String> kA = new ArrayList<String>(map.keySet());

			int n = kA.size();
			boolean[] visited = new boolean[n];
			for (int i = 1; i <= n; i++) {
				combination(map, kA, visited, 0, n, i);
			}
			return answer;
		}

		public static int combination(HashMap<String, Integer> map, ArrayList<String> array, boolean[] visited,
				int start, int n, int r) {
			if (r == 0) {
				answer += print(map, array, visited, n);
				return answer;
			}
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(map, array, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
			return answer;
		}

		public static int print(HashMap<String, Integer> map, ArrayList<String> arr, boolean[] visited, int n) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					if (temp > 0)
						temp = temp * map.get(arr.get(i));
					else
						temp = map.get(arr.get(i));
					// System.out.print(map.get(arr.get(i)) + " ");
				}
			}
			// System.out.println();
			return temp;
		}
}
