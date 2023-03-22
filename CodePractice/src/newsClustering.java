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
		        //1. 모두 대문자로 만든다.
		        str1 = str1.toUpperCase();
		        str2 = str2.toUpperCase();
		        //2. 2글자 씩 끊은 문자열을 만든다
		        ArrayList<String> ss1 = splice2(str1);
		        ArrayList<String> ss2 = splice2(str2);
	//	        System.out.println(ss1.toString());
	//	        System.out.println(ss2.toString());
		        //3. 두 문자열을 비교
	
		        int gyo = 0;
		        int hab = 0;
		        for(String k : ss2) {
		        	if(ss1.remove(k)) //True = 첫 번째 문자열에 두 번쨰 스플라이스 문자가 존재한다!
		        		gyo++; //교집합 발생
		        	hab++;
		        }
		        hab += ss1.size();
		        //System.out.println("교집합 : " + gyo + ", 합집합 : " + hab);
	
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
