package BinarySearch;

public class MinValue {

	/**
	 * ����һ������ѭ������arr������arr�е���Сֵ������ѭ��������ָ����������������ⳤ�ȵĲ��ַŵ��ұ�ȥ��
	 * �ұߵĲ����õ����������������[1,2,3,3,4]��������ѭ�����飬[4,1,2,3,3]Ҳ�ǡ���������arr�����Ĵ�Сn���뷵����Сֵ��
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
