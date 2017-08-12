package string;

import java.util.ArrayList;

public class GetLeastNumbers {
	/*����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�
	����С��4��������1,2,3,4,��*/
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // ʱ�临�Ӷ�ΪO��N��
        // ˼·���ҵ���k���������ÿ����ҵ���k����
		ArrayList<Integer> res = new ArrayList<Integer>();
		// �����쳣����
		if (input == null || input.length == 0 || input.length < k || k <= 0) {
			return res;
		}
		int start = 0;
		int end = input.length - 1;
		int index = Partition(input, start, end);
		while (index != k - 1) {
			if(index < k - 1) {
				start = index + 1;
				index = Partition(input, start, end);
			} else {
				end = index - 1;
				index = Partition(input, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		return res;
    }
	public static int Partition(int[] arr, int start, int end) {
		int small = start - 1;
		int big = end + 1;
		int index = start;
		int target = arr[start];
		while (index != big) {
			if (arr[index] < target) {
				++small;
				int tmp = arr[index];
				arr[index] = arr[small];
				arr[small] = tmp;
				++index;
			} else if(arr[index] == target) {
				++index;
			} else {
				--big;
				int tmp = arr[index];
				arr[index] = arr[big];
				arr[big] = tmp;
			}			
		}
		return big - 1;
	}
	public static void main(String[] args) {
		int[] input = {11,31,7,5,6};
		ArrayList<Integer> res = GetLeastNumbers_Solution(input, 2);
		System.out.println(res);
	}

}
