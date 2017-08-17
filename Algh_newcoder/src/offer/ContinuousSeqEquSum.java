package offer;

import java.util.ArrayList;

public class ContinuousSeqEquSum {
	/*究竟有多少种连续的正数序列的	和为100(至少包括两个数)。
	没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	现在把问题交给你,找出所有和为S的连续正数序列?*/
	// 1,2,3,4,5 通过双指针small和big来维护这个表，如果大于，就++small进行判断
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// 异常判断
		if (sum < 3) 
			return res;
		// 声明指针
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(small);
		arr.add(big);
		// 边界条件，small遍历到中间值即可
		while (small < middle) {
			if (curSum == sum) {
				ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
				res.add(arr1);
			} 				
			while (curSum > sum && small < middle) {
				arr.remove(0);
				curSum -= small;
				small++;
				if (curSum == sum) {
					ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
					res.add(arr1);
				}
			} 	
			arr.add(++big);
			curSum += big;
		}
		return res;
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res = FindContinuousSequence(15);
		System.out.println(res);

	}

}
