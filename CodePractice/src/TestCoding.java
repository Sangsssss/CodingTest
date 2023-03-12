import java.util.Stack;

public class TestCoding {

	public static void main(String[] args) {
		
		String s = "[](){}";
		solution(s);
	}
	
	 public static int solution(String s) {
		 
	        int answer = 0;
	        int lenidx = s.length();
	        String tempS = "";
	        Stack<Character> stack = new Stack<Character>();
	        for(int i = 0; i<s.length(); i++) {
	        	if(i==0)
	        		tempS = s;
	        	else {
	        	String temp = "";
		        char tempF = tempS.charAt(0); //[
		        //char tempL = s.charAt(lenidx); //]
		        temp = tempS.substring(1, lenidx);
		        tempS = temp + tempF;
	        	}
	        	//System.out.println(tempS);
	        	char[] tA = tempS.toCharArray();
	        	for(char k : tA) {
	        		if(!stack.isEmpty()) {
	        			if(stack.peek() == '[' && k == ']' ||
	        					stack.peek() == '{' && k == '}' ||stack.peek() == '(' && k == ')') {
	        				stack.pop();
	        				//System.out.println("올바른 문자열입니다.");
	        			}	
	        			else {
	        				//System.out.println(k + "를 스택에 추가합니다");
	        				stack.add(k);
	        			}
	        		} else
	        			stack.add(k);
	        	}
	        	if(stack.isEmpty())
	        		answer++;
	        	stack.removeAllElements();
	        	//System.out.println(answer);
	        }

	        return answer;
	    }
}
