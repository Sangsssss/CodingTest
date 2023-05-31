import java.util.HashMap;

public class racing {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		solution(players, callings);

	}
	 public static String[] solution(String[] players, String[] callings) {
	        //이름을 부르면 추월 
	        String[] answer = {};
	        HashMap<String, Integer> map = new HashMap<>();
	        for(int i =0; i<players.length; i++) {
	        	map.put(players[i], i); //map에 각 선수의 랭크 저장
	        }
	        
	        
	        for(String calling : callings) {
	        	int current = map.get(calling); //kai의 순위 3을 가져옴
	        	String front = players[current-1]; //kai앞의 poe 저장
	        	
	        	//위치 바꿈
	        	players[current-1] = calling;
	        	players[current] = front;
	        	
	        	map.put(calling, current-1);
	        	map.put(front, current);
	        }
	        answer = players.clone();
	        return answer;
	    }
	 
	
}
