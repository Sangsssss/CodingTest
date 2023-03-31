import java.util.HashMap;
import java.util.HashSet;

public class hashCall {

	public static void main(String[] args) {
		String[] phone_book = {"119", "12345678", "123456789"};
		solution(phone_book);

	}
	 public static boolean solution(String[] phone_book) {
		    int len = 20;
		    boolean answer = true;
		    HashMap<String, Integer> map = new HashMap<>();
		 	for(int i = 0; i < phone_book.length; i++){
		 		map.put(phone_book[i], i);
		        if(phone_book[i].length() < len){
		        	len = phone_book[i].length();
		        }
		    }
		    for(int i = 0; i<phone_book.length; i++) {
		    	for(int j = len; j<phone_book[i].length(); j++) {
		    		if(map.containsKey(phone_book[i].substring(0, j)))  {
		    			//System.out.println("f");
			    		return false;
			    	}	
		    	}   	
		    }
	        return answer;
	    }
}
