package BinarySearch;

public class FindAiEqualsi {

	/**
	 * ��һ����������arr�����в������ظ�Ԫ�أ����ҵ�����arr[i]==i�����������λ�á�
	 * �������λ���ϵ���������������������-1��������������arr�����Ĵ�Сn���뷵������ֵ��
	 */
	public static int findPos(int[] arr, int n) {
		int res = -1;
        if (arr == null || n < 1 || arr[0] > n - 1 || arr[n - 1] < 0) 
			return res;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == mid) {
				res = mid;
				right = mid - 1;
			} else if (arr[mid] > mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
        return res;        
    }
	public static void main(String[] args) {
		int[] arr = {-1,1,2,3,4};
		System.out.println(findPos(arr, 4));

	}
}
