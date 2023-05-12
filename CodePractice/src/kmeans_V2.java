import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kmeans_V2 {

	public static void main(String[] args) {
		double[][] a = {{1,1}, {2,2}, {3,3}, {7,7},{8,8},{9,9}};
		solution(a);

	}


	
	private static void solution(double[][] a) {
		int num1 = 0, num2 = 0;
		int[] numA = randomPick(a, num1, num2);
		Arrays.sort(numA);
		System.out.println(numA[0] + "," + numA[1]);
		
		double[] centroidA = a[numA[0]];

		double[] centroidB = a[numA[1]];
//		double[] centroidA = new double[] {7, 7};
//		double[] centroidB =  new double[] {8, 8};
		
		
		List<double[]> A = null;
		List<double[]> B = null;
		System.out.println("�߽��� A => (" + centroidA[0] + " " + centroidA[1] + ")");
		System.out.println("�߽��� B => (" +centroidB[0] + " " + centroidB[1] + ")");
		double[] priorCentroidA = {-1, -1};
		double[] priorCentroidB = {-1, -1};
		
		while(centroidA[0] != priorCentroidA[0] || centroidB[0] != priorCentroidB[0]) {
		//���� �߽� ����
		priorCentroidA = centroidA.clone();
		priorCentroidB = centroidB.clone();
		//���� �ʱ�ȭ
		
		A = new ArrayList<>();
		B = new ArrayList<>();
		//�߽ɰ��� �Ÿ� ��� �� ����ȭ
		calculateDistance(a, centroidA, centroidB, A, B);
		//����ȭ �� �߽� �ٽ� ���ϱ�
		calculateCentroid(centroidA, centroidB, A, B);
		System.out.println(centroidA[0] + " " + priorCentroidA[0] + " "+centroidB[0] + " " + priorCentroidB[0]);
		}
		System.out.println("����ȭ �Ϸ�");
		System.out.print("A���� ==> ");
		for(double[] k : A) {
			System.out.print("(" +k[0] + "," + k[1] + ")");
		}
		System.out.println();
		System.out.print("B���� ==> ");
		for(double[] k : B) {
			System.out.print("(" +k[0] + "," + k[1] + ")");
		}
	}

	
	private static int[] randomPick(double[][] a, int num1, int num2) {
		num1 = (int)Math.round(Math.random() * (a.length-1));
		num2 = (int)Math.round(Math.random() * (a.length-1));
		if(num1 == num2)
			return randomPick(a, num1, num2);
		return new int[] {num1, num2};
	}
	
	private static void calculateCentroid(double[] centroidA, double[] centroidB, List<double[]> a, List<double[]> b) {
		int x = 0;
		int y = 0;
		//�߽ɰ� ���ϱ�
		for(double[] k : a) {
			x += k[0];
			y += k[1];
			//{10,10}
		}
		
		
		centroidA[0] =  Math.round(((double) x/a.size()*100))/100;
		centroidA[1] = Math.round(((double) y/a.size()*100))/100;
		x = 0;
		y = 0;
		for(double[] k : b) {
			x += k[0];
			y += k[1];
			//{10,10}
		}
		centroidB[0] =  Math.round(((double) x/b.size()*100))/100;
		centroidB[1] = Math.round(((double) y/b.size()*100))/100;
		System.out.println("�߽��� A => (" + centroidA[0] + " " + centroidA[1] + ")");
		System.out.println("�߽��� B => (" +centroidB[0] + " " + centroidB[1] + ")");
	}

	private static void calculateDistance(double[][] a2, double[] centroidA, double[] centroidB, List<double[]> a, List<double[]> b) {
		for(int i = 0; i<a2.length; i++) {
			double distance = Math.pow((a2[i][0]-centroidA[0]),2) + Math.pow((a2[i][1]-centroidA[1]),2);
			double distance2 = Math.pow((a2[i][0]-centroidB[0]),2) + Math.pow((a2[i][1]-centroidB[1]),2);
			System.out.println("(" + a2[i][0] + "," + a2[i][1] + ") - " + "centroidA ������ �Ÿ� => " +distance);
			System.out.println("(" + a2[i][0] + "," + a2[i][1] + ") - " + "centroidB ������ �Ÿ� => "  +distance2);
			//�߽� A�� ����� ��
			if(distance <= distance2) {
				System.out.println(a2[i][0] + "," + a2[i][1] + "�� A�� �ֽ��ϴ�");
				a.add(a2[i]);
			} else {
				System.out.println(a2[i][0] + "," + a2[i][1] + "�� B�� �ֽ��ϴ�");
				b.add(a2[i]);
			}
				
		}
	}

	
}
