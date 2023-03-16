import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class queuePrice {

	public static void main(String[] args) {
		int[] prices = {1,2,3,4,5,6,5,4,3,6,7};
		solution(prices);

	}

		  public static int[] solution(int[] prices) {
		        int[] answer = new int[prices.length];
		        //Deque<Integer> st = new LinkedList<>();
		        Stack<Integer> stack = new Stack<>();
		        List<Integer> li = new ArrayList<>();
		        
		        for(int i=0; i<prices.length; i++) {
		            if(!stack.isEmpty() && stack.peek() > prices[i]) {
		            	//하락장 발생 시점!
		            	while(!stack.isEmpty() && stack.peek() > prices[i]) {
		            		answer[li.lastIndexOf(stack.peek())] = i-li.lastIndexOf(stack.peek());
		            		li.set(li.lastIndexOf(stack.peek()), 0);
		                    stack.pop();
		                }
		            }
		            stack.push(prices[i]);
		            li.add(prices[i]);
		        }
		        for(int i = 0; i<answer.length; i++) {
		        	if(answer[i] == 0) 
		        		answer[i] = prices.length -1 - i;
		        }
//		        for(int k : answer) {
//		        	//System.out.println("--------");
//		        	System.out.println(k);
//		        }
		        return answer;
		    }
}
