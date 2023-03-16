import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class skillDevelop {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1,1,1,1,1};
		solution(progresses, speeds);

	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> l = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int total = 0;
        boolean[] checked = new boolean[progresses.length];
        int idx = 0;
        while(total != progresses.length) {
        	 for(int i=progresses.length-1; i>=0; i--) {
        		 if(!checked[i]) {
        			 progresses[i] = progresses[i] + speeds[i];
        			 st.push(progresses[i] + speeds[i]); //60 -> 60 -> 94 -> 65 -> 90 -> 95 -> 70
        		 }
             }
            if(st.peek() >= 100) {
                int count = 0;
                while(st.peek() >= 100) {
                    count++;
                    st.pop();
                    checked[idx++] = true;
                }
                l.add(count);
                total += count;
            } else
            	continue;
        }
        answer = new int[l.size()];
        for(int i = 0; i<l.size(); i++) {
        	answer[i] = l.get(i);
        }
        return answer;
    }
}
