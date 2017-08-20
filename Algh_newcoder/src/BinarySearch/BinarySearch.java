package BinarySearch;


public class BinarySearch {

	/**
	 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，
	 * 如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，
	 * 那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，
	 * 那么arr[i]是局部最小。 给定无序数组arr，已知arr中任意两个相邻的数都不相等，
	 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
	 */
	public static int getLessIndex(int[] arr) {
		int res = -1;
		if (arr == null || arr.length < 1) 
			return res;
		int n = arr.length;
		if (n == 1 || arr[0] < arr[1]) {
			res = 0;
			return res;
		} else if (arr[n - 1] < arr[n - 2]) {
			res = n - 1;
			return res;
		}
		// 二分查找的判断
		int left = 0;
		int right = n - 1;		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid + 1] > arr[mid] && arr[mid -1] > arr[mid]) {
				res = mid;
				break;
			} else if (arr[mid + 1] < arr[mid] && arr[mid - 1] > arr[mid]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return res;		
    }
	public static void main(String[] args) {
		int[] err1 = null;
		int[] err2 = {};
		int[] err3 = {1};
		int[] err4 = {3,4,1};
		int[] exp1 = {7,6,4,5,8};
		int[] exp2 = {7,6,4,3,8};
		int[] exp3 = {7,3,4,6,8};
		int[] exp4 = {7,1,4,3,8};
		System.out.println(getLessIndex(err1) == -1); // -1
		System.out.println(getLessIndex(err2) == -1); // -1
		System.out.println(getLessIndex(err3) == 0); // 0
		System.out.println(getLessIndex(err4) == 0); // 0
		System.out.println(getLessIndex(exp1) == 2);
		System.out.println(getLessIndex(exp2) == 3);
		System.out.println(getLessIndex(exp3) == 1);
		System.out.println(getLessIndex(exp4) == 1);
	}
}
