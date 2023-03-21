import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class newsClustering {

	public static void main(String[] args) {
		
		solution("FRANCE", "french");
		solution("handshake", "shake hands");
		solution("aa1+aa2", "AAAA12");
		//ha an nd ds sh ha ak ke
		//sh ha ak ke ha an nd ds
	}
	 public static int solution(String str1, String str2) {
	        int answer = 0;
	        //1. ��� �빮�ڷ� �����.
	        str1 = str1.toUpperCase();
	        str2 = str2.toUpperCase();
	        //2. 2���� �� ���� ���ڿ��� �����
	        ArrayList<String> ss1 = splice2(str1);
	        ArrayList<String> ss2 = splice2(str2);
	        //3. �� ���ڿ��� ��

	        //3-2 : ������
	        HashMap<String, Integer> map1 = new HashMap<>();
	        HashMap<String, Integer> map2 = new HashMap<>();
	        for(int i=0; i<ss1.size(); i++) {
	        	map1.put(ss1.get(i), map1.getOrDefault(ss1.get(i), 0)+1);
	        }
	        for(int i=0; i<ss2.size(); i++) {
	        	map2.put(ss2.get(i), map2.getOrDefault(ss2.get(i), 0)+1);
	        }
	        ArrayList<String> al1 = new ArrayList<>(map1.keySet()); //{FR*2, AN, CE}
	        ArrayList<String> al2 = new ArrayList<>(map2.keySet()); //{FR, CN, CH}
	        System.out.println(al1.toString());
	        System.out.println(al2.toString());

	        int min = 0;
	        int maxT = 0;
	        for(int i =0; i<al1.size(); i++) {
	        	for(int j = 0; j<al2.size(); j++) {
	        		if(al1.get(i).equals(al2.get(j))) {
	        			min += Math.min(map1.get(al1.get(i)), map2.get(al1.get(i)));
	        			maxT += Math.max(map1.get(al1.get(i)), map2.get(al1.get(i)));
	        			al2.remove(al2.get(j));
	        			break;
	        		}
	        	}
	        }
	        System.out.println(min);
	        System.out.println(maxT);
	        
	        //3-1 : ������
	        
	        //set�� ������ �ٸ� �͵鸸 ��
	        //8��
	        HashSet<String> set = new HashSet<String>();
	        for(int i=0; i<ss1.size(); i++) {
	        	set.add(ss1.get(i));
	        }
	        for(int i=0; i<ss2.size(); i++) {
	        	set.add(ss2.get(i));
	        }
	        
	        System.out.println("set size - > " + set.size());
	        int max = 0;
	        
	        if(maxT > min) {
	        	max = set.size()+(maxT-min);
	        } else
	        	max = maxT;
	        

	        answer = (int) ((double)min/(double)max*65536);
	        System.out.println(answer);

	        return answer;
	    }
	 
	    public static ArrayList<String> splice2(String str) {
	        ArrayList<String> sl = new ArrayList<>();
	        for(int i = 0; i<str.length()-1; i++) {
	        	StringBuilder sb = new StringBuilder();
	        	String temp = "";
	        	char a = str.charAt(i);
	        	char b = str.charAt(i+1);
	        	if(a < 65 || a > 90 || b < 65 || b > 90)
	        		continue;
	        	else {
	        		sb.append(a);
	        		sb.append(b);
	        		sl.add(sb.toString());
	        	}
	        }
	        return sl;
	    }
}
