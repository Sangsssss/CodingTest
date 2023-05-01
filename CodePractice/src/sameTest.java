import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sameTest {

	public static void main(String[] args) {
		
		String[][] dtnewsList = {{"°Ç¾ç´ë, ÇÑ¡¤Áß ´ëÇÐ ±³·ù È°¼ºÈ­ ¾÷¹«Çù¾à", ""},
				{"±è¿ëÇÏ °Ç¾ç´ëÃÑÀå, Áß±¹ ±³À°ºÎ ¾§¾ß¿À ºÎºÎÀå ¸¸³ª ÇÑ¡¤Áß ´ëÇÐ ±³·ù È°¼ºÈ­ ³íÀÇ", ""},
		{"[Á¤¸é½ÂºÎ] Â÷µÎÇö ¡°NPT¿¡¼­ °É¾î ³ª¿Â´Ù? °á±¹ ºÏÇÑ°ú °°Àº ±æ °¡´Â °Í¡±", ""},
		{"[Á¤¸é½ÂºÎ] ±èÇà ¡°¹ÎÇü¹è, ºÎÆÐ¿ÏÆÇ ºÒ½î½Ã°³¡± ÀÌ°æ ¡°±¹¹ÎÀÌ ¹Ù·¨´ø °Ë¼ö¿Ï¹Ú¡±", ""},
		{"Àü¼¼»ç±â, °á±¹ ¹ýÀ¸·Î ÇØ°á¡¦\"Ç÷¼¼ ÅõÀÔ ¸·°Ú´Ù\"", ""}
		};
		
		
		//´º½ºÁ¦¸ñ ÀüÃ³¸®
		for (int i=0; i<dtnewsList.length; i++) {
			dtnewsList[i][0]= dtnewsList[i][0].replaceAll("[^¤¡-¤¾¤¿-¤Ó°¡-ÆRa-zA-Z0-9 ]", "");
		}
		
		//(Studio¿¡ SetÀÌ ¾ø´Âµí?? )map (== Dictionary)¿¡ ´º½ºÁ¦¸ñ¿¡¼­ ³ª¿Â º¤ÅÍ ÀüºÎ ³Ö±â(Áßº¹ Á¦°Å)
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<dtnewsList.length; i++) {
			calculation(map, dtnewsList[i][0]);
		}
		int sum = 0;
		for(int k : map.values()) {
			sum += k;
		}
		
		//À¯»çµµ °ËÃâ ÁøÇà
		for(int i=0; i<dtnewsList.length; i++) {
			int same = 0;
			System.out.println("´º½ºÁ¦¸ñ ==>" + dtnewsList[i][0]);
			String[] templi = dtnewsList[i][0].split(" ");
			for(String k : templi) {
				if(map.containsKey(k))
					 same += map.get(k);
			}	
			dtnewsList[i][1] =  "" + (double)same/sum;
			System.out.println(dtnewsList[i][1]);
		}
				 
	}
	
	//º¤ÅÍÈ­
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
