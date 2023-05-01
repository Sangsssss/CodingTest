import java.util.LinkedList;
import java.util.Queue;

public class busQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100;
		int weight = 10;
		int[] truck_weights = {10};
		solution(bridge_length, weight, truck_weights);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0; //= time
		Queue<Integer> que = new LinkedList<>();
		int sumW = 0;
		for(int i=0; i<truck_weights.length; i++) {
			
			int currentTruck = truck_weights[i]; //7
			//다리가 비어 있는 경우(Queue.isEmpty())
			while(true) {
			if(que.isEmpty()) {
				que.add(currentTruck);
				sumW += currentTruck; //7
				time++;
				break;
			} else if(que.size() == bridge_length) { //다리가 꽉찬 경우
				sumW -= que.poll();
			} else {
				//다리에 트럭이 더 올라갈 수 있는 경우
				if(sumW + currentTruck <= weight) {
					que.add(currentTruck);
					sumW += currentTruck;
					time++;
					break;
				}//다리에 트럭이 올라갔는데, 다음 트럭이 올라갈 수 없는 경우 
				else {
					que.add(0);
					time++;
				}	
			}	
		}
			
		}
		time += bridge_length;
		//System.out.println(time);
		return time;
	}
}
