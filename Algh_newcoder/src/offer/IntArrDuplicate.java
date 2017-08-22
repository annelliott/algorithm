package offer;

import java.util.TreeSet;

public class IntArrDuplicate {
	/*在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
	但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。*/
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    boolean res = false;
		// 异常判断
		if (numbers == null || length < 1) 
			return res;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (set.contains(numbers[i])) {
				res = true;
				duplication[0] = numbers[i];
				break;
			} else {
				set.add(numbers[i]);
			}
		}
		return res;
    }
	
	public static boolean duplicate1(int numbers[],int length,int [] duplication) {
		boolean res = false;
		// 异常判断
		if (numbers == null || length < 1) 
			return res;	
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				if (count == 0) {
					count++;
				} else {
					res = true;
					duplication[0] = 0;
					break;
				}
			} else {
				int a = Math.abs(numbers[i]);
				if (numbers[a] >= 0) {
					numbers[a] *= -1;
				} else {
					res = true;
					duplication[0] = a;
					break;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,5,6};
		int[] dup = new int[1];
		int n = arr.length;
		System.out.println(duplicate1(arr, n, dup));
	}

}
