package offer;

import java.util.Comparator;

public class MinNumber {

	/**
	 * ����һ�����������飬����������������ƴ�������ų�һ������
	 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
	 * ���ӡ���������������ųɵ���С����Ϊ321323��
	 */
	
	public static String PrintMinNumber(int [] numbers) {
		String res = "";
		// �쳣����
		if (numbers == null) 
			return res;
		// ������������������ܹ�ʹ��n[j]n[j+1] > n[j+1]n[j]������n[j]�ŵ�����
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (compareStr(numbers[j], numbers[j + 1]) > 0) {
					int tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
		// ����ƴ��
		for (int i = 0; i < numbers.length; i++) {
			res += numbers[i];
		}
		return res;
	}
	public static int compareStr(int i1, int i2) {
		String str1 = i1 + "" + i2;
		String str2 = i2 + "" + i1;
		return str1.compareTo(str2);
	}
	public static void main(String[] args) {
		int[] arr = {4,32,321};
		String res = PrintMinNumber(arr);
		System.out.println(res);
	}

}
