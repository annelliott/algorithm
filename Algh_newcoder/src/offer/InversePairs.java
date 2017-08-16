package offer;

/*�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ�������
�����P%1000000007*/
public class InversePairs {
	
	public static int InversePairs(int [] array) {
		int[] res = new int[1];
		// �쳣����
		if (array == null || array.length <= 1)
			return res[0];
		// ���ù鲢�����˼����д���
		MergePairs(array, res, 0, array.length - 1);
		return res[0];
    }
	public static void MergePairs(int[] arr, int[] res, int left, int right) {
		// �߽紦��
		if (left < right) {
			int mid = (left + right) / 2;
			MergePairs(arr, res, left, mid);
			MergePairs(arr, res, mid + 1, right);
			Merge(arr, res, left, mid, right);
		}
	}
	public static void Merge(int[] arr, int[] res, int left, int mid, int right) {
		int[] helper = new int[right - left + 1];
		int p1 = mid;
		int p2 = right;
		int p3 = right - left;
		while (p1 >= left && p2 > mid) {
			if (arr[p1] > arr[p2]) {
				helper[p3--] = arr[p1--];
				res[0] += p2 - mid;
				res[0] &= 0x3b9aca07;
			} else {
				helper[p3--] = arr[p2--];				
			}					
		}
		while (p1 >= left) {
			helper[p3--] = arr[p1--];
		}
		while (p2 > mid) {
			helper[p3--] = arr[p2--];
		}
		for (int i = left; i < right + 1; i++) {
			arr[i] = helper[i - left];
		}
	}
	public static void main(String[] args) {
		int[] array = {4,5,1,2};
		int res = InversePairs(array);
		String a = Integer.toHexString(1000000007);
		// 3b9aca07
		System.out.println(res);
	}

}
