package cpBt;

public class PostArray {
	public static boolean isPostArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length - 1);
	}
	public static boolean isPost(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		// ����С�ڸ��ڵ������λ�õ�ֵless
		int less = -1;
		// ������ڸ��ڵ������λ�õ�ֵmore
		int more = end;
		// �����������飬��¼less��more
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || more == end) {
			return isPost(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end - 1);
	}
	public static void main(String[] args) {

	}

}
