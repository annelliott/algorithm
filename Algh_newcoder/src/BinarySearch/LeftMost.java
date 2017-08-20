package BinarySearch;

public class LeftMost {

	/**
	 * ����һ����������arr���ٸ���һ������num������arr���ҵ�num��������ֵ�����ߵ�λ�á�
	 * ����һ������arr�����Ĵ�Сn��ͬʱ����num���뷵������λ�á�����Ԫ����������δ���֣�
	 * �뷵��-1��
	 */
	public static int findPos(int[] arr, int n, int num) {
        int res = -1;
        // �쳣����
        if (arr == null || n < 1) 
			return res;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == num) {
				if (mid > 0 && arr[mid - 1] == num) {
					right = mid - 1;
				} else {
					res = mid;
					break;
				}
			} else if(arr[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
        return res;
    }
	public static void main(String[] args) {
		int[] err1 = null; // -1
		int[] err2 = {};   // -1
		int[] err3 = {3};  // -1
		int[] test1 = {1}; // -1
		int[] test2 = {1,2,3,4}; // 1
		int[] test3 = {1,2,2,2,3}; // 1
		int[] test4 = {2};   // 0
		int num = 2;
		System.out.println(findPos(err1, 0, num) == -1);
		System.out.println(findPos(err2, 0, num) == -1);
		System.out.println(findPos(err3, 0, num) == -1);
		System.out.println(findPos(test1, 1, num) == -1);
		System.out.println(findPos(test2, 4, num) == 1);
		System.out.println(findPos(test3, 5, num) == 1);
		System.out.println(findPos(test4, 1, num) == 0);
	}

}
