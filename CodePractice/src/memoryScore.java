import java.util.HashMap;

public class memoryScore {

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5,10,1,3};
		String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}};
		
		solution(name, yearning, photo);
	}
	
	  public static int[] solution(String[] name, int[] yearning, String[][] photos) {
	        int[] answer = new int[photos.length];
	        int count = 0;
	        //1. 점수판 만들기
	        HashMap<String, Integer> score = new HashMap<>();
	        for(int i =0; i<name.length; i++) {
	            score.put(name[i], yearning[i]);
	        }
	        //2. 계산
	        for(String[] photo : photos) {
	        	int sum = 0;
	        	for(String person : photo) {
	        		sum += score.getOrDefault(person, 0);
	        	}
	        	answer[count++] = sum;
	        }
	       // System.out.println(answer[0] + " " + answer[1]);
	        return answer;
	    }

	
}
