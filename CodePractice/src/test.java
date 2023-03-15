import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		int[] array = {1};
		solution(array);
	}

		public static int solution(int[] array) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int k : array) {
        	map.put(k, map.getOrDefault(k, 0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>(map.values()); //1,1,3,1 
        ArrayList<Integer> al2 = new ArrayList<>(map.keySet()); //{1,2,3,4} 
        Collections.sort(al);
        int max = al.get(al.size()-1);
        int idx =0;
        for(int k : al2) {
        	if(map.get(k)==max) {
        		idx++;
        	}
        }
        if(idx>1)
        	answer = -1;
        else 
        	answer = map.
        
        return answer;
    }
}
