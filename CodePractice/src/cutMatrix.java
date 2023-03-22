import java.util.ArrayList;

public class cutMatrix {

	public static void main(String[] args) {
		int n = 3;
		int left = 2;
	    int right = 5;
		solution(n, left, right);

	}
	 public static ArrayList<Integer> solution(int n, long left, long right) {
		 	ArrayList<Integer> answer = new ArrayList<Integer>();
		 	long i = left/n; //0
		 	long j = left%n; //2
		 	int count = 0;
		 	//(0,2)
		 	while(count<=right-left) {
		 		if(j>=n) {
		 			j = 0;
		 			i++;
		 		}
		 		answer.add((int) Math.max(i+1, j+1));
		 		j++;
		 		count++;
		 	}
		 
	        //System.out.println(answer.toString());

	        return answer;
	    }
	 
	 public static void showMatrix(int[][] matrix) {
		 for(int i =0; i<matrix.length; i++) {
			 for(int j=0; j<matrix.length; j++) {
				 System.out.print(matrix[i][j]);
			 }
			 System.out.println();
		 }
	 }

}
