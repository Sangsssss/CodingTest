
public class kmeans {

	public static void main(String[] args) {
		int[][] a = {{10,10}, {20,20}, {30,30}, {70,70},{80,80},{90,90}};
		solution(a);

	}

	private static void solution(int[][] a) {
		for(int i = 0; i<a.length; i++) {
			for(int j = i+1; j<a.length; j++) {
				double distance = Math.pow((a[i][0]-a[j][0]),2) + Math.pow((a[i][1]-a[j][1]),2);
				System.out.println(i + "와" + j + "까지의 거리 => " +distance);
			}
		}
		
	}

	
}
