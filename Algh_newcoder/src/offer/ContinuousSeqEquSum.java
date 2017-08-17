package offer;

import java.util.ArrayList;

public class ContinuousSeqEquSum {
	/*�����ж������������������е�	��Ϊ100(���ٰ���������)��
	û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
	���ڰ����⽻����,�ҳ����к�ΪS��������������?*/
	// 1,2,3,4,5 ͨ��˫ָ��small��big��ά�������������ڣ���++small�����ж�
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// �쳣�ж�
		if (sum < 3) 
			return res;
		// ����ָ��
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(small);
		arr.add(big);
		// �߽�������small�������м�ֵ����
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
