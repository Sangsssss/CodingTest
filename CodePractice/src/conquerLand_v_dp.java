import java.util.Arrays;

public class conquerLand_v_dp {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5}, {5,6,7,8},{4,3,2,1}};
		
		solution(land);

	}
  
    public static int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        for(int i=0; i<land[0].length; i++) {
        	dp[0][i] = land[0][i];
        } //dp = {{1,2,3,5}}

        for(int i = 1; i<land.length; i++) {
        	for(int j =0; j<land[0].length; j++) {
        		for(int k=0; k<land[0].length; k++) {
        			if(j==k)
        				continue;
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+land[i][j]);
        		}
        	}
        }
        int max = 0;
        for(int i =0; i<dp[0].length; i++) {
        	//System.out.println(dp[dp.length-1][i]);
        	max = Math.max(max, dp[dp.length-1][i]);
        }
        answer = max;
       // System.out.println(answer);
        return answer;
    }

    
}
