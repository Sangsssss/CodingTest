import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sameTest {

	public static void main(String[] args) {
		
		String[][] dtnewsList = {{"�Ǿ��, �ѡ��� ���� ���� Ȱ��ȭ ��������", ""},
				{"����� �Ǿ������, �߱� ������ ���߿� �κ��� ���� �ѡ��� ���� ���� Ȱ��ȭ ����", ""},
		{"[����º�] ������ ��NPT���� �ɾ� ���´�? �ᱹ ���Ѱ� ���� �� ���� �͡�", ""},
		{"[����º�] ���� ��������, ���п��� �ҽ�ð��� �̰� �������� �ٷ��� �˼��Ϲڡ�", ""},
		{"�������, �ᱹ ������ �ذᡦ\"���� ���� ���ڴ�\"", ""}
		};
		
		
		//�������� ��ó��
		for (int i=0; i<dtnewsList.length; i++) {
			dtnewsList[i][0]= dtnewsList[i][0].replaceAll("[^��-����-�Ӱ�-�Ra-zA-Z0-9 ]", "");
		}
		
		//(Studio�� Set�� ���µ�?? )map (== Dictionary)�� �������񿡼� ���� ���� ���� �ֱ�(�ߺ� ����)
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<dtnewsList.length; i++) {
			calculation(map, dtnewsList[i][0]);
		}
		int sum = 0;
		for(int k : map.values()) {
			sum += k;
		}
		
		//���絵 ���� ����
		for(int i=0; i<dtnewsList.length; i++) {
			int same = 0;
			System.out.println("�������� ==>" + dtnewsList[i][0]);
			String[] templi = dtnewsList[i][0].split(" ");
			for(String k : templi) {
				if(map.containsKey(k))
					 same += map.get(k);
			}	
			dtnewsList[i][1] =  "" + (double)same/sum;
			System.out.println(dtnewsList[i][1]);
		}
				 
	}
	
	//����ȭ
	public static void calculation(HashMap<String,Integer> map, String tempS) {
		String[] vectorA = tempS.split(" "); 
		for(String k : vectorA) {
			map.put(k, map.getOrDefault(k, 0)+1);
		}

		for(String k : map.keySet()) {
			System.out.print(k + ",");
		}
		System.out.println();
		
	
	}

}
