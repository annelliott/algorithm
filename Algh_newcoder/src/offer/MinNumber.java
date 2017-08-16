package offer;

import java.util.Comparator;

public class MinNumber {

	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
	 * 则打印出这三个数字能排成的最小数字为321323。
	 */
	
	public static String PrintMinNumber(int [] numbers) {
		String res = "";
		// 异常处理
		if (numbers == null) 
			return res;
		// 进行排序操作，定义能够使得n[j]n[j+1] > n[j+1]n[j]成立的n[j]放到后面
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (compareStr(numbers[j], numbers[j + 1]) > 0) {
					int tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
		// 进行拼接
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
