package BinarySearch;

public class MinValue {

	/**
	 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，
	 * 右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。给定数组arr及它的大小n，请返回最小值。
	 */
	public static int getMin(int[] arr, int n) {
		int res = -1;
        if (arr == null || n < 1) 
			return -1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
				res = arr[0];
				for (int i = 0; i < n; i++) {
					if (arr[i] < res) {
						res = arr[i];
					}
				}
				break;
			} else if ((arr[left] <= arr[mid] && arr[mid] < arr[right]) 
					|| (arr[left] < arr[mid] && arr[mid] <= arr[right])) {
				res = arr[left];
				break;
			} else if (arr[left] <= arr[mid] && arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				mid = right;
				left++;
			}			
		}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
