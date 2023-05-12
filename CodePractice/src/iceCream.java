import java.util.LinkedList;
import java.util.Queue;

public class iceCream {

	
	public static void main(String[] args) {
		
		int[][] iceCase = {
				  {1, 0, 0, 1, 1},
				  {0, 0, 0, 1, 1},
				  {1, 1, 1, 1, 1},
				  {0, 0, 1, 1, 0}
				};
		//j>0
		//j=0 (
		// 
		solution(iceCase);

	}
	public static void solution(int[][] iceCase) {
		int answer = 0;
		boolean[][] visited = new boolean[iceCase.length][iceCase[0].length];
		
		System.out.println(visited[0][0]);
		for(int i=0; i<iceCase.length; i++) {
			for(int j=0; j<iceCase[0].length; j++) {
				if(iceCase[i][j] == 0 && !visited[i][j]) {
					bfs(visited, iceCase, i, j);
					answer++;
					System.out.println("dfs 종료");
				} else
					continue;
			}
			
		}

		System.out.println(answer);

	}
	public static void bfs(boolean[][] visited, int[][] iceCase, int i, int j) {	
		//System.out.println("(" + i + ", " + j + ")" + " 방문");
		if(i > iceCase.length-1 || j > iceCase[0].length-1 ||visited[i][j] || iceCase[i][j] == 1) {
			return;
		}
		visited[i][j] = true;
		if(j == 0) {
			if(i == iceCase.length-1) {
				bfs(visited, iceCase, i, j + 1);
			} else {
				bfs(visited, iceCase, i+1, j);
				bfs(visited, iceCase, i, j + 1);
			}
		}
		
		
		if (i == iceCase.length - 1) {
			
		} else if (j == iceCase[0].length - 1) {
			bfs(visited, iceCase, i + 1, j);
		} else {
			bfs(visited, iceCase, i, j + 1);
			bfs(visited, iceCase, i + 1, j);
		}
		
	}
}
