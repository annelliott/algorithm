package offer;

import java.util.ArrayList;

public class NumbersWithSum {

	/**
	 * ����һ����������������һ������S���������в�����������
	 * �ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С��
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		// �����������б�
		ArrayList<Integer> res = new ArrayList<Integer>();
		// ����start��end����ָ�������б���
		if (array == null || array.length < 2 || (array[0] + array[1]) > sum) 
			return res;
		// �������������߽�ָ�������
		int small = 0;
		int big = array.length - 1;
		int min = Integer.MAX_VALUE;
		while (small < big) {
			int curSum = array[small] + array[big];
			if (curSum == sum) {
				int cmp = array[small] * array[big];
				if (cmp < min) {					
					res.clear();
					res.add(array[small]);
					res.add(array[big]);
					min = cmp;
				}
				small++;
			} else if (curSum < sum) {
				small++;
			} else {
				big--;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrayList<Integer> res = FindNumbersWithSum(arr, 6);
		System.out.println(res);
	}

}
