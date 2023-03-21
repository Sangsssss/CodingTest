import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s2 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String s3 = 	"{{20,111},{111}}";
		//solution(s);
		solution(s3);
	}
	public static List<Integer> solution(String s) {
        //중복되는 원소 X
       s = s.substring(2, s.length()-2); 
       s = s.replace("},{", ";");
       
       System.out.println(s);
       String[] temp = s.split(";");

       Arrays.sort(temp,new Comparator<String>(){
           public int compare(String o1, String o2){       
               return Integer.compare(o1.length(), o2.length());
           }
       });

       List<Integer> answers = new ArrayList<Integer>();   
       for(String k : temp) {
    	   String[] ss = k.split(",");
    	   for(String kk : ss) {
    		   int it = Integer.parseInt(kk+"");
    		   if(!answers.contains(it))
    			   answers.add(it);
    		   else
    			   continue;
    	   }
       }
       //System.out.println(answers.toString());
    return answers;
}

	
}
