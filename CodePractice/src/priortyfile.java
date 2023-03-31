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
		// 1. ������� ���� �տ� �ִ� ������ ������.
		for (int i = 0; i < priorities.length; i++) {
			li.add(priorities[i]);
			que.add(check[i]);
		}
		int count = 0;
		// li = 2132 -> 1322 -> 3221 --> 221 --> 21 --> 2 --> null
		while (li.size() != 0) {
			// 2
			int temp = li.get(0); // 2
			if (check(li, temp) == true) { // �ڿ� �켱������ ���� ������ �����Ѵٸ�
				li.remove(0);
				li.add(temp); // 2���� ��, �� �ڿ� �߰�
				boolean qp = que.poll(); 
				que.add(qp);
			} else  {
				li.remove(0); // �ڿ� �켱 ������ ���� ������ ���� X -> �� �� ���� ���
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
				//System.out.println(temp + "���� �켱������ ���� ������ �־�, �� �ڷ� �����ϴ�");
				return true;
			}
		}
		//System.out.println(temp + "���� �켱������ ���� ������ �������� �ʽ��ϴ� ==> " + temp + "�� ����մϴ�" );
		return false;
	}
}
