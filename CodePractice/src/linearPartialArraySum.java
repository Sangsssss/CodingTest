import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class linearPartialArraySum {

	public static void main(String[] args) {
		int[] elements = {7,9,1,1,4};
		solution(elements);

	}
	 public static int solution(int[] elements) {
	        int answer = 0;
	        int max = elements.length; //5
	        List<Integer> array = new ArrayList<>();
	        int turn = 0;
	        while(turn < max) {
	        	int n = 1;
	        while(n<=elements.length) {
	            int count = 0;
	            while(count+n<=max) { 
	            	//System.out.println("count ==> " + count);
	                int tmpCount = count;
	                int temp = 0;
	                int idx = 0;
	                while(idx<n) {
	                    temp += elements[tmpCount];
	                    if(array.isEmpty() || !array.contains(temp))
	                    	array.add(temp);
	                    idx++;
	                    tmpCount++;
	                }
	                count++;
	            }
	            n++;
	        }
	       // System.out.println("¹è¿­ ½ºÇÉ");
	        spinArray(elements);
	        turn++;
	        }
//	        Collections.sort(array);
//	        System.out.println(array.toString());
	        answer = array.size();
	        //System.out.println(answer);
	        return answer;
	    }
	 public static int[] spinArray(int[] elements) {
	        int temp = elements[0];
	        for(int i = 0; i<elements.length-1; i++) {
	            elements[i] = elements[i+1];
	        }
	        elements[elements.length-1] = temp;
//	        for(int k : elements ) {
//	        	System.out.println(k);
//	        }
			return elements;
	    }
}
