package BinarySearch;


public class BinarySearch {

	/**
	 * ����ֲ���С�ĸ��arr����Ϊ1ʱ��arr[0]�Ǿֲ���С��arr�ĳ���ΪN(N>1)ʱ��
	 * ���arr[0]<arr[1]����ôarr[0]�Ǿֲ���С�����arr[N-1]<arr[N-2]��
	 * ��ôarr[N-1]�Ǿֲ���С�����0<i<N-1������arr[i]<arr[i-1]����arr[i]<arr[i+1]��
	 * ��ôarr[i]�Ǿֲ���С�� ������������arr����֪arr�������������ڵ���������ȣ�
	 * дһ��������ֻ�践��arr������һ���ֲ���С���ֵ�λ�ü��ɡ�
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
		// ���ֲ��ҵ��ж�
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
