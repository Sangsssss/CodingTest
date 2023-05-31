import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class openChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);

	} //uid1234님이 들어왔습니다.
	  //uid4567님이 들어왔습니다.
	  //uid1234님이 나갔습니다.
	  //uid1234님이 들어왔습니다.
	  //uid4567님이 닉네임을 변경하였습니다.

	public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> r = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i<record.length; i++) {
            String[] temp = record[i].split(" "); //{Enter, uid1234, Muzi}
          
            if(temp[0].equals("Enter")) {
            	r.add(temp[1] + "님이 들어왔습니다.");
            	map.put(temp[1], temp[2]);
            }
            else if(temp[0].equals("Leave")) {
            	r.add(temp[1] + "님이 나갔습니다.");
            }
            else if(temp[0].equals("Change")) {
            	map.put(temp[1], temp[2]);
            }
           
        }
        answer = new String[r.size()];
        for(int i = 0; i<r.size(); i++) {
        	int index = r.get(i).indexOf("님");
            String uid = r.get(i).substring(0, index);
            answer[i] = r.get(i).replaceAll(uid, map.get(uid));
            }
        return answer;
    }
}
