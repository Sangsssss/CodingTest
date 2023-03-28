import java.util.Arrays;
import java.util.HashSet;

public class linearPartialArraySum {

	public static void main(String[] args) {
		int[] elements = {7,9,1,1,4};
		//7911479114
		solution(elements);

	}
	 public static int solution(int[] elements) {
		 int answer = 0;
		 int[] elementsD = new int[elements.length + elements.length];
		 System.arraycopy(elements, 0, elementsD, 0, elements.length);
		 System.arraycopy(elements, 0, elementsD, elements.length, elements.length);
		 //System.out.println(elementsD.length);
		 HashSet<Integer> set = new HashSet<>();
		 int len = 1;
		 
		 for(int k = 0; k<elements.length; k++) {
			 int count = 0;
		 for(int i = k; i<elements.length; i++) {
			 int temp = 0;
			 while(count<len) {
				 System.out.println("count : " + count);
				 temp += elementsD[count];
				 System.out.println(temp);
				 count++;
			 }
		 }
		 len++;
		 }
		 System.out.println(set.size());
	      return answer;
	    }

}
