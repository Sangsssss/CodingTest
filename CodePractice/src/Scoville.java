import java.util.Arrays;
import java.util.PriorityQueue;

public class Scoville {

	public static void main(String[] args) {
		int[] scoville = {1,2};
		int k = 7;
		solution(scoville, k);

	}

	    public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> que = new PriorityQueue<>();
	        for(int k : scoville) { //������������ ť�� ���ĵǰ� �� : Heap�� ������ ����
	        	que.add(k);  
	        }  //{1,3,5,9,10,12} => {5,7,9,10,12} => {9,10,12,13}
	        int cal = 0;

	        
	        while(!que.isEmpty()) {
	        	//System.out.println(que.peek());
	        	if(cal == 0) {
	        		if(que.peek() >= K)
	        			break;
	        		else
	        			cal += que.poll();
	        	}
	        	else {
	        		answer++;
	        		cal += 2*que.poll();
	        		que.add(cal);
	        		cal = 0;
	        	}     	
	        }
	        if(que.isEmpty() || que.peek() < K)
	        	answer = -1;

	       // System.out.println("���� : " + answer);
	        return answer;
	    
}
	

}
