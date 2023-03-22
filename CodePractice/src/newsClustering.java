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
	//	        System.out.println(ss1.toString());
	//	        System.out.println(ss2.toString());
		        //3. �� ���ڿ��� ��
	
		        int gyo = 0;
		        int hab = 0;
		        for(String k : ss2) {
		        	if(ss1.remove(k)) //True = ù ��° ���ڿ��� �� ���� ���ö��̽� ���ڰ� �����Ѵ�!
		        		gyo++; //������ �߻�
		        	hab++;
		        }
		        hab += ss1.size();
		        //System.out.println("������ : " + gyo + ", ������ : " + hab);
	
		        answer = (int) ((double)gyo/(double)hab*65536);
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
