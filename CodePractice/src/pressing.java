import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class pressing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("TOBEORNOTTOBEORTOBEORNOT");
	}
	 public static List<Integer> solution(String msg) {
	        int[] answer = {};
	        List<String> dictionary = new ArrayList<>();
	        char[] ca = msg.toCharArray();
	        //1. 
	        for(int i = 65; i<91; i++) {
	        	//System.out.print((char)i + "");
	            dictionary.add((char) i + "");
	        }
	        //System.out.println();
	        //2. �������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w�� ã��
            int idx = 0;
            int currentidx = 0;
            String temp = ca[idx] + ""; //K
            String oTemp = "";
            List<Integer> print = new ArrayList<>();
            while(idx < msg.length()) {
            	//System.out.println(temp);
                if(dictionary.contains(temp)) {	
                	if(idx == msg.length()-1) {
                    	print.add(dictionary.indexOf(temp)+1);
                		break;
                	}
                idx = idx+1;
                oTemp = temp;
                temp += ca[idx] + ""; //KA
                } else {
                print.add(dictionary.indexOf(oTemp)+1);
                //System.out.println("������ " + temp + "�� �߰��մϴ�");
                dictionary.add(temp);
                temp = ca[idx] + ""; //A
                } 
             
        }
            //System.out.println(print.toString());
	        return print;
	    }

}
