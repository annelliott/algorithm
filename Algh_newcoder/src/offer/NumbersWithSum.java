package offer;

import java.util.ArrayList;

public class NumbersWithSum {

	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
	 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		// 定义结果数组列表
		ArrayList<Integer> res = new ArrayList<Integer>();
		// 定义start和end两个指针来进行遍历
		if (array == null || array.length < 2 || (array[0] + array[1]) > sum) 
			return res;
		// 定义左右两个边界指针来完成
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
