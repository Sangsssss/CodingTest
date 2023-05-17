import java.util.List;

public class divideTo1 {

	public static void main(String[] args) {
		int N = 12;
		dp(N);

	}
	public static int dp(int N) {
		int answer = 0;
		int[] DP = new int[N+1];
		int[] back = new int[N+1];
		DP[0] = 0;
		DP[1] = 0;
		DP[2] = 1; back[2] = 1;
		DP[3] = 1; back[3] = 1;
		
		for(int i = 4; i<=N; i++) {
			DP[i] = DP[i-1] + 1;
			back[i] = i-1;
			if(i%2 == 0 && DP[i/2]+1 < DP[i]) {	
				DP[i] = DP[i/2] + 1;
				back[i] = i/2;
			}
			if(i%3 == 0 && DP[i/3]+1 < DP[i]) {	
				DP[i] = DP[i/3] + 1;
				back[i] = i/3;
			}
			System.out.println(i +"번 째 DP : " + DP[i] + ", 값은 =>"  + back[i]);
		}
		answer = DP[N];
		
		String route = "";
		while(N>1) {
		    route += back[N] + " ";
			N = back[N];	
		}
		
		
		System.out.println("정답 : "
				+ "" + answer + "\n" + route);
		
		
		return answer;
	}
	

}
