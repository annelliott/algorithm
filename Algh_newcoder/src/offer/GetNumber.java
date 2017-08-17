package offer;

/*ͳ��һ�����������������г��ֵĴ�����*/
public class GetNumber {

	public static int GetNumberOfK(int [] array , int k) {
		int res = 0;
		int left = getFirstK(array, k, 0, array.length - 1);
		int right = getLastK(array, k, 0, array.length - 1);
		if (left > -1 && right > -1) 
			res = right - left + 1;
		return res;
    }	
	// �õ���ʼ��K
	public static int getFirstK(int[] array, int k, int left, int right) {
		// �쳣����
		if (left > right) 
			return -1;
		int mid = (left + right) / 2;
		int midData = array[mid];
		
		// ���ö��ַ��ҵ���ʼ�ĵ�һ������k��ֵ
		if (midData == k) {
			// �߽��������߽��ж�
			if (mid == 0 || (mid > 0 && array[mid - 1] < k)) {
				return mid;
			} else {
				right = mid - 1;
			}
		} else if (midData > k) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
		return getFirstK(array, k, left, right);
	}
	public static int getLastK(int[] array, int K, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		int midData = array[mid];
		if (midData == K) {
			if (mid == right || (mid < right && array[mid + 1] > K)) {
				return mid;
			} else {
				left = mid + 1;
			}
		} 
		else if (midData > K) {
			right = mid - 1;
		} else {
			left = mid + 1;
		}
		return getLastK(array, K, left, right);
	}
	
	public static void main(String[] args) {
		int [] arr1 = {1,2,2,2,3};
		int [] arr2 = {1};
		int [] arr3 = {2};
		int [] arr4 = {1,1,2};
		int k = 2;
		System.out.println(GetNumberOfK(arr1, k));
		System.out.println(GetNumberOfK(arr2, k));
		System.out.println(GetNumberOfK(arr3, k));
		System.out.println(GetNumberOfK(arr4, k));
	}

}
