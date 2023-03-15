import java.util.Arrays;

public class conquerLand {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5}, {5,6,7,8},{4,3,2,1}};
		
		solution(land);

	}
    static int answer;
    public static int solution(int[][] land) {
        int y = land.length-1;  //3
        boolean[][] checked = new boolean[land.length][land[0].length];
        
        //한번 탐색한 값이 max가 아니라면 새로운 max로 초기화하는 과정 필요
        int depth = 1;
        int total = 0;
        int[] prepose = new int[land.length+1]; //4칸으로 만듦
        Arrays.fill(prepose, -1); //{-1,-1,-1,-1}
        cLand(total, depth, land, y, checked, prepose);
        //System.out.println("max : " + answer);
        return answer;
    }

    public static void cLand(int total, int depth, int[][] land, int y, boolean[][] checked, int[] prepose) {
        if(depth-1 > y) {	
        	answer = Math.max(answer, total);
        	//System.out.println(max);
            return;
        }
        for(int i = 0; i<land[depth-1].length; i++) {
        if(!checked[depth-1][i] && prepose[depth-1] != i) {
        //System.out.println("depth : "  + (depth-1) + ", i" + i);
        checked[depth-1][i] = true; // 0,0 = true
        total += land[depth-1][i];
        prepose[depth] = i; //prepose = 0
        cLand(total, depth+1, land, y, checked, prepose);
        checked[depth-1][i] = false; // 0,0 = false
        total -= land[depth-1][i];
        }
        }
    }
}
