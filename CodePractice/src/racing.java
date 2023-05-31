import java.util.HashMap;

public class racing {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		solution(players, callings);

	}
	 public static String[] solution(String[] players, String[] callings) {
	        //�̸��� �θ��� �߿� 
	        String[] answer = {};
	        HashMap<String, Integer> map = new HashMap<>();
	        for(int i =0; i<players.length; i++) {
	        	map.put(players[i], i); //map�� �� ������ ��ũ ����
	        }
	        
	        
	        for(String calling : callings) {
	        	int current = map.get(calling); //kai�� ���� 3�� ������
	        	String front = players[current-1]; //kai���� poe ����
	        	
	        	//��ġ �ٲ�
	        	players[current-1] = calling;
	        	players[current] = front;
	        	
	        	map.put(calling, current-1);
	        	map.put(front, current);
	        }
	        answer = players.clone();
	        return answer;
	    }
	 
	
}
