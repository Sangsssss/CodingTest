
public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,4,3,2,1};
		int[] arr2 = {4,5,6,3,2,1};
 		solution(arr);
	}
	public static void solution(int[] arr) {
		show(arr);
		System.out.println();
		int count = 0;
		int len = arr.length-1;
		
		while(count<len) {
		for(int i = 0; i<len; i++) {
			if(arr[i] > arr[i+1]) {
				swap(arr, i);
			}
		}
		count++;
		}
		
		show(arr);
	}
	private static void swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;
	}
	

	public static void show(int[] arr) {
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
