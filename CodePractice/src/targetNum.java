
public class targetNum {

	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;
		solution(numbers, target);

	}
	static int answer = 0;
	private static int solution(int[] numbers, int target) {
		dfs(0,0, numbers, target);
		//System.out.println(answer);
		return answer;

	}
	private static void dfs(int count, int cal, int[] numbers, int target) {
		if(count == numbers.length) {
			if(cal == target)
				answer++;
			return;
		}
		dfs(count+1, cal+numbers[count], numbers, target);
		dfs(count+1, cal-numbers[count], numbers, target);
	}
	
}
