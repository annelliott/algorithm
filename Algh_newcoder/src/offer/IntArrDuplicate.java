package offer;

import java.util.TreeSet;

public class IntArrDuplicate {
	/*��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�
	����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
	���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��*/
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    boolean res = false;
		// �쳣�ж�
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
		// �쳣�ж�
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
