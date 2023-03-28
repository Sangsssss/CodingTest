import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class priortyfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorites = {2,1,3,2};
		int location  = 2;
		solution(priorites, location);
	}
	
	 public static int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Boolean> que = new LinkedList<Boolean>();
	        boolean[] check = new boolean[priorities.length];
	        check[location] = true;
	        List<Integer> li = new ArrayList<>();
	        //1. 대기목록의 가장 앞에 있는 문서를 꺼낸다.
	        for(int i = 0; i<priorities.length; i++) {
	            li.add(priorities[i]);
	            que.add(check[i]);
	        } 
	        int count = 0;
	        while(li.size() != 0) {
	        int temp = li.get(0); //2
	        for(int i = 1; i<li.size(); i++) {
	            if(li.get(i)<=temp) {
	            	continue; 	   
	            } else {
	            	System.out.println(temp + "보다 우선순위가 높은 문서가 있어, 맨 뒤로 보냅니다");
	                li.remove(0);
	                li.add(temp);
	                boolean t = que.poll();
	                que.add(t);
	                //2132 -> 1322 
	                break;
	            }
	        }
	        
	        }
	        
	        return answer;
	    }
}
