
public class permutation {
    public static int sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 80;
		int[][] dungeons = {{80,20}, {50,40}, {30,10}};
		solution(k, dungeons);
	}
	
	 public static int solution(int k, int[][] dungeons) {
	        int answer = -1;
	        // 1. sort를 하고, 던전 탐험
	        // 2. 완전 탐색 적용 
	        // 2적용 : 123 -> 132
	        boolean[] visited = new boolean[dungeons.length]; //{f,f,f}
	        for(int i=0; i<dungeons.length; i++) {
	        	int idx = 0;
	            answer= explore(dungeons, visited, i, k, idx);
	        }
	        System.out.println(answer);
	        return answer;
	    }
	    public static int explore(int[][] dungeons, boolean[] visited, int count, int k, int idx) {
	        for(int i=count; i<dungeons.length; i++) { // 1. count = 0
	            if(!visited[i]) {
	            	System.out.println(i+1 + "번 쨰 던전 탐색 진행" + ",남은 피로도" + k);
	                if(dungeons[i][0] <= k) { //count = 0, explore -> count = 1, explore, 
	                    visited[i] = true; // 0번째 탐색 -> 1번째 탐색
	                    k -= dungeons[i][1]; // 80-20 -> 60-40
	                    System.out.println("소모 피로도 : " + dungeons[i][1]);
	                    idx = explore(dungeons, visited, count, k, idx) + 1; //(0, 60) -> (1, 20)
	                    visited[i] = false; //1번 미탐험
	                    k += dungeons[i][1];
	                } else {
	                	System.out.println("피로도가 부족합니다");
	                    return idx;
	                }
	        }
	            else  {
	            	System.out.println(i+1 + "는 이미 탐험한 던전입니다. 다음 던전을 탐험하겠습니다");
	            	continue;
	            }
	        }
	        return Math.max(sum, idx);
	    }

}
