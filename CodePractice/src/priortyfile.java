import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class priortyfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorites = {1,1,9,1,1,1};
		int location  = 0;
		solution(priorites, location);
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Boolean> que = new LinkedList<Boolean>();
		boolean[] check = new boolean[priorities.length];
		check[location] = true;
		List<Integer> li = new ArrayList<>();
		// 1. 대기목록의 가장 앞에 있는 문서를 꺼낸다.
		for (int i = 0; i < priorities.length; i++) {
			li.add(priorities[i]);
			que.add(check[i]);
		}
		int count = 0;
		// li = 2132 -> 1322 -> 3221 --> 221 --> 21 --> 2 --> null
		while (li.size() != 0) {
			// 2
			int temp = li.get(0); // 2
			if (check(li, temp) == true) { // 뒤에 우선순위가 높은 문서가 존재한다면
				li.remove(0);
				li.add(temp); // 2삭제 후, 맨 뒤에 추가
				boolean qp = que.poll(); 
				que.add(qp);
			} else  {
				li.remove(0); // 뒤에 우선 순위가 높은 문서가 존재 X -> 맨 앞 문서 출력
				count++;
				if(que.poll() == true) 
					break;
				
			}
		}
		answer = count;
		//System.out.print(answer);
		return answer;
	}

	public static boolean check(List<Integer> li, int temp) {
		for (int i = 1; i < li.size(); i++) {
			if (li.get(i) <= temp) {
				continue;
			} else {
				//System.out.println(temp + "보다 우선순위가 높은 문서가 있어, 맨 뒤로 보냅니다");
				return true;
			}
		}
		//System.out.println(temp + "보다 우선순위가 높은 문서가 존재하지 않습니다 ==> " + temp + "를 출력합니다" );
		return false;
	}
}
