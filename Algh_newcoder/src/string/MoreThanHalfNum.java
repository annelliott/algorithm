package string;

public class MoreThanHalfNum {

	/*��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ�
	�������鳤�ȵ�һ�룬������2����������������0��*/
	
	// ��һ�ֽⷨ������partition���������в��ҡ����һ��������һ��
	// ��������϶�λ�����������м䡣
	public static int MoreThanHalfNum_Solution(int [] array) {
        // �쳣����
		if(array.length == 0 || array == null)
			return 0;
		// ���ÿ��ŵ��м�����������λ��
		int mid = array.length >> 1;
		int start = 0;
		int end = array.length - 1;
		int index = Partition(array, 0, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
				index = Partition(array, start, end);
			} else {
				start = index + 1;
				index = Partition(array, start, end);
			}			
		}
		// ������ڣ��õ������ϵ�ֵ
		int result = array[mid];		
		// �õ����ֵ��ʱ�򣬽�һ���ж�
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				++count;
			}
		}
		if (count > array.length / 2) {
			return result;
		} else {
			return 0;
		}
    }
	
	// ����û��ֺ���
	public static int Partition(int[] array, int start, int end) {
		int small = start - 1;
		int big = end + 1;
		int index = start;
		int target = array[start];
		while (index < big) {
			if (array[index] < target) {
				++small;
				int tmp = array[small];
				array[small] = array[index];
				array[index] = tmp;
				++index;				
			} else if(array[index] == target) {
				++index;
			} else {
				--big;
				int tmp = array[big];
				array[big] = array[index];
				array[index] = tmp;
			}
		}
		return index - 1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,1,3,2,3};
		int res = MoreThanHalfNum_Solution(arr);
		System.out.println(res);
	}

}
