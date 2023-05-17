
public class findRoute {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}, {2,3}};
		
		solution(m, n, puddles);

	}
	
	 public static int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        int[][] memo = new int[n+1][m+1]; //m+1, n+1의 길이를 가진 행렬 생성
	        //물웅덩이가 있는 좌표에 벽을 생성
	        for(int[] k : puddles) {
	            memo[k[0]][k[1]] = 999;
	        }
	        answer = (dp(n,m, memo)-1)%1000000007;
	        return answer;
	    }
	    
	    
	    public static int dp(int p, int q, int[][] memo) {
	    	System.out.println("(" + p + ", " + q + ")");
	    	if(p == 1 && q == 1) 
	            return 0;
	    	if(memo[p][q] == 999)
	    		return 999;
	        if(memo[p][q] != 0)
	        	return memo[p][q]++;
	        
	        if(p == 1)        
	        	memo[p][q] = dp(p, q-1, memo) + 1;
	        else if(q == 1)
	        	memo[p][q] = dp(p-1, q, memo) + 1;
	        else
	        	memo[p][q] = Math.min(dp(p, q-1, memo), dp(p-1,q, memo)) + 1;
	        System.out.println("(" + p + ", " + q + ") ==>" + memo[p][q]);
	        return memo[p][q];
	    }
}
