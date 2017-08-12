package string;

public class quickSort {
	
	
	public static void quicksort(int[] arr, int left, int right) {
		if(right <= left || left < 0 || right < 0)
			return;
		int mid = sort1(arr, left, right);
		quicksort(arr, left, mid - 1);
		quicksort(arr, mid + 1, right);
	}
	public static int sort1(int[] arr, int left, int right) {
		int small = left - 1;
		int big = right + 1;
		int i = left;
		int target = arr[left];
		while(i != big) {
			if(arr[i] < target) {
				++small;
				int tmp = arr[small];
				arr[small] = arr[i];
				arr[i] = tmp;
				++i;
			} else if(arr[i] == target) {
				++i;
			} else {
				--big;
				int tmp = arr[big];
				arr[big] = arr[i];
				arr[i] = tmp;
			}
		}
		return big - 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,2,5,3};
		quicksort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
