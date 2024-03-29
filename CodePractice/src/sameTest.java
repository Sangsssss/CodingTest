import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sameTest {

	public static void main(String[] args) {
		
		String[][] dtnewsList = {{"건양대, 한·중 대학 교류 활성화 업무협약", ""},
				{"김용하 건양대총장, 중국 교육부 쑨야오 부부장 만나 한·중 대학 교류 활성화 논의", ""},
		{"[정면승부] 차두현 “NPT에서 걸어 나온다? 결국 북한과 같은 길 가는 것”", ""},
		{"[정면승부] 김행 “민형배, 부패완판 불쏘시개” 이경 “국민이 바랬던 검수완박”", ""},
		{"전세사기, 결국 법으로 해결…\"혈세 투입 막겠다\"", ""}
		};
		
		
		//뉴스제목 전처리
		for (int i=0; i<dtnewsList.length; i++) {
			dtnewsList[i][0]= dtnewsList[i][0].replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9 ]", "");
		}
		
		//(Studio에 Set이 없는듯?? )map (== Dictionary)에 뉴스제목에서 나온 벡터 전부 넣기(중복 제거)
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<dtnewsList.length; i++) {
			calculation(map, dtnewsList[i][0]);
		}
		int sum = 0;
		for(int k : map.values()) {
			sum += k;
		}
		
		//유사도 검출 진행
		for(int i=0; i<dtnewsList.length; i++) {
			int same = 0;
			System.out.println("뉴스제목 ==>" + dtnewsList[i][0]);
			String[] templi = dtnewsList[i][0].split(" ");
			for(String k : templi) {
				if(map.containsKey(k))
					 same += map.get(k);
			}	
			dtnewsList[i][1] =  "" + (double)same/sum;
			System.out.println(dtnewsList[i][1]);
		}
				 
	}
	
	//벡터화
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
