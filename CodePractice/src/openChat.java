import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class openChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);

	} //uid1234���� ���Խ��ϴ�.
	  //uid4567���� ���Խ��ϴ�.
	  //uid1234���� �������ϴ�.
	  //uid1234���� ���Խ��ϴ�.
	  //uid4567���� �г����� �����Ͽ����ϴ�.

	public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> r = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i<record.length; i++) {
            String[] temp = record[i].split(" "); //{Enter, uid1234, Muzi}
          
            if(temp[0].equals("Enter")) {
            	r.add(temp[1] + "���� ���Խ��ϴ�.");
            	map.put(temp[1], temp[2]);
            }
            else if(temp[0].equals("Leave")) {
            	r.add(temp[1] + "���� �������ϴ�.");
            }
            else if(temp[0].equals("Change")) {
            	map.put(temp[1], temp[2]);
            }
           
        }
        answer = new String[r.size()];
        for(int i = 0; i<r.size(); i++) {
        	int index = r.get(i).indexOf("��");
            String uid = r.get(i).substring(0, index);
            answer[i] = r.get(i).replaceAll(uid, map.get(uid));
            }
        return answer;
    }
}
